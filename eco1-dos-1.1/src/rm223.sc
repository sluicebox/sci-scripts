;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 223)
(include sci.sh)
(use Main)
(use enterScript)
(use Interface)
(use n804)
(use n819)
(use Talker)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use Grooper)
(use Motion)
(use Inventory)
(use Actor)
(use System)

(public
	rm223 0
)

(local
	local0
	local1
)

(instance rm223 of ApartmentRoom
	(properties
		lookStr 9
		picture 220
		style -32761
		east 200
		south 200
	)

	(method (init)
		(= global250 3)
		(= global251 1)
		(= global229 5)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 189 0 -10 319 -10 319 178 289 178 266 163 305 82 298 41 226 11 105 16 49 42 56 99 101 105 121 132 73 149 172 168 249 189
					yourself:
				)
			setRegions: 51 ; bubblesRegion
		)
		(super init: &rest)
		(NormalEgo)
		(gEgo setPri: 8)
		(if (== ((Inv at: 31) owner:) 223) ; sixPackRing
			(rings init: cel: 14 setPri: 0 stopUpd:)
		)
		(if (gEgo has: 14) ; tweezers
			(tools init:)
		)
		(if (not (IsFlag 50))
			(swordFish init:)
		)
		(gAddToPics
			add:
				anotherplant
				sculpture
				cabinet
				cert
				plant
				wallplaque
				plant2
				plant1
			eachElementDo: #init
			doit:
		)
		(golfClubs init:)
		(bookCase init:)
	)

	(method (notify)
		(HandsOn)
	)
)

