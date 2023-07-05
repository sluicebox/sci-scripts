;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 670)
(include sci.sh)
(use Main)
(use KQ6Print)
(use KQ6Room)
(use n913)
(use GatePanel)
(use Conversation)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm670 0
)

(local
	local0
	[local1 26] = [12 15 22 5 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0]
	[local27 2]
)

(instance rm670 of KQ6Room
	(properties
		noun 4
		picture 670
		south 660
	)

	(method (init)
		(gGame handsOff:)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 224 76 319 76 319 189 95 189 44 165 27 143 64 118 105 113 162 91 168 86 184 86
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 181 81 163 81 102 108 71 109 45 115 26 127 8 146 10 172 30 189 0 189 0 0 319 0 319 72 215 72
					yourself:
				)
		)
		(super init:)
		(Lock rsMESSAGE 670 0)
		(gEgo init: reset: posn: 49 230 setScale: Scaler 90 80 250 50)
		(self setScript: enterRoomScript)
		(torch1 setCycle: Fwd ignoreActors: 1 init:)
		(torch2 setCycle: Fwd ignoreActors: 1 init:)
		(shimmer1 setCycle: Fwd ignoreActors: 1 init:)
		(shimmer2 setCycle: Fwd ignoreActors: 1 init:)
		(gate init: ignoreHorizon: 1 ignoreActors: 1)
		(path init:)
		(river init:)
	)

	(method (doVerb theVerb)
		(return
			(if (== theVerb 1) ; Look
				(if local0
					(gMessager say: noun theVerb 3) ; "Alexander is standing in front of Gate, the guardian of the Lord of the Dead's inner sanctum. On two sides of the path is the River Styx. Charon, the ferryman, is gone. Apparently, Gate is the only way to leave this area, but he doesn't seem very accommodating."
					1
				else
					(gMessager say: noun theVerb 4) ; "Alexander is standing on a path in front of a large gate. The path is surrounded by the chilly River Styx. Charon, the ferryman, is gone. Alexander has a feeling that he's close to his destination; that it must, in fact, lie on the other side of the gate."
					1
				)
			else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 660)
			(gGame handsOff:)
			(self setScript: dontGoAlex)
		else
			(super newRoom: newRoomNumber &rest)
		)
	)

	(method (doit &tmp temp0)
		(= temp0 (gEgo onControl: 1))
		(cond
			(script 0)
			((and (& temp0 $4000) (not local0))
				(gGame handsOff:)
				(self setScript: convertGate)
			)
		)
		(super doit: &rest)
	)

	(method (notify param1)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(DrawPic (gCurRoom picture:))
		(gEgo reset:)
		(gate view: 677)
		(shimmer1 view: 670 loop: 1)
		(shimmer2 view: 670 loop: 1)
		(torch1 view: 670)
		(torch2 view: 670)
		(gCast eachElementDo: #show)
		(if param1
			(script cue:)
		else
			(gGame handsOff:)
			(self setScript: killAlexScript)
		)
	)

	(method (dispose)
		(super dispose: &rest)
		(LoadMany 0 916)
	)
)

(instance torch1 of Prop
	(properties
		x 170
		y 57
		noun 7
		view 670
	)
)

(instance torch2 of Prop
	(properties
		x 250
		y 54
		noun 7
		view 670
		cel 1
		priority 10
		signal 16
	)
)

(instance shimmer1 of Prop
	(properties
		x 172
		y 176
		view 670
		loop 1
	)

	(method (doVerb theVerb)
		(river doVerb: theVerb &rest)
	)
)

(instance shimmer2 of Prop
	(properties
		x 252
		y 179
		view 670
		loop 1
	)

	(method (doVerb theVerb)
		(river doVerb: theVerb &rest)
	)
)

(instance path of Feature
	(properties
		noun 8
		onMeCheck 2
	)
)

