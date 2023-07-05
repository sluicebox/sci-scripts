;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 42)
(include sci.sh)
(use Main)
(use Interface)
(use eRS)
(use Talker)
(use PChase)
(use Osc)
(use Polygon)
(use Feature)
(use LoadMany)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm42 0
)

(local
	local0
)

(instance rm42 of SQRoom
	(properties
		lookStr {This is the back of the bar at the southeast corner of Ulence Flats.}
		picture 42
		horizon 140
		north 47
		west 41
	)

	(method (init)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 130 192 131 213 137 209 146 223 148 220 153 197 153 181 161 136 161 107 166 62 171 0 170
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 319 189 294 189 286 181 291 174 319 174
					yourself:
				)
		)
		(LoadMany rsVIEW 10 142)
		(switch gPrevRoomNum
			(north
				(= style 10)
				(gEgo posn: 230 (+ horizon 5))
			)
			(west
				(= style 12)
				(gEgo x: 20)
				(if (IsFlag 40)
					(LoadMany rsVIEW 29 432 515)
					(mugger init:)
					(self setScript: mugEgo)
				else
					(HandsOn)
				)
			)
			(43
				(gCurRoom setScript: dumpDust 0 1)
			)
			(else
				(= style 8)
				(gEgo posn: 220 180)
				(HandsOn)
			)
		)
		(self setRegions: 702) ; ulenceRegion
		(if (!= gPrevRoomNum 43)
			(gEgo init:)
		)
		(super init:)
		(robotArm init: hide:)
		(hole init: stopUpd: setScript: dumpDust)
		(radar1 init: setCycle: Fwd)
		(radar2 init: setCycle: Fwd)
		(pile init:)
		(pickup init:)
		(toDBU init:)
		(droidStore init:)
		(barBack init:)
		(scribbles init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 42 0) ; "Nothing to do there."
			)
			(5 ; Talk
				(Print 42 1) ; "Why bother?"
			)
			(12 ; Smell
				(Print 42 2) ; "You detect a bit of sulfur in the air here as well. Can't get away from it on this planet, it appears."
			)
			(11 ; Taste
				(Print 42 3) ; "Don't lick the air. You're libel to get more more than you bargained for."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance dumpDust of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if register
					(= cycles 6)
				else
					(= seconds (Random 10 35))
				)
			)
			(1
				(if (and (gCurRoom script:) (not register))
					(self init:)
				else
					(HandsOff)
					(gSoundEffects number: 603 loop: 1 play:)
					(hole cel: 0 setCycle: End self)
				)
			)
			(2
				(gSoundEffects stop:)
				(Face gEgo hole)
				(robotArm show: loop: 1 cel: 0 setCycle: End self)
			)
			(3
				(= cycles 24)
			)
			(4
				(robotArm loop: 2 cel: 0 setCycle: CT 3 1 self)
			)
			(5
				(gLongSong2 number: 604 loop: 1 play:)
				(robotArm setCycle: End self)
			)
			(6
				(robotArm loop: 6 cel: 0 setCycle: End self)
			)
			(7
				(gSoundEffects number: 603 loop: 1 play:)
				(hole setCycle: Beg self)
			)
			(8
				(gSoundEffects stop:)
				(hole stopUpd:)
				(robotArm hide:)
				(= seconds 2)
			)
			(9
				(if register
					(EgoDead 78 0 0 42 4) ; "Luck's turn has cost you dearly. As your dust particles gradually drift across Kerona's barren landscape, you reflect upon the irony of your fate. Many was the time you swept and dumped piles of dust very similar to your current state."
				else
					(HandsOn)
					(self init:)
				)
			)
		)
	)
)