(instance firstTalk of Script
	(properties)

	(method (init)
		(super init: &rest)
		(gKeyDownHandler addToFront: self)
		(gMouseDownHandler addToFront: self)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event)
		(if (and (event type:) gModelessDialog)
			(gModelessDialog dispose:)
			(event claimed: 1)
		else
			(super handleEvent: event)
		)
	)

	(method (changeState newState &tmp [temp0 500])
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 15)
			)
			(1
				(Hippocrates init: 1 0 0 1 1 self) ; "Um Hmmm Hmmm Hmph. I seem to have a problem, my good man."
			)
			(2
				((ScriptID 2 1) init: 2 0 0 15 1 self) ; Adam, "I guess so! That looks painful. How did you get your nose stuck in those plastic six-pack rings?"
			)
			(3
				(bubble init: stopUpd:)
				(bubbleFish init:)
				(= cycles 2)
			)
			(4
				(Message msgGET gCurRoomNum 1 0 0 2 @temp0)
				(Print
					@temp0
					#icon
					(Hippocrates view:)
					(Hippocrates loop:)
					(Hippocrates cel:)
					#at
					-1
					124
					#width
					141
					#dispose
					self
				)
				(bubbleFish setCycle: End)
			)
			(5
				(bubble dispose:)
				(bubbleFish dispose:)
				(swordFish setScript: stuckShut)
				(SetScore 2 287)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance useShell of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((ScriptID 2 1) init: 2 0 0 16 1 self) ; Adam, "I have a shell with a sharp edge. Let me see if I can get the rings off."
			)
			(1
				(Hippocrates init: 1 0 0 4 1 self) ; "Be careful, young man. A thnout ith a terrible thing to wathe."
			)
			(2
				(gEgo hide:)
				(= local0 (gEgo x:))
				(= local1 (gEgo y:))
				(swordFish
					view: 238
					loop: 0
					cel: 0
					posn: 182 107
					cycleSpeed: 25
					setCycle: CT 6 1 self
				)
			)
			(3
				((Inv at: 31) owner: 223) ; sixPackRing
				(rings init: setPri: (+ swordFish 1) setCycle: End rings)
				(swordFish cel: 7 setCycle: CT 9 1 self)
			)
			(4
				(gEgo
					setCycle: 0
					view: 238
					loop: 1
					cel: 0
					posn: (swordFish x:) (swordFish y:)
					show:
					setCycle: End
				)
				(swordFish cel: 10 setCycle: End self)
			)
			(5
				(gEgo view: 805 x: local0 y: local1)
				(= seconds 3)
			)
			(6
				(Hippocrates init: 1 0 0 5 0 self) ; "Ah! What a blessed relief! I was afraid I was a bit doomed, good fellow, but your speedy and accurate surgical techniques were my salvation!"
			)
			(7
				(Hippocrates init: 1 0 0 10 1 self) ; "Allow me to introduce myself. I'm Hippocrates, chief sturgeon... er, that is surgeon of Eluria. And who might I have the pleasure of addressing?"
			)
			(8
				((ScriptID 2 1) init: 2 0 0 17 1 self) ; Adam, "I'm Adam - a friend of Delphineus."
			)
			(9
				(Hippocrates init: 1 0 0 6 0 self) ; "Ah! A delightful chap, Delphineus. And in perfect medical condition."
			)
			(10
				(Hippocrates init: 1 0 0 11 1 self) ; "Do you need a check-up, lad? I must confess I know distressingly little about human anatomy, but you are simple creatures - it can't be that difficult."
			)
			(11
				((ScriptID 2 1) init: 2 0 0 18 1 self) ; Adam, "Ugh. I don't need a check-up. I came to tell you about a meeting the Mayor's called in the Council Chambers."
			)
			(12
				(Hippocrates init: 1 0 0 7 0 self) ; "A meeting? Good show! That's just the ticket for what ails us."
			)
			(13
				(Hippocrates init: 1 0 0 8 1 self) ; "Before I go, let me express my gratitude by giving you these fish-bone tweezers. Perhaps they will serve you some day as you have served me."
			)
			(14
				(swordFish
					view: 227
					setCycle: Walk
					cycleSpeed: 8
					setLoop: -1
					setLoop: Grooper
					posn: 177 86
					setHeading: 270 self
				)
			)
			(15
				(swordFish setMotion: MoveTo 146 77 self)
			)
			(16
				(swordFish
					view: 238
					loop: 3
					cel: 0
					posn: 133 94
					cycleSpeed: 8
					setCycle: CT 2 1 self
				)
			)
			(17
				(tools init:)
				(swordFish cel: 3 setCycle: End self)
			)
			(18
				(gEgo view: 238 loop: 4 cel: 0 posn: 184 96)
				(swordFish posn: 184 96 loop: 2 cel: 0)
				(= cycles 2)
			)
			(19
				(if (< (gEgo cel:) 6)
					(-- state)
					(gEgo cel: (+ (gEgo cel:) 1))
					(swordFish cel: (+ (swordFish cel:) 1))
				)
				(= cycles 8)
			)
			(20
				(SetScore 10 288)
				(gEgo get: 14) ; tweezers
				(Narrator init: 3 0 0 63 self) ; "Adam catches the fish-bone tweezers."
			)
			(21
				((ScriptID 2 1) init: 2 0 0 19 1 self) ; Adam, "Thanks, Hippocrates!"
			)
			(22
				(Hippocrates init: 1 0 0 9 1 self) ; "'Tis but a trifle. May you live many days, Adam, and be well!"
			)
			(23
				(NormalEgo 1)
				(gEgo x: local0 y: local1)
				(= cycles 2)
			)
			(24
				(gEgo setHeading: 180 self)
			)
			(25
				(= cycles 12)
			)
			(26
				(swordFish
					ignoreActors:
					view: 227
					loop: 0
					heading: 90
					setCycle: Walk
					setMotion: PolyPath 356 178 self
				)
			)
			(27
				(swordFish dispose:)
				(SetFlag 50)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance pickupRings of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 10)
			)
			(1
				(gEgo setHeading: 90 self)
			)
			(2
				(= cycles 10)
			)
			(3
				(gEgo
					setCycle: 0
					view: 238
					setLoop: 6
					cel: 0
					cycleSpeed: 8
					posn: 144 112
					setCycle: CT 5 1 self
				)
			)
			(4
				(rings dispose:)
				(SetScore 5 290)
				(gEgo cel: 6 setCycle: End self)
				(if (== register 3)
					(gEgo get: 31) ; sixPackRing
				else
					((Inv at: 31) owner: 0) ; sixPackRing
				)
			)
			(5
				(if (== register 10)
					(Narrator init: 3 0 0 3 self) ; "Adam picks up the plastic and puts it in his garbage bag. For a moment, he has the suspicion that there's something he's forgotten to do to the rings. Oh well, too late now."
				else
					(Narrator init: 3 0 0 68 self) ; "Adam picks up the six-pack rings."
				)
			)
			(6
				(NormalEgo 0)
				(gEgo posn: 170 103 setPri: 8)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance stuckShut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(swordFish cycleSpeed: 4 setCycle: RandCycle (Random 3 13) self)
			)
			(1
				(= state -1)
				(= cycles (Random 5 30))
			)
		)
	)
)

