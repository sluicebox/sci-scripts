;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 47)
(include sci.sh)
(use Main)
(use eRS)
(use Inset)
(use Talker)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use StopWalk)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm047 0
	Todd 1
	Mike 2
)

(local
	local0
	local1
	local2
	local3
	local4 = 5
)

(instance rm047 of PQRoom
	(properties
		noun 10
		picture 47
	)

	(method (init)
		(= global224 {4/14/92 @9:40a})
		(LoadMany rsVIEW 1 914 104 415 410 412 413 103)
		(LoadMany rsSOUND 470 900 901 904 404)
		(super init:)
		(HandsOff)
		(= local1 0)
		(gLongSong number: 470 loop: -1 flags: -1 play:)
		(if (not (OneOf global211 85 86))
			(car view: 914 loop: 0 cel: 0 x: 416 y: 102 setPri: 10 init:)
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PContainedAccess
						init: 191 106 183 115 148 126 53 160 40 165 0 165 1 173 44 189 319 189 319 159 298 166 276 165 237 149 241 134 319 120 319 105 207 105
						yourself:
					)
			)
		else
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PContainedAccess
						init: 47 189 70 189 43 179 97 156 219 177 219 189 319 189 319 163 309 166 287 166 242 148 247 137 319 122 319 102 214 102 193 103 172 122 68 150 55 159 0 170
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 187 134 202 141 202 154 245 154 226 171 180 164 134 155 175 140 173 140
						yourself:
					)
			)
			(= global211 86)
			(body init:)
			(writingOfficer init:)
			(photoOfficer init:)
			(car view: 104 loop: 0 cel: 0 x: 319 y: 114 setPri: 10 init:)
			(patrolCar addToPic:)
			(topLights init: setCycle: Fwd)
			(blueLight init: setCycle: Fwd)
			(redLight init: setCycle: Fwd)
		)
		(trees init:)
		(stream init:)
		(plants init:)
		(plants2 init:)
		(plants3 init:)
		(plants4 init:)
		(rocks init:)
		(rocks2 init:)
		(grass init:)
		(self
			setScript: (if (== global211 86) photoScript else patrollingScript)
		)
	)

	(method (doit &tmp temp0)
		(Palette palANIMATE 242 252 1)
		(super doit:)
	)

	(method (dispose)
		(super dispose:)
	)
)

(instance patrollingScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(car setStep: 3 2 setMotion: MoveTo 346 137 self)
			)
			(1
				(car addToPic:)
				(= seconds 4)
			)
			(2
				(mySound number: 900 loop: 1 flags: -1 play:)
				(= seconds 3)
			)
			(3
				(mySound number: 901 loop: 1 flags: -1 play:)
				(= seconds 3)
			)
			(4
				(gEgo
					view: 1
					x: 334
					y: 156
					init:
					setCycle: StopWalk -1
					setPri: 11
					setMotion: MoveTo 298 166 self
				)
			)
			(5
				(SetScore 195 10)
				(NormalEgo)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance photoScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 10)
			)
			(1
				(photoOfficer setCycle: CT 3 1 self)
			)
			(2
				(= ticks 75)
			)
			(3
				(photoOfficer setCycle: CT 5 1 self)
			)
			(4
				(= ticks 30)
			)
			(5
				(photoOfficer setCycle: End self)
			)
			(6
				(photoOfficer
					setLoop: 4
					setCycle: Walk
					setMotion: PolyPath 194 140 self
				)
			)
			(7
				(photoOfficer setLoop: 2 setCel: 0 setCycle: CT 3 1 self)
			)
			(8
				(= ticks 75)
			)
			(9
				(photoOfficer setCycle: CT 5 1 self)
			)
			(10
				(= ticks 45)
			)
			(11
				(photoOfficer setCycle: End self)
			)
			(12
				(photoOfficer
					setLoop: 4
					cel: 0
					setCycle: Walk
					setMotion: PolyPath 262 170 self
				)
			)
			(13
				(photoOfficer setLoop: 3 setCel: 255 setCycle: Beg self)
			)
			(14
				(photoOfficer setLoop: 0 setCel: 0 setCycle: CT 2 1)
				(car setMotion: MoveTo 260 129 self)
			)
			(15
				(car addToPic:)
				(photoOfficer setCycle: CT 4 1 self)
				(mySound number: 900 loop: 1 flags: -1 play:)
			)
			(16
				(= seconds 4)
			)
			(17
				(photoOfficer setCycle: End self)
				(mySound number: 901 loop: 1 flags: -1 play:)
			)
			(18
				(= seconds 2)
			)
			(19
				(gEgo
					view: 1
					x: 334
					y: 156
					init:
					setPri: 12
					setCycle: StopWalk -1
					setMotion: MoveTo 298 166 self
				)
			)
			(20
				(= ticks 30)
			)
			(21
				(NormalEgo)
				(= ticks 5)
			)
			(22
				(HandsOn)
				(gMessager say: 7 2) ; "Hey, Sonny, what's up? I hear you found a dead guy the other day. We have one, too, so there!"
				(= local3 1)
				(gCurRoom setScript: 0)
			)
		)
	)
)

