;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 40)
(include sci.sh)
(use Main)
(use eRS)
(use PAvoider)
(use Talker)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use StopWalk)
(use Rev)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm040 0
	Witness 1
)

(local
	local0
	local1 = 1
	local2 = 1
	local3
	local4 = 1
	local5
	local6
	local7 = 1
	local8 = 1
	local9
	local10
)

(instance rm040 of PQRoom
	(properties
		noun 22
		picture 99
	)

	(method (init)
		(if (== gPrevRoomNum 1)
			(= global206 0)
			(= global207 914)
			(gEgo get: 2 0 5 1 9) ; Extender
			(= global224 {Saturday, August 8, 1992})
		)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 0 189 160 189 164 172 187 168 202 189 244 189 266 179 280 189 319 189 319 181 273 164 272 145 319 125 319 122 263 142 212 122 226 85 203 120 77 131 61 151 0 151
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 222 148 263 148 263 169 222 169
					yourself:
				)
		)
		(super init:)
		(gLongSong stop:)
		(gLongSong2 stop:)
		(gEgo init: setPri: -1 posn: 319 138 illegalBits: 0 ignoreActors: 1)
		(carTrunk init:)
		(carDoor init:)
		(carFront init:)
		(flowerShop init:)
		(donutShop init:)
		(victim init:)
		(lightpole init:)
		(fireplug init:)
		(street init:)
		(otherShops init:)
		(HandsOn)
		(steam1 init: setCycle: Fwd)
		(steam2 init: setCycle: Fwd)
		(steam3 init: setCycle: Fwd)
		(steam4 init: setCycle: Fwd)
		(steam5 init: setCycle: Fwd)
		(oldGrayDude init:)
		(oldGrayDudeBottom init: ignoreActors: 1 addToPic:)
		(redHead init:)
		(hippie init:)
		(hippieBottom init: ignoreActors: 1 addToPic:)
		(graySuit init:)
		(graySuitBottom init: ignoreActors: 1 addToPic:)
		(blueJacket init:)
		(blueJacketBottom init: ignoreActors: 1 addToPic:)
		(whiteJacket init:)
		(witness init: stopUpd:)
		(group1 init: ignoreActors: 1 addToPic:)
		(car init: ignoreActors: 1 addToPic:)
		(lights init: setCycle: Fwd)
		(flare1 init: setCycle: Rev)
		(flare2 init: setCycle: Fwd)
		(wreckedCar init:)
		(oldGrayDude setScript: cycleCrowd)
		(for ((= local10 0)) (<= local10 331) ((++ local10))
			(Wait 1)
			(cond
				((== local10 1)
					(soundFX number: 911 loop: -1 play:)
					(gCurRoom drawPic: 40 picture: 40)
				)
				((== local10 40)
					(soundFX fade:)
				)
				((== local10 100)
					(soundFX2 number: 900 loop: 1 play:)
				)
				((== local10 300)
					(soundFX3 number: 901 loop: 1 play:)
				)
				((== local10 325)
					(soundFX number: 401 loop: -1 play:)
				)
				(else
					(== local10 330)
				)
			)
		)
	)
)

(class Spectator of Prop
	(properties
		noun 6
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Talk
				(== local9 1)
				(Witness init:)
				(if (not local3)
					(witness setScript: theWalkerTalks)
				else
					(gMessager say: 6 2 1) ; "Despite your queries, nobody steps forward. Apparently nobody else in the crowd saw -- or will admit to having seen -- anything."
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance egoUseRadio of Actions
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(11 ; Extender
				(cond
					((== local0 1)
						(gMessager say: 20 11 2) ; "Dispatch, this is 83-32. The driver is 11-44. We'll need a meat wagon. 83-32 out."
						(gCurRoom setScript: bringHamiltonOn)
						(= local0 2)
					)
					((and (== local3 1) (== local8 1))
						(gMessager say: 20 11 5) ; "Dispatch, 83-32 is on scene at the 11-80. 83-32 out."
						(soundFX number: 942 loop: 1 play:)
						(SetScore 144 5)
						(= local8 0)
					)
					(else
						(gMessager say: 20 11 6) ; "Dispatch, this is 83-32. My 10-20 is near the corner of Fig and 4th. 83-32 out."
					)
				)
				(return 1)
			)
		)
	)
)

