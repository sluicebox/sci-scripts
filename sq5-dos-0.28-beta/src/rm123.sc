;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 123)
(include sci.sh)
(use Main)
(use Scaler)
(use PolyPath)
(use Polygon)
(use LoadMany)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm123 0
)

(instance rm123 of Rm
	(properties
		picture 21
		style -32758
		horizon -20
		vanishingX 140
		vanishingY -5
	)

	(method (init)
		(self setRegions: 109) ; starCon
		(LoadMany rsVIEW 157 127 110 108 113)
		(LoadMany rsMESSAGE 123)
		(if (IsFlag 2)
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PContainedAccess
						init: 36 189 287 189 245 153 228 143 203 138 206 128 194 124 182 123 163 120 160 111 143 105 136 104 137 108 133 115 104 144 71 171
						yourself:
					)
			)
		else
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PContainedAccess
						init: 36 189 287 189 245 153 228 143 204 142 201 134 210 130 186 120 157 109 143 105 136 104 137 108 133 115 104 144 71 171
						yourself:
					)
			)
		)
		(classDoor init: approachVerbs: 4 stopUpd:) ; Do
		(doorFrameLeft init: addToPic:)
		(doorFrameRight init: addToPic:)
		(extraPanel init: addToPic:)
		(bboard init: addToPic:)
		(ship1 init: addToPic:)
		(ship2 init: addToPic:)
		(ship3 init: addToPic:)
		(shipLight1 setCycle: Fwd init:)
		(shipLight2 setCycle: Fwd init:)
		(shipLight3 init: setScript: sShipLights)
		(guy1 setCycle: Fwd init:)
		(guy2 setCycle: Fwd init:)
		(guy3 setCycle: Fwd init:)
		(guy4 init:)
		(guy5 init:)
		(guy6 init:)
		(guy7 init: setScript: sBayGuys)
		(NormalEgo 1)
		(gEgo setScale: Scaler 130 24 157 106)
		(switch gPrevRoomNum
			(122
				(gEgo init:)
				(gCurRoom setScript: (ScriptID 109 5)) ; sEnterSouth
			)
			(135
				(gCurRoom setScript: sLeaveClassroom)
			)
			(else
				(gEgo init:)
				(gCurRoom setScript: (ScriptID 109 6)) ; sEnterNorth
			)
		)
		(super init:)
		(if (IsFlag 2)
			(cadet1 init: setScript: sCadet1Move)
			(cadet2 init: setScript: sCadet2Move)
			(cadet3 init: setScript: sCadet3Move)
			(cadet4 init:)
			(cadet5 init:)
		)
	)

	(method (doit)
		(super doit:)
		(cond
			(script 0)
			((and (> (gEgo y:) 157) (< 90 (gEgo heading:) 270))
				(gCurRoom setScript: (ScriptID 109 3) 0 122) ; sExitSouth
			)
			((<= (gEgo y:) 106)
				(gCurRoom setScript: (ScriptID 109 4) 0 125) ; sExitNorth
			)
		)
	)
)

(instance sLeaveClassroom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= seconds 1)
			)
			(1
				(classDoor setCycle: End self)
			)
			(2
				(gSq5Music2 number: 103 setLoop: 1 play:)
				(gEgo
					setPri: 8
					loop: 1
					posn: 222 122
					init:
					setMotion: MoveTo 183 130 self
				)
			)
			(3
				(classDoor setCycle: Beg self)
				(gSq5Music2 number: 103 setLoop: 1 play:)
			)
			(4
				(classDoor stopUpd:)
				(gEgo setPri: -1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sCadet1Move of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cadet1 setCycle: End self)
			)
			(1
				(= ticks (Random 90 360))
			)
			(2
				(cadet1 setCycle: Beg self)
			)
			(3
				(= ticks (Random 60 100))
			)
			(4
				(= cycles 1)
				(= state -1)
			)
		)
	)
)

(instance sCadet2Move of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cadet2 setCycle: End self)
			)
			(1
				(= ticks (Random 120 240))
			)
			(2
				(cadet2 setCycle: Beg self)
			)
			(3
				(= ticks (Random 120 240))
			)
			(4
				(= cycles 1)
				(= state -1)
			)
		)
	)
)

(instance sCadet3Move of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cadet3 setCycle: End self)
			)
			(1
				(= ticks (Random 120 240))
			)
			(2
				(cadet3 setCycle: Beg self)
			)
			(3
				(= ticks (Random 120 240))
			)
			(4
				(= cycles 1)
				(= state -1)
			)
		)
	)
)