(instance intoCarScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 339 162 self)
				(= ticks 30)
			)
			(1
				(if (== (car view:) 104)
					(gMessager say: 13 0 12) ; "See you later, Sonny."
				else
					(= seconds 3)
				)
			)
			(2
				(mySound number: 900 loop: 1 flags: -1 play:)
				(= seconds 3)
			)
			(3
				(mySound number: 901 loop: 1 flags: -1 play:)
				(= seconds 4)
			)
			(4
				(mySound number: 904 loop: 1 flags: -1 play:)
				(= seconds 3)
				(gLongSong fade:)
			)
			(5
				(= global211 88)
				(gCurRoom newRoom: 500)
			)
		)
	)
)

(instance toBodyScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(body approachVerbs: 0)
				(writingOfficer setCycle: End)
				(gEgo
					view: 415
					setLoop: 0
					cel: 0
					x: 217
					y: 153
					setCycle: CT 6 1 self
				)
			)
			(1
				(body setCel: 1)
				(= ticks 60)
			)
			(2
				(gMessager say: 1 4 1 0 self) ; "You lift the sheet off of the body. He's looking pretty bad. You guess he's been in the river for a day or two. Oh well, it could be worse. It could have been a week or two."
			)
			(3
				(HandsOn)
				(gTheIconBar disable: 0)
				(= local0 4)
				(gCurRoom setScript: 0)
				(self dispose:)
			)
		)
	)
)

(instance bodyCUScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (IsFlag 40)
					(SetScore 180 2)
				)
				(gCurRoom setInset: bodyInset self)
				(mySound number: 404 loop: 1 flags: -1 play:)
			)
			(1
				(if (IsFlag 40)
					(SetScore 181 3)
				)
				(gCurRoom setScript: 0)
				(self dispose:)
			)
		)
	)
)

(instance insetScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(if (IsFlag 40)
					(gMessager say: 15 1 14 0 self) ; "A rose tattoo! It's Taselli! Geez, he didn't get too far."
					(= local1 5)
				else
					(gMessager say: 15 1 13 0 self) ; "The dead man has a tattoo over his left nipple. It appears to be a red rose."
					(= local1 4)
				)
			)
			(2
				(bodyInset dispose:)
				(= ticks 10)
			)
			(3
				(gMessager say: 1 4 3 0) ; "You carefully replace the sheet on the body."
				(gEgo setCycle: End self)
				(writingOfficer setCycle: Beg)
				(body setCel: 0)
			)
			(4
				(gEgo
					view: 1
					x: (- (gEgo x:) 9)
					y: (- (gEgo y:) 1)
					setHeading: 180
					setLoop: -1
					loop: 8
					cel: 2
					setCycle: StopWalk -1
				)
				(NormalEgo)
				(= ticks 60)
			)
			(5
				(writingOfficer stopUpd:)
				(gMessager say: 12 0 6 0 self) ; "So who is he, dude? Do you have any idea?"
			)
			(6
				(= local0 3)
				(body approachVerbs: 4) ; Do
				(gTheIconBar enable: 0 2)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance bodyInset of Inset
	(properties
		view 410
		x 158
		y 130
		priority 15
		disposeNotOnMe 1
	)

	(method (init)
		(super init: &rest)
		(gCurRoom setScript: insetScript)
	)
)

