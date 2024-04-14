func convert(s string, numRows int) string {
    buf := bytes.NewBufferString("")
    if numRows == 1 {
        return s
    }
    width := 2*(numRows-1)
    for idx := 0; idx < numRows; idx++ {
        step := 2*idx
        if idx == 0 || idx == numRows-1 {
            step = width
        }
        for walker := idx; walker < len(s); walker+=step {
            buf.WriteByte(s[walker])
            if step != width {
                step = width-step
            }
        }
    }

    return buf.String()
}