(instance sRogGetScore of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 173 119 self)
			)
			(1
				(gEgo
					view: 127
					loop: 1
					cel: 0
					x: 173
					y: 119
					setScale: 0
					setCycle: End self
				)
			)
			(2
				(= seconds 3)
			)
			(3
				(gCurRoom newRoom: 166)
				(self dispose:)
			)
		)
	)
)

(instance sGoIntoClass of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(classDoor setCycle: End self)
				(gSq5Music2 number: 103 setLoop: 1 play:)
			)
			(1
				(gEgo setPri: 8 setMotion: MoveTo 225 122 self)
			)
			(2
				(classDoor setCycle: Beg self)
				(gSq5Music2 number: 103 setLoop: 1 play:)
			)
			(3
				(gCurRoom newRoom: 135)
				(gGame handsOn:)
			)
		)
	)
)

(instance sBayGuys of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 4 7))
			)
			(1
				(guy7 setLoop: 8 setCycle: Fwd setMotion: MoveTo 50 122 self)
			)
			(2
				(guy7 setLoop: 9 setCycle: End self)
			)
			(3
				(guy7 setLoop: 10 setCycle: Fwd)
				(= seconds (Random 4 7))
			)
			(4
				(guy4 setLoop: 4 setCel: 0 setMotion: MoveTo 90 104)
				(guy1 setCycle: 0)
				(= seconds (Random 4 7))
			)
			(5
				(guy5 setLoop: 5 setCel: 0 setMotion: MoveTo 0 128)
				(guy1 setCycle: Fwd)
				(= seconds (Random 4 6))
			)
			(6
				(guy6 setMotion: MoveTo 0 66)
				(guy2 setCycle: 0)
				(= seconds (Random 4 6))
			)
			(7
				(guy4 setLoop: 5 setMotion: MoveTo 1 75)
				(guy3 setCycle: 0)
				(= seconds (Random 3 5))
			)
			(8
				(guy6 setMotion: MoveTo 87 114)
				(guy2 setCycle: Fwd)
				(guy3 setCycle: Fwd)
				(= seconds (Random 3 5))
			)
			(9
				(guy5 setLoop: 4 setMotion: MoveTo 53 145)
				(= seconds (Random 4 7))
			)
			(10
				(= state (Random 3 5))
				(= cycles 1)
			)
		)
	)
)

(instance sShipLights of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(shipLight4 init:)
				(shipLight5 init:)
				(shipLight6 init:)
				(shipLight7 init:)
				(= cycles 1)
			)
			(1
				(shipLight3 hide:)
				(shipLight4 hide:)
				(shipLight5 show:)
				(shipLight6 show:)
				(shipLight7 show:)
				(= seconds 3)
			)
			(2
				(shipLight3 show:)
				(shipLight4 show:)
				(shipLight5 hide:)
				(shipLight6 hide:)
				(shipLight7 hide:)
				(= seconds 2)
			)
			(3
				(= state 0)
				(= cycles 1)
			)
		)
	)
)

(instance cadet1 of Prop
	(properties
		x 174
		y 117
		noun 8
		view 157
		loop 1
		signal 16384
		detailLevel 2
	)
)

(instance cadet2 of Prop
	(properties
		x 185
		y 119
		noun 8
		view 157
		signal 16384
		detailLevel 2
	)
)

(instance cadet3 of Prop
	(properties
		x 168
		y 118
		noun 8
		view 157
		loop 2
		signal 16384
		detailLevel 2
	)
)

