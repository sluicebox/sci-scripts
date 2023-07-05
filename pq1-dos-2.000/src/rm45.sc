;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 45)
(include sci.sh)
(use Main)
(use ExitCar)
(use eRS)
(use PolyPath)
(use Polygon)
(use Feature)
(use StopWalk)
(use Motion)
(use Actor)
(use System)

(public
	rm45 0
	barf 1
)

(local
	[local0 9] = [243 184 217 184 150 158 150 135 -32768]
)

(instance rm45 of PQRoom
	(properties
		noun 1
		picture 45
	)

	(method (init)
		(if (OneOf gPrevRoomNum 1 500)
			(= global207 104)
			(= global206 1)
			(gEgo get: 2 get: 0 get: 9) ; Extender, Service_Revolver, Handcuffs
			(= global211 64)
		)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 3 166 3 187 28 187 315 84 315 58 214 95 165 74 126 74 111 105 119 124
					yourself:
				)
		)
		(super init:)
		(bushes init:)
		(fowlers init:)
		(grass init:)
		(oakTrees init:)
		(path init:)
		(pineTrees init:)
		(posts init:)
		(sidewalk init:)
		(sky init:)
		(spiPlant init:)
		(street init:)
		(HandsOn)
		(gEgo init:)
		(switch gPrevRoomNum
			(46
				(gEgo posn: 153 79)
				(self posn: 153 86 setScript: (ScriptID 896 1)) ; sWI
				(proc160_0)
				(cond
					((== global211 67)
						(laura posn: 142 118 init:)
						(colby init:)
						(simms
							cycleSpeed: (gEgo cycleSpeed:)
							moveSpeed: (gEgo moveSpeed:)
							setCycle: StopWalk -1
							init:
							setMotion: MoveTo 188 113
						)
						(script next: sGotEm)
					)
					((OneOf global211 65 66)
						(laura
							posn: 319 70
							init:
							setLoop: 5
							setCycle: Walk
							setMotion: MoveTo 292 83 sMissedBust
						)
						(script next: sMissedBust)
					)
				)
			)
			(else
				(gEgo init:)
				(self setScript: (ScriptID 160 1)) ; ExitCar
				(script next: sGetEm)
				(if (== global211 64)
					(laura setScript: sGetOut)
				)
			)
		)
		((ScriptID 160 3) actions: doorActions) ; carDoor
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((& (gEgo onControl: 1) $0002)
				(self newRoom: 46)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 315)
		(DisposeScript 1399)
		(DisposeScript 160)
	)
)

(instance barf of Obj
	(properties)
)

(instance sGetEm of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 243 183 self)
			)
			(1
				(gEgo setMotion: MoveTo 207 179 self)
			)
			(2
				(gEgo setMotion: MoveTo 163 157 self)
			)
			(3
				(gEgo setMotion: MoveTo 161 115 self)
			)
			(4
				(gEgo setHeading: 90 self)
			)
			(5
				(= cycles 2)
			)
			(6
				(gMessager say: 13 0 1 0 self) ; "Okay, Sonny, we've been given a tip that a drug deal is going down in the park this afternoon. What we need to do is this: You go straight into the park, and position yourself so that you can watch the bench without being observed. I'll go around the side and cover the park's other entrance. Any questions?"
			)
			(7
				(laura setMotion: MoveTo 330 60 self)
			)
			(8
				(laura dispose:)
				(NormalEgo)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sGotEm of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 179 108 self)
			)
			(1
				(= cycles 3)
			)
			(2
				(gMessager say: 13 0 (if (IsFlag 176) 3 else 7) 0 self)
			)
			(3
				(gMessager say: 13 0 5 0 self) ; "Okay then. Mister--Colby, is it? How long have you been dealing to little boys, Mr. Colby?"
			)
			(4
				(HandsOn)
				(gTheIconBar disable: 0)
				(= cycles 2)
			)
			(5
				(self dispose:)
			)
		)
	)
)