(instance river of Feature
	(properties
		noun 3
		onMeCheck 4
	)

	(method (init)
		(gWalkHandler addToFront: self)
		(super init: &rest)
	)

	(method (dispose)
		(gWalkHandler delete: self)
		(super dispose: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Walk
				(gGame handsOff:)
				(gCurRoom setScript: walkInWater)
			)
			(44 ; teaCup
				(if (IsFlag 58)
					(gMessager say: noun theVerb 14) ; "Alexander already has enough River Styx water in that teacup."
				else
					(gMessager say: noun theVerb 15) ; "Alexander would love to get some River Styx water in that teacup, but there's no access to the water from this side of the River Styx."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance gate of Actor
	(properties
		x 216
		y 36
		noun 2
		approachX 172
		approachY 82
		view 672
		cycleSpeed 10
	)

	(method (doit)
		(if
			(and
				local0
				(not (gCurRoom script:))
				(< (gEgo distanceTo: self) 40)
			)
			(gGame handsOff:)
			(gCurRoom setScript: walkCloseToGate)
		)
		(super doit: &rest)
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 2) ; Talk
				(if local0
					(gGame handsOff:)
					(gate setScript: 0)
					(gCurRoom setScript: talkGate)
				else
					(gMessager say: noun theVerb 4) ; "The wooden gate does not look particularly conversational at the moment."
				)
			)
			((== theVerb 5) ; Do
				(if local0
					(gGame handsOff:)
					(gCurRoom setScript: handGateDead)
				else
					(gGame handsOff:)
					(gCurRoom setScript: handGate)
				)
			)
			((== theVerb 1) ; Look
				(if local0
					(gMessager say: noun theVerb 3) ; "Gate is a malicious-looking, wooden gate. It eyes Alexander hungrily."
				else
					(gMessager say: noun theVerb 4) ; "The large wooden gate at the end of the path is closed."
				)
			)
			((OneOf theVerb 48 35 28 16 13) ; gauntlet, skeletonKey, spellBook, scythe, mirror
				(if local0
					(gMessager say: noun theVerb 3 0)
				else
					(gMessager say: noun theVerb 4 0)
				)
			)
			(local0
				(gMessager say: noun 0 3) ; "I have this...."
			)
			(else
				(gMessager say: noun 0 4) ; "Alexander sees no reason to use that on the gate."
			)
		)
	)
)

(instance gateMorph of Sound
	(properties
		flags 1
	)
)

(instance enterRoomScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(gEgo setMotion: PolyPath (gEgo x:) 186 self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance convertGate of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlobalSound pause: 1)
				(gateMorph number: 670 loop: 1 play: self)
				(gate
					view: 675
					ignoreHorizon: 1
					setLoop: 0
					cel: 0
					posn: 210 48
					setCycle: End self
				)
			)
			(1 0)
			(2
				(gGlobalSound pause: 0)
				(= local0 1)
				(gate view: 677 setLoop: 0 cel: 0 setScript: randomMsg)
				(if (== client gCurRoom)
					(gGame handsOn:)
				)
				(self dispose:)
			)
		)
	)
)

(instance dontGoAlex of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 4 3 8 0 self) ; "Charon is gone. There is no way back across the River Styx."
			)
			(1
				(gEgo
					setMotion: MoveTo (gEgo x:) (- (gEgo y:) 10) self
				)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance talkGate of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if
					(>
						(GetDistance
							(gEgo x:)
							(gEgo y:)
							(gate x:)
							(gate y:)
						)
						50
					)
					(gEgo
						setMotion:
							PolyPath
							(gate approachX:)
							(gate approachY:)
							self
					)
				else
					(Face gEgo gate self)
				)
			)
			(1
				(theConv
					add: -1 2 2 3 1 ; "Despite his fear, Alexander summons his bravest voice to command the living gate."
					add: -1 2 2 3 2 ; "I would pass, Gate. I have business with your master."
					add: -1 2 2 3 3 ; "(GREEDY, LECHEROUS) My master and thine, human! I would be pleased to introduce thee! Only step forward and thou shalt meet him shortly."
					add: -1 2 2 3 4 ; "No, thank you! I come to meet the Lord of the Dead with my flesh still intact!"
					add: -1 2 2 3 5 ; "And why should I let you past, human, when I would much rather eat you?"
					add: -1 2 2 3 6 ; "I have been told that there is a way for humans to enter Death's realm. There must be something I can do; some task that will allow me to pass your doors, Gate."
					add: -1 2 2 3 7 ; "Hmmm. I seem to recall something.... A trick, perhaps...a test. Hmmm. Ah, yesss.... 'Should a human try to pass, a riddle is Gate's wont to ask.'"
					add: -1 2 2 3 8 ; "(TRYING TO BE BRAVE)<ahem> A riddle it is then."
					add: -1 2 2 3 9 ; "And if thou wouldst fail to answer Gate, his thirsty jaws will be thy fate?"
					add: -1 2 2 3 10 ; "Agreed."
					add: -1 2 2 3 11 ; "Listen as though it meant thy life then, human, for it surely does:"
					add: -1 2 2 3 12 ; "My first is foremost legally. My second circles outwardly. My third leads all in victory. My fourth twice ends a nominee. My whole is this gate's only key."
					init: self
				)
			)
			(2
				(User canInput: 1 canControl: 1)
				(gCast eachElementDo: #hide)
				(SetFlag 49)
				(DrawPic 98)
				(= cycles 2)
			)
			(3
				(docoProtect init: @local1 4 26)
			)
			(4
				(gGame givePoints: 3)
				(gGame setCursor: gWaitCursor)
				(= cycles 2)
			)
			(5
				(ClearFlag 49)
				(gMessager say: 1 5 1 0 self) ; "The answer is 'Love.'"
			)
			(6
				(gGlobalSound pause: 1)
				(gateMorph number: 671 loop: 1 play: self)
				(gate view: 675 setLoop: 0)
				(gate cel: (gate lastCel:) setCycle: Beg self)
			)
			(7 0)
			(8
				(gate view: 672 setLoop: 0 cel: 0 posn: 216 36)
				(= cycles 5)
			)
			(9
				(gate
					view: 672
					setCel: 0
					setLoop: 1
					posn: 216 36
					ignoreActors: 1
					setPri: 5
					setCycle: End self
				)
				(gateMorph number: 342 loop: 1 play: self)
			)
			(10 0)
			(11
				(gGlobalSound pause: 0)
				(= local0 0)
				(gEgo
					ignoreHorizon: 1
					setPri: (+ (gate priority:) 1)
					setMotion: PolyPath 217 74 self
				)
			)
			(12
				(gEgo
					setPri: (- (gate priority:) 1)
					setMotion: PolyPath 248 74 self
				)
			)
			(13
				(gTheIconBar enable:)
				(gCurRoom newRoom: 680)
			)
		)
	)
)

