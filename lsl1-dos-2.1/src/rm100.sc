;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 100)
(include sci.sh)
(use Main)
(use Interface)
(use eRS)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm100 0
)

(local
	clapTimer
)

(instance rm100 of LLRoom
	(properties
		picture 100
		horizon 120
		north 110
		east 170
	)

	(method (init)
		(if (== gDebugging 2)
			(SetFlag 43)
		)
		(if (== gDebugging 1)
			(SetFlag 15)
		)
		(Load rsVIEW 100)
		(LoadMany rsSOUND 801 802)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 319 140 300 140 300 124 296 124 296 146 98 146 99 137 82 137 72 146 9 146 0 116
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 28 150 55 150 55 154 28 154
					yourself:
				)
		)
		(switch gPrevRoomNum
			(110
				(HandsOff)
				(self setScript: fromBarScript)
			)
			(160
				(gEgo x: 300 y: 155 setHeading: 180)
			)
			(170
				(if (> (gEgo x:) 160)
					(self west: 170)
					(self east: 0)
				)
				(gEgo y: 157)
			)
			(200 0)
			(else
				(self style: 7)
				(HandsOn)
				(gTheIconBar enable:)
				(gEgo x: 140 y: 149 setHeading: 180)
			)
		)
		(gEgo init:)
		(super init:)
		(self setRegions: 700) ; sidewalk
		(door cycleSpeed: global101 init: approachVerbs: 3 stopUpd:) ; Do
		(if (< (LarryHours) 4)
			(leftySign cycleSpeed: (+ 3 global101) setCycle: Fwd init:)
			(hotelSign cycleSpeed: 30 setCycle: Fwd init:)
			(glass cycleSpeed: (+ 2 global101) setCycle: Fwd init:)
		)
		(taxiSign
			approachY: 159
			approachX: (gEgo x:)
			approachVerbs: 3 5 ; Do, Talk
			init:
		)
		(pole init:)
		(theWindow init:)
		(upperWindows init:)
		(building init:)
		(doormat init: approachVerbs: 3 4 10 11) ; Do, Inventory, Zipper, Taste/Smell
		(cans init: approachVerbs: 3 4 10 11) ; Do, Inventory, Zipper, Taste/Smell
		(if (IsFlag 15)
			(Load rsVIEW 101)
			(LoadMany rsSOUND 105 101)
			(= clapTimer 150)
		)
		(if (and (not (IsFlag 38)) (IsFlag 43))
			(Load rsVIEW 104)
			(Load rsSOUND 104)
			(aCop
				init:
				setCycle: Walk
				x: (if (== gPrevRoomNum 160) -20 else 340)
				setScript: sChaseEgo
			)
		)
		(self east: 170)
		(self west: 0)
	)

	(method (doit &tmp n)
		(taxiSign approachX: (gEgo x:))
		(if clapTimer
			(if (gCast contains: (ScriptID 700 2)) ; taxi
				(= clapTimer 1)
			)
			(if
				(and
					(== clapTimer 1)
					(!= (gCurRoom script:) sDieOfTheClap)
					(!= (gCurRoom script:) (ScriptID 813 1)) ; lRS
				)
				(HandsOff)
				(gCurRoom setScript: sDieOfTheClap)
			)
			(-- clapTimer)
		)
		(super doit:)
		(cond
			(script)
			((< (gEgo x:) 2)
				(HandsOff)
				(gCurRoom setScript: sWalkWest)
			)
			((< (gEgo y:) 135)
				(if (< (gEgo x:) 160)
					(= n 170)
				else
					(= n 160)
				)
				(if (not (IsFlag 15))
					(super newRoom: n)
				else
					(HandsOff)
					(gCurRoom setScript: sDieOfTheClap)
				)
			)
			(else 0)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 100 0) ; "You are outside Lefty's bar. Isn't it wonderful what can be done with a little neon?"
				(Print 100 1) ; "You notice a sign on that utility pole."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance sWalkWest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo -20 (gEgo y:) self)
			)
			(1
				(gCurRoom newRoom: 170)
				(self dispose:)
			)
		)
	)
)

(instance fromBarScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(door setCel: 255)
				(gEgo posn: 93 125 setMotion: MoveTo 92 148 self)
			)
			(1
				(soundFX number: 802 loop: 1 play:)
				(door setCycle: Beg self)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sEnterDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setPri: (+ (door priority:) 1))
				(soundFX number: 801 loop: 1 play:)
				(door setCycle: End self)
			)
			(1
				(gEgo setMotion: MoveTo 97 130 self)
			)
			(2
				(gEgo setPri: (- (door priority:) 1))
				(= cycles 3)
			)
			(3
				(soundFX number: 802 loop: 1 play:)
				(gEgo setMotion: 0)
				(door setCycle: Beg self)
			)
			(4
				(gCurRoom newRoom: 110)
			)
		)
	)
)