(instance deadDude of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cycleCrowd dispose:)
				(gEgo setMotion: PolyPath 133 135 self)
			)
			(1
				(Face gEgo wreckedCar)
				(gLongSong pause: 1 setVol: 50)
				(lights dispose:)
				(steam1 dispose:)
				(steam2 dispose:)
				(steam3 dispose:)
				(steam4 dispose:)
				(steam5 dispose:)
				(= cycles 15)
			)
			(2
				(gEgo stopUpd:)
				(deadGuy init:)
				(gLongSong2 number: 404 loop: 1 play: self)
			)
			(3
				(deadGuy stopUpd:)
				(= seconds 3)
			)
			(4
				(gLongSong fade: 127 10 8 0 pause: 0)
				(= seconds 4)
			)
			(5
				(deadGuy dispose:)
				(= cycles 1)
			)
			(6
				(gMessager say: 16 1 5) ; "There is a head injury as well as a small hole near the jaw. Both of them are slowly trickling blood. He doesn't appear to be breathing."
				(= local0 1)
				(= cycles 1)
			)
			(7
				(steam1 init: setCycle: Fwd)
				(steam2 init: setCycle: Fwd)
				(steam3 init: setCycle: Fwd)
				(steam4 init: setCycle: Fwd)
				(steam5 init: setCycle: Fwd)
				(lights init: setCycle: Fwd)
				(= local6 1)
				(oldGrayDude setScript: cycleCrowd)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance cycleCrowd of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if local6
					(= cycles 1)
				else
					(gEgo
						actions: egoUseRadio
						setCycle: StopWalk -1
						setMotion: PolyPath 275 143 self
					)
				)
			)
			(1
				(if local7
					(soundFX fade:)
					(gLongSong
						number: 403
						loop: -1
						flags: 1
						play: 5
						fade: 127 15 5 0
						loop: -1
					)
					(= local7 0)
				)
				(= seconds 5)
			)
			(2
				(oldGrayDude cycleSpeed: 10 setCycle: End self)
			)
			(3
				(oldGrayDude setCel: 0 stopUpd:)
				(graySuit cycleSpeed: 10 setCycle: End self)
			)
			(4
				(graySuit setCel: 0 stopUpd:)
				(redHead cycleSpeed: 10 setCycle: End self)
			)
			(5
				(redHead setCel: 0 stopUpd:)
				(blueJacket cycleSpeed: 10 setCycle: End self)
			)
			(6
				(blueJacket stopUpd:)
				(hippie cycleSpeed: 10 setCycle: End self)
			)
			(7
				(hippie setCel: 0 stopUpd:)
				(whiteJacket cycleSpeed: 10 setCycle: End self)
			)
			(8
				(whiteJacket setCel: 0 stopUpd:)
				(self changeState: 1)
			)
		)
	)
)

(instance bringHamiltonOn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cycleCrowd dispose:)
				(car2 init:)
				(= seconds 10)
			)
			(1
				(gLongSong2 number: 911 flags: 1 play: fade:)
				(car2 setLoop: 0 setMotion: MoveTo 380 152 self)
			)
			(2
				(car2 ignoreActors: 1 addToPic:)
				(= cycles 30)
			)
			(3
				(HandsOff)
				(= cycles 1)
			)
			(4
				(dooley
					init:
					setAvoider: PAvoider
					illegalBits: 0
					posn: 319 182
					setCycle: StopWalk -1
					setMotion: MoveTo 270 189 self
				)
			)
			(5
				(Face dooley gEgo self)
			)
			(6
				(gMessager say: 9 2 3) ; "Hello, Sonny. Lieutenant Hamilton is taking over the scene. You can go ahead and hit the streets."
				(dooley stopUpd:)
				(= cycles 5)
			)
			(7
				(HandsOn)
				(oldGrayDude setScript: cycleCrowd)
				(self dispose:)
			)
		)
	)
)

(instance theWalkerTalks of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local3 1)
				(gMessager say: 6 2 0 0 self) ; "EXCUSE ME!"
			)
			(1
				(gEgo setMotion: PolyPath 228 93 self)
				(witness
					setLoop: -1
					setCycle: StopWalk -1
					setMotion: MoveTo 247 84 self
				)
			)
			(2)
			(3
				(witness setPri: 6 noun: 17)
				(gEgo setHeading: 90 self)
			)
			(4
				(= cycles 2)
			)
			(5
				(gMessager say: 17 2 3) ; "Could you please tell me what you saw and heard?"
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance moveWitnessBack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (and (!= (gEgo x:) 228) (!= (gEgo y:) 93))
					(gEgo setMotion: PolyPath 228 93 self)
				else
					(= cycles 1)
				)
			)
			(1
				(gMessager say: 17 2 1 0 self) ; "Could you describe the car? Did you happen to get the license plate number?"
			)
			(2
				(witness
					setPri: -1
					setCycle: Walk
					setMotion: MoveTo 240 69 self
				)
			)
			(3
				(= local5 1)
				(witness setLoop: 5 setCel: 4)
				(= cycles 5)
			)
			(4
				(HandsOn)
				(= cycles 5)
			)
			(5
				(witness stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance getInCar of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 305 130 self)
			)
			(1
				(= global211 6)
				(gCast eachElementDo: #setCycle 0)
				(LoadMany 0 939 969)
				(gLongSong fade:)
				(gCurRoom newRoom: 500)
				(self dispose:)
			)
		)
	)
)