(instance searchDust of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 10
					setLoop: 5
					cel: 0
					cycleSpeed: 18
					setCycle: CT 2 1 self
				)
			)
			(1
				(gEgo setCycle: CT 1 -1 self)
			)
			(2
				(gEgo setCycle: CT 2 1 self)
			)
			(3
				(gEgo setCycle: CT 1 -1 self)
			)
			(4
				(gEgo setCycle: CT 6 1 self)
			)
			(5
				(= cycles 12)
			)
			(6
				(if (>= global176 3)
					(= temp0 (Random 2 global176))
					(-= global176 temp0)
					(+= global165 temp0)
					(Printf 42 5 temp0) ; "Searching through the pile of dust, you find %u buckazoids!"
				else
					(Print 42 6) ; "You find nothing but ashes, which filter through your fingers and blow away."
				)
				(= seconds 2)
			)
			(7
				(gEgo setCycle: End self)
			)
			(8
				(NormalEgo 0 1 61)
				(if register
					((ScriptID 702 1) setMotion: PFollow gEgo 55) ; robot
				)
				(gEgo loop: 1)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance mugEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 125 171 self)
				(= cycles 30)
			)
			(1
				(mugger setCycle: Osc 1)
			)
			(2
				(muggerTalker
					init:
						muggerBust
						muggerEyes
						muggerMouth
						{"Come on over here, pal. Wait'll ya see this!"}
						0
						0
						1
						self
				)
			)
			(3
				(gEgo setHeading: 90 self)
			)
			(4
				(mugger setLoop: 4 cel: 0 setCycle: End self)
			)
			(5
				(gEgo view: 29 cel: 0 setCycle: End self)
			)
			(6
				(mugger setLoop: 5 cel: 0 setCycle: End self)
			)
			(7
				(muggerTalker
					init:
						muggerBust
						muggerEyes
						muggerMouth
						{"Hold it right there, pal! This is a stick-up! I'll just relieve you of your cash, thank you very much."}
						0
						0
						0
						self
				)
			)
			(8
				(= local0 1)
				(HandsOn)
				(gTheIconBar disable: 0 1 3 4)
				(= seconds 4)
			)
			(9
				(muggerTalker
					say: {"C'mon, c'mon, I ain't got all day."} 0 0 0 self
				)
			)
			(10
				(= seconds 5)
			)
			(11
				(mugger setLoop: 6 cel: 2 setCycle: Beg self)
			)
			(12
				(gEgo setLoop: 2 cel: 0)
				(mugger cel: 1)
				(= cycles 3)
			)
			(13
				(gEgo cel: 1)
				(mugger cel: 0)
				(= cycles 3)
			)
			(14
				(gEgo cel: 0)
				(mugger cel: 1)
				(= cycles 3)
			)
			(15
				(gEgo cel: 1)
				(mugger cel: 0)
				(= cycles 3)
			)
			(16
				(gEgo cel: 0)
				(mugger cel: 1)
				(= cycles 3)
			)
			(17
				(gEgo cycleSpeed: 15 setCycle: End self)
				(mugger cel: 0 setCycle: End)
			)
			(18
				(EgoDead 940 1 0 42 7) ; "The mugger impresses upon you that he was quite serious."
			)
		)
	)
)