(instance swordFish of Actor
	(properties
		x 177
		y 86
		heading 90
		approachX 220
		approachY 90
		view 251
	)

	(method (init)
		(super init: &rest)
		(self
			setCycle: Walk
			ignoreActors:
			setLoop: Grooper
			approachVerbs: 3 4 2 5 ; Do, Inventory, Look, Talk
			setScript: stuckShut
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (not (gEgo has: 14)) ; tweezers
					(Narrator init: 3 0 0 54) ; "The swordfish has gotten his snout trapped in the plastic rings from a six-pack of soda. The plastic is tight and he can't open his mouth enough to eat."
				)
			)
			(3 ; Do
				(Narrator init: 3 0 0 55) ; "The plastic is wrapped tightly around the swordfish's snout. Adam can't pull it off with his hands."
			)
			(4 ; Inventory
				(switch invItem
					(13 ; sharpShell
						(self setScript: 0 setCycle: 0 cel: 0)
						(gCurRoom setScript: useShell)
					)
					(21 ; healingPotion
						(Narrator init: 3 0 0 65) ; "The healing potion won't help get those rings off the swordfish's snout."
					)
					(15 ; urchins
						(Narrator init: 3 0 0 66) ; "The sea urchins can't do anything for the poor swordfish."
					)
					(else
						(Narrator init: 3 0 0 56) ; "That won't help Adam get the rings off of the swordfish's snout."
					)
				)
			)
			(5 ; Talk
				(if script
					(self setScript: 0 setCycle: Beg self)
				else
					(self cue:)
				)
			)
			(10 ; Recycle
				(Hippocrates init: 1 0 0 12) ; "Medicaddy thpeaking, that would not tholve anything."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)

	(method (cue)
		(if (and (SetFlag 38) (not ((Inv at: 31) owner:))) ; sixPackRing
			(Hippocrates init: 1 0 0 3 1) ; "I thorry, but ith too difficult to thalk right now."
		else
			(gCurRoom setScript: firstTalk)
		)
	)
)

(instance bubble of View
	(properties
		x 21
		y 3
		view 243
		priority 15
		signal 16400
	)
)

(instance bubbleFish of Prop
	(properties
		x 102
		y 5
		view 243
		loop 1
		priority 15
		signal 16400
		cycleSpeed 13
	)
)

(instance tools of View
	(properties
		x 118
		y 86
		onMeCheck 0
		view 226
		loop 3
		cel 1
		signal 16401
	)
)

