;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 420)
(include sci.sh)
(use Main)
(use eRS)
(use Garbage)
(use n819)
(use Talker)
(use PolyPath)
(use Polygon)
(use Feature)
(use MoveFwd)
(use Motion)
(use Actor)
(use System)

(public
	rm420 0
)

(local
	local0
	local1
	[local2 12] = [-1 -1 -340 60 15 -20 90 340 105 80 210 -32768]
	[local14 16] = [-1 0 240 -20 15 -20 60 270 77 8192 -1 340 97 -20 83 -32768]
	[local30 20] = [-1 1 -340 105 15 45 120 8192 -1 340 120 -20 75 50 67 8192 -1 340 30 -32768]
)

(instance rm420 of EcoRoom
	(properties
		lookStr 46
		picture 420
		style 7
		horizon 10
		east 440
		west 100
	)

	(method (init)
		(NormalEgo)
		(gEgo ignoreActors: init: setPri: 13)
		(if (not (IsFlag 73))
			(NormalDelph)
			(gDelph init: setPri: 12 z: 0 ignoreActors: hide:)
		)
		(SetFlag 107)
		(if (not (IsFlag 73))
			(switch gPrevRoomNum
				(east
					(gDelph
						show:
						posn: 405 100
						setHeading: 270
						setMotion: MoveFwd 120
					)
				)
				(else
					(gDelph
						show:
						posn: -85 100
						setHeading: 90
						setMotion: MoveFwd 120
					)
				)
			)
		)
		(gFeatures
			add: city colossusHead tire plants ledge frond
			eachElementDo: #init
		)
		(gCast add: bear flamingo larryDoll boxers eachElementDo: #init)
		(super init:)
		(self setRegions: 51 50) ; bubblesRegion, regionFish
		((ScriptID 50 0) addFish: @local14 @local30 @local2) ; regionFish
		(if (not (gEgo has: 24)) ; mirror
			(mirror init: setPri: 11 stopUpd:)
			(damselFish init: setCycle: Fwd)
		)
		(if (not (IsFlag 248))
			(glassJar init: stopUpd:)
		)
		(kelpBed1 init: setPri: 5 setCycle: Fwd)
		(kelpBed2 init: setPri: 14 stopUpd:)
		(if (== global233 2)
			(ear init:)
		else
			(blueGlow init: setPri: 10 setCycle: Fwd)
		)
		(self
			setRegions: 51 ; bubblesRegion
			addObstacle:
				((Polygon new:) type: PBarredAccess init: 0 0 319 0 319 10 0 10 yourself:)
		)
		(if (!= (gLongSong number:) 420)
			(gLongSong number: 420 loop: -1 play:)
		)
	)

	(method (notify)
		(if (not (gEgo has: 24)) ; mirror
			(damselFish setScript: kissMirror)
		)
	)

	(method (doit)
		(super doit:)
		(if (> gHowFast 0)
			(Palette palANIMATE 33 42 7)
		)
		(cond
			(script 0)
			((& (gEgo onControl: 1) $4000)
				(gCurRoom newRoom: 120)
			)
			((== (gEgo edgeHit:) EDGE_BOTTOM)
				(gCurRoom setScript: cantGoThatWay)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(gSoundEffects flags: 0)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance waitForNothing of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 131 92 self)
			)
			(1
				(gEgo
					setCycle: 0
					view: 421
					loop: 0
					cel: 0
					x: 136
					y: 78
					cycleSpeed: 20
					setPri: 14
					setCycle: End self
				)
			)
			(2
				(gEgo
					view: 421
					loop: 1
					cel: 0
					x: 136
					y: 78
					cycleSpeed: 10
					setCycle: Fwd
				)
				(= cycles 10)
			)
			(3
				(Narrator init: 2 self) ; "The flashlight fish swims right up to the jar. However, the lid keeps it from going any farther."
				(= cycles 1)
			)
			(4
				(NormalEgo 0)
				(gEgo ignoreActors: posn: 140 74 setPri: 13)
				(= cycles 1)
			)
			(5
				(gEgo setHeading: 90)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance jarOnEar of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 131 92 self)
			)
			(1
				(gEgo
					setCycle: 0
					view: 421
					loop: 0
					cel: 0
					x: 136
					y: 78
					cycleSpeed: 20
					setPri: 14
					setCycle: End self
				)
			)
			(2
				(gEgo
					view: 421
					loop: 1
					cel: 0
					x: 136
					y: 78
					cycleSpeed: 10
					setCycle: Fwd
				)
				(= cycles 25)
			)
			(3
				(Narrator init: 29 self) ; "Adam senses some movement inside the ear."
			)
			(4
				(= cycles 20)
			)
			(5
				(blueGlow
					view: 422
					loop: 1
					cel: 0
					x: 178
					y: 56
					priority: 14
					setCycle: End
				)
				(= cycles 15)
			)
			(6
				(Narrator init: 30 self) ; "The flashlight fish darts into the jar and settles in the bottom."
			)
			(7
				(= global233 2)
				(gEgo get: 23) ; jar
				(SetScore 10 306)
				(blueGlow dispose:)
				(ear init:)
				(= cycles 1)
			)
			(8
				((ScriptID 2 0) init: 22 1 self) ; Delphineus, "Wow, look at that, glowing light, just like the Oracle said!"
			)
			(9
				(Narrator init: 31 self) ; "Adam carefully places the glowing jar in his backpack."
			)
			(10
				(NormalEgo 0)
				(gEgo ignoreActors: posn: 140 74 setPri: 13)
				(= cycles 1)
			)
			(11
				(gEgo setHeading: 90)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance getMirror of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 143 162 self)
			)
			(1
				(gEgo view: 421 loop: 8 cel: 0 x: 143 y: 162)
				(gEgo get: 24) ; mirror
				(mirror dispose:)
				(= cycles 2)
			)
			(2
				(SetScore 2 305)
				(NormalEgo)
				(gEgo ignoreActors: setPri: 13)
				(= cycles 12)
			)
			(3
				(Narrator init: 17 self) ; "Adam picks up the old rearview mirror and puts it away."
			)
			(4
				((ScriptID 2 0) init: 20 1 self) ; Delphineus, "Hey, cool, there was a diver down here the other day using something like that to attract the fish. Nice to find somebody who wants to make friends rather than collect us!"
			)
			(5
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance getJar of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 179 145 self)
			)
			(1
				(gEgo setHeading: 270 self)
			)
			(2
				(gEgo
					setCycle: 0
					view: 421
					loop: 8
					cel: 0
					posn: 168 149
					cycleSpeed: 13
					setCycle: CT 3 1 self
				)
			)
			(3
				(Narrator init: 8 self) ; "Adam picks up the glass jar. It looks recyclable, so he puts it away in his backpack."
			)
			(4
				(SetScore 2 248)
				(glassJar dispose:)
				(gEgo get: 23 setCycle: End self) ; jar
			)
			(5
				(NormalEgo 1)
				(gEgo ignoreActors: posn: 179 145 setPri: 13)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance lookAtGlow of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 150 76 self)
			)
			(1
				(Face gEgo blueGlow)
				(= cycles 15)
			)
			(2
				((ScriptID 2 0) init: 7 1 self) ; Delphineus, "Oooh, weird! Lemme look at that!"
			)
			(3
				(gEgo ignoreActors: setMotion: MoveTo 117 28 self)
			)
			(4
				(Face gEgo gDelph)
				(= seconds 1)
			)
			(5
				(gDelph setMotion: MoveTo 132 76 self)
			)
			(6
				(NormalDelph)
				(gDelph setPri: 12 z: 0 ignoreActors:)
				(Face gEgo gDelph)
				(Face gDelph blueGlow)
				(= seconds 2)
			)
			(7
				((ScriptID 2 0) init: 8 1 self) ; Delphineus, "Blow me away, it's a flashlight fish! He's one of those nocturnal types, so I dunno what he's doing there!"
			)
			(8
				((ScriptID 2 1) init: 2 1 self) ; Adam, "Nocturnal?"
			)
			(9
				((ScriptID 2 0) init: 9 1 self) ; Delphineus, "Yeah, comes out at night, lives down deep during the day. I wonder why he didn't go home. Something must have happened."
			)
			(10
				(NormalDelph)
				(gDelph
					setPri: 12
					z: 0
					ignoreActors:
					setMotion: MoveTo 35 100 self
				)
			)
			(11
				(Face gDelph gEgo)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance kissMirror of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(if (and (< state 5) (<= (gEgo distanceTo: damselFish) 50))
			(= state 4)
			(= cycles 1)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(damselFish
					view: 423
					loop: 0
					cel: 0
					posn: 177 152
					setCycle: CT 1 1 self
				)
			)
			(1
				(damselFish
					view: 423
					loop: 0
					cel: 2
					posn: 177 152
					setCycle: End self
				)
			)
			(2
				(damselFish
					view: 423
					loop: 1
					cel: 0
					posn: 177 152
					setCycle: CT 4 1 self
				)
			)
			(3
				(gSoundEffects number: 421 loop: 1 flags: 1 play:)
				(damselFish cel: 5 setCycle: End self)
			)
			(4
				(= state 0)
				(= cycles 1)
			)
			(5
				(damselFish
					view: 423
					loop: 2
					cel: 0
					posn: 177 152
					cycleSpeed: 6
					setCycle: End self
				)
			)
			(6
				(if (< (gEgo x:) 160)
					(= local1 1)
					(damselFish
						view: 423
						setLoop: 3
						cel: 0
						posn: 182 152
						cycleSpeed: 2
						setCycle: Fwd
					)
				else
					(damselFish
						view: 423
						setLoop: 4
						cel: 0
						posn: 166 152
						cycleSpeed: 2
						setCycle: Fwd
					)
				)
				(= cycles 2)
			)
			(7
				(Narrator init: 98 self) ; "The damsel fish is startled by Adam's approach. She gives up looking at the "other" fish in the mirror and swims away."
			)
			(8
				(if (== local1 1)
					(damselFish setMotion: MoveTo 330 140 self)
				else
					(damselFish setPri: 12 setMotion: MoveTo -10 140 self)
				)
			)
			(9
				(damselFish setScript: 0 dispose:)
			)
		)
	)
)