(instance sChaseEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(aCop setMotion: PolyPath (gEgo x:) (gEgo y:))
				(= cycles 5)
			)
			(1
				(cond
					((and (not register) (< (aCop distanceTo: gEgo) 160))
						(= register 1)
						(soundFX play:)
					)
					((and (== register 1) (< (aCop distanceTo: gEgo) 80))
						(= register 2)
						(Print 100 2 #at -1 20) ; ""STOP, PERVERT!!!" shouts the cop. "I wonder who he's yelling at," you think."
					)
				)
				(if (> (aCop distanceTo: gEgo) 50)
					(self init:)
				else
					(= cycles 1)
				)
			)
			(2
				(HandsOff)
				(aCop setMotion: 0)
				(Print 100 3 #at -1 20) ; "Caught you, pervert!" the cop shouts. "We don't like people exposing themselves around this town, especially wearing one of those!"
				(= seconds 3)
			)
			(3
				(Print 100 4 #at -1 20) ; "Glancing down, you realize what he is talking about. Your face flushes."
				(= seconds 3)
			)
			(4
				(Death 103 0 1)
				(Format @gYourPart 100 5) ; "What is that?!"
				(GameOver 100 6)
			)
		)
	)
)

(instance sDieOfTheClap of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Print 100 7 #at -1 20) ; "Suddenly, you have a warm feeling in the front of your pants."
				(if (or (== (gEgo view:) 800) (== (gEgo view:) 809))
					(gEgo egoSpeed: setHeading: 90 self)
				else
					(= cycles 1)
				)
			)
			(1
				(gEgo
					view: 101
					cycleSpeed: 6
					setLoop: 0
					setCel: 0
					setCycle: CT 2 1 self
				)
			)
			(2
				(gTheMusic3 number: 105 flags: 1 setLoop: 1 play: 127)
				(Print 100 8 #at -1 20) ; "It appears that the hooker gave you a little more than you bargained for!"
				(gEgo setCycle: End self)
			)
			(3
				(gTheMusic3 number: 101 setLoop: 1 play:)
				(gEgo setLoop: 1 setCel: 0)
				(= seconds 3)
			)
			(4
				(gEgo setCycle: End self)
			)
			(5
				(egoEyes
					init:
					x: (gEgo x:)
					y: (gEgo y:)
					setPri: (+ (gEgo priority:) 1)
					cycleSpeed: (* 2 global101)
					setCycle: Fwd
				)
				(= seconds 3)
			)
			(6
				(Death 101 3)
				(Format @gYourPart 100 9) ; "You're no Trojan, Larry!"
				(GameOver 100 10)
			)
		)
	)
)

(instance leftySign of Prop
	(properties
		x 111
		y 144
		z 95
		description {the neon sign}
		lookStr {You are outside Lefty's bar. Isn't it wonderful what can be done with a little neon?}
		view 100
		cel 1
		priority 14
		signal 24592
		detailLevel 3
	)
)

(instance hotelSign of Prop
	(properties
		x 283
		y 144
		z 144
		description {the neon sign}
		lookStr {The "L" in this place must be hot!}
		view 100
		loop 2
		priority 14
		signal 16400
		detailLevel 2
	)
)