(instance witness of Actor
	(properties
		x 240
		y 69
		view 335
		loop 5
		cel 4
		priority 4
		signal 18448
		illegalBits 0
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(cond
					(local5
						(gMessager say: 17 2 4) ; "You've learned all you can from the witness. Dooley can handle any further interrogation."
					)
					((== local3 1)
						(self setScript: moveWitnessBack)
					)
					(else
						(self setScript: theWalkerTalks)
					)
				)
			)
			(1 ; Look
				(if (== local3 1)
					(gMessager say: 17 1) ; "The witness is a thin, white male, about 140 pounds. He seems a bit nervous."
				else
					(gMessager say: 6 1) ; "A cross section of average Lyttonians is gathered here to gawk at the scene. One guy seems to be talking more than the others."
				)
			)
			(4 ; Do
				(if (== local3 1)
					(gMessager say: 17 4) ; "You only need to talk to the witness. You have no reason to touch him."
				else
					(gMessager say: 6 4) ; "Careful. You don't want someone yelling `Police Brutality'."
				)
			)
			(else
				(self noun: 6)
			)
		)
	)
)

(instance dooley of Actor
	(properties
		x 319
		y 182
		noun 9
		view 1102
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Talk
				(if local2
					(gMessager say: 9 2 1) ; "Sonny, you can get back out on patrol now."
					(= local2 0)
				else
					(gMessager say: 9 2 4) ; "Sonny, you're trying my patience. Get your butt on patrol!"
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance car2 of Actor
	(properties
		x 415
		y 152
		noun 21
		view 914
		priority 13
		signal 16
	)
)

(instance Witness of Talker
	(properties
		x 200
		y 10
		view 1338
		priority 15
		signal 16400
		talkWidth 150
		textX -180
	)

	(method (init)
		(= font gUserFont)
		(super init: 0 0 witnessMouth &rest)
	)
)

(instance witnessMouth of Prop
	(properties
		nsTop 54
		nsLeft 32
		view 1338
		loop 1
		priority 15
		signal 16400
	)
)

(instance steam1 of Prop
	(properties
		x 91
		y 99
		noun 14
		approachX 96
		approachY 136
		view 1004
		cel 6
		priority 7
		signal 16
		detailLevel 2
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 4 1) ; Do, Look
	)
)

(instance steam2 of Prop
	(properties
		x 73
		y 91
		noun 14
		approachX 96
		approachY 136
		view 1004
		loop 1
		cel 6
		priority 7
		signal 16
		detailLevel 2
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 4 1) ; Do, Look
	)
)

(instance steam3 of Prop
	(properties
		x 72
		y 60
		noun 14
		approachX 96
		approachY 136
		view 1004
		loop 2
		cel 2
		priority 7
		signal 16
		detailLevel 2
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 4 1) ; Do, Look
	)
)

(instance steam4 of Prop
	(properties
		x 91
		y 69
		noun 14
		approachX 96
		approachY 136
		view 1004
		loop 3
		cel 4
		priority 7
		signal 16
		detailLevel 2
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 4 1) ; Do, Look
	)
)

(instance steam5 of Prop
	(properties
		x 70
		y 94
		noun 14
		approachX 96
		approachY 136
		view 1004
		cel 10
		priority 7
		signal 16
		detailLevel 2
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 4 1) ; Do, Look
	)
)

(instance sonny of Prop ; UNUSED
	(properties
		x 132
		y 156
		view 1007
		priority 14
		signal 16
	)
)

(instance flare1 of Prop
	(properties
		x 170
		y 188
		noun 11
		approachX 150
		approachY 185
		view 1002
		loop 2
		signal 16
		detailLevel 2
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 4 1) ; Do, Look
	)
)

(instance flare2 of Prop
	(properties
		x 233
		y 164
		noun 11
		approachX 218
		approachY 161
		view 1002
		loop 2
		cel 2
		priority 12
		signal 18448
		detailLevel 2
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 4 1) ; Do, Look
	)
)