(instance lookAtFlam of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 2 0) init: 21 1 self) ; Delphineus, "Icky. Is that what I think it is?"
			)
			(1
				((ScriptID 2 1) init: 5 1 self) ; Adam, "No, don't worry. It's just a statue. Actually, what we call lawn art."
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance cantGoThatWay of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 1)
			)
			(1
				(if (== local0 0)
					(Narrator init: 9 self) ; "The fronds form a dense, impenetrable forest this way."
				else
					((ScriptID 2 1) init: 3 1 self) ; Adam, "I'd probably get caught in those fronds if I swam that way again."
				)
			)
			(2
				(= local0 1)
				(gEgo setMotion: MoveTo (gEgo x:) (- (gEgo y:) 7) self)
			)
			(3
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance damselFish of Actor
	(properties
		x 177
		y 152
		view 423
		loop 3
		priority 11
		signal 20496
		cycleSpeed 9
		xStep 9
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				((ScriptID 2 0) init: 13) ; Delphineus, "Can you stand it? These little fish just love mirrors. They think there's another fish in there. I'm glad I'm one of the higher mammals."
			)
			(3 ; Do
				((ScriptID 2 0) init: 18) ; Delphineus, "Don't disturb her, Adam. She's primping."
			)
			(5 ; Talk
				((ScriptID 2 0) init: 19) ; Delphineus, "She's not an Elurian, Adam, so she doesn't have the power of speech."
			)
			(4 ; Inventory
				(Narrator init: 47) ; "The damsel fish wouldn't appreciate that."
			)
			(10 ; Recycle
				(Narrator init: 52) ; "Bagging a live fish is not a good idea."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance city of Feature
	(properties
		onMeCheck 16384
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (IsFlag 73)
					(Narrator init: (Random 174 176) 0 4)
				else
					((ScriptID 2 0) init: 16 1) ; Delphineus, "I don't know exactly what the Oracle meant, Adam. But I do know she wants us to look around out here."
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance colossusHead of Feature
	(properties
		onMeCheck 4
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 1) ; "Someone beheaded the Colossus that guarded the harbor a long time ago. Here it lies and could tell many a tale if such statues could talk."
				(if (not (== global233 2))
					(Narrator store: 28)
				)
			)
			(3 ; Do
				(if (IsFlag 73)
					(Narrator init: (Random 177 179) 0 4)
				else
					((ScriptID 2 0) init: 6 1) ; Delphineus, "That works in some Sierra games, like Space Quest 3. But it would be tacky to use the same trick, wouldn't it?"
				)
			)
			(5 ; Talk
				(if (IsFlag 73)
					(super doVerb: theVerb)
				else
					((ScriptID 2 0) init: 5 1) ; Delphineus, "Are you feeling okay, Adam? You can't talk to statues! Not if you want answers, at least!"
				)
			)
			(4 ; Inventory
				(switch invItem
					(24 ; mirror
						(Narrator init: 32) ; "The statue doesn't need to look at himself."
					)
					(else
						(super doVerb: theVerb invItem &rest)
					)
				)
			)
			(10 ; Recycle
				(Narrator init: 53) ; "Come on, there's room in the garbage bag - but not THAT much!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance tire of Feature
	(properties
		onMeCheck 8
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator store: 42 init: 24) ; "Somebody heaved an old tire over the side, probably some time ago, since it's half buried in the sand."
			)
			(3 ; Do
				(Narrator init: 25) ; "The tire would be too hard to pull out."
			)
			(5 ; Talk
				(Narrator init: 43) ; "The fish who live in the tire are not Elurians and can't talk to Adam."
			)
			(10 ; Recycle
				(Narrator init: 40) ; "The tire is half-buried in the sand and Adam can't bag it. Anyway, someone's living there."
			)
			(4 ; Inventory
				(switch invItem
					(12 ; trident
						(Narrator init: 41) ; "Digging the tire up would disturb the creatures who live there."
					)
					(else
						(super doVerb: theVerb invItem &rest)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance plants of Feature
	(properties
		onMeCheck 16
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 4) ; "The fronds sway in the current."
			)
			(3 ; Do
				(if (IsFlag 73)
					(Narrator init: (Random 177 179) 0 4)
				else
					((ScriptID 2 0) init: 17) ; Delphineus, "That frond is alive, Adam. You might damage it!"
				)
			)
			(10 ; Recycle
				(Narrator init: 37) ; "The living fronds don't belong in a garbage bag."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance ledge of Feature
	(properties
		onMeCheck 32
		lookStr 3
	)
)

(instance frond of Feature
	(properties
		onMeCheck 64
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (IsFlag 73)
					(Narrator init: (Random 174 176) 0 4)
				else
					((ScriptID 2 0) init: 1) ; Delphineus, "With fronds like these - who needs anemones! HAHAHA!"
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance ear of Feature
	(properties
		x 175
		y 63
		nsTop 56
		nsLeft 170
		nsBottom 71
		nsRight 180
		approachX 145
		approachY 63
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 2 4 5) ; Look, Inventory, Talk
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (IsFlag 73)
					(Narrator init: (Random 174 176) 0 4)
				else
					((ScriptID 2 0) init: 11 1) ; Delphineus, "Nothing there but marble earwax!"
				)
			)
			(3 ; Do
				(Narrator init: 35) ; "There's nothing more in the ear."
			)
			(4 ; Inventory
				(switch invItem
					(12 ; trident
						(Narrator init: 39) ; "Don't you know it's unhealthy to stick things in your ears?"
					)
					(else
						(Narrator init: 35) ; "There's nothing more in the ear."
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance mirror of View
	(properties
		x 161
		y 178
		approachX 134
		approachY 171
		view 420
		loop 4
		signal 20480
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 2 4) ; Look, Inventory
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (IsFlag 73)
					(Narrator init: (Random 174 176) 0 4)
				else
					((ScriptID 2 0) init: 12 1) ; Delphineus, "I'd say the rearview mirror from a '57 Chevy. Great car!"
				)
			)
			(3 ; Do
				(gCurRoom setScript: getMirror)
			)
			(10 ; Recycle
				(Narrator init: 97) ; "The mirror still looks useful."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance glassJar of View
	(properties
		x 148
		y 159
		view 421
		loop 7
		priority 10
		signal 20496
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 99) ; "An empty glass jar sits on the ledge. The jar is perfectly clean - its lid is screwed on tight."
			)
			(3 ; Do
				(gCurRoom setScript: getJar)
			)
			(10 ; Recycle
				(Narrator init: 44) ; "The jar still looks useful. It shouldn't be thrown away."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance bear of Garbage
	(properties
		x 183
		y 157
		view 420
		loop 2
		priority 10
		signal 16
		flag 1
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 21) ; "This teddy bear got lost on the way to the picnic."
			)
			(3 ; Do
				(Narrator init: 22) ; "The old teddy bear has nothing to contribute to Adam's adventures."
			)
			(10 ; Recycle
				(Narrator init: 49 self) ; "Adam puts the teddy bear into the garbage bag."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance flamingo of Garbage
	(properties
		x 130
		y 174
		view 420
		loop 2
		cel 5
		priority 9
		signal 16
		flag 2
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (IsFlag 73)
					(Narrator init: (Random 174 176) 0 4)
				else
					(gCurRoom setScript: lookAtFlam)
				)
			)
			(3 ; Do
				(Narrator init: 23) ; "Adam's not going to play croquet anytime soon."
			)
			(10 ; Recycle
				(Narrator init: 50 self) ; ""Squawk!" (Well, the flamingo would say that if it could.) Adam puts the plastic flamingo in the garbage bag."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance larryDoll of Garbage
	(properties
		x 88
		y 153
		view 420
		loop 2
		cel 2
		priority 9
		signal 16
		flag 3
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 18) ; "A discarded doll rests on the sand here."
			)
			(3 ; Do
				(Narrator init: 19) ; "Adam doesn't want to play dolls right now."
			)
			(10 ; Recycle
				(Narrator init: 48 self) ; "The sodden doll goes into the garbage bag."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance boxers of Garbage
	(properties
		x 141
		y 148
		lookStr {boxers}
		view 420
		loop 2
		cel 7
		priority 9
		signal 16
		flag 4
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 26) ; "Polka dot shorts are no longer in fashion, it seems."
			)
			(3 ; Do
				(Narrator init: 27) ; "Adam doesn't like underwear covered with polka dots."
			)
			(10 ; Recycle
				(Narrator init: 51 self) ; "The tasteless underwear goes into the garbage bag."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance kelpBed1 of Prop
	(properties
		x 60
		y 64
		view 420
		loop 1
		signal 20480
		cycleSpeed 20
		detailLevel 2
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 4) ; "The fronds sway in the current."
			)
			(3 ; Do
				(if (IsFlag 73)
					(Narrator init: (Random 177 179) 0 4)
				else
					((ScriptID 2 0) init: 17) ; Delphineus, "That frond is alive, Adam. You might damage it!"
				)
			)
			(10 ; Recycle
				(Narrator init: 37) ; "The living fronds don't belong in a garbage bag."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance kelpBed2 of Prop
	(properties
		x 252
		y 55
		view 420
		signal 20480
		cycleSpeed 25
		detailLevel 2
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 4) ; "The fronds sway in the current."
			)
			(3 ; Do
				(if (IsFlag 73)
					(Narrator init: (Random 177 179) 0 4)
				else
					((ScriptID 2 0) init: 17) ; Delphineus, "That frond is alive, Adam. You might damage it!"
				)
			)
			(10 ; Recycle
				(Narrator init: 37) ; "The living fronds don't belong in a garbage bag."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance blueGlow of Prop
	(properties
		x 178
		y 56
		approachX 131
		approachY 92
		view 422
		signal 20480
		cycleSpeed 7
		detailLevel 2
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 3 5) ; Do, Talk
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(gCurRoom setScript: lookAtGlow)
			)
			(3 ; Do
				(Narrator init: 36) ; "Adam doesn't want to scare the fish."
			)
			(4 ; Inventory
				(switch invItem
					(23 ; jar
						(switch global233
							(0
								(gCurRoom setScript: waitForNothing)
							)
							(1
								(gCurRoom setScript: jarOnEar)
							)
						)
					)
					(12 ; trident
						(Narrator init: 33) ; "Adam might skewer the fish if he tried that."
					)
					(14 ; tweezers
						(Narrator init: 34) ; "The fish is too quick for Adam to catch that way."
					)
					(else
						(Narrator init: 38) ; "Adam can't catch the ear's occupant that way."
					)
				)
			)
			(5 ; Talk
				((ScriptID 2 0) init: 10 1) ; Delphineus, "Talking to him won't help, Adam. Only the creatures of Eluria have the power of speech."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

