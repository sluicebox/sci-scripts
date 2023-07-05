;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 82)
(include sci.sh)
(use Main)
(use Print)
(use LoadMany)
(use DCIcon)
(use Sound)
(use Motion)
(use System)

(public
	EgoDead 0
)

(local
	local0
	local1
	[local2 16] = [-1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1]
	local18 = 60
	local19
	local20
	local21
)

(procedure (EgoDead param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13 temp14 temp15 temp16)
	(= local21 param1)
	(= local0 -1)
	(gSounds eachElementDo: #pause 1)
	(switch local21
		(18
			(= temp2 633)
			(= temp4 70)
			(= temp3 0)
		)
		(16
			(= temp2 315)
			(= temp4 11)
			(= temp3 0)
		)
		(1
			(= temp2 453)
			(= temp4 46)
			(= temp3 0)
			(= local0 0)
			(= [local2 3] 355)
			(= [local2 7] 355)
			(= [local2 13] 814)
		)
		(4
			(= temp2 424)
			(= temp4 14)
			(= temp3 0)
		)
		(7
			(= [local2 3] 800)
			(= temp2 805)
			(= temp4 47)
			(= temp3 0)
			(= local0 0)
		)
		(20
			(= [local2 3] 800)
			(= temp2 805)
			(= temp4 47)
			(= temp3 0)
			(= local0 0)
		)
		(8
			(= temp2 369)
			(= temp4 71)
			(= temp3 0)
			(= local0 0)
		)
		(9
			(= temp2 337)
			(= temp3 0)
			(= local0 -2)
			(= temp4 15)
		)
		(10
			(= temp2 337)
			(= temp3 0)
			(= local0 -2)
			(= temp4 15)
		)
		(5
			(= temp2 5102)
			(= temp3 0)
			(= temp4 15)
			(= local0 0)
		)
		(12
			(= temp2 866)
			(= temp3 0)
			(= temp4 15)
		)
		(13
			(= temp2 5102)
			(= temp3 0)
			(= local0 0)
			(= temp4 15)
		)
		(14
			(= temp2 563)
			(= temp4 15)
			(= temp3 0)
			(= local0 0)
			(= [local2 0] 565)
		)
		(6
			(= temp2 408)
			(= temp3 0)
			(= temp4 182)
			(= local0 0)
			(= [local2 9] 572)
		)
		(11
			(= temp2 409)
			(= temp3 0)
			(= temp4 13)
			(= local0 0)
		)
		(19
			(= temp2 823)
			(= temp4 42)
			(= [local2 0] 822)
		)
		(else
			(Printf {ERROR: must call EgoDead with valid reason})
		)
	)
	(if (!= local21 16)
		(deathMusic number: 446 play: setLoop: 1)
	else
		(deathMusic number: 313 play: setLoop: 1)
	)
	(Load rsVIEW temp2)
	(= temp1 gTheCursor)
	(gGame setCursor: gNormalCursor)
	(= temp7 80)
	(= temp9 90)
	(= temp8 180)
	(= temp10 90)
	(= temp11 1)
	(= temp12 10)
	(= temp13 0)
	(= temp14 1)
	(= temp16 57)
	(= temp15 72)
	(= temp6 0)
	(SetCursor 255 100)
	(while (not temp6)
		(if (not (OneOf local21 7 20))
			(DoAudio audPLAY 82 2 0 local21 1)
		)
		(Print
			font: gUserFont
			width: 110
			back: temp4
			addTitle: 2 0 local21 2 82
			addText: 2 0 local21 1 temp15 temp11 82
			addIcon: frameIcon -1 -1 2 4
			addIcon:
				(deathIcon view: temp2 cel: 0 loop: temp3 yourself:)
				-1
				-1
				temp13
				temp14
		)
		((Print dialog:) setSize:)
		(= temp6
			(Print
				addButton: 1 2 0 3 1 (+ temp15 1) temp16 82 ; "Restore"
				addButton: 0 2 0 2 1 (+ temp15 68) temp16 82 ; "Try Again"
				init:
			)
		)
		(DoAudio audSTOP 82 2 0 local21 1)
		(switch temp6
			(0
				(Print back: 7)
				(gGame setCursor: temp1)
				(soundFx number: 0 dispose:)
				(deathMusic number: 0 dispose:)
				(gSounds eachElementDo: #pause 0)
				(if param2
					(param2 cue:)
				)
				(= temp6 -1)
			)
			(1
				(= local19 0)
				(deathMusic stop:)
				(gGame restore:)
				(deathMusic play:)
				(FrameOut)
				(= temp6 0)
			)
		)
	)
	(LoadMany 0 64967 82)
)

(instance deathIcon of DCIcon
	(properties)

	(method (init)
		(cond
			((== local0 -1)
				((= cycler (Fwd new:)) init: self)
			)
			((== local0 -2)
				((= cycler (CT new:)) init: self 10 1)
			)
			(else
				((= cycler (End new:)) init: self cueScript)
			)
		)
		(super init: &rest)
	)

	(method (cycle &tmp temp0)
		(if gCuees
			(gCuees doit:)
		)
		(cond
			((and (!= [local2 cel] -1) (OneOf local21 7 20))
				(cond
					((not (soundFx handle:))
						(soundFx number: [local2 cel] loop: 1 play:)
					)
					((== (soundFx handle:) -1)
						(soundFx handle: 0)
						(DoAudio audPLAY 82 2 0 local21 1)
					)
				)
			)
			((!= [local2 cel] -1)
				(soundFx number: [local2 cel] play:)
			)
		)
		(if (and (not cycler) (not local19) (== local0 -2) (not (-- local18)))
			(= local18 60)
			(= cycler ((End new:) init: self yourself:))
			(= local19 1)
			(return)
		)
		(= temp0 cel)
		(super cycle:)
		(if (and cycler (cycler completed:))
			(cycler motionCue:)
		)
	)
)

(instance frameIcon of DCIcon
	(properties
		view 1850
	)

	(method (init)
		(super init: &rest)
		(cycler dispose:)
		(= cycler 0)
	)
)

(instance cueScript of Script
	(properties)

	(method (cue)
		(if (!= (deathIcon loop:) local0)
			(deathIcon loop: local0 cel: 0)
			(deathIcon init:)
		)
	)
)

(instance deathMusic of Sound
	(properties
		flags 1
	)
)

(instance soundFx of Sound
	(properties
		flags 1
	)
)

