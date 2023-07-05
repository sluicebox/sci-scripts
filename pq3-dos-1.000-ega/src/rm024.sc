;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 24)
(include sci.sh)
(use Main)
(use Interface)
(use rmnScript)
(use eRS)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm024 0
)

(local
	local0
	local1
)

(instance rm024 of PQRoom
	(properties
		picture 24
		south -1
	)

	(method (init)
		(super init:)
		(ScriptID 941) ; MISSING EXPORT
		(ScriptID 891) ; station
		(ScriptID 894) ; elevator
		(escSound number: 240 loop: -1 flags: 1 play:)
		(soundFX init:)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 319 189 288 189 288 160 164 76 128 74 22 128 22 189 0 189 0 0 319 0
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 124 101 150 84 207 127 182 143
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 193 151 217 133 264 166 238 180
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 145 161 108 185 48 143 52 139 40 126 57 115 68 123 81 115 93 128 112 116 134 134 133 144
					yourself:
				)
			setRegions: 891 894 ; station, elevator
		)
		(gEgo
			view: (if (> gDay 1) 4 else 0)
			posn: 77 73
			setPri: 1
			setStep: 3 2
			init:
		)
		(dispatch1 init: setScript: (dispatchScripts new:))
		(dispatch2 init: setScript: (dispatchScripts new:))
		(dispatch3 init: setScript: (dispatchScripts new:))
		(screen1 init:)
		(screen2 init:)
		(screen3 init:)
		(monitor1 init:)
		(monitor2 init:)
		(inOut init:)
		(cabinet init:)
		(banks init:)
		(desk init:)
		(deskD init:)
		(computer init:)
		(table init:)
		(glass init:)
		(floor init:)
		(theRoom init:)
		(if (== ((gInventory at: 21) owner:) 24) ; compCard
			(reqCard init:)
		)
		(self setScript: global110)
		(labTech approachVerbs: 5 4 init:) ; Talk, Inventory
		(= global113 labTech)
		(if
			(and
				(not (gEgo has: 22)) ; tracker
				(not (== ((gInventory at: 22) owner:) 47)) ; tracker
				(>= gDay 4)
			)
			(gEgo get: 22 put: 22 24) ; tracker, tracker
		)
	)

	(method (dispose)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(super dispose:)
		(DisposeScript 894)
	)
)

(instance giveForm of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= save1 1)
				(Print 24 0 #dispose) ; "You hand the requisition form to Mike, the head technician."
				(= seconds 5)
			)
			(1
				(SetScore 102 4)
				(gEgo put: 0 24) ; compRequest
				(= save1 1)
				(techInset init:)
				(Say techInset 24 1) ; "Hey, no problem. You've got the new Mark V model don't you? What a beaut!"
				(= seconds 6)
			)
			(2
				(= save1 1)
				(Say techInset 24 2) ; "It goes from zero to 30 Megahertz in 3.5 seconds."
				(= seconds 6)
			)
			(3
				(= save1 1)
				(Say techInset 24 3) ; "And! It has a 4 Megabyte memory capacity, XGA graphics, and a 5 millisecond network access time."
				(= seconds 7)
			)
			(4
				(= save1 1)
				(techInset dispose:)
				(Animate (gCast elements:) 0)
				(Print 24 4 #dispose) ; "You wait for Mike to shut-up. But like a streak of bad luck, he keeps going."
				(= seconds 6)
			)
			(5
				(= save1 1)
				(techInset init:)
				(Say techInset 24 5) ; "Just don't spill coffee on it, man!"
				(= seconds 4)
			)
			(6
				(= save1 1)
				(Say techInset 24 6) ; "You shoulda seen what I had to go through when the Chief dripped ice cream all over his. Yuck!"
				(= seconds 7)
			)
			(7
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(techInset dispose:)
				(labTech setPri: 12 loop: 2 cel: 0 setCycle: CT 7 1 self)
				(soundFX number: 914 play:)
			)
			(8
				(labTech setCycle: End self)
			)
			(9
				((gInventory at: 21) owner: 24) ; compCard
				(reqCard init:)
				(labTech setCycle: CT 4 -1 self)
			)
			(10
				(labTech setCycle: Beg self)
				(soundFX number: 915 play:)
			)
			(11
				(= save1 1)
				(Print 24 7 #at 10 10 #dispose) ; "Mike logs your new card and places it on his desk."
				(= seconds 5)
			)
			(12
				(= save1 1)
				(techInset init:)
				(Say techInset 24 8) ; "Okay Bonds, here's your card. It goes in face up, arrow first."
				(= seconds 7)
			)
			(13
				(= save1 1)
				(Say techInset 24 9) ; "I know that's a little hard for you cop types to handle, but you'll figure it out."
				(= seconds 7)
			)
			(14
				(= save1 1)
				(Say techInset 24 10) ; "It's real simple man. Just boot up your machine and stick in your card."
				(= seconds 6)
			)
			(15
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(techInset dispose:)
				(HandsOn)
				(labTech setPri: 12 loop: 0 cel: 0 stopUpd: setScript: getLost)
				(gTheIconBar curIcon: (gTheIconBar at: 2))
				(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
				(self dispose:)
			)
		)
	)
)

