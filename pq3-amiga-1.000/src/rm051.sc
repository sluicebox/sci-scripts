;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 51)
(include sci.sh)
(use Main)
(use Interface)
(use trunk)
(use rmnScript)
(use eRS)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm051 0
)

(local
	local0
	local1
)

(procedure (localproc_0)
	(if
		(or
			(== ((gInventory at: 7) owner:) gEgo) ; camera
			(== ((gInventory at: 39) owner:) gEgo) ; scraper
			(== ((gInventory at: 40) owner:) gEgo) ; toothpick
			(== ((gInventory at: 42) owner:) gEgo) ; sampleEnv
		)
		(return 1)
	)
)

(instance rm051 of PQRoom
	(properties
		picture 51
		north -1
		east -1
		south -1
		west -1
	)

	(method (init)
		(LoadMany rsVIEW 5 535 536 537 538 539 546)
		(gEgo
			normal: 1
			view: 5
			setStep: 3 2
			setLoop: -1
			setPri: -1
			cycleSpeed: (gEgo moveSpeed:)
			init:
		)
		(super init:)
		(ClearFlag 66)
		(trunk x: 225 y: 187 marked: 0 init: close:)
		(theTrunk approachVerbs: 3 init:) ; Do
		(theCar approachVerbs: 3 init:) ; Do
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 225 154 247 140 282 154 261 179 251 189 243 189 232 189 0 189 0 91 124 123 136 117 168 125 181 120 199 124 210 138 218 145
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 319 58 252 119 126 84 127 73 123 69 144 43 132 39 82 73 0 46
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 319 189 304 189 285 189 272 174 281 162 319 139
					yourself:
				)
		)
		(if (!= gPrevRoomNum 52)
			(= global105 15)
			(= global106 0)
			(fire1 setCycle: Fwd init:)
			(fire2 setCycle: Fwd init:)
			(fire3 setCycle: Fwd init:)
			(embers1 setCycle: Fwd init:)
			(embers2 setCycle: Fwd init:)
			(embers3 setCycle: Fwd init:)
			(embers4 setCycle: Fwd init:)
			(embers5 setCycle: Fwd init:)
			(hoseWater1 setCycle: Fwd init:)
			(hoseWater2 setCycle: Fwd init:)
			(gEgo posn: 300 145)
			(sFireHose play:)
			(fireman1 setScript: putOutFire)
			(fireman3 init: stopUpd:)
			(gCurRoom setScript: enterStageRight)
		else
			(gEgo posn: 150 50)
			(if (not (gEgo has: 6)) ; photo
				(picInset init: hide:)
			)
			(sFireTruckEngine setVol: 10 play: 10 fade: 127 25 10 0)
			(HandsOff)
			(gCurRoom setScript: enterStageLeft)
			(= local1 (= local0 1))
		)
		(grass init:)
		(sidewalk init:)
		(windows init:)
		(firetruck init:)
		(fireman1 init: stopUpd:)
		(fireman2 setCycle: Fwd init:)
		(chief init: stopUpd:)
		(drip setCycle: Fwd init:)
		(lights setCycle: Fwd init:)
		(hydrant init:)
		(theRoom init:)
		(sFireTruckEngine setVol: 10 play: 10 fade: 127 25 10 0)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 881)
	)

	(method (doit &tmp temp0)
		(= temp0 (gEgo onControl: 1))
		(cond
			(script 0)
			((& temp0 $4000)
				(if local1
					(HandsOff)
					(gCurRoom setScript: inHouse)
				else
					(Print 51 0) ; "You ignore the firemen and walk right into the burning house. Falling debris hits you on the head, and you succumb to the flames."
					(EgoDead 9) ; "At the scene of a fire, the firechief's the man in charge. Do as he says, and you won't get burned."
				)
			)
			((and (& temp0 $0200) (not local0))
				(self setScript: chiefYellScript)
			)
		)
		(super doit:)
	)
)

(instance inHouse of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(sFlames fade: self)
				(= seconds 4)
			)
			(1
				(gCurRoom newRoom: 52)
			)
		)
	)
)

