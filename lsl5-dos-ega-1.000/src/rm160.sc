;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 160)
(include sci.sh)
(use Main)
(use eRS)
(use Door)
(use PolyPath)
(use Polygon)
(use Feature)
(use Timer)
(use Sound)
(use Motion)
(use Inventory)
(use Actor)
(use System)

(public
	rm160 0
)

(local
	oldDoVerbCode
	usedEyeball
	usedHand
	lookedAtPot
	belched
)

(instance rm160 of LLRoom
	(properties
		lookStr {Once PornProdCorp was heavily involved in X-rated movies, but since their recent I.P.O. and entry into soft-R television, they've totally changed their image. Now they are struggling their way into respectability.}
		picture 160
		north 180
		east 190
		west 170
	)

	(method (init)
		(self setRegions: 40) ; HollywoodRgn
		(gEgo init: normalize: illegalBits: -32760)
		(switch gPrevRoomNum
			(140
				(HandsOn)
				(gTheMusic number: 160 setLoop: -1 play:)
				(= style 7)
				(gEgo posn: 138 121 setHeading: 180 edgeHit: 0)
				(gTheIconBar disable: 8)
			)
			(155 ; passwordTest
				(SetFlag 7)
				(= gRestartRoom 160)
				(SetFFRoom 0)
				(gEgo get: 0) ; Camcorder
				(= gScore 2)
				(if (IsFlag 80)
					(+= gScore 1)
				)
				(if (IsFlag 81)
					(+= gScore 1)
				)
				(gTheMusic number: 160 setLoop: -1 play:)
				(HandsOn)
			)
			(west
				(self setScript: sFromWest)
			)
			(north
				(HandsOn)
				(gEgo posn: 260 77 setHeading: 180 edgeHit: 0 illegalBits: 0)
			)
			(east
				(gEgo y: 160)
			)
			(else
				(if (!= gPrevRoomNum 150)
					(SetFlag 7)
					(= gScore 2)
					(if (IsFlag 80)
						(+= gScore 1)
					)
					(if (IsFlag 81)
						(+= gScore 1)
					)
					(gEgo get: 0) ; Camcorder
				)
				(gEgo
					posn: (presDoor approachX:) (presDoor approachY:)
					edgeHit: 0
				)
				(gTheMusic number: 160 setLoop: -1 play:)
				(HandsOn)
			)
		)
		(super init:)
		(fileDoor init: approachVerbs: 3) ; Do
		(presDoor init:)
		(if (not (IsFlag 7))
			(coffee init: approachVerbs: 3 setScript: sCoffee) ; Do
		)
		(coffeeMaker init:)
		(leftDoor init: approachVerbs: 3) ; Do
		(bigSign init:)
		(portrait init: approachVerbs: 3 2) ; Do, Look
		(poster init: approachVerbs: 3 2) ; Do, Look
		(pictures init: approachVerbs: 3 2) ; Do, Look
		(onePicture init: approachVerbs: 3 2) ; Do, Look
		(certificate init: approachVerbs: 3 2) ; Do, Look
		(plant init: approachVerbs: 3) ; Do
		(smallPlant init: approachVerbs: 3) ; Do
		(largePlant init: approachVerbs: 3) ; Do
		(bronzeAward init: approachVerbs: 3 2) ; Do, Look
		(waterCooler init: approachVerbs: 3) ; Do
		(chair init:)
		(desk init: approachVerbs: 3) ; Do
		(cabinetDoors init: approachVerbs: 3 2) ; Do, Look
		(outlet init: approachVerbs: 3 4) ; Do, Inventory
		(hallway init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 319 79 296 79 286 71 273 71 273 44 250 44 250 71 233 71 219 86 143 86 137 74 118 74 104 59 0 59
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 73 79 73 99 76 98 92 66 108 58 113 12 113 11 119 60 119 48 131 22 135 2 148 2 187 185 187 190 181 216 181 220 187 314 187 319 157 319 189 0 189
					yourself:
				)
		)
		(if (not (IsFlag 7))
			(helpTimer set: helpTimer 45)
		)
		(= oldDoVerbCode gDoVerbCode)
		(= gDoVerbCode doVerb160Code)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 190)
			(gTheMusic fade: 80 25 10 0)
		)
		(super newRoom: newRoomNumber)
	)

	(method (dispose)
		(helpTimer dispose: delete:)
		(coffeeTimer dispose: delete:)
		(= gDoVerbCode oldDoVerbCode)
		(super dispose:)
	)

	(method (doit)
		(super doit:)
		(cond
			(script)
			((StepOn gEgo 2)
				(if (not (IsFlag 7))
					(self setScript: sMoveOffControl 0 10)
				else
					(self newRoom: west)
				)
			)
			((and (StepOn gEgo 4) (not (IsFlag 7)))
				(self setScript: sMoveOffControl 0 -10)
			)
			(
				(and
					(not belched)
					(== (gEgo loop:) 3)
					(< 30 (gEgo distanceTo: waterCooler) 40)
				)
				(self setScript: sBelch)
			)
			((and belched (> (gEgo distanceTo: waterCooler) 60))
				(= belched 0)
			)
		)
	)
)