(instance getCard of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 104 120 self)
			)
			(1
				(= save1 1)
				(reqCard dispose:)
				(gEgo get: 21) ; compCard
				(Animate (gCast elements:) 0)
				(Print 24 11) ; "You pick up the computer access card."
				(labTech
					setPri: 10
					loop: 2
					cel: 0
					setScript: 0
					setCycle: CT 4 1 self
				)
				(SetScore 103 1)
				(proc0_17 20)
			)
			(2
				(Print 24 12) ; "Mike mumbles to himself..."
				(= cycles 1)
			)
			(3
				(= save1 1)
				(Say labTech 24 13) ; "I'm getting sick and tired of cops who don't return things."
				(= seconds 6)
			)
			(4
				(labTech setCycle: Beg self)
				(soundFX number: 915 play:)
			)
			(5
				(labTech setPri: 12 loop: 0 cel: 0 setCycle: End self)
			)
			(6
				(handSet init:)
				(= save1 1)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(Print 24 14 #at 130 150 #dispose) ; "You hear Mike tell the dispatcher."
				(= seconds 4)
			)
			(7
				(= save1 1)
				(Say labTech 24 15) ; "Get on the radio and tell that dimwit Banks to get that tracking device back to me."
				(= seconds 5)
			)
			(8
				(labTech setCycle: Beg self)
				(handSet dispose:)
			)
			(9
				(techInset dispose:)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(= seconds 2)
			)
			(10
				(labTech loop: 0 cel: 0 setCycle: End self)
			)
			(11
				(handSet init:)
				(Print 24 16) ; "Dispatch responds..."
				(= cycles 1)
			)
			(12
				(= save1 1)
				(Say dispatch3 24 17) ; "Officer Banks says that he needs the tracker for three more days."
				(= seconds 8)
			)
			(13
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(= save1 1)
				(Print 24 18 #dispose) ; "Mike hangs up in disgust."
				(labTech setCycle: Beg self)
			)
			(14
				(handSet dispose:)
				(= seconds 4)
			)
			(15
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(HandsOn)
				(labTech stopUpd: setScript: getLost)
				(self dispose:)
			)
		)
	)
)

(instance getLost of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOn)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(techInset dispose:)
				(= seconds 30)
			)
			(1
				(if
					(and
						(not (gCurRoom script:))
						(not (& (gEgo onControl: 0) $2000))
						(not ((ScriptID 894 1) script:)) ; elevBut
					)
					(= save1 1)
					(HandsOff)
					(techInset init:)
					(switch local0
						(0
							(Say techInset 24 19) ; "Don't you have anything to do, Sergeant?"
						)
						(1
							(Say techInset 24 20) ; "Has your brain slipped into neutral, Sarge?"
						)
						(2
							(Say techInset 24 21) ; "Someone, somewhere must need you, Sergeant."
						)
						(3
							(Say techInset 24 22) ; "Sergeant! Can you stand around and pick your nose somewhere else? I really don't have time for you."
						)
						(else
							(Say techInset 24 23) ; "If you don't mind, I need to get back to installing a hard disk."
						)
					)
					(++ local0)
					(= state -1)
				else
					(= state 0)
				)
				(= seconds 5)
			)
		)
	)
)