(instance killAlexScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame setCursor: gWaitCursor)
				(= cycles 2)
			)
			(1
				(gate setScript: 0)
				(gMessager say: 1 5 2 1 self) ; "I...I don't know the answer."
			)
			(2
				(gMessager say: 1 5 2 2 self) ; "Ah, don't sound so disappointed! I will make it quick...perhaps."
			)
			(3
				(gEgo setMotion: PolyPath 182 81 self)
			)
			(4
				(gEgo
					normal: 0
					view: 673
					setLoop: 0
					cel: 0
					cycleSpeed: 5
					setScale: 0
					posn: (+ (gate x:) 3) (+ (gate y:) 20)
					setCycle: CT 6 1 self
				)
			)
			(5
				(gEgo setCycle: End self)
				(eatSound play:)
			)
			(6
				(gEgo dispose:)
				(= cycles 30)
			)
			(7
				(gMessager say: 1 5 2 3 self) ; "YUM!"
			)
			(8
				(EgoDead 17) ; "Riddle, fiddle, what to do? Somewhere sticky, there's a clue!"
			)
		)
	)
)

(instance eatSound of Sound
	(properties
		number 672
	)
)

(instance handGateDead of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gate setScript: 0)
				(gMessager say: 2 5 3 1 self) ; "Alexander decides to try to force the gate open."
			)
			(1
				(gEgo setMotion: PolyPath 182 81 self)
			)
			(2
				(gMessager say: 2 5 3 2 self) ; "That's very good, human! Come to me!"
			)
			(3
				(gEgo
					normal: 0
					view: 673
					setLoop: 0
					cel: 0
					cycleSpeed: 5
					setScale: 0
					posn: (+ (gate x:) 3) (+ (gate y:) 20)
					setScale: 0
					setCycle: CT 6 1 self
				)
			)
			(4
				(gEgo setCycle: End self)
				(eatSound play:)
			)
			(5
				(gEgo dispose:)
				(= cycles 30)
			)
			(6
				(gMessager say: 2 5 3 3 self) ; "Mmmm! Tasty!"
			)
			(7
				(= cycles 2)
			)
			(8
				(EgoDead 16) ; "It must have been love at first bite!"
			)
		)
	)
)

(instance handGate of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 184 82 self)
			)
			(1
				(gEgo
					normal: 0
					view: 673
					setLoop: 1
					cel: 0
					posn: 178 82
					setScale: 0
					setCycle: End self
				)
			)
			(2
				(gMessager say: 2 5 4 1 self) ; "Alexander reaches out to open the gate."
			)
			(3
				(gMessager say: 2 5 4 2 self) ; "Suddenly, the wood trembles beneath his fingertips!"
			)
			(4
				(gEgo reset: 6 setScale: Scaler 90 80 250 50)
				(self setScript: convertGate self)
			)
			(5
				(gMessager say: 2 5 4 3 self) ; "What touch has awakened my sleep?"
			)
			(6
				(gMessager say: 2 5 4 4 self) ; "I smell the blood of a mortal! Reach out thine hand again, fleshy human, that I might devour it! It has been centuries since I last ate!"
			)
			(7
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance randomMsg of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= seconds 30)
			)
			(1
				(switch (= temp0 (Random 1 3))
					(1
						(gMessager say: 6 0 10 0 self) ; "Don't be shy, mortal. I shall make thy death quick!"
					)
					(2
						(gMessager say: 6 0 11 0 self) ; "If thou wouldst see Death, I can accommodate thee. Only step into my jaws and Death thou shalt meet!"
					)
					(3
						(gMessager say: 6 0 12 0 self) ; "Come forward and let me taste thee, human!"
					)
				)
			)
			(2
				(self init:)
			)
		)
	)
)