(instance sMoveOffControl of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setMotion:
						MoveTo
						(+ (gEgo x:) register)
						(gEgo y:)
						self
				)
			)
			(1
				(TPrint 160 0) ; "Don't leave now, when they're crying for coffee in there!"
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sCoffee of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(coffeeTimer cycleCnt: 0)
				(coffeeYell
					init:
					setCel: 0
					posn: (coffeeYell x:) (Random 53 104)
					cycleSpeed: (Random 5 10)
					setCycle: End self
				)
			)
			(1
				(coffeeSound setLoop: 0 play:)
				(coffeeYell setCycle: CT 3 -1 self)
			)
			(2
				(coffeeYell setCycle: End)
				(= ticks (Random 30 90))
			)
			(3
				(coffeeYell dispose:)
				(coffeeTimer setReal: coffeeTimer (Random 6 12))
				(self dispose:)
			)
		)
	)
)

(instance sFromWest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo posn: 65 70 setMotion: MoveTo 95 70 self)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sBelch of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(waterSound setLoop: 0 play:)
				(waterCooler setLoop: 4 setCycle: End self)
			)
			(1
				(waterCooler setLoop: 3 setCel: 0)
				(gEgo
					view: 160
					loop: 5
					cel: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(2
				(Say gEgo 160 1 67 -1 185) ; ""Excuse me!" you say, assuming responsibility!"
				(gEgo setLoop: 3 normalize: illegalBits: -32760)
				(HandsOn)
				(= belched 1)
				(self dispose:)
			)
		)
	)
)

(instance sDeliver of Script
	(properties)

	(method (changeState newState &tmp theX theY)
		(switch (= state newState)
			(0
				(HandsOff)
				(coffeeTimer dispose: delete:)
				(helpTimer dispose: delete:)
				(gEgo view: 141 setLoop: 0 setCycle: CT 1 1 self)
			)
			(1
				(coffee dispose:)
				(gEgo setCycle: End self)
			)
			(2
				(coffee dispose:)
				(if (gCast contains: coffeeYell)
					(coffeeYell dispose:)
				)
				(Points 1 82)
				(TPrint 160 2) ; "You grab the pot from the warmer and head for Mr. Scruemall's office--eager to once again kiss up to the boss!"
				(= theX (presDoor approachX:))
				(= theY (presDoor approachY:))
				(gEgo
					normalize: 141
					setLoop: 1
					setCycle: Walk
					setMotion: PolyPath theX theY self
				)
			)
			(3
				(presDoor entranceTo: 140 doVerb: 3)
			)
		)
	)
)

(instance fileDoor of Door
	(properties
		x 245
		y 67
		description {the file room door}
		approachX 264
		approachY 76
		view 160
		loop 2
		entranceTo 180
		moveToX 264
		moveToY 61
		enterType 0
		exitType 0
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 160 3) ; "This door leads to the filing room where PPC stores its voluminous correspondence. Some of your favorite moments have been spent at this exact location, watching secretaries fill those lower drawers."
				(= usedEyeball 1)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)

	(method (open)
		(if (not (IsFlag 7))
			(TPrint 160 0) ; "Don't leave now, when they're crying for coffee in there!"
			(= usedHand 1)
		else
			(gEgo illegalBits: 0)
			(super open: &rest)
		)
	)

	(method (close)
		(gEgo illegalBits: -32760)
		(super close:)
	)
)

