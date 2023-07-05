;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 65)
(include sci.sh)
(use Main)
(use ExitButton)
(use Str)
(use Print)
(use File)

(class SwatFile of File
	(properties)

	(method (open &tmp temp0 temp1)
		(= temp0 (Str format: {%s%s} (gStr data:) {swat.dat}))
		(self name: (KString 8 (temp0 data:))) ; StrDup
		(temp0 dispose:)
		(= temp1 (super open: &rest))
	)

	(method (readIt param1 &tmp temp0 temp1)
		(= temp1 0)
		(= temp0 (Str new: 10))
		(if (self open: 1)
			(self seek: (* param1 2) read: temp0 2 dispose:)
			(= temp1 (proc4_8 temp0 0))
		)
		(temp0 dispose:)
		(DisposeScript 64993)
		(DisposeScript 65 temp1)
	)

	(method (writeIt param1 param2 &tmp temp0)
		(= temp0 (Str new: 10))
		(proc4_7 temp0 0 param2)
		(if (self open:)
			(self seek: (* param1 2) write: temp0 2 dispose:)
		else
			(Printf {Error opening file %s} name)
		)
		(temp0 dispose:)
		(DisposeScript 64993)
		(DisposeScript 65)
	)
)