(instance car of Actor
	(properties
		noun 11
		approachX 319
		approachY 164
		yStep 1
		priority 13
		signal 22528
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 4) ; Do
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(1 ; Look
				(if (== (car view:) 914)
					(gMessager say: 11 1 11) ; "That's your police issue patrol car."
				else
					(gMessager say: 11 1 10) ; "It's your undercover vehicle. It was confiscated in a large drug bust upstate and issued to the department through a program which redistributes siezed assets to local law enforcement agencies."
				)
			)
			(4 ; Do
				(gCurRoom setScript: intoCarScript)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance body of Prop
	(properties
		x 217
		y 160
		noun 1
		approachX 212
		approachY 150
		view 410
		loop 1
		priority 12
		signal 20496
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 4) ; Do
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(1 ; Look
				(cond
					((== local0 4)
						(HandsOff)
						(gCurRoom setScript: bodyCUScript)
					)
					((not local0)
						(gMessager say: 1 1 4) ; "The poor guy is pretty seriously dead. You wonder what happened to him."
					)
					(else
						(gMessager say: 1 1 5) ; "He's very gray and waterlogged. You feel the contents of your stomach slowly rolling around."
					)
				)
			)
			(4 ; Do
				(cond
					((and (< local1 2) (== (gEgo view:) 1))
						(HandsOff)
						(gCurRoom setScript: toBodyScript)
					)
					((== local1 4)
						(gMessager say: 15 1 13 0 self) ; "The dead man has a tattoo over his left nipple. It appears to be a red rose."
					)
					(else
						(gMessager say: 1 1) ; "Yep, this is just about the deadest body you've ever seen in Lytton."
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance writingOfficer of Prop
	(properties
		x 180
		y 148
		noun 6
		view 412
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(cond
					((== local0 3)
						(if (== local1 5)
							(= local1 6)
							(gMessager say: 5 2 6 0) ; "I'm afraid it's Jason Taselli."
						else
							(= local1 6)
							(gMessager say: 5 2) ; "I think it might be Taselli. I can't be sure, though."
						)
						(= local0 8)
						(= local2 2)
						(= local3 2)
					)
					((and (== local2 1) (-- local4))
						(if (== local4 1)
							(= local2 2)
						)
						(= local2 2)
						(gMessager say: 6 2 7) ; "Investigate if you're gonna, Sonny. The coroner is coming for this dude any minute now."
					)
					((== local2 0)
						(gMessager say: 6 2) ; "Hey, Todd, what do we have here?"
						(= local1 1)
						(= local2 1)
					)
					(else
						(gMessager say: 6 2 8) ; "Officer Ballew is busy."
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance photoOfficer of Actor
	(properties
		x 118
		y 135
		noun 7
		view 413
		loop 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(cond
					((== local0 3)
						(if (== local1 5)
							(= local1 6)
							(gMessager say: 5 2 6 0) ; "I'm afraid it's Jason Taselli."
						else
							(= local1 6)
							(gMessager say: 5 2) ; "I think it might be Taselli. I can't be sure, though."
						)
						(= local0 8)
						(= local2 2)
						(= local3 2)
					)
					((== local3 1)
						(gMessager say: 7 2 7) ; "Oh, man, I'm not feelin' so hot."
						(= local3 2)
					)
					((not local3)
						(gMessager say: 7 2) ; "Hey, Sonny, what's up? I hear you found a dead guy the other day. We have one, too, so there!"
						(= local3 1)
					)
					(else
						(gMessager say: 7 2 8) ; "Officer Shannon doesn't feel like talking right now. I wouldn't get too close to him if I were you, Bonds."
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance Todd of Narrator
	(properties
		x 60
		y 30
		talkWidth 130
		showTitle 1
		back 46
	)

	(method (init)
		(= font gUserFont)
		(super init: &rest)
	)
)

(instance Mike of Narrator
	(properties
		x 170
		y 40
		talkWidth 130
		showTitle 1
		back 62
	)

	(method (init)
		(= font gUserFont)
		(super init: &rest)
	)
)

(instance patrolCar of View
	(properties
		x 102
		y 151
		noun 2
		view 103
		priority 14
		signal 20496
	)
)

(instance topLights of Prop
	(properties
		x 121
		y 161
		noun 2
		view 103
		loop 4
		priority 14
		signal 16400
	)
)

(instance redLight of Prop
	(properties
		x 150
		y 178
		noun 2
		view 103
		loop 6
		priority 14
		signal 16400
	)
)

(instance blueLight of Prop
	(properties
		x 154
		y 177
		noun 2
		view 103
		loop 5
		cel 1
		priority 14
		signal 16400
	)
)

(instance trees of Feature
	(properties
		x 159
		y 47
		noun 16
		nsBottom 95
		nsRight 319
		sightAngle 40
		onMeCheck 64
	)
)

(instance stream of Feature
	(properties
		x 134
		y 102
		noun 14
		nsTop 49
		nsBottom 155
		nsRight 268
		sightAngle 40
		onMeCheck 2
	)
)

(instance plants of Feature
	(properties
		x 35
		y 173
		noun 8
		nsTop 157
		nsBottom 189
		nsRight 70
		sightAngle 40
		onMeCheck 16384
	)
)

(instance plants2 of Feature
	(properties
		x 37
		y 92
		noun 8
		nsTop 61
		nsBottom 123
		nsRight 74
		sightAngle 40
		onMeCheck 16384
	)
)

(instance plants3 of Feature
	(properties
		x 161
		y 47
		noun 8
		nsTop 40
		nsLeft 104
		nsBottom 54
		nsRight 218
		sightAngle 40
		onMeCheck 16384
	)
)

(instance plants4 of Feature
	(properties
		x 288
		y 73
		noun 8
		nsTop 50
		nsLeft 257
		nsBottom 96
		nsRight 319
		sightAngle 40
		onMeCheck 16384
	)
)

(instance rocks of Feature
	(properties
		x 73
		y 91
		noun 9
		nsTop 63
		nsBottom 120
		nsRight 147
		sightAngle 40
		onMeCheck 16
	)
)

(instance rocks2 of Feature
	(properties
		x 220
		y 71
		noun 9
		nsTop 49
		nsLeft 169
		nsBottom 93
		nsRight 272
		sightAngle 40
		onMeCheck 16
	)
)

(instance grass of Feature
	(properties
		x 222
		y 105
		noun 3
		nsTop 53
		nsBottom 189
		nsRight 319
		sightAngle 40
		onMeCheck 4
	)
)

(instance mySound of Sound
	(properties)
)