(instance enterStageLeft of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 90 85 self)
			)
			(1
				(if (not (gEgo has: 6)) ; photo
					(firemanPhoto init: setScript: firePhotoScript)
				else
					(HandsOn)
				)
				(self dispose:)
			)
		)
	)
)

(instance patTalkScript of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(= save1 1)
				(Say theCar 51 1) ; "I'll deal with the gawkers across the street."
				(= seconds 4)
			)
			(2
				(= save1 1)
				(sonnyInset init:)
				(Say sonnyInset 51 2) ; "Just try to conduct yourself like a professional. OK, Morales?"
				(= seconds 5)
			)
			(3
				(sonnyInset dispose:)
				(= save1 1)
				(Say theCar 51 3) ; "No prob' Boss man!"
				(= seconds 3)
			)
			(4
				(= save1 1)
				(Say theCar 51 4) ; "Ok folks! Who brought the marshmallows, huh?"
				(= seconds 4)
			)
			(5
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(gEgo setMotion: PolyPath 290 145 self)
			)
			(6
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance enterStageRight of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 5)
			)
			(1
				(= seconds 3)
				(HandsOff)
				(ShowClock 1)
			)
			(2
				(gEgo setMotion: PolyPath 280 145 self)
			)
			(3
				(= save1 1)
				(Say theCar 51 5) ; "I'll go take care of the gawkers across the street, Sonny."
				(= seconds 7)
			)
			(4
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(ShowClock 0)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance putOutFire of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 10)
			)
			(1
				(fire1 setCycle: End)
				(fire2 setCycle: End)
				(hoseWater2 loop: 10 setCycle: End self)
				(embers2 dispose:)
			)
			(2
				(fire1 dispose:)
				(= cycles 4)
			)
			(3
				(hoseWater2 loop: 2 setCycle: End self)
				(embers1 dispose:)
			)
			(4
				(hoseWater2 dispose:)
				(fire2 dispose:)
				(embers3 dispose:)
				(= cycles 1)
			)
			(5
				(fireman1 setCycle: End self)
			)
			(6
				(sFireHose fade:)
				(fireman1 stopUpd:)
				(hoseWater1 loop: 10 setCycle: End self)
				(fire3 setCycle: End)
				(sFlames play:)
				(gLongSong number: 510 loop: -1 flags: 1 play:)
				(sFireHose dispose:)
				(embers4 dispose:)
			)
			(7
				(fire3 dispose:)
				(= cycles 4)
			)
			(8
				(= local0 1)
				(fireman2 setCycle: 0 stopUpd:)
				(hoseWater1 dispose:)
				(embers5 dispose:)
				(self dispose:)
			)
		)
	)
)