(instance lights of Prop
	(properties
		x 322
		y 70
		noun 3
		view 1002
		loop 1
		cel 5
		priority 8
		signal 16
		detailLevel 2
	)
)

(instance oldGrayDude of Spectator
	(properties
		x 10
		y 143
		view 1001
	)
)

(instance redHead of Spectator
	(properties
		x 37
		y 140
		view 1001
		loop 1
		priority 1
		signal 16
	)
)

(instance hippie of Spectator
	(properties
		x 51
		y 145
		view 1001
		loop 3
	)
)

(instance graySuit of Spectator
	(properties
		x 191
		y 75
		view 1001
		loop 5
		priority 2
		signal 16
	)
)

(instance blueJacket of Spectator
	(properties
		x 206
		y 83
		view 1001
		loop 4
	)
)

(instance whiteJacket of Spectator
	(properties
		x 221
		y 74
		view 1001
		loop 2
	)
)

(instance oldGrayDudeBottom of View
	(properties
		x 10
		y 143
		view 1008
		signal 18448
	)
)

(instance hippieBottom of View
	(properties
		x 51
		y 145
		view 1008
		loop 3
		signal 18448
	)
)

(instance blueJacketBottom of View
	(properties
		x 206
		y 83
		view 1008
		loop 4
		signal 18448
	)
)

(instance graySuitBottom of View
	(properties
		x 191
		y 75
		view 1008
		loop 5
		priority 2
		signal 18448
	)
)

(instance deadGuy of View
	(properties
		x 90
		y 52
		view 330
		priority 13
		signal 18448
	)
)

(instance sonnyInset of View ; UNUSED
	(properties
		x 80
		y 58
		view 1009
		priority 13
		signal 17
	)
)

(instance group1 of View
	(properties
		x 150
		y 79
		noun 6
		view 1000
		priority 3
		signal 16
	)

	(method (doVerb theVerb)
		(Spectator doVerb: theVerb)
	)
)

(instance car of View
	(properties
		x 319
		y 89
		z -20
		noun 3
		view 914
		priority 7
		signal 4112
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Do
				(gEgo setScript: getInCar)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance wreckedCar of Feature
	(properties
		noun 4
		sightAngle 40
		onMeCheck 4
	)
)

(instance carDoor of Feature
	(properties
		noun 1
		sightAngle 40
		onMeCheck 32
	)
)

(instance carTrunk of Feature
	(properties
		y 150
		noun 2
		sightAngle 40
		onMeCheck 8
	)
)

(instance carFront of Feature
	(properties
		noun 4
		nsTop 84
		nsLeft 68
		nsBottom 114
		nsRight 103
		sightAngle 40
	)
)

(instance donutShop of Feature
	(properties
		noun 5
		sightAngle 40
		onMeCheck 128
	)
)

(instance flowerShop of Feature
	(properties
		noun 7
		nsTop 13
		nsLeft 1
		nsBottom 90
		nsRight 60
		sightAngle 40
	)
)

(instance victim of Feature
	(properties
		x 100
		y 100
		noun 16
		nsTop 88
		nsLeft 115
		nsBottom 94
		nsRight 142
		sightAngle 40
		approachX 133
		approachY 135
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 4) ; Do
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(1 ; Look
				(if (not local0)
					(HandsOff)
					(gCurRoom setScript: deadDude)
				else
					(gMessager say: 16 1 2) ; "He doesn't look any better."
				)
			)
			(2 ; Talk
				(gMessager say: 16 2) ; "There is no answer."
			)
			(4 ; Do
				(if local4
					(gMessager say: 16 4 5) ; "No pulse. No vital signs whatsoever. Your worst fear is confirmed. This guy just booked a one-drawer stainless steel suite at the Toe-Tag Motel."
					(= local4 0)
				else
					(gMessager say: 16 4 2) ; "You do the smart thing and check twice for signs of life. But this man's as dead as any man you've ever seen."
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance lightpole of Feature
	(properties
		noun 13
		sightAngle 40
		onMeCheck 16
	)
)

(instance fireplug of Feature
	(properties
		noun 10
		nsTop 46
		nsLeft 257
		nsBottom 62
		nsRight 272
		sightAngle 40
		approachX 270
		approachY 75
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 1) ; Look
	)
)

(instance street of Feature
	(properties
		noun 15
		sightAngle 40
		onMeCheck 64
	)
)

(instance otherShops of Feature
	(properties
		noun 18
		sightAngle 40
		onMeCheck 256
	)
)

(instance soundFX of Sound
	(properties)
)

(instance soundFX2 of Sound
	(properties)
)

(instance soundFX3 of Sound
	(properties)
)