(instance rings of Prop
	(properties
		x 176
		y 90
		approachX 144
		approachY 101
		view 238
		loop 5
		signal 16400
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 3 10) ; Do, Recycle
		(&= signal $efff)
	)

	(method (cue)
		(self stopUpd: setPri: 0)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 3 0 0 67) ; "The six-pack rings that were holding Hippocrates' snout closed are now lying on the floor."
			)
			(3 ; Do
				(gCurRoom setScript: pickupRings 0 theVerb)
			)
			(10 ; Recycle
				(gCurRoom setScript: pickupRings 0 theVerb)
			)
			(4 ; Inventory
				(switch invItem
					(13 ; sharpShell
						(Narrator init: 3 0 0 69) ; "Good idea! Pick the rings up first."
					)
					(else
						(Narrator init: 3 0 0 70) ; "Adam can't do that to the six-pack rings!"
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance golfClubs of Feature
	(properties
		x 253
		y 74
		nsTop 57
		nsLeft 247
		nsBottom 92
		nsRight 260
		sightAngle 90
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Narrator init: 3 0 0 57) ; "Golf clubs? The swordfish is, apparently, just like the doctors back home."
			)
			(3 ; Do
				(Narrator init: 3 0 0 16) ; "Adam can't imagine how a person could play golf under the water, and, anyway, he'd rather be diving... and he is!"
			)
			(4 ; Inventory
				(Narrator init: 3 0 0 73) ; "Adam doesn't need to mess with the doctor's personal belongings."
			)
			(10 ; Recycle
				(Narrator init: 3 0 0 72) ; "The swordfish doctor might not have much, but what he has he wants to keep, thank you very much."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bookCase of Feature
	(properties
		x 271
		y 69
		sightAngle 90
	)

	(method (onMe param1)
		(return
			(or
				(InRect 263 45 280 94 param1)
				(InRect 281 44 290 59 param1)
				(InRect 299 45 310 60 param1)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Narrator init: 3 0 0 58) ; "The bookcase contains `Fishbein's Medical Encyclopedia.'"
			)
			(3 ; Do
				(Narrator init: 3 0 0 15) ; "Yuck! Fishy medical books! No thanks!"
			)
			(4 ; Inventory
				(Narrator init: 3 0 0 73) ; "Adam doesn't need to mess with the doctor's personal belongings."
			)
			(10 ; Recycle
				(Narrator init: 3 0 0 72) ; "The swordfish doctor might not have much, but what he has he wants to keep, thank you very much."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance plant1 of PicView
	(properties
		x 61
		y 89
		lookStr 11
		view 226
		priority 15
		signal 20496
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Narrator init: 3 0 0 19) ; "Adam doesn't want to disturb the living sea plants. He knows the plants on the ocean floor are delicate and can be destroyed with even a gentle touch."
			)
			(4 ; Inventory
				(Narrator init: 3 0 0 73) ; "Adam doesn't need to mess with the doctor's personal belongings."
			)
			(10 ; Recycle
				(Narrator init: 3 0 0 72) ; "The swordfish doctor might not have much, but what he has he wants to keep, thank you very much."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance plant2 of PicView
	(properties
		x 281
		y 56
		z -75
		lookStr 11
		view 226
		loop 1
		priority 0
		signal 20496
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Narrator init: 3 0 0 19) ; "Adam doesn't want to disturb the living sea plants. He knows the plants on the ocean floor are delicate and can be destroyed with even a gentle touch."
			)
			(4 ; Inventory
				(Narrator init: 3 0 0 73) ; "Adam doesn't need to mess with the doctor's personal belongings."
			)
			(10 ; Recycle
				(Narrator init: 3 0 0 72) ; "The swordfish doctor might not have much, but what he has he wants to keep, thank you very much."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance wallplaque of PicView
	(properties
		x 230
		y 61
		lookStr 62
		view 226
		cel 2
		priority 0
		signal 20496
	)

	(method (init)
		(proc804_8 self)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Narrator init: 3 0 0 71) ; "The shield is a bit pretentious for Adam's tastes."
			)
			(4 ; Inventory
				(Narrator init: 3 0 0 73) ; "Adam doesn't need to mess with the doctor's personal belongings."
			)
			(10 ; Recycle
				(Narrator init: 3 0 0 72) ; "The swordfish doctor might not have much, but what he has he wants to keep, thank you very much."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance plant of PicView
	(properties
		x 165
		y 60
		lookStr 11
		view 220
		cel 2
		priority 0
		signal 20496
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Narrator init: 3 0 0 19) ; "Adam doesn't want to disturb the living sea plants. He knows the plants on the ocean floor are delicate and can be destroyed with even a gentle touch."
			)
			(4 ; Inventory
				(Narrator init: 3 0 0 73) ; "Adam doesn't need to mess with the doctor's personal belongings."
			)
			(10 ; Recycle
				(Narrator init: 3 0 0 72) ; "The swordfish doctor might not have much, but what he has he wants to keep, thank you very much."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance cert of PicView
	(properties
		x 113
		y 67
		lookStr 61
		view 226
		cel 1
		priority 0
		signal 20496
	)

	(method (init)
		(proc804_8 self)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Narrator init: 3 0 0 17) ; "If Adam wants a diploma in medicine, he'll have to earn one himself!"
			)
			(4 ; Inventory
				(Narrator init: 3 0 0 73) ; "Adam doesn't need to mess with the doctor's personal belongings."
			)
			(10 ; Recycle
				(Narrator init: 3 0 0 72) ; "The swordfish doctor might not have much, but what he has he wants to keep, thank you very much."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance cabinet of PicView
	(properties
		x 122
		y 118
		lookStr 60
		view 226
		loop 1
		cel 1
		priority 0
		signal 20496
	)

	(method (init)
		(proc804_8 self)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Narrator init: 3 0 0 60) ; "The table holds the swordfish Doctor's medical supplies."
			)
			(3 ; Do
				(if (IsFlag 50)
					(Narrator init: 3 0 0 13) ; "Adam doesn't want to take anything from the swordfish's apartment that wasn't given to him."
				else
					(Narrator init: 3 0 0 64) ; "Unfortunately, there doesn't seem to be anything on the table that would help the swordfish out of his predicament."
				)
			)
			(4 ; Inventory
				(Narrator init: 3 0 0 73) ; "Adam doesn't need to mess with the doctor's personal belongings."
			)
			(10 ; Recycle
				(Narrator init: 3 0 0 72) ; "The swordfish doctor might not have much, but what he has he wants to keep, thank you very much."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance sculpture of PicView
	(properties
		x 69
		y 141
		lookStr 59
		view 226
		loop 2
		cel 1
		priority 10
		signal 20496
	)

	(method (init)
		(proc804_8 self)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Narrator init: 3 0 0 18) ; "Nah. Adam has a REAL dolphin to play with."
			)
			(4 ; Inventory
				(Narrator init: 3 0 0 73) ; "Adam doesn't need to mess with the doctor's personal belongings."
			)
			(10 ; Recycle
				(Narrator init: 3 0 0 72) ; "The swordfish doctor might not have much, but what he has he wants to keep, thank you very much."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance anotherplant of PicView
	(properties
		x 164
		y 171
		lookStr 11
		view 226
		loop 2
		priority 15
		signal 20496
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Narrator init: 3 0 0 19) ; "Adam doesn't want to disturb the living sea plants. He knows the plants on the ocean floor are delicate and can be destroyed with even a gentle touch."
			)
			(4 ; Inventory
				(Narrator init: 3 0 0 73) ; "Adam doesn't need to mess with the doctor's personal belongings."
			)
			(10 ; Recycle
				(Narrator init: 3 0 0 72) ; "The swordfish doctor might not have much, but what he has he wants to keep, thank you very much."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance Hippocrates of Talker
	(properties
		nsTop 16
		nsLeft 10
		view 235
		viewInPrint 1
		charNum 12
		keepWindow 1
	)

	(method (init)
		(if (= cel (!= ((Inv at: 31) owner:) 223)) ; sixPackRing
			(hMouth nsLeft: 21 nsTop: 15)
		else
			(hMouth nsLeft: 25 nsTop: 10)
		)
		(hMouth loop: (+ 1 cel))
		(super init: hBust hEyes hMouth &rest)
	)
)

(instance hBust of Prop
	(properties
		view 235
		cel 1
	)
)

(instance hEyes of Prop
	(properties
		nsTop 5
		nsLeft 27
		view 235
		loop 3
		cycleSpeed 30
	)
)

(instance hMouth of Prop
	(properties
		nsTop 10
		nsLeft 25
		view 235
		loop 1
		cycleSpeed 10
	)
)