(instance talkChief of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 181 125 self)
				(chief setCycle: End self)
			)
			(1 0)
			(2
				(Face gEgo chief self)
			)
			(3
				(= cycles 2)
			)
			(4
				(= save1 1)
				(sonnyInset init:)
				(Say sonnyInset 51 6) ; "What appears to have started the fire?"
				(= seconds 4)
			)
			(5
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(sonnyInset dispose:)
				(chiefInset setCycle: End self init:)
				(chiefMouth hide:)
			)
			(6
				(= save1 1)
				(chiefInset stopUpd:)
				(chiefMouth show:)
				(Say chiefInset 51 7) ; "Looks like arson to me. She went up awful fast."
				(= seconds 5)
			)
			(7
				(= save1 1)
				(chiefInset dispose:)
				(sonnyInset init:)
				(Say sonnyInset 51 8) ; "Do you have any idea who might have started it?"
				(= seconds 4)
			)
			(8
				(= save1 1)
				(sonnyInset dispose:)
				(chiefInset init:)
				(Say chiefInset 51 9) ; "It's under investigation. You can go in if you like."
				(= seconds 5)
			)
			(9
				(= save1 1)
				(chiefInset dispose:)
				(Print 51 10 #at 10 10 #dispose) ; "You thank the fire chief and let him get back to work."
				(= seconds 4)
			)
			(10
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(chief setCycle: Beg self)
			)
			(11
				(chief stopUpd:)
				(= local1 1)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance chiefYellScript of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= save1 1)
				(chief setCycle: End self)
				(chiefInset setCycle: End self init:)
				(chiefMouth hide:)
			)
			(1 0)
			(2
				(chiefInset stopUpd:)
				(chiefMouth show:)
				(Say chiefInset 51 11) ; "Hey you! Get back away from the fire line!"
				(= seconds 4)
			)
			(3
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(chiefInset dispose:)
				(chief setCycle: Beg self)
				(gEgo setMotion: MoveTo 290 145 self)
			)
			(4 0)
			(5
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance firePhotoScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(firemanPhoto setCycle: Walk setMotion: MoveTo 105 70 self)
			)
			(1
				(firemanPhoto view: 535 loop: 5 setCycle: End self)
			)
			(2
				(Say firemanPhoto 51 12) ; "Officer, I found something you might want to look at."
				(= seconds 3)
			)
			(3
				(Face gEgo firemanPhoto)
				(= cycles 1)
			)
			(4
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(gEgo setMotion: PolyPath 105 80 self)
			)
			(5
				(Face gEgo firemanPhoto)
				(firemanPhoto setCycle: Beg self)
			)
			(6
				(gEgo get: 6) ; photo
				(picInset show:)
				(Print 51 13 #at 40 20) ; "It looks like a photograph."
				(SetFlag 67 57)
				(= cycles 1)
			)
			(7
				(Print 51 14 #at 40 20) ; "It takes you a moment to realize what you're seeing. You feel goosebumps crawl up your back."
				(= cycles 1)
			)
			(8
				(Print 51 15 #at 40 20 #dispose) ; "The man on the left is none other than your one-time arch nemesis, Jessie Bains. The man on the right bears a striking resemblance to him."
				(= cycles 2)
			)
			(9
				(firemanPhoto hide:)
				(= cycles 2)
			)
			(10
				(= seconds 4)
			)
			(11
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(= cycles 1)
			)
			(12
				(Print 51 16 #at 40 20) ; "You don't believe this! The Bains brothers, Michael and Jessie."
				(= cycles 1)
			)
			(13
				(firemanPhoto dispose:)
				(picInset hide:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance fireman1 of Prop
	(properties
		x 146
		y 133
		view 535
		signal 16384
		cycleSpeed 11
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(if (== local0 0)
					(Print 51 17) ; "The firemen are struggling to put out the fire."
				else
					(Print 51 18) ; "The firemen are anxious to get this wrapped up."
				)
			)
			(3 ; Do
				(if (== local0 0)
					(Print 51 17) ; "The firemen are struggling to put out the fire."
				else
					(Print 51 18) ; "The firemen are anxious to get this wrapped up."
				)
			)
			(5 ; Talk
				(if (== local0 0)
					(Print 51 19) ; "The fire's under control. Not to worry."
				else
					(Print 51 20) ; ""Hey, we're off call as soon as we're done here. Who wants to grab a beer down at Johnny's?"
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance fireman2 of Prop
	(properties
		x 70
		y 175
		view 536
		cel 2
		signal 16384
		cycleSpeed 9
		detailLevel 3
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Talk
				(if (== local0 0)
					(Print 51 21) ; "We've almost got it out now."
				else
					(Print 51 22) ; "Man, I gotta call my wife. Anybody seen a phone?"
				)
			)
			(else
				(fireman1 doVerb: theVerb)
			)
		)
	)
)

(instance fireman3 of Prop
	(properties
		x 76
		y 133
		view 537
		loop 1
		priority 13
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Talk
				(if (== local0 0)
					(Print 51 23) ; "This fire's nothing compared to the office building that went up yesterday."
				else
					(Print 51 24) ; "This one didn't take long at all. At least we caught it before it spread up the street."
				)
			)
			(else
				(fireman1 doVerb: theVerb)
			)
		)
	)
)

(instance chief of Actor
	(properties
		x 191
		y 134
		view 537
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 51 25) ; "It looks like the man with the bull horn is in charge. He must be the fire chief."
			)
			(5 ; Talk
				(if local1
					(Print 51 26) ; "The fire chief is focused on his men. He doesn't notice you."
				else
					(chief setScript: talkChief)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance firemanPhoto of Actor
	(properties
		x 141
		y 37
		sightAngle 90
		view 535
		loop 3
		signal 2048
		cycleSpeed 8
	)
)

(instance chiefInset of Prop
	(properties
		x 46
		y 122
		sightAngle 90
		view 538
		priority 15
		signal 16401
	)

	(method (init)
		(super init:)
		(chiefMouth x: (self x:) y: (self y:) setCycle: RandCycle init:)
	)

	(method (dispose)
		(chiefMouth dispose:)
		(super dispose:)
	)
)

(instance chiefMouth of Prop
	(properties
		view 538
		loop 1
		cel 3
		priority 15
		signal 16401
	)
)

(instance lights of Prop
	(properties
		x 28
		y 89
		lookStr {The fire engine's lights are on.}
		view 539
		loop 3
		cel 1
		priority 14
		signal 16400
		cycleSpeed 9
		detailLevel 2
	)
)

(instance drip of Prop
	(properties
		x 249
		y 153
		view 539
		loop 2
		cel 2
		cycleSpeed 7
		detailLevel 2
	)

	(method (doVerb theVerb)
		(super doVerb: theVerb &rest)
	)
)

(instance embers1 of Prop
	(properties
		x 233
		y 6
		view 539
		loop 5
		cel 1
		priority 2
		signal 16384
		cycleSpeed 7
		detailLevel 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(if (== local0 0)
					(Print 51 27) ; "You see the fire gutted shell of a house still ablaze. It looks like the fire fighters have it under control."
				else
					(Print 51 28) ; "You see the fire gutted shell of a house."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance embers2 of Prop
	(properties
		x 161
		y 42
		view 539
		loop 6
		priority 2
		signal 16400
		cycleSpeed 7
		detailLevel 2
	)

	(method (doVerb theVerb)
		(embers1 doVerb: theVerb)
	)
)

(instance embers3 of Prop
	(properties
		x 224
		y 60
		view 539
		loop 7
		cel 1
		priority 2
		signal 16400
		cycleSpeed 7
		detailLevel 2
	)

	(method (doVerb theVerb)
		(embers1 doVerb: theVerb)
	)
)

(instance embers4 of Prop
	(properties
		x 68
		y 20
		view 539
		loop 8
		cel 1
		priority 2
		signal 16400
		cycleSpeed 7
		detailLevel 2
	)

	(method (doVerb theVerb)
		(embers1 doVerb: theVerb)
	)
)

(instance embers5 of Prop
	(properties
		x 119
		y 26
		view 539
		loop 9
		priority 1
		signal 16400
		cycleSpeed 7
		detailLevel 2
	)

	(method (doVerb theVerb)
		(embers1 doVerb: theVerb)
	)
)

(instance fire1 of Prop
	(properties
		x 167
		y 49
		view 539
		cel 3
		priority 3
		signal 16
		cycleSpeed 7
		detailLevel 2
	)

	(method (dispose)
		(self setCycle: 0)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(super doVerb: theVerb &rest)
	)
)

(instance fire2 of Prop
	(properties
		x 215
		y 62
		view 539
		cel 2
		priority 3
		signal 16
		cycleSpeed 9
		detailLevel 2
	)

	(method (dispose)
		(self setCycle: 0)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(fire1 doVerb: theVerb)
	)
)

(instance fire3 of Prop
	(properties
		x 216
		y 58
		view 539
		cel 6
		priority 3
		signal 16
		detailLevel 2
	)

	(method (dispose)
		(self setCycle: 0)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(fire1 doVerb: theVerb)
	)
)

(instance hoseWater1 of Prop
	(properties
		x 159
		y 105
		lookStr {The hose is squirting water.}
		view 539
		loop 4
		cycleSpeed 9
		detailLevel 2
	)
)

(instance hoseWater2 of Prop
	(properties
		x 111
		y 93
		lookStr {The hose is squirting water.}
		view 539
		loop 4
		cycleSpeed 9
		detailLevel 2
	)
)

(instance theRoom of Feature
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(if (== local0 0)
					(Print 51 27) ; "You see the fire gutted shell of a house still ablaze. It looks like the fire fighters have it under control."
				else
					(Print 51 28) ; "You see the fire gutted shell of a house."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance grass of Feature
	(properties
		onMeCheck 2560
		lookStr {The lawn is green and closely clipped.}
	)
)

(instance sidewalk of Feature
	(properties
		onMeCheck 256
		lookStr {The sidewalk is wet with water from the firemen's hoses.}
	)
)

(instance windows of Feature
	(properties
		onMeCheck 128
		lookStr {The windows have been blown to pieces by the heat of the fire.}
	)
)

(instance hydrant of Feature
	(properties
		onMeCheck 16
		lookStr {You see a fire hydrant.}
	)
)

(instance firetruck of Feature
	(properties
		onMeCheck 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 51 29) ; "It's a Lytton Fire Department pumper."
			)
			(3 ; Do
				(Print 51 30) ; "The firemen have the fire well in hand and don't need your assistance."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance theCar of Prop
	(properties
		x 318
		y 187
		approachX 310
		approachY 166
		view 536
		loop 1
		signal 16385
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 51 31) ; "It's the trunk of your car."
			)
			(3 ; Do
				(cond
					((localproc_0)
						(Print 51 32) ; "You need to put the field equipment back into the trunk first."
					)
					((gEgo has: 6) ; photo
						(proc0_17 5)
						(SetFlag 202)
						(gCurRoom newRoom: 25)
					)
					(else
						(HandsOff)
						(gCurRoom setScript: patTalkScript)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance theTrunk of View
	(properties
		x 317
		y 164
		approachX 286
		approachY 186
		lookStr {It's The trunk of your car.}
		view 536
		loop 1
		cel 1
		priority 1
		signal 16401
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(trunk open:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance sonnyInset of Prop
	(properties
		x 47
		y 122
		description {Sonny}
		view 25
		priority 15
		signal 16401
	)

	(method (init)
		(super init:)
		(sonnyShirt posn: (+ (self x:) 3) (+ (self y:) 61) init:)
		(sonnyMouth
			posn: (self x:) (+ (self y:) 20)
			z: 20
			setCycle: RandCycle
			init:
		)
		(sonnyEyes x: (self x:) y: (self y:) init: setScript: egoEyesBlink)
		(self stopUpd:)
	)

	(method (dispose)
		(sonnyMouth dispose:)
		(sonnyShirt dispose:)
		(sonnyEyes setScript: 0 dispose:)
		(super dispose:)
	)
)

(instance sonnyMouth of Prop
	(properties
		description {Sonny}
		view 25
		loop 1
		priority 15
		signal 16401
		cycleSpeed 9
	)
)

(instance sonnyShirt of View
	(properties
		description {Sonny}
		view 25
		cel 1
		priority 15
		signal 16401
	)
)

(instance sonnyEyes of Prop
	(properties
		view 25
		loop 2
		priority 15
		signal 16400
	)
)

(instance egoEyesBlink of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(sonnyEyes cel: 1)
				(= cycles 4)
			)
			(2
				(sonnyEyes cel: 0)
				(= cycles 1)
			)
			(3
				(= seconds 2)
			)
			(4
				(self init:)
			)
		)
	)
)

(instance picInset of View
	(properties
		x 237
		y 189
		sightAngle 90
		view 546
		priority 15
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(picInset hide:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance sFlames of Sound
	(properties
		flags 1
		number 511
		loop -1
	)
)

(instance sFireHose of Sound
	(properties
		flags 1
		number 512
		loop -1
	)
)

(instance sFireTruckEngine of Sound
	(properties
		flags 1
		number 513
		vol 10
		loop -1
	)
)