(instance sGetOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((= register (Prop new:))
					view: 104
					loop: 2
					x: 226
					y: 118
					init:
					setCycle: End self
				)
			)
			(1
				(laura
					init:
					setLoop: 5
					setPri: 5
					yStep: 4
					setMotion: MoveTo 238 143 self
				)
			)
			(2
				(laura setMotion: MoveTo 235 128 self)
			)
			(3
				(laura
					setCycle: StopWalk -1
					setLoop: -1
					setPri: -1
					yStep: 2
					setMotion: MoveTo 238 121 self
				)
			)
			(4
				(laura setMotion: MoveTo 232 112 self)
			)
			(5
				(laura setHeading: 225 self)
			)
			(6
				(register setCycle: Beg self)
			)
			(7
				(register dispose:)
				(laura setMotion: MoveTo 200 113 self)
			)
			(8
				(= global211 65)
				(self dispose:)
			)
		)
	)
)

(instance sInterogEm of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gMessager say: 14 2 4 0 self) ; "Victor, how long have you been taking drugs?"
			)
			(1
				(SetScore 178 2)
				(if (IsFlag 177)
					(= global211 70)
					(gCurRoom newRoom: 500)
				else
					(= cycles 2)
				)
			)
			(2
				(gMessager say: 13 0 6 0 self) ; "Nice bust, Bonds. You just forgot one little thing--you didn't search Victor Simms. The boy panicked, and swallowed the packet of cocaine he had just purchased in an attempt to conceal it. He died. You were immediately suspended. Remember, not following police procedure can cost people their lives--your own, or someone else's."
			)
			(3
				(EgoDead)
			)
		)
	)
)

(instance doorActions of Actions
	(properties)

	(method (doVerb theVerb)
		(return
			(if (== theVerb 4) ; Do
				(gCurRoom setScript: sGoAway)
				1
			else
				0
			)
		)
	)
)

(instance sGoAway of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (!= global211 70)
					(gMessager say: 1 4 4 0 self 160) ; "That's not an option at this time."
				else
					(++ state)
					(gEgo setMotion: PolyPath 149 141 self)
				)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
			(2
				(gEgo setMotion: MoveTo 163 157 self)
			)
			(3
				(gEgo setMotion: MoveTo 207 179 self)
			)
			(4
				(gEgo setMotion: MoveTo 243 183 self)
			)
			(5
				(gEgo setMotion: MoveTo 312 160 self)
			)
			(6
				(self next: (ScriptID 160 2) dispose:) ; EnterCar
			)
		)
	)
)

(instance simms of Actor
	(properties
		x 153
		y 86
		noun 14
		view 398
		loop 8
		cel 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (IsFlag 177)
					(gMessager say: 13 4 10 2) ; "You've already done that! Keep your mind on your work, Bonds."
				else
					(gMessager say: 13 4 10 1) ; "You should've searched him back when you first cuffed him. It's a little late now."
				)
			)
			(2 ; Talk
				(gCurRoom setScript: sInterogEm)
			)
		)
	)
)

(instance colby of Actor
	(properties
		x 158
		y 119
		view 392
		loop 8
		cel 4
	)
)

(instance laura of Actor
	(properties
		x 244
		y 149
		view 12
		signal 16384
	)
)

(instance bushes of Feature
	(properties
		noun 12
		onMeCheck 1024
	)
)

(instance fowlers of Feature
	(properties
		noun 4
		onMeCheck 16384
	)
)

(instance grass of Feature
	(properties
		noun 5
		onMeCheck 4
	)
)

(instance oakTrees of Feature
	(properties
		noun 6
		onMeCheck 64
	)
)

(instance path of Feature
	(properties
		noun 10
		onMeCheck 34
	)
)

(instance pineTrees of Feature
	(properties
		noun 7
		onMeCheck 512
	)
)

(instance posts of Feature
	(properties
		noun 8
		onMeCheck 8
	)
)

(instance sidewalk of Feature
	(properties
		noun 9
		onMeCheck 128
	)
)

(instance sky of Feature
	(properties
		noun 2
		onMeCheck 2048
	)
)

(instance spiPlant of Feature
	(properties
		noun 3
		onMeCheck 16
	)
)

(instance street of Feature
	(properties
		noun 11
		onMeCheck 256
	)
)

(instance sMissedBust of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setHeading: 90 self)
			)
			(1)
			(2
				(laura setLoop: 8 setCel: 5)
				(= ticks 20)
			)
			(3
				(gMessager say: 13 0 11 0 self) ; "You missed the bust, Sonny!! Geez Louise, I didn't realize I was working with a rank AMATEUR here! Why do I always get the screwups? Morgan's gonna find me a partner who doesn't have his head up his butt or he's gonna have to restaff the whole @#)($@ DEPARTMENT!"
			)
			(4
				(EgoDead)
			)
		)
	)
)