(instance walkCloseToGate of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gate setScript: 0)
				(= local0 0)
				(gMessager say: 4 3 13 1 self) ; "Alexander walks too close to the menacing Gate!"
			)
			(1
				(gMessager say: 4 3 13 2 self) ; "That's it, human! Come close to me!"
			)
			(2
				(gEgo
					normal: 0
					view: 673
					setLoop: 0
					cel: 0
					cycleSpeed: 5
					posn: (+ (gate x:) 3) (+ (gate y:) 20)
					setCycle: CT 6 1 self
				)
			)
			(3
				(gEgo setCycle: End self)
				(eatSound play:)
			)
			(4
				(gEgo dispose:)
				(= cycles 30)
			)
			(5
				(gMessager say: 4 3 13 3 self) ; "Mmmm! Tasty!"
			)
			(6
				(= cycles 2)
			)
			(7
				(EgoDead 16) ; "It must have been love at first bite!"
			)
		)
	)
)

(instance splashSound of Sound
	(properties
		number 923
	)
)

(instance walkInWater of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gate setScript: 0)
				(gEgo setMotion: PolyPath 138 103 self)
			)
			(1
				(Load rsVIEW 674)
				(= cycles 2)
			)
			(2
				(gGlobalSound number: 653 loop: 1 play:)
				(gEgo
					normal: 0
					view: 674
					setLoop: 0
					cel: 0
					cycleSpeed: 3
					setCycle: CT 8 1 self
				)
			)
			(3
				(splashSound play:)
				(gEgo setCycle: End self)
			)
			(4
				(gEgo dispose:)
				(= cycles 2)
			)
			(5
				(if local0
					(gMessager say: 3 3 3 1 self) ; "Unable to think of any other way around the fierce Gate, Alexander decides to brave the River Styx."
				else
					(gMessager say: 3 3 4 1 self) ; "Alexander falls from the path into the River Styx."
				)
			)
			(6
				(if local0
					(gMessager say: 3 3 3 2 self) ; "You may cheat me of your flesh, human, but you can't cheat Death of your soul!"
				else
					(gMessager say: 3 3 4 2 self) ; "The black water of the River Styx numbs Alexander to the bone. He sinks like a rock!"
					(= cycles 1)
				)
			)
			(7
				(if local0
					(gMessager say: 3 3 3 3 self) ; "The black water of the River Styx numbs Alexander to the bone. He sinks like a rock!"
				else
					(= cycles 1)
				)
			)
			(8
				(EgoDead 31) ; "Hey, hey, what a fix! Bathin' in the River Styx!"
			)
		)
	)
)

(instance docoProtect of GatePanel
	(properties
		x 84
		y 17
		noun 1
		view 678
		offsetX 30
		offsetY 20
		maxCol 5
		maxRow 5
		numButtons 30
	)

	(method (init)
		(gate setScript: 0)
		(gEgo view: 2002)
		(gate view: 2002)
		(torch1 view: 2002)
		(torch2 view: 2002)
		(shimmer1 view: 2002)
		(shimmer2 view: 2002)
		(KQ6Print
			modeless: 1
			width: 290
			posn: 10 146
			say: 1 0 0 0 1 0 0 671 ; "My first is foremost legally. My second circles outwardly. My third leads all in victory. My fourth twice ends a nominee. My whole is this gate's only key."
			init:
		)
		(super init: &rest)
	)

	(method (drawButton &tmp temp0)
		(= temp0 0)
		(if (not (OneOf value 26 27 29 30))
			(if (not (& [local27 (/ value 16)] (>> $8000 (mod value 16))))
				(= [local27 (/ value 16)]
					(| [local27 (/ value 16)] (>> $8000 (mod value 16)))
				)
				(= temp0 (super drawButton: &rest))
				(gGlobalSound3 number: 910 setLoop: 1 play:)
			else
				(= temp0 0)
			)
		)
		(return temp0)
	)
)

(instance theConv of Conversation
	(properties)
)

