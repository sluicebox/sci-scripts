;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 82)
(include sci.sh)
(use Main)
(use n079)
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
)

(procedure (EgoDead param1 param2 &tmp [temp0 20] [temp20 150] [temp170 20] temp190 temp191 temp192 temp193 temp194 temp195 temp196 temp197 temp198 temp199 temp200 temp201 temp202 temp203 temp204 temp205 temp206)
	(= local0 -1)
	(gSounds eachElementDo: #pause 1)
	(switch param1
		(18
			(= temp192 633)
			(= temp194 70)
			(= temp193 0)
		)
		(16
			(= temp192 315)
			(= temp194 11)
			(= temp193 0)
		)
		(1
			(= temp192 453)
			(= temp194 46)
			(= temp193 0)
			(= local0 0)
			(= [local2 3] 355)
			(= [local2 7] 355)
			(= [local2 13] 814)
		)
		(4
			(= temp192 424)
			(= temp194 14)
			(= temp193 0)
		)
		(7
			(= [local2 3] 800)
			(= temp192 805)
			(= temp194 47)
			(= temp193 0)
			(= local0 0)
		)
		(20
			(= [local2 3] 800)
			(= temp192 805)
			(= temp194 47)
			(= temp193 0)
			(= local0 0)
		)
		(8
			(= temp192 369)
			(= temp194 71)
			(= temp193 0)
			(= local0 0)
		)
		(9
			(= temp192 337)
			(= temp193 0)
			(= local0 -2)
			(= temp194 15)
		)
		(10
			(= temp192 337)
			(= temp193 0)
			(= local0 -2)
			(= temp194 15)
		)
		(5
			(= temp192 5102)
			(= temp193 0)
			(= temp194 15)
			(= local0 0)
		)
		(12
			(= temp192 866)
			(= temp193 0)
			(= temp194 15)
		)
		(13
			(= temp192 5102)
			(= temp193 0)
			(= local0 0)
			(= temp194 15)
		)
		(14
			(= temp192 563)
			(= temp194 15)
			(= temp193 1)
			(= local0 1)
			(= [local2 0] 565)
		)
		(6
			(= temp192 408)
			(= temp193 0)
			(= temp194 182)
			(= local0 0)
			(= [local2 9] 572)
		)
		(11
			(= temp192 409)
			(= temp193 0)
			(= temp194 13)
			(= local0 0)
		)
		(19
			(= temp192 823)
			(= temp194 42)
			(= [local2 0] 822)
		)
		(else
			(Printf {ERROR: must call EgoDead with valid reason})
		)
	)
	(if (< (>> (MemoryInfo 4) $0006) 230) ; TotalHunk
		(= temp192 (+= temp192 1000))
	)
	(if (!= param1 16)
		(deathMusic number: 446 play: setLoop: 1)
	else
		(deathMusic number: 313 play: setLoop: 1)
	)
	(Load rsVIEW temp192)
	(if (not (IsObject param2))
		(= param2 0)
	)
	(= temp190 (gSystemWindow back:))
	(gSystemWindow back: temp194)
	(= temp191 gTheCursor)
	(gGame setCursor: gNormalCursor)
	(Message msgGET 82 2 0 param1 1 @temp20)
	(Message msgGET 82 2 0 param1 2 @temp170)
	(= temp197 80)
	(= temp199 90)
	(= temp198 180)
	(= temp200 90)
	(= temp201 1)
	(= temp202 10)
	(= temp203 5)
	(= temp204 3)
	(= temp206 62)
	(= temp205 72)
	(= temp196 0)
	(SetCursor 255 100)
	(while (not temp196)
		(Print
			font: gUserFont
			addTitle: @temp170
			addText: @temp20 temp205 temp201
			addIcon: frameIcon 0 0 2 0
			addIcon:
				(deathIcon view: temp192 cel: 0 loop: temp193 yourself:)
				0
				0
				temp203
				temp204
		)
		(switch
			(= temp196
				(Print
					addButton: 1 2 0 3 1 (+ temp205 1) temp206 82 ; "Restore"
					addButton: ; "Try Again"
						0
						2
						0
						2
						1
						(- ((Print dialog:) nsRight:) 75)
						temp206
						82
					init:
				)
			)
			(0
				(gSystemWindow back: temp190)
				(gGame setCursor: temp191)
				(gSounds eachElementDo: #pause 0)
				(if param2
					(param2 cue:)
				)
				(= temp196 -1)
			)
			(1
				(if (IsFlag 86)
					(gSystemWindow back: temp190)
					(gGame setCursor: temp191)
					(gSounds eachElementDo: #pause 0)
					(if param2
						(param2 cue:)
					)
					(= temp196 -1)
				else
					(= local19 0)
					(gGame restore: hideControls: drawControls:)
					(= temp196 0)
				)
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