(instance presDoor of Door
	(properties
		x 47
		y 110
		heading 90
		description {Silas Scruemall's office door}
		approachX 60
		approachY 116
		view 160
		loop 1
		entranceTo 155
		moveToX 27
		moveToY 115
		enterType 1
		exitType 0
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(if (IsFlag 7)
					(TPrint 160 4) ; "Remembering your boss' "open door" policy, you decide to just follow your orders. Besides, that's what you do best!"
				else
					(super doVerb: theVerb invItem &rest)
				)
				(= usedHand 1)
			)
			(2 ; Look
				(TPrint 160 5) ; "This is the entrance to the office of Silas Scruemall, your boss. Mr. S is famous for his "open door" policy: open his door and you're fired!"
				(TPrint 160 6) ; "A tasteful, wood-grained brass plate on his door reads, "President, C. E. O., C. F. O., C. T. O., C. O. O., Chairman of the Board, Executive Producer""
				(= usedEyeball 1)
			)
			(5 ; Talk
				(Say gEgo 160 7) ; "Hey, Scruemall!" you whisper softly, "I'm not afraid of you!"
				(TPrint 160 8 67 -1 185) ; "("Only your power," you think.)"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)

	(method (open)
		(if (and (gCast contains: coffee) (not (IsFlag 7)))
			(coffee setScript: sCoffee)
		else
			(super open: &rest)
		)
	)
)

(instance coffee of Prop
	(properties
		x 73
		y 75
		description {the coffee pot}
		approachX 98
		approachY 97
		view 160
		priority 6
		signal 16400
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 160 9) ; "You notice a fresh pot of "Discount Coffee Warehouse's" finest Kona-like blend waiting on the warmer. You wonder if anyone nearby would like a cup."
				(= lookedAtPot 1)
				(= usedEyeball 1)
			)
			(3 ; Do
				(gCurRoom setScript: sDeliver)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance coffeeYell of Prop
	(properties
		x 32
		y 81
		description {the sound of coffee drinkers}
		lookStr {It looks like someone wants some coffee!}
		view 162
		priority 14
		signal 16400
	)
)

(instance coffeeSound of Sound
	(properties
		number 161
	)
)

(instance waterCooler of Prop
	(properties
		x 204
		y 182
		description {the water cooler}
		approachX 201
		approachY 179
		lookStr {The water cooler is the office equipment with which you're most familiar.}
		view 160
		loop 3
		priority 15
		signal 16400
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(waterSound play:)
				(self setCycle: End self)
				(= usedHand 1)
				(TPrint 160 10) ; "You get a refreshing drink of bottled tap water."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)

	(method (cue)
		(waterCooler setCel: 0)
		(Points 1 80)
	)
)

(instance waterSound of Sound
	(properties
		number 163
	)
)

(instance helpTimer of Timer
	(properties)

	(method (cue)
		(cond
			((not usedEyeball)
				(TPrint 160 11) ; "Here are some suggestions if this is the first time you've played a Sierra adventure with the "no-typing" interface."
				(TPrint 160 12) ; "When windows like this one appear, press ENTER or click your mouse to clear them away immediately. Or, you can just wait and they'll clear automatically. Use the control panel to adjust the Text Speed to your reading speed."
				(TPrint 160 13) ; "When there is no text here, you can press ESC or move your mouse to the very top of your screen. The "Icon Bar" will appear. Click on the Question Mark, then move your cursor across the other icons. They'll each tell you what they do."
				(TPrint 160 14) ; "Click on those icons to change your game cursor. For example, choose the Eyeball icon and click it on various things around this room to "Look" at them."
				(self set: self 45)
			)
			((and (== 95 (gEgo x:)) (== 65 (gEgo y:)))
				(TPrint 160 15) ; "Choose the Walking Man icon from the icon bar and click its feet where you would like to "Walk.""
				(TPrint 160 16) ; "Your feet will stop as close as possible to where you clicked."
				(self set: self 45)
			)
			((not usedHand)
				(TPrint 160 17) ; "Choose the Hand icon from the icon bar and click its index finger where you would like to do some "Action.""
				(self set: self 45)
			)
			((not lookedAtPot)
				(TPrint 160 18) ; "This would be a good time to select the Eyeball "Look" icon from the icon bar and click it on the coffee pot in the upper left corner of this room."
				(self set: self 45)
			)
			(else
				(TPrint 160 19) ; "Select the Hand "Action" icon and click it on the coffee pot to use the coffee."
				(TPrint 160 20) ; "If you haven't already, now would be a good time to read the documentation that came with this game."
			)
		)
	)
)

(instance coffeeTimer of Timer
	(properties)

	(method (cue)
		(coffee setScript: sCoffee)
	)
)

(instance coffeeMaker of Feature
	(properties
		x 72
		y 69
		nsTop 61
		nsLeft 62
		nsBottom 78
		nsRight 82
		description {the coffee maker}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (gCast contains: coffee)
					(TPrint 160 21) ; "The coffee maker has just finished brewing a fresh batch of Kahuii Koala Mocha-Homo Blend."
				else
					(TPrint 160 22) ; "There's no pot here. Remember? You broke it!"
				)
			)
			(3 ; Do
				(if (gCast contains: coffee)
					(TPrint 160 23) ; "You'd love to brew a fresh pot, but there's already a whole pot of coffee on the warmer."
				else
					(TPrint 160 24) ; "You'd love to brew a fresh pot, but there's no pot left to brew in!"
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance leftDoor of Feature
	(properties
		x 22
		y 87
		nsTop 51
		nsLeft 12
		nsBottom 123
		nsRight 32
		description {Silas Scruemall's office door}
		sightAngle 40
		approachX 60
		approachY 116
	)

	(method (doVerb)
		(presDoor doVerb: &rest)
	)
)

(instance bigSign of Feature
	(properties
		x 176
		y 26
		nsLeft 153
		nsBottom 52
		nsRight 199
		description {the "America's Sexiest Home Videos" sign}
		sightAngle 40
		lookStr {Evidently this company is the home of "America's Sexiest Home Videos." You've heard of that show! Especially since you work here!}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(TPrint 160 25) ; "Yes, of course you think the sign is lovely, but you really have no use for a big, ugly sign."
				(= usedHand 1)
			)
			(5 ; Talk
				(TPrint 160 26) ; "If that thing talks back, you vow to leave the building immediately!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance portrait of Feature
	(properties
		x 62
		y 40
		nsTop 24
		nsLeft 53
		nsBottom 57
		nsRight 71
		description {the portrait of Silas Scruemall}
		sightAngle 40
		approachX 94
		approachY 95
		lookStr {"Our founder, Silas Scruemall!"}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(TPrint 160 27) ; "Thinking yourself incredibly smart, you attempt to remove the painting from the wall in order to crack the safe which you feel certain lies behind it."
				(TPrint 160 28) ; "You fail."
				(TPrint 160 29 67 -1 185) ; "(But not because you can't crack a good one!)"
				(= usedHand 1)
			)
			(5 ; Talk
				(TPrint 160 30) ; "Try talking to people instead."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance poster of Feature
	(properties
		x 93
		y 27
		nsTop 11
		nsLeft 83
		nsBottom 43
		nsRight 103
		description {the poster}
		sightAngle 40
		lookStr {Art is one thing, but this is something else!}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(TPrint 160 31) ; "Take your hand off her!"
				(TPrint 160 32 67 -1 185) ; "(You're smudging that fine cardboard surface!)"
				(= usedHand 1)
			)
			(5 ; Talk
				(TPrint 160 33) ; "You really ARE lonely, aren't you, Larry?"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance pictures of Feature
	(properties
		x 128
		y 29
		nsTop 11
		nsLeft 111
		nsBottom 48
		nsRight 146
		description {the photographs}
		sightAngle 40
		approachX 122
		approachY 75
		lookStr {The pictures are of past stars of PornProdCorp's many films, television shows and artsy documentaries. There are a total of zero pictures of Chief Video Tape Rewinders like you. You have no reason to assume you'll be the first!}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(TPrint 160 34) ; "You really enjoy playing with your hands, eh, Larry?"
				(= usedHand 1)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance onePicture of Feature
	(properties
		x 220
		y 22
		nsTop 11
		nsLeft 213
		nsBottom 33
		nsRight 228
		description {the hydrant photograph}
		sightAngle 40
		approachX 231
		approachY 78
		lookStr {It's either the star of "Manhunter," or a fire hydrant, you're not sure which.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(TPrint 160 35) ; "You have so much fun feeling things!"
				(= usedHand 1)
			)
			(5 ; Talk
				(TPrint 160 36) ; "You attempt to throw your voice into the picture. You fail."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance certificate of Feature
	(properties
		x 295
		y 24
		nsTop 15
		nsLeft 295
		nsBottom 29
		nsRight 309
		description {the certificate}
		sightAngle 40
		approachX 288
		approachY 76
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 160 37 30 1) ; ""Class B Establishment" granted by the Board of Health. (Contested by the Board of Good Taste!)"
			)
			(3 ; Do
				(TPrint 160 38) ; "This is in keeping with your opinion of this place."
				(= usedHand 1)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance plant of Feature
	(properties
		x 305
		y 45
		nsTop 31
		nsLeft 292
		nsBottom 60
		nsRight 319
		description {the plant}
		sightAngle 40
		approachX 291
		approachY 75
		lookStr {You really enjoy the look of fine plastic.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(TPrint 160 39) ; "Ouch! Those plastic leaves are sharp!"
				(= usedHand 1)
			)
			(5 ; Talk
				(TPrint 160 40) ; "Does talking to plastic plants help them grow?"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance smallPlant of Feature
	(properties
		x 13
		y 188
		nsTop 139
		nsBottom 183
		nsRight 26
		description {the plant}
		sightAngle 40
		approachX 16
		approachY 187
		lookStr {You really enjoy the look of fine plastic.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(TPrint 160 41) ; "Ouch! Pricked again!"
				(= usedHand 1)
			)
			(5 ; Talk
				(TPrint 160 40) ; "Does talking to plastic plants help them grow?"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance largePlant of Feature
	(properties
		x 245
		y 180
		nsTop 112
		nsLeft 224
		nsBottom 182
		nsRight 266
		description {the plant}
		sightAngle 40
		approachX 260
		approachY 179
		lookStr {How you love plastic plants! (Especially the smell!)}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(TPrint 160 42) ; ""SPROING!" says the leaf."
				(= usedHand 1)
			)
			(5 ; Talk
				(TPrint 160 40) ; "Does talking to plastic plants help them grow?"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance bronzeAward of Feature
	(properties
		x 283
		y 188
		nsTop 173
		nsLeft 280
		nsBottom 189
		nsRight 313
		description {the "Titty" award}
		sightAngle 40
		approachX 283
		approachY 185
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 160 43 30 1 80 {Genuine Engraved Plastic}) ; "Presented to PornProdCorp for their humanitarian efforts in the field of free speech and the commercial development of the steel-reinforced videotape.  March 10, 1976"
				(Points 1 81)
				(TPrint 160 44 67 -1 185) ; "(Wow! It's a genuine "Titty!")"
				(= usedEyeball 1)
			)
			(3 ; Do
				(TPrint 160 45) ; "Is this the best thing you've found to do with your hand cursor?"
				(= usedHand 1)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance chair of Feature
	(properties
		x 117
		y 173
		nsTop 164
		nsLeft 106
		nsBottom 183
		nsRight 129
		description {the chair}
		sightAngle 40
		lookStr {This chair and desk belong to the person least in favor with your boss, Silas Scruemall. Currently, they are unoccupied. Often, you sit here.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(TPrint 160 46) ; "You're afraid to sit down here since your boss may come out of his office at any moment. Shouldn't you continue with your mission?"
				(= usedHand 1)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance desk of Feature
	(properties
		x 132
		y 186
		nsTop 184
		nsLeft 85
		nsBottom 189
		nsRight 179
		description {the desk}
		sightAngle 40
		approachX 151
		approachY 188
		lookStr {This chair and desk belong to the person least in favor with your boss, Silas Scruemall. Currently, they are unoccupied. Often, you sit here.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(TPrint 160 47) ; "Rubbing your hand across the desk makes you appreciate its fine vinyl woodgrain surface."
				(= usedHand 1)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance cabinetDoors of Feature
	(properties
		x 78
		y 92
		nsTop 86
		nsLeft 70
		nsBottom 99
		nsRight 87
		description {the cabinet}
		sightAngle 40
		lookStr {The only thing in the cabinet under the coffee pot is a box of thoughtfully premeasured, preweakened coffee portions, and some empty plastic bags that used to hold stacks of Styrofoam coffee cups. You have no need for either coffee or filters.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(TPrint 160 48) ; "You have no need for coffee or filters."
				(= usedHand 1)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance outlet of Feature
	(properties
		x 51
		y 97
		nsTop 88
		nsLeft 48
		nsBottom 101
		nsRight 55
		description {the electrical outlet}
		sightAngle 40
		approachX 77
		approachY 105
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (== ((Inv at: 1) owner:) gCurRoom) ; Battery_Charger
					(TPrint 160 49) ; "The coffee pot is plugged into the upper electrical outlet, and your battery charger is "currently" occupying the lower outlet."
				else
					(TPrint 160 50) ; "The coffee pot is plugged into the upper electrical outlet, but the lower one is "currently" available."
				)
				(= usedEyeball 1)
			)
			(3 ; Do
				(if (not (== ((Inv at: 1) owner:) gCurRoom)) ; Battery_Charger
					(gCurRoom setScript: (ScriptID 22 2) 0 1) ; sGetShocked
				else
					((ScriptID 22 3) doVerb: 3) ; charger
				)
				(= usedHand 1)
			)
			(4 ; Inventory
				(switch invItem
					(1 ; Battery_Charger
						(TPrint 160 51) ; "Good idea! You can never tell when a guy might need his pocket protector fully charged!"
						(gCurRoom setScript: (ScriptID 22 0)) ; sPlugCharger
					)
					(0 ; Camcorder
						(TPrint 160 52) ; "The camcorder can't be plugged into an outlet. You must use its recharger base."
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

(instance hallway of Feature
	(properties
		x 99
		y 64
		nsTop 57
		nsLeft 77
		nsBottom 71
		nsRight 122
		description {the hallway}
		sightAngle 40
		lookStr {This hallway leads to the Department of Video Tape Rewinding and your workroom, where you fulfill your job as Chief Rewinder and Sterilizer (Betamax Division).}
	)
)

(instance doVerb160Code of Code
	(properties)

	(method (doit theVerb theObj &tmp objDesc theItem [str 100])
		(= objDesc (theObj description:))
		(switch theVerb
			(2
				(if (theObj facingMe: gEgo)
					(if (theObj lookStr:)
						(TPrint (theObj lookStr:))
					else
						(NoResponse theObj theVerb)
					)
				)
				(= usedEyeball 1)
			)
			(5
				(if (theObj facingMe: gEgo)
					(Format @str 160 53 objDesc) ; "You engage in a short, but personally meaningful, conversation with %s."
					(TPrint @str)
				)
			)
			(3
				(Format @str 160 54 objDesc) ; "That feels exactly like %s."
				(TPrint @str)
				(= usedHand 1)
			)
			(4
				(= theItem ((gTheIconBar curInvIcon:) description:))
				(Format @str 160 55 theItem objDesc) ; "It seems %s just doesn't work with %s."
				(TPrint @str)
			)
			(10
				(Format @str 160 56 objDesc) ; "Don't do that to %s!"
				(TPrint @str)
			)
			(else
				(NoResponse theObj theVerb)
			)
		)
	)
)