(instance egoGivesMoney of Script
	(properties)

	(method (changeState newState &tmp [temp0 80])
		(switch (= state newState)
			(0
				(ClearFlag 40)
				(SetFlag 41)
				(gEgo setLoop: 1 cel: 0 cycleSpeed: 15 setCycle: End self)
			)
			(1
				(mugger setCycle: CT 2 -1 self)
			)
			(2
				(muggerTalker say: (Format @temp0 42 8 global165) 0 0 0 self) ; "%d buckazoids? I guess it's better than nothing. Here, keep five for yourself. I gotta admit you look like you need it."
			)
			(3
				(mugger setCycle: End self)
			)
			(4
				(gEgo cel: 5 setCycle: CT 7 1 self)
				(= global165 5)
			)
			(5
				(gEgo setCycle: CT 5 -1 self)
			)
			(6
				(NormalEgo 0 1 61)
				(mugger setCycle: Beg self)
			)
			(7
				(muggerTalker
					say:
						{"Well, you've got to be leaving now. Go straight back the way you came in. Deviate from that path and you're Grell kibble!"}
						0
						0
						1
						self
				)
			)
			(8
				(mugger setLoop: 4 cel: 5 setCycle: Beg self)
			)
			(9
				(mugger setCycle: CT 3 1 self)
			)
			(10
				(muggerTalker
					init:
						muggerBust
						muggerEyes
						muggerMouth
						{"And if ya try followin' me, you'll get a nasty taste of my blaster. Got it? Good."}
						0
						0
						1
						self
				)
			)
			(11
				(mugger setCycle: Beg self)
			)
			(12
				(mugger
					setLoop: 0
					setCycle: Walk
					setMotion: MoveTo 216 159 self
				)
			)
			(13
				(mugger setMotion: MoveTo 258 150 self)
			)
			(14
				(mugger setLoop: 1 setMotion: MoveTo 215 122 self)
			)
			(15
				(mugger setMotion: MoveTo 152 114 self)
			)
			(16
				(mugger dispose:)
				(NormalEgo 0 1 61)
				(gEgo loop: 0)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance mugger of Actor
	(properties
		x 170
		y 166
		description {alien wolf-creature}
		view 432
		loop 8
		cel 7
		signal 24576
		cycleSpeed 6
		illegalBits 0
		xStep 4
		moveSpeed 6
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if local0
					(Print 42 9) ; "Well, he looked harmless before he pulled that blaster."
				else
					(Print 42 10) ; "This being is about the size of a humanoid but has some odd features. He seems to have a friendly-looking mug."
				)
			)
			(5 ; Talk
				(Print 42 11) ; "He just wants your buckazoids but will take your life if he has to."
			)
			(4 ; Inventory
				(if (== invItem 10) ; buckazoid
					(cond
						((IsFlag 41)
							(Print 42 12) ; "Don't be so generous. You've already given him enough money."
						)
						(local0
							(gCurRoom setScript: egoGivesMoney)
						)
						(else
							(Print 42 13) ; "He hasn't offered to sell you anything yet."
						)
					)
				else
					(Print 42 14) ; "He doesn't want that. He wants your buckazoids."
					(Print 42 15) ; "And you had better hurry!"
				)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance hole of Prop
	(properties
		x 175
		y 97
		description {waste disposal port}
		lookStr {This waste disposal port looks as though it's used quite often.}
		view 142
		priority 10
		signal 16
		cycleSpeed 10
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 42 16) ; "It's controlled from the inside. You can't do anything to it."
			)
			(12 ; Smell
				(Print 42 17) ; "It smells like the outside of a building exposed to a filthy atmosphere for a long time."
			)
			(11 ; Taste
				(Print 42 18) ; "Yuck! This place could use a good beam-cleaning."
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance robotArm of Prop
	(properties
		x 176
		y 108
		description {robot arm}
		lookStr {A robot arm reaches out to dump another load of dust into an already large pile. That must be one very dirty bar.}
		view 142
		loop 1
		priority 10
		signal 24592
		cycleSpeed 10
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 42 16) ; "It's controlled from the inside. You can't do anything to it."
			)
			(12 ; Smell
				(Print 42 19) ; "You can't reach it."
			)
			(5 ; Talk
				(Print 42 20) ; "It's just a mechanical arm, not a head."
			)
			(11 ; Taste
				(Print 42 19) ; "You can't reach it."
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance radar1 of Prop
	(properties
		x 27
		y 173
		description {force field sensor}
		lookStr {The force field's sensors detect any moving, ground-based animals to prevent them from entering - or leaving - Ulence Flats.}
		view 142
		loop 3
		cel 7
		priority 15
		signal 16400
		cycleSpeed 4
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 42 21) ; "I wouldn't mess with them if I were you."
			)
			(5 ; Talk
				(Print 42 22) ; "No answer is forthcoming."
			)
			(12 ; Smell
				(Print 42 21) ; "I wouldn't mess with them if I were you."
			)
			(11 ; Taste
				(Print 42 21) ; "I wouldn't mess with them if I were you."
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance radar2 of Prop
	(properties
		x 302
		y 137
		lookStr {The force field's sensors detect any moving, ground-based animals to prevent them from entering - or leaving - Ulence Flats.}
		view 142
		loop 4
		cel 6
		priority 15
		signal 16400
		cycleSpeed 4
	)

	(method (doVerb theVerb)
		(radar1 doVerb: theVerb &rest)
	)
)

(instance pile of Feature
	(properties
		x 200
		y 147
		description {pile of dust}
		onMeCheck 64
		approachX 231
		approachY 147
		lookStr {There is a strange pile of very fine white powder here. It has a strange, burnt smell to it.}
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 3) ; Do
	)

	(method (doVerb theVerb)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(switch theVerb
			(3 ; Do
				(if (gCurRoom script:)
					(super doVerb: theVerb &rest)
				else
					(gCurRoom setScript: searchDust)
				)
			)
			(12 ; Smell
				(Print 42 23) ; "I'm beginning to understand you a little better now. You snort some of the powder and feel a pain like that of a thousand krebble mites feasting on your nasal membranes. You won't want to be doing that again."
			)
			(11 ; Taste
				(Print 42 24) ; "No way!"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance pickup of Feature
	(properties
		description {pickup building}
		onMeCheck 4
		lookStr {It's a Droids-B-Us store.}
	)

	(method (doVerb theVerb)
		(droidStore doVerb: theVerb &rest)
	)
)

(instance toDBU of Feature
	(properties
		description {way to the Droids-B-Us store}
		onMeCheck 2
		lookStr {That's the way to the Droids-B-Us store.}
	)

	(method (doVerb theVerb)
		(droidStore doVerb: theVerb &rest)
	)
)

(instance droidStore of Feature
	(properties
		description {Droids-B-Us store}
		onMeCheck 16
		lookStr {In the distance you see the familiar shape of a Droids-B-Us store.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 42 25) ; "You can't do anything to it."
			)
			(12 ; Smell
				(Print {You can't do that from here.})
			)
			(11 ; Taste
				(Print {You can't do that from here.})
			)
			(5 ; Talk
				(Print {You can't do that from here.})
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance barBack of Feature
	(properties
		description {bar building}
		onMeCheck 8
		lookStr {The back of the bar looks about as dingy as the front did.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 42 25) ; "You can't do anything to it."
			)
			(12 ; Smell
				(Print 42 17) ; "It smells like the outside of a building exposed to a filthy atmosphere for a long time."
			)
			(11 ; Taste
				(Print 42 18) ; "Yuck! This place could use a good beam-cleaning."
			)
			(5 ; Talk
				(Print 42 26) ; "If you're talking to that you must be frustrated."
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance scribbles of Feature
	(properties
		description {graffiti}
		onMeCheck 4096
		lookStr {It appears to be in Sarienese. Your Sarienese is a little rusty, but you decide it must say "Xenon Bites!"}
	)

	(method (doVerb theVerb)
		(barBack doVerb: theVerb &rest)
	)
)

(instance muggerTalker of Talker
	(properties
		x 7
		y 46
		nsTop 5
		nsLeft 207
		view 515
	)
)

(instance muggerBust of View
	(properties
		view 515
		cel 1
	)
)

(instance muggerMouth of Prop
	(properties
		nsTop 44
		nsLeft 19
		view 515
		loop 2
		cycleSpeed 8
	)
)

(instance muggerEyes of Prop
	(properties
		nsTop 32
		nsLeft 15
		view 515
		loop 1
		cycleSpeed 16
	)
)