(instance classDoor of Prop
	(properties
		x 212
		y 127
		noun 2
		approachX 208
		approachY 126
		view 110
		loop 5
		priority 7
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (not (IsFlag 1))
					((ScriptID 109 1) dispose:) ; sTestTimer
					(gCurRoom setScript: sGoIntoClass)
				else
					(gMessager say: 2 4 1 0) ; "The door is locked--class is over for the day. Besides, you've got more important things to do right now."
				)
			)
			(1 ; Look
				(if (IsFlag 1)
					(gMessager say: 2 1 1 0) ; "Recently, the StarCon Aptitude Test was administered in this classroom. As a result, despondent cadets can be found sulking throughout the station."
				else
					(gMessager say: 2 1 2 0) ; "This door leads to one of the academy's classrooms. Currently, the students in your Space Piloting 101 class are taking the StarCon Aptitude Test here."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance guy1 of Prop
	(properties
		x 57
		y 109
		noun 7
		view 108
		priority 14
		signal 24592
		detailLevel 2
	)
)

(instance guy2 of Prop
	(properties
		x 24
		y 101
		noun 7
		view 108
		loop 7
		priority 14
		signal 24592
		detailLevel 2
	)
)

(instance guy3 of Prop
	(properties
		x 17
		y 108
		noun 7
		view 108
		loop 2
		priority 14
		signal 24592
		detailLevel 2
	)
)

(instance guy4 of Actor
	(properties
		x 1
		y 75
		noun 7
		yStep 1
		view 108
		loop 4
		priority 4
		signal 24592
		detailLevel 2
		xStep 1
	)
)

(instance guy5 of Actor
	(properties
		x 53
		y 145
		noun 7
		yStep 1
		view 108
		loop 5
		priority 4
		signal 24592
		detailLevel 2
		xStep 1
	)
)

(instance guy6 of Actor
	(properties
		x 87
		y 114
		noun 7
		yStep 1
		view 108
		loop 11
		priority 4
		signal 24592
		detailLevel 2
		xStep 1
	)
)

(instance guy7 of Actor
	(properties
		x 113
		y 108
		noun 7
		yStep 1
		view 108
		loop 8
		priority 4
		signal 24592
		detailLevel 2
		xStep 1
	)
)

(instance shipLight1 of Prop
	(properties
		x 6
		y 48
		noun 4
		view 113
		loop 10
		priority 14
		signal 24592
		cycleSpeed 12
		detailLevel 2
	)
)

(instance shipLight2 of Prop
	(properties
		x 63
		y 75
		noun 6
		view 113
		loop 12
		priority 14
		signal 24592
		cycleSpeed 9
		detailLevel 2
	)
)

(instance shipLight3 of Prop
	(properties
		x 5
		y 137
		noun 5
		view 113
		loop 11
		priority 14
		signal 24592
		detailLevel 2
	)
)

(instance shipLight4 of Prop
	(properties
		x 64
		y 136
		noun 5
		view 113
		loop 11
		priority 14
		signal 24592
		detailLevel 2
	)
)

(instance shipLight5 of Prop
	(properties
		x 5
		y 93
		noun 5
		view 113
		loop 11
		cel 1
		priority 14
		signal 24592
		detailLevel 2
	)
)

(instance shipLight6 of Prop
	(properties
		x 63
		y 92
		noun 5
		view 113
		loop 11
		cel 1
		priority 14
		signal 24592
		detailLevel 2
	)
)

(instance shipLight7 of Prop
	(properties
		x 33
		y 40
		noun 5
		view 113
		loop 11
		cel 1
		priority 14
		signal 24592
		detailLevel 2
	)
)

(instance cadet4 of View
	(properties
		x 183
		y 116
		noun 8
		view 157
		loop 3
		signal 16384
	)
)

(instance cadet5 of View
	(properties
		x 180
		y 120
		noun 8
		view 157
		loop 4
		signal 16384
	)
)

(instance doorFrameLeft of View
	(properties
		x 212
		y 127
		noun 2
		view 110
		loop 3
		priority 7
		signal 16400
	)
)

(instance doorFrameRight of View
	(properties
		x 212
		y 127
		noun 2
		view 110
		loop 4
		priority 9
		signal 16400
	)
)

(instance ship1 of View
	(properties
		x 10
		y 40
		noun 4
		view 113
		loop 2
		signal 20480
	)
)

(instance ship2 of View
	(properties
		x 6
		y 92
		noun 5
		view 113
		loop 2
		cel 1
		signal 20480
	)
)

(instance ship3 of View
	(properties
		x 65
		y 73
		noun 6
		view 113
		loop 2
		cel 2
		signal 20480
	)
)

(instance bboard of View
	(properties
		x 185
		y 105
		noun 1
		view 110
		loop 2
		priority 8
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (IsFlag 2)
					(gCurRoom setScript: sRogGetScore)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(1 ; Look
				(if (IsFlag 2)
					(gCurRoom setScript: sRogGetScore)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance extraPanel of View
	(properties
		x 250
		y 124
		noun 3
		view 110
		loop 9
		priority 5
		signal 16400
	)
)

