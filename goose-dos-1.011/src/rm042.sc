;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 42)
(include sci.sh)
(use Main)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm042 0
)

(local
	local0
)

(instance rm042 of Rm
	(properties
		picture 42
		style 0
		horizon 143
		south 32
		vanishingY -99
	)

	(method (init)
		(HandsOn)
		(gEgo
			loop: 3
			x: (+ (/ (* (- (gEgo x:) 3) 51) 33) 88)
			y: 188
			init:
		)
		(proc0_10)
		(mother init:)
		(logs1 init: addToPic:)
		(logs2 init: addToPic:)
		(fire init:)
		(Load rsVIEW 91)
		(Load rsVIEW 39)
		(Load rsSOUND 7)
		(super init:)
		(= global207 1)
		(gGlobalMGSound number: 7 priority: 5 loop: -1 play:)
	)

	(method (doit)
		(super doit:)
		(if (> (gEgo distanceTo: mother) 60)
			(= global108 0)
		)
		(if (and (not global108) (< (gEgo distanceTo: mother) 60))
			(= global108 1)
			(gEgo setScript: talkScript)
		)
	)

	(method (dispose)
		(gGlobalMGSound fade:)
		(super dispose:)
	)

	(method (handleEvent event &tmp temp0)
		(switch (event type:)
			(evMOUSEBUTTON
				(if
					(and
						(& (= temp0 (event modifiers:)) emSHIFT)
						(proc0_16 event 244 121 277 167)
						(!= local0 1)
					)
					(MomaScript changeState: 2)
				)
			)
		)
		(super handleEvent: event)
	)
)

(instance talkScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local0 1)
				(mother setScript: 0 setLoop: 3 cycleSpeed: 1 setCycle: Fwd)
				(cond
					((> gScore 14)
						(itemBalloon init:)
						(RedrawCast)
						(Display
							(Format
								@global270
								{You're so close\nto fixing ALL\nof my rhymes,\n%s!}
								@global210
							)
							dsWIDTH
							90
							dsCOORD
							160
							61
							dsALIGN
							alCENTER
							dsFONT
							0
							dsCOLOR
							0
						)
					)
					((> gScore 9)
						(itemBalloon init:)
						(RedrawCast)
						(Display
							(Format
								@global270
								{Oh, you've fixed over\nhalf of my rhymes,\n%s!}
								@global210
							)
							dsWIDTH
							90
							dsCOORD
							160
							57
							dsALIGN
							alCENTER
							dsFONT
							0
							dsCOLOR
							0
						)
					)
					((> gScore 0)
						(itemBalloon init:)
						(RedrawCast)
						(Display
							(Format
								@global270
								{I'm so glad you're fixing my rhymes,\n%s!}
								@global210
							)
							dsWIDTH
							90
							dsCOORD
							160
							61
							dsALIGN
							alCENTER
							dsFONT
							0
							dsCOLOR
							0
						)
					)
					(else
						(itemBalloon init:)
						(RedrawCast)
						(Display
							(Format @global270 {Hello there,\n%s.} @global210)
							dsWIDTH
							90
							dsCOORD
							160
							74
							dsALIGN
							alCENTER
							dsFONT
							0
							dsCOLOR
							0
						)
					)
				)
				(= seconds global120)
			)
			(1
				(itemBalloon dispose:)
				(mother setScript: MomaScript)
				(= local0 0)
				(HandsOn)
				(= cycles 2)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance mother of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			view: 91
			posn: 263 169
			setLoop: 0
			cycleSpeed: 3
			setScript: MomaScript
		)
	)
)

(instance fire of Prop
	(properties)

	(method (init)
		(super init:)
		(self view: 91 posn: 170 131 setLoop: 1 setCycle: Fwd cycleSpeed: 1)
	)
)

(instance itemBalloon of View
	(properties)

	(method (init)
		(super init:)
		(self view: 39 setLoop: 0 posn: 206 119 setPri: 14 stopUpd:)
	)
)

(instance MomaScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(mother setLoop: 0 setCycle: Fwd cycleSpeed: (Random 1 3))
				(= seconds (Random 2 4))
			)
			(1
				(mother setLoop: 2)
				(= seconds (Random 2 4))
				(= state -1)
			)
			(2
				(= cycles (= seconds 0))
				(= local0 1)
				(HandsOff)
				(mother setLoop: 3 cycleSpeed: 1 setCycle: Fwd)
				(itemBalloon init:)
				(RedrawCast)
				(Display
					(switch (Random 0 3)
						(0
							(Format
								@global270
								{Hurry up,\nnow! My\nrhymes need\nfixing.}
							)
						)
						(1
							(Format
								@global270
								{I'm trying\nto write\nmy nursery\nrhymes.}
							)
						)
						(2
							(Format
								@global270
								{Go on,\n%s.\nMy rhymes\nneed your\nhelp.}
								@global210
							)
						)
						(3
							(Format
								@global270
								{We really\nneed your\nhelp,\n%s!}
								@global210
							)
						)
					)
					dsWIDTH
					120
					dsCOORD
					145
					62
					dsALIGN
					alCENTER
					dsFONT
					0
					dsCOLOR
					0
				)
				(= seconds global120)
			)
			(3
				(itemBalloon dispose:)
				(= cycles 5)
				(= state -1)
				(= local0 0)
				(HandsOn)
			)
		)
	)
)

(instance logs1 of View
	(properties
		y 145
		x 124
		view 91
		loop 4
	)

	(method (init)
		(super init:)
		(self setPri: 1)
	)
)

(instance logs2 of View
	(properties
		y 139
		x 124
		view 91
		loop 4
	)

	(method (init)
		(super init:)
		(self setPri: 1)
	)
)

