;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 195)
(include sci.sh)
(use Main)
(use LoadMany)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm195 0
)

(local
	[local0 18] = [176 171 165 157 148 137 127 115 102 86 72 60 51 38 26 12 -1 -14]
	[local18 18] = [126 128 130 132 134 136 138 140 142 144 146 148 150 152 154 156 158 160]
	[local36 18] = [10 12 14 17 21 26 34 42 52 69 83 94 103 119 128 128 128 128]
	local54
)

(instance rm195 of Rm
	(properties
		picture 35
		style -32758
	)

	(method (init)
		(self setRegions: 109) ; starCon
		(LoadMany rsVIEW 155)
		(NormalEgo 0)
		(super init:)
		(gCurRoom setScript: sByeByeRog)
	)
)

(instance sByeByeRog of Script
	(properties)

	(method (doit)
		(Palette palANIMATE 15 22 1)
		(super doit: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(ejectRoger
					init:
					setCycle: 0
					setLoop: -1
					setLoop: 0
					setMotion: MoveTo 180 124 self
				)
			)
			(1
				(gSq5Music2 number: 154 setLoop: 1 play:)
				(= ticks 5)
			)
			(2
				(ejectRoger
					setCycle: 0
					x: [local0 local54]
					y: [local18 local54]
					scaleX: [local36 local54]
					scaleY: [local36 local54]
				)
				(if (<= (++ local54) 17)
					(-- state)
				)
				(= ticks 5)
			)
			(3
				(cond
					((not (IsFlag 1))
						(EgoDead 1) ; "There's no place for slackers in StarCon Academy."
					)
					((< global115 4)
						(EgoDead 2) ; "Maybe you should have taken the correspondence course."
					)
					(else
						(EgoDead 3) ; "StarCon academy is no place for slackers."
					)
				)
			)
		)
	)
)

(instance ejectRoger of Actor
	(properties
		x 180
		y 103
		view 155
		scaleSignal 1
		scaleX 7
		scaleY 7
		moveSpeed 3
	)
)