(instance glass of Prop
	(properties
		x 180
		y 144
		z 106
		description {the neon sign}
		lookStr {This is the cleanest glass in Lefty's collection.}
		view 100
		loop 1
		cel 1
		priority 14
		signal 16400
		detailLevel 1
	)
)

(instance door of Prop
	(properties
		x 84
		y 120
		z -15
		description {Lefty's door}
		approachX 97
		approachY 135
		lookStr {Nice tuck and roll job, eh?}
		view 100
		loop 3
		signal 16384
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(cond
					((> 2 (LarryHours) 10)
						(Print 100 11) ; "You can't. The door is securely locked."
						(Print 100 12) ; "Lefty's closes at 3:00 a.m."
					)
					((aCop script:)
						(Print 100 13) ; "You won't be safe in there, Larry!"
					)
					(else
						(HandsOff)
						(gCurRoom setScript: sEnterDoor)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance egoEyes of Prop
	(properties
		z 33
		view 101
		loop 2
	)
)

(instance theWindow of Feature
	(properties
		x 211
		y 142
		z 57
		nsTop 67
		nsLeft 155
		nsBottom 103
		nsRight 268
		description {Lefty's window}
		sightAngle 40
		lookStr {Lefty's windows are too dirty to see through.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 100 14) ; "You rub your fingerprints into Lefty's window!"
				(Print 100 15 #at -1 140) ; "(You hope Lefty doesn't see you!)"
			)
			(4 ; Inventory
				(switch invItem
					(14 ; hammer
						(Print 100 16) ; "Nah. Lefty would probably break both your legs!"
					)
					(else
						(super doVerb: theVerb invItem)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance taxiSign of Feature
	(properties
		x 42
		y 152
		z 72
		nsTop 73
		nsLeft 36
		nsBottom 87
		nsRight 49
		description {the taxi sign}
		sightAngle 40
		lookStr {High up that telephone pole sits a lonely sign that reads, "Taxi Stand."}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 100 17) ; "You whistle loudly for a taxi."
				(HandsOff)
				(gCurRoom setScript: (ScriptID 700 3)) ; sTaxiScript
			)
			(5 ; Talk
				(Print 100 18) ; "You shout, "YO! TAXI!!""
				(HandsOff)
				(gCurRoom setScript: (ScriptID 700 3)) ; sTaxiScript
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance pole of Feature
	(properties
		x 38
		y 150
		nsLeft 31
		nsBottom 152
		nsRight 45
		description {the utility pole}
		sightAngle 40
		lookStr {It's tall and skinny; built like a pole!}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 100 19) ; "You wouldn't touch that pole with a 10-foot pole!"
			)
			(4 ; Inventory
				(switch invItem
					(16 ; ribbon
						(Print 100 20) ; "You COULD tie yourself to the pole, but what would that accomplish?"
					)
					(14 ; hammer
						(Print 100 21) ; ""Take that, you mean old pole," you shout!"
					)
					(else
						(super doVerb: theVerb invItem)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance upperWindows of Feature
	(properties
		x 158
		y 142
		z 126
		nsLeft 48
		nsBottom 33
		nsRight 268
		description {the windows}
		sightAngle 80
		lookStr {You cleverly notice that light shines from only one of the windows above Lefty's. Could there be someone up there?}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 100 22) ; "There's no way to climb up there from here."
			)
			(5 ; Talk
				(Print 100 23) ; "Hark, Juliet! What light from yonder window breaks? Be dat you up 'dere?"
				(Print 100 24 #at -1 140) ; "(You were always weak at memorization!)"
			)
			(4 ; Inventory
				(Print 100 25) ; "That's far too high for you to hurl anything, Larry!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance building of Feature
	(properties
		x 146
		y 92
		nsTop 42
		nsLeft 13
		nsBottom 142
		nsRight 280
		description {Lefty's bar}
		sightAngle 85
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (> 2 (LarryHours) 10)
					(Print 100 12) ; "Lefty's closes at 3:00 a.m."
				else
					(Print 100 26) ; "Considering the looks of this place, you decide that next time you'd be better off to spend a little more money on your computer games!"
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance aCop of Actor
	(properties
		y 155
		description {that cop}
		lookStr {He appears to be chasing someone!}
		view 104
		signal 16384
		xStep 6
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(5 ; Talk
				(Print 100 27) ; ""STOP, PERVERT!!!" shouts the cop. "I wonder who he's yelling at?" you think."
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance doormat of Feature
	(properties
		x 90
		y 139
		nsTop 134
		nsLeft 73
		nsBottom 144
		nsRight 108
		description {the doormat}
		sightAngle 40
		approachX 89
		approachY 142
		lookStr {"Welcome"}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 100 28) ; "Amazed by your own cleverness, you lift the door mat and discover..."
				(Print 100 29) ; "...absolutely nothing!"
				(Print 100 30 #at -1 140) ; "(What did you expect? A key?)"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance cans of Feature
	(properties
		x 307
		y 118
		nsTop 99
		nsLeft 295
		nsBottom 137
		nsRight 319
		description {the trash cans}
		sightAngle 40
		approachX 305
		approachY 140
		lookStr {Can can. }
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 100 31) ; "Now that you're here, you decide you don't really want to look inside."
			)
			(11 ; Taste/Smell
				(Print 100 32) ; "Lefty's wife, Linda, must have made her famous tuna casserole again!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance soundFX of Sound
	(properties
		flags 1
		number 104
	)
)

