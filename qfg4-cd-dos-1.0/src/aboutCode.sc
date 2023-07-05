;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 19)
(include sci.sh)
(use Main)
(use Str)
(use Print)
(use System)

(public
	aboutCode 0
)

(local
	local0
)

(procedure (localproc_0 param1 param2 &tmp temp0 temp1 temp2)
	(if (= temp2 (Message msgSIZE 19 param1 0 0 param2))
		(= temp1 (Str new: temp2))
		(Message msgGET 19 param1 0 0 param2 (temp1 data:))
		(Print font: 0 largeAlp: 0 mode: 1 addText: (temp1 data:) init:)
		(temp1 dispose:)
	)
)

(instance aboutCode of Code
	(properties)

	(method (doit &tmp temp0 [temp1 2])
		(= temp0 (= local0 (gTheIconBar getCursor:)))
		(temp0 view: 999)
		(gGlory setCursor: temp0)
		(localproc_0 2 1)
		(localproc_0 2 2)
		(localproc_0 2 3)
		(localproc_0 2 4)
		(localproc_0 2 5)
		(localproc_0 2 6)
		(localproc_0 2 7)
		(localproc_0 2 8)
		(localproc_0 2 9)
		(localproc_0 2 10)
		(localproc_0 2 11)
		(localproc_0 2 12)
		(localproc_0 2 13)
		(localproc_0 2 14)
		(localproc_0 1 1)
		(localproc_0 1 2)
		(localproc_0 1 3)
		(localproc_0 1 4)
		(localproc_0 1 5)
		(localproc_0 1 6)
		(localproc_0 1 7)
		(localproc_0 1 8)
		(localproc_0 1 9)
		(localproc_0 1 10)
		(localproc_0 1 11)
		(localproc_0 3 1)
		(self dispose:)
	)

	(method (dispose)
		(gGlory setCursor: local0)
		(DisposeScript 19)
	)
)