(instance getTracker of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 88 122 self)
			)
			(1
				(Face gEgo deskD self)
			)
			(2
				(Print 24 24) ; "You look in the drawer to see what loaner equipment is in stock."
				(soundFX number: 914 play:)
				(= cycles 1)
			)
			(3
				(dInset init: stopUpd:)
				(Animate (gCast elements:) 0)
				(if (== ((gInventory at: 22) owner:) 24) ; tracker
					(Print 24 25) ; "You see a tracking device in the drawer."
				else
					(Print 24 26) ; "The drawer is empty."
					(dInset dispose:)
				)
				(= cycles 1)
			)
			(4
				(soundFX number: 915 play:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance propScripts of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= seconds (Random 3 8))
			)
			(1
				(client
					loop: (= temp0 (+ (client myLoop:) (Random 0 1)))
					cel: 0
				)
				(if (== (client myLoop:) 1)
					(client setCycle: End)
				)
				(= seconds (Random 3 8))
				(= state -1)
			)
		)
	)
)

(instance dispatchScripts of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 3 8))
			)
			(1
				(client cel: 0 setCycle: End self)
				(= seconds (Random 3 8))
				(= state -1)
			)
		)
	)
)

(instance labTalk of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= save1 1)
				(Print 24 27 #dispose) ; "The head technician, Mike Downs, stops his work and says..."
				(= seconds 5)
			)
			(1
				(= save1 1)
				(techInset init:)
				(if (or local1 (gEgo has: 21)) ; compCard
					(Say techInset 24 28) ; "Listen, Sarge, I'm a very busy person!"
					(= seconds 4)
					(= state 5)
				else
					(Say techInset 24 28) ; "Listen, Sarge, I'm a very busy person!"
					(= seconds 4)
					(++ local1)
				)
			)
			(2
				(= save1 1)
				(Say techInset 24 29) ; "Unless you're here on official business, I don't have time for you!"
				(= seconds 6)
			)
			(3
				(= save1 1)
				(Say techInset 24 30) ; "If you don't have your access card, you're out of synch man!"
				(= seconds 6)
			)
			(4
				(= save1 1)
				(Say techInset 24 31) ; "I can't let you access my data without the right authorization sequence."
				(= seconds 6)
			)
			(5
				(= save1 1)
				(Say techInset 24 32) ; "These disks don't spin without the right paperwork. Come back when you got the Requisition form."
				(= seconds 7)
			)
			(6
				(techInset dispose:)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance tellAspen of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= save1 1)
				(sonnyInset init:)
				(Say sonnyInset 24 33) ; "Hey Mike, what does dispatch want?"
				(= seconds 4)
			)
			(1
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(sonnyInset dispose:)
				(labTech setPri: 12 loop: 0 cel: 0 setCycle: CT 6 1 self)
			)
			(2
				(= save1 1)
				(Say labTech 24 34) ; "Who? Oh. Sure, I'll tell him."
				(= seconds 3)
			)
			(3
				(techInset dispose:)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(labTech setCycle: End self)
			)
			(4
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(= save1 1)
				(techInset init:)
				(Say techInset 24 35) ; "Hey Bonds! They need you to drive out to Aspen Falls to respond to a call. All other units are occupied."
				(= seconds 7)
			)
			(5
				(= save1 1)
				(Say techInset 24 36) ; "Listen Sarge, I'm a very busy person! Not your messenger boy."
				(= seconds 6)
			)
			(6
				(techInset dispose:)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance getTracker2 of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Print 24 37) ; "You remove the tracking device from Mike's desk drawer."
				(gEgo get: 22) ; tracker
				(tracker dispose:)
				(dInset dispose:)
				(SetScore 145 5)
				(proc0_17 15)
				(= cycles 1)
			)
			(1
				(= save1 1)
				(techInset init:)
				(Say techInset 24 38) ; "Now, don't you forget to return the tracker either!"
				(= seconds 4)
			)
			(2
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(techInset dispose:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance handSet of Prop
	(properties
		x 120
		y 140
		view 192
		loop 4
		priority 12
		signal 16401
	)
)

(instance labTech of Prop
	(properties
		x 126
		y 132
		description {lab tech}
		approachX 89
		approachY 123
		lookStr {Mike Downs is the head technician. He runs the computer facilities.}
		view 192
		priority 12
		signal 16401
		cycleSpeed 9
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(5 ; Talk
				(HandsOff)
				(if (and (IsFlag 54) (not (IsFlag 55)))
					(SetFlag 55)
					(SetFlag 6)
					(SetFlag 58)
					(gCurRoom setScript: tellAspen)
				else
					(gCurRoom setScript: labTalk)
				)
			)
			(3 ; Do
				(Print 24 39) ; "Yeah, he's a nerd, but he knows his stuff."
			)
			(4 ; Inventory
				(switch invItem
					(0 ; compRequest
						(HandsOff)
						(gCurRoom setScript: giveForm)
					)
					(else
						(Print 24 40) ; "The lab tech doesn't have time to look at your stuff, Bonds."
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance reqCard of Prop
	(properties
		x 102
		y 126
		description {computer card}
		lookStr {Your computer access card is on Mike's desk.}
		view 192
		loop 3
		priority 12
		signal 16401
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(HandsOff)
				(labTech setScript: 0)
				(gCurRoom setScript: getCard)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance dispatch1 of Prop
	(properties
		x 198
		y 54
		description {lab tech}
		lookStr {Behind their glass wall, dispatch is busy monitoring the police band.}
		view 195
		loop 5
		cycleSpeed 8
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Talk
				(Print 24 41) ; "Trying to project your voice through glass proves to be futile."
			)
			(3 ; Do
				(Print 24 42) ; "Yep! There's been times when you've wanted to get your hands around the neck of a dispatcher."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance dispatch2 of Prop
	(properties
		x 216
		y 65
		description {lab tech}
		lookStr {Behind their glass wall, dispatch is busy monitoring the police band.}
		view 195
		loop 6
		cycleSpeed 8
	)

	(method (doVerb theVerb)
		(dispatch1 doVerb: theVerb)
	)
)

(instance dispatch3 of Prop
	(properties
		x 249
		y 85
		description {lab tech}
		lookStr {Behind their glass wall, dispatch is busy monitoring the police band.}
		view 195
		loop 7
		cycleSpeed 8
	)

	(method (doVerb theVerb)
		(dispatch1 doVerb: theVerb)
	)
)

(class escProp of Prop
	(properties
		myLoop 0
	)

	(method (init)
		(super init:)
		(self setScript: (propScripts new:))
		(if (== myLoop 3)
			(self setCycle: Fwd)
		)
	)
)

(instance screen1 of escProp
	(properties
		x 202
		y 26
		description {monitor}
		lookStr {The dispatch center is equipped with the latest audio, visual equipment.}
		view 195
		loop 1
		cycleSpeed 8
		myLoop 1
	)
)

(instance screen2 of escProp
	(properties
		x 223
		y 39
		description {monitor}
		lookStr {The dispatch center is equipped with the latest audio, visual equipment.}
		view 195
		loop 1
		cycleSpeed 8
		myLoop 1
	)
)

(instance screen3 of escProp
	(properties
		x 245
		y 53
		description {monitor}
		lookStr {Law enforcement has certainly gone high tech hasn't it?}
		view 195
		loop 1
		cycleSpeed 8
		myLoop 1
	)
)

(instance monitor1 of escProp
	(properties
		x 235
		y 32
		description {radio}
		lookStr {Law enforcement has certainly gone high tech hasn't it?}
		view 195
		loop 3
		cycleSpeed 8
		myLoop 3
	)
)

(instance monitor2 of escProp
	(properties
		x 259
		y 47
		description {radio}
		lookStr {The dispatch center is equipped with the latest audio, visual equipment.}
		view 195
		loop 3
		cycleSpeed 8
		myLoop 3
	)
)

(instance dInset of Prop
	(properties
		x 73
		y 189
		description {drawer}
		lookStr {It is a drawer.}
		view 194
		priority 15
		signal 17
	)

	(method (init)
		(if (== ((gInventory at: 22) owner:) 24) ; tracker
			(tracker init: stopUpd:)
		)
		(self stopUpd:)
		(super init:)
	)

	(method (doit)
		(super doit:)
		(if (not (gEgo inRect: 86 120 90 124))
			(dInset dispose:)
			(tracker dispose:)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(self dispose:)
				(tracker dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance tracker of Prop
	(properties
		x 73
		y 190
		z 35
		description {drawer}
		lookStr {It is a tracking device.}
		view 194
		loop 1
		priority 15
		signal 17
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(HandsOff)
				(gCurRoom setScript: getTracker2)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance techInset of Prop
	(properties
		x 53
		y 187
		description {lab tech}
		view 190
		priority 15
		signal 16
	)

	(method (init)
		(tMouth posn: (self x:) (self y:) 58 setCycle: RandCycle init:)
		(self stopUpd:)
		(super init:)
	)

	(method (dispose)
		(super dispose:)
		(tMouth dispose:)
	)
)

(instance tMouth of Prop
	(properties
		x 53
		y 187
		description {lab tech}
		view 190
		loop 1
		priority 15
		signal 16
		cycleSpeed 8
	)
)

(instance sonnyInset of Prop
	(properties
		x 264
		y 107
		description {Sonny}
		view 25
		priority 15
		signal 16401
	)

	(method (init)
		(sonnyMouth posn: (self x:) (self y:) setCycle: RandCycle init:)
		(sonnyEyes x: (self x:) y: (self y:) init: setScript: egoEyesBlink)
		(self stopUpd:)
		(super init:)
	)

	(method (dispose)
		(super dispose:)
		(sonnyMouth dispose:)
		(sonnyEyes setScript: 0 dispose:)
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

(instance cabinet of Feature
	(properties
		x 70
		y 127
		description {drawer}
		onMeCheck 2048
		lookStr {That's Mike's cabinet.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 24 43) ; "Don't look through Mike's cabinet."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance deskD of Feature
	(properties
		x 133
		y 167
		description {desk}
		onMeCheck 16384
		lookStr {That's Mike's desk.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(HandsOff)
				(gCurRoom setScript: getTracker)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance banks of Feature
	(properties
		x 196
		y 136
		description {drawer}
		onMeCheck 2
		lookStr {The size of the department's main computer banks always astounds you.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 24 44) ; "You're not qualified to screw around with the mainframe."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance desk of Feature
	(properties
		x 99
		y 138
		description {drawer}
		onMeCheck 8
		lookStr {That's Mike's desk.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 24 45) ; "There's nothing for you on the desk right now."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance computer of Feature
	(properties
		x 99
		y 138
		description {drawer}
		onMeCheck 4
		lookStr {That's Mike's computer.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 24 46) ; "Mike's very protective of his computers."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance table of Feature
	(properties
		x 149
		y 98
		description {drawer}
		onMeCheck 16
		lookStr {The table holds various computer magazines - none of which interest you.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 24 47) ; "The computer magazines are of little interest."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance glass of Feature
	(properties
		x 217
		y 94
		description {drawer}
		onMeCheck 64
		lookStr {The glass wall divides dispatch from the computer facilities.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 24 48) ; "Don't rap on the window and disturb dispatch!"
			)
			(4 ; Inventory
				(Print 24 49) ; "You have an evil mind."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance floor of Feature
	(properties
		x 155
		y 130
		description {drawer}
		onMeCheck 32
		lookStr {The elevated floor consists of individual movable tiles. All the computer cables run underneath the tiles.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 24 50) ; "You don't need to get at the computer cables and Mike wouldn't let you anyway."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance inOut of Feature
	(properties
		x 87
		y 135
		description {drawer}
		onMeCheck 256
		lookStr {That is Mike's In\Out basket.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 24 51) ; "It is empty."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theRoom of Feature
	(properties
		x 160
		y 100
		description {drawer}
		lookStr {The third floor is home to the computer facilities and dispatch.}
	)
)

(instance escSound of Sound
	(properties)
)

(instance soundFX of Sound
	(properties)
)

