;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4)
(include sci.sh)
(use Main)
(use DText)
(use Print)
(use Dialog)
(use Talker)
(use System)

(public
	initCode 0
)

(instance initCode of Code
	(properties)

	(method (doit &tmp [temp0 2])
		(= global170 (== (Platform 4) 2))
		(= gUserFont 4)
		(Print font: 4)
		(Dialog font: gUserFont)
		(DText font: gUserFont)
		(Narrator font: gUserFont)
		(= gUseSortedFeatures 1)
		(= gEatMice 6)
		(= global116 0)
		(= gTheArrowCursor (ScriptID 25 2)) ; theArrowCursor
		(= gTheInvisCursor (ScriptID 25 3)) ; theInvisCursor
		(= gMsgType 2)
		(= global105 0)
		(= global111 3)
		(gGame setCursor: gWaitCursor 1 304 172 detailLevel: 5)
		(= global110 (DoSound sndGET_POLYPHONY))
	)
)

