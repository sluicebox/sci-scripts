;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 666)
(include sci.sh)
(use Main)
(use Print)
(use LoadMany)
(use Sound)

(public
	proc666_0 0
)

(procedure (proc666_0 param1 param2 &tmp temp0)
	(Load rsVIEW 920 921 925)
	(Load rsMESSAGE 666)
	(Load rsHEAP 64912)
	(Load rsSCRIPT 64912)
	(if (gGSound1 handle:)
		(gGSound1 pause: 1)
	)
	(if (gGSound2 handle:)
		(gGSound2 pause: 1)
	)
	(if (& gMsgType $0002)
		(deathMusic play: setVol: 110)
	else
		(deathMusic play:)
	)
	(switch param1
		(17
			(switch (proc0_8 3 5)
				(3
					(= param1 21)
				)
				(4
					(= param1 22)
				)
			)
		)
	)
	(= temp0 gTheCursor)
	(gGame setCursor: gNormalCursor 1 220 103)
	(if (& gMsgType $0002)
		(gTalkers eachElementDo: #dispose)
		(DoAudio audPLAY 666 3 0 0 param1 1 130)
	)
	(repeat
		(switch
			((Print new:)
				addBitmap: 925 0 0
				font: gUserFont
				fore: 84
				back: 0
				width: 150
				addText: 3 0 0 param1 74 23 666
				addButtonBM: 925 1 0 1 { } 83 62
				addButtonBM: 925 2 0 2 { } 161 62
				init:
			)
			(1
				(if (& gMsgType $0002)
					(DoAudio audSTOP 666 3 0 0 param1)
				)
				(gGame restore:)
			)
			(2
				(if (& gMsgType $0002)
					(DoAudio audSTOP 666 3 0 0 param1)
				)
				(gGame setCursor: temp0)
				(if (and (> argc 1) param2)
					(param2 cue:)
				)
				(break)
			)
		)
	)
	(if (gGSound1 handle:)
		(gGSound1 pause: 0)
	)
	(if (gGSound2 handle:)
		(gGSound2 pause: 0)
	)
	(deathMusic stop: dispose:)
	(LoadMany 0 64967 666)
)

(instance deathMusic of Sound
	(properties
		number 990
	)
)

