;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 82)
(include sci.sh)
(use Main)
(use n079)
(use Print)
(use Osc)
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
)

(procedure (EgoDead param1 param2 &tmp [temp0 20] [temp20 250] [temp270 40] temp310 temp311 temp312 temp313 temp314 temp315 temp316 temp317 temp318 temp319 temp320 temp321 temp322 temp323 temp324 temp325 temp326)
	(= local0 -1)
	(gSounds eachElementDo: #pause 1)
	(switch param1
		(18
			(= temp312 633)
			(= temp314 70)
			(= temp313 0)
		)
		(16
			(= temp312 315)
			(= temp314 11)
			(= temp313 0)
		)
		(1
			(= temp312 453)
			(= temp314 46)
			(= temp313 0)
			(= local0 0)
			(= [local2 3] 355)
			(= [local2 7] 355)
			(= [local2 13] 814)
		)
		(4
			(= temp312 424)
			(= temp314 14)
			(= temp313 0)
		)
		(7
			(= [local2 3] 800)
			(= temp312 805)
			(= temp314 47)
			(= temp313 0)
			(= local0 0)
		)
		(20
			(= [local2 3] 800)
			(= temp312 805)
			(= temp314 47)
			(= temp313 0)
			(= local0 0)
		)
		(8
			(= temp312 369)
			(= temp314 71)
			(= temp313 0)
			(= local0 0)
		)
		(9
			(= temp312 337)
			(= temp313 0)
			(= local0 -2)
			(= temp314 15)
		)
		(10
			(= temp312 337)
			(= temp313 0)
			(= local0 -2)
			(= temp314 15)
		)
		(5
			(= temp312 5102)
			(= temp313 0)
			(= temp314 15)
			(= local0 0)
		)
		(12
			(= local0 -3)
			(= temp312 866)
			(= temp313 0)
			(= temp314 15)
		)
		(13
			(= temp312 5102)
			(= temp313 0)
			(= local0 0)
			(= temp314 15)
		)
		(14
			(= temp312 563)
			(= temp314 15)
			(= temp313 1)
			(= local0 1)
			(= [local2 0] 565)
		)
		(6
			(= temp312 408)
			(= temp313 0)
			(= temp314 182)
			(= local0 0)
			(= [local2 9] 572)
		)
		(11
			(= temp312 409)
			(= temp313 0)
			(= temp314 13)
			(= local0 0)
		)
		(19
			(= temp312 823)
			(= temp314 42)
			(= [local2 0] 822)
		)
		(else
			(Printf {ERROR: must call EgoDead with valid reason})
		)
	)
	(if (< (>> (MemoryInfo 4) $0006) 230) ; TotalHunk
		(= temp312 (+= temp312 1000))
	)
	(if (!= param1 16)
		(deathMusic number: 446 play: setLoop: 1)
	else
		(deathMusic number: 313 play: setLoop: 1)
	)
	(Load rsVIEW temp312)
	(if (not (IsObject param2))
		(= param2 0)
	)
	(= temp310 (gSystemWindow back:))
	(gSystemWindow back: temp314)
	(= temp311 gTheCursor)
	(gGame setCursor: gNormalCursor)
	(Message msgGET 82 2 0 param1 1 @temp20)
	(Message msgGET 82 2 0 param1 2 @temp270)
	(= temp317 80)
	(= temp319 90)
	(= temp318 180)
	(= temp320 90)
	(= temp321 1)
	(= temp322 10)
	(= temp323 5)
	(= temp324 3)
	(= temp326 62)
	(= temp325 72)
	(= temp316 0)
	(SetCursor 255 100)
	(while (not temp316)
		(if (== (gGame printLang:) 1)
			(Print
				font: gUserFont
				addTitle: @temp270
				addText: @temp20 temp325 temp321
				addIcon: frameIcon 0 0 2 0
				addIcon:
					(deathIcon view: temp312 cel: 0 loop: temp313 yourself:)
					0
					0
					temp323
					temp324
			)
		else
			(Print
				font: gUserFont
				addText: @temp270 temp325 temp321
				addText: @temp20 temp325 (+ temp321 25)
				addIcon: frameIcon 0 0 2 0
				addIcon:
					(deathIcon view: temp312 cel: 0 loop: temp313 yourself:)
					0
					0
					temp323
					temp324
			)
		)
		(if (== gCurRoomNum 230)
			(= temp316
				(Print
					addButton: ; "Try Again"
						0
						2
						0
						2
						1
						(- ((Print dialog:) nsRight:) 75)
						(+ temp326 (proc79_4 35 25 25 25 0))
						82
					init:
				)
			)
		else
			(= temp316
				(Print
					addButton: ; "Restore"
						1
						2
						0
						3
						1
						(+ temp325 1)
						(+ temp326 (proc79_4 35 25 25 25 0))
						82
					addButton: ; "Try Again"
						0
						2
						0
						2
						1
						(- ((Print dialog:) nsRight:) 75)
						(+ temp326 (proc79_4 35 25 25 25 0))
						82
					init:
				)
			)
		)
		(switch temp316
			(0
				(gSystemWindow back: temp310)
				(gGame setCursor: temp311)
				(gSounds eachElementDo: #pause 0)
				(if param2
					(param2 cue:)
				)
				(= temp316 -1)
			)
			(1
				(= local19 0)
				(gGame restore: hideControls: drawControls:)
				(= temp316 0)
			)
		)
	)
	(soundFx dispose:)
	(deathMusic dispose:)
	(LoadMany 0 967 82)
)

(instance deathIcon of DCIcon
	(properties
		cycleSpeed 12
	)

	(method (init)
		(cond
			((== local0 -3)
				((= cycler (Osc new:)) init: self)
			)
			((== local0 -1)
				((= cycler (Fwd new:)) init: self)
			)
			((== local0 -2)
				((= cycler (CT new:)) init: self 10 1)
			)
			(else
				(= cycler ((End new:) init: self cueScript yourself:))
			)
		)
	)

	(method (cycle)
		(if (!= [local2 cel] -1)
			(soundFx number: [local2 cel] play:)
		)
		(if (and (not cycler) (not local19) (== local0 -2) (not (-- local18)))
			(= local18 60)
			(= cycler ((End new:) init: self yourself:))
			(= local19 1)
			(return)
		)
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

