;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 740)
(include sci.sh)
(use Main)
(use Teller)
(use n026)
(use JumpX)
(use Scaler)
(use MCyc)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Sound)
(use Jump)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm740 0
)

(local
	[local0 21] = [4 0 151 41 4 1 150 41 4 2 150 56 4 3 150 66 4 4 150 79 -32768]
	[local21 10]
	[local31 10]
	local41
	local42
	local43
	local44
	local45
	local46
	local47
	local48
	local49
	[local50 9] = [0 1 -4 -10 -7 -6 -2 8 999]
	[local59 2]
	[local61 5] = [0 15 2 16 999]
	[local66 2]
)

(instance rm740 of Rm
	(properties
		noun 13
		picture 740
	)

	(method (notify param1)
		(if (and (== param1 -15) local47)
			(Graph grDRAW_LINE 36 124 36 283 0 -1 -1)
			(Graph grUPDATE_BOX 35 123 37 284 1)
		)
	)

	(method (init)
		(HandsOff)
		(gTheIconBar disable:)
		(= [local59 0] @local50)
		(= [local66 0] @local61)
		(gWalkHandler addToFront: target)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 67 50 71 101 93 139 91 167 72 146 72 138 82 116 81 103 66 112 54 132 48 132 42 108 42 106 51 86 65 69 61 0 60 0 0 319 0 319 62 296 70 239 67 248 94 319 91 319 189 0 189
					yourself:
				)
		)
		(super init:)
		(target init:)
		(gLongSong2 number: 742 setLoop: -1 play: 127)
		(waterFall init:)
		(rightVines init:)
		(lowPath init:)
		(upperPath init:)
		(mist setCycle: Fwd init:)
		(vine init: stopUpd:)
		(vine2 init: stopUpd:)
		(egoTell init: gEgo @local50 @local59)
		(manuTell init: (ScriptID 41 1) @local61 @local66) ; Manu
		(gEgo
			x: -15
			y: 60
			noun: 1
			init:
			setScale: Scaler 100 60 189 60
			normalize:
		)
		((ScriptID 41 1) ; Manu
			ignoreActors: 1
			x: -15
			y: 50
			noun: 3
			setScale: 0
			init:
			stopUpd:
		)
		(jungle init:)
		(gCurRoom setScript: enterRoom)
		(gGame save: 1)
	)

	(method (doit)
		(proc0_15 227 234 -1)
		(if (and (GameIsRestarting) (== local47 1))
			(Graph grDRAW_LINE 36 124 36 283 0 -1 -1)
			(Graph grUPDATE_BOX 35 123 37 284 1)
		)
		(if
			(and
				(not (== (gLongSong2 number:) 742))
				(== (gLongSong2 prevSignal:) -1)
			)
			(gLongSong2 number: 742 setLoop: -1 play:)
		)
		(cond
			(script)
			((<= (gEgo x:) 10)
				(gCurRoom setScript: manuWarn)
			)
			((>= (gEgo x:) 310)
				(gCurRoom setScript: exitRoom)
			)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(84 ; levitateSpell
				(cond
					((== ((ScriptID 41 1) script:) manuPulls) ; Manu
						(manuPulls cue:)
					)
					((and local43 local45 local46)
						(gCurRoom setScript: leviWVine)
					)
					((== gHeroType 1) ; Magic User
						(gCurRoom setScript: leviNotMonks)
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
			(81 ; flameDartSpell
				(gMessager say: 2 6 35) ; "That won't do much in this situation."
			)
			(83 ; forceBoltSpell
				(gMessager say: 2 6 35) ; "That won't do much in this situation."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(mist setCycle: 0)
		(LoadMany 0 964 41 942 57)
		(gWalkHandler delete: target)
		(gWalkHandler delete: bridge)
		(gLongSong stop:)
		(gLongSong2 stop:)
		(super dispose:)
	)
)

(instance thiefCrossBridge of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 5)
			)
			(1
				(gEgo setMotion: PolyPath 132 46 self)
			)
			(2
				(gEgo
					view: 12
					setCycle: Fwd
					setLoop: 0
					cycleSpeed: 6
					moveSpeed: 6
					setMotion: MoveTo 132 36 self
				)
			)
			(3
				(gEgo setMotion: MoveTo 264 36 self)
			)
			(4
				(gEgo view: 0 setLoop: -1 normalize:)
				(bridge dispose:)
				(self setScript: exitRoom)
			)
		)
	)
)

(instance manuPulls of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (or (== state 6) (== state 7))
			(egoVine x: (gEgo x:))
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo normalize:)
				(if (gEgo has: 26) ; theRope
					(self cue:)
				else
					(gMessager say: 1 34 4 0 self) ; "You show Manu the vine rope and tell him that you will use it to cross the waterfall."
				)
			)
			(1
				(gEgo setMotion: PolyPath 164 77 ignoreActors: 1)
				((ScriptID 41 1) setMotion: PolyPath 150 78 self) ; Manu
			)
			(2
				((ScriptID 41 1) setMotion: JumpTo 256 82 self) ; Manu
				(gMessager say: 2 6 26) ; "You tie one end of the rope to yourself."
			)
			(3
				(egoVine ignoreActors: 1 setLoop: 1 setPri: 1 init:)
				((ScriptID 41 1) view: 741 loop: 4 setCycle: End self) ; Manu
				(= local49 1)
				(gMessager say: 2 6 28) ; "You feel pressure on the rope as Manu tries to pull you across the chasm."
				(gEgo drop: 24 -1) ; theVine
			)
			(4
				(proc0_13)
			)
			(5
				(HandsOff)
				(gEgo
					view: 17
					setLoop: 0
					setCycle: End self
					setMotion: MoveTo 164 (gEgo y:)
				)
			)
			(6
				((ScriptID 41 1) setCycle: Fwd) ; Manu
				(gEgo
					xStep: 3
					moveSpeed: 3
					setMotion: MoveTo 240 (gEgo y:) self
				)
			)
			(7
				((ScriptID 41 1) view: 985 setCycle: 0 setLoop: -1 loop: 1) ; Manu
				(gWalkHandler delete: target)
				(target dispose:)
				(egoVine dispose:)
				(gEgo setCycle: Beg setMotion: MoveTo 240 77 self)
			)
			(8
				(gLongSong2 number: 742 setLoop: -1 play: 60)
				(gEgo view: 0 normalize:)
				(self setScript: exitRoom)
				(self dispose:)
			)
		)
	)
)

(instance leviVine of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local46 1)
				(gEgo drop: 24) ; theVine
				(gEgo setMotion: PolyPath 164 77)
				((ScriptID 41 1) setMotion: PolyPath 169 77 self) ; Manu
			)
			(1
				((ScriptID 41 1) setMotion: JumpTo 259 78 self) ; Manu
			)
			(2
				(gMessager say: 2 6 26) ; "You tie one end of the rope to yourself."
				(egoVine ignoreActors: 1 setLoop: 1 setPri: 1 init:)
				((ScriptID 41 1) view: 741 loop: 4 setScale: cel: 0) ; Manu
				(gEgo drop: 24 -1) ; theVine
				(= cycles 1)
			)
			(3
				(gLongSong2 number: 742 setLoop: -1 play: 60)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance leviWVine of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gTheIconBar disable:)
				(gEgo
					view: 17
					setLoop: 0
					setCycle: End self
					setMotion: MoveTo 164 70
				)
				(egoVine setMotion: MoveTo 164 70)
			)
			(1
				((ScriptID 41 1) setLoop: 4 setCycle: Fwd) ; Manu
				(gEgo xStep: 3 moveSpeed: 3 setMotion: MoveTo 240 70 self)
				(egoVine xStep: 3 moveSpeed: 3 setMotion: MoveTo 240 70)
			)
			(2
				((ScriptID 41 1) view: 985 setCycle: 0 setLoop: -1 loop: 1) ; Manu
				(egoVine dispose:)
				(gEgo setCycle: Beg self setMotion: MoveTo 240 77)
			)
			(3
				(gLongSong2 number: 742 setLoop: -1 play: 60)
				(gEgo view: 0 normalize:)
				(gEgo drop: 24 2) ; theVine
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance leviNotMonks of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((ScriptID 31 0) init:) ; leviCode
				(= seconds 5)
			)
			(1
				(gMessager say: 2 6 25 0 self) ; "This spell may make you weightless, but it doesn't move you across."
			)
			(2
				(gLongSong2 number: 742 setLoop: -1 play: 60)
				(gTheIconBar enable:)
				(self dispose:)
			)
		)
	)
)

(instance setBridge of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 41 1) setMotion: PolyPath 150 78 self) ; Manu
			)
			(1
				((ScriptID 41 1) ; Manu
					view: 741
					loop: 0
					cel: 0
					setCycle: End
					setMotion: JumpTo 256 82 self
				)
			)
			(2
				(= seconds 2)
			)
			(3
				((ScriptID 41 1) ; Manu
					view: 985
					setCycle: Walk
					setMotion: MoveTo 247 62 self
				)
			)
			(4
				((ScriptID 41 1) view: 741 loop: 3 cel: 0 setCycle: End self) ; Manu
			)
			(5
				((ScriptID 41 1) loop: 2 cel: 0 setCycle: End self) ; Manu
			)
			(6
				((ScriptID 41 1) loop: 5 cel: 0 setCycle: End self) ; Manu
			)
			(7
				((ScriptID 41 1) setCycle: Beg self) ; Manu
			)
			(8
				(Graph grDRAW_LINE 36 124 36 283 0 -1 -1)
				(Graph grUPDATE_BOX 35 123 37 284 1)
				(gEgo drop: 41) ; theBridge
				(gTheIconBar advanceCurIcon:)
				(bridge approachVerbs: 4 init:) ; Do
				(gWalkHandler add: bridge)
				(= cycles 1)
			)
			(9
				(gMessager say: 2 6 2 0 self) ; "You throw the end of the bridge to Manu, and he secures it to a rock (you hope). Then you tie it to your side."
			)
			(10
				((ScriptID 41 1) setPri: 1) ; Manu
				(= local47 1)
				(self dispose:)
			)
		)
	)
)

(instance setVine of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 41 1) setMotion: PolyPath 150 78 self) ; Manu
			)
			(1
				((ScriptID 41 1) ; Manu
					view: 741
					loop: 0
					cel: 0
					setCycle: End
					setMotion: JumpTo 256 82 self
				)
			)
			(2
				(= seconds 2)
			)
			(3
				((ScriptID 41 1) ; Manu
					view: 985
					setCycle: Walk
					setMotion: MoveTo 271 52 self
				)
			)
			(4
				((ScriptID 41 1) view: 741 loop: 3 cel: 0 setCycle: End self) ; Manu
			)
			(5
				((ScriptID 41 1) loop: 2 cel: 0 setCycle: End self) ; Manu
			)
			(6
				((ScriptID 41 1) loop: 5 cel: 0 setCycle: End self) ; Manu
			)
			(7
				((ScriptID 41 1) setCycle: Beg self) ; Manu
			)
			(8
				(Graph grDRAW_LINE 36 124 36 283 0 -1 -1)
				(Graph grUPDATE_BOX 35 123 37 284 1)
				(gEgo drop: 24 2) ; theVine
				(bridge approachVerbs: 4 init:) ; Do
				(gEgo solvePuzzle: 324 3 9)
				(gWalkHandler add: bridge)
				(= cycles 1)
			)
			(9
				((ScriptID 41 1) view: 985 loop: 0 setPri: 1 setCycle: Walk) ; Manu
				(= local47 1)
				(self dispose:)
			)
		)
	)
)

(instance jumpScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setMotion: PolyPath 150 78 self)
			)
			(1
				(client
					view: 741
					loop: 0
					cel: 0
					setCycle: End
					setMotion: JumpX 256 (Random 15 25) self
				)
			)
			(2
				(client view: 985 setCycle: Walk setMotion: MoveTo 350 66 self)
			)
			(3
				(client dispose:)
			)
		)
	)
)

(instance enterRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(for ((= local41 0)) (< local41 9) ((++ local41))
					(= [local21 local41] (jumpScript new:))
					((= [local31 local41] (monkey new:))
						x: (- (monkey x:) (* 25 local41))
						setLoop: 0
						setCycle: Walk
						cycleSpeed: 3
						moveSpeed: 3
						xStep: 5
						init:
						setScript: [local21 local41]
					)
				)
				(= seconds 7)
			)
			(1
				(gEgo setStep: 3 2 setMotion: PolyPath 38 66 self)
				((ScriptID 41 1) setCycle: Walk setMotion: PolyPath 42 60) ; Manu
			)
			(2
				(gMessager say: 3 6 12 0 self) ; "Alla monkeys across. You cross. You very big. You no jump good. How man-friend cross big rock waters that fall down?"
			)
			(3
				(gTheIconBar enable:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance manuWarn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setMotion: PolyPath (+ (gEgo x:) 10) (gEgo y:) self
				)
			)
			(1
				(gMessager say: 3 6 13) ; "No go. Man-friend no go back. Monkeys go home. Monkeys no come back. Man-friend no go here again."
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance throwGrap of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 163 75 self)
			)
			(1
				(gEgo view: 8 loop: 0 cel: 0 setCycle: CT 6 1 self)
			)
			(2
				(gEgo setCycle: End)
				(rope init: setCycle: End self)
				(sFx number: 721 play:)
			)
			(3
				(gEgo view: 4 setCycle: End self)
				(gEgo drop: 6) ; theGrapnel
			)
			(4
				(gEgo view: 0 setCycle: Walk)
				(= local47 1)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance exitRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (gEgo has: 24) ; theVine
					(gEgo drop: 24) ; theVine
				)
				(gEgo
					solvePuzzle: 325 10
					setMotion: PolyPath 330 (gEgo y:) self
				)
			)
			(1
				(= seconds 1)
			)
			(2
				(gCurRoom newRoom: 180)
			)
		)
	)
)

(instance attemptBridge of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 5)
			)
			(1
				(gEgo setMotion: PolyPath 132 46 self)
			)
			(2
				(gEgo
					view: 12
					setCycle: Fwd
					setLoop: 0
					cycleSpeed: 6
					moveSpeed: 6
					setMotion: MoveTo 132 36 self
				)
			)
			(3
				(gEgo view: 6 setLoop: 4 setCycle: MCyc @local0 self)
			)
			(4
				(gEgo setCycle: End self)
			)
			(5
				(switch local42
					(0
						(gMessager say: 2 6 20) ; "You don't seem be able to keep your balance on this narrow thing."
					)
					(1
						(gMessager say: 2 6 21) ; "You walk a bit, you fall down. Maybe you should try another profession besides tightrope walking."
					)
				)
				(++ local42)
				(= cycles 1)
			)
			(6
				(gEgo setLoop: 10 cel: 0 setCycle: End self)
			)
			(7
				(gEgo
					cycleSpeed: 3
					moveSpeed: 3
					setLoop: -1
					changeGait: 0 ; walking
					normalize:
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance egoDeathFall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 5)
			)
			(1
				(gEgo setMotion: PolyPath 120 36 self)
			)
			(2
				(gEgo
					view: 12
					setCycle: Fwd
					setLoop: 0
					cycleSpeed: 6
					moveSpeed: 6
					setMotion: MoveTo 209 36 self
				)
			)
			(3
				(self setScript: egoFalls)
			)
		)
	)
)

(instance egoFalls of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo view: 6 setLoop: 4 setCel: 0 setCycle: End self)
			)
			(1
				(= seconds 2)
			)
			(2
				(sFx number: 912 play:)
				(gEgo
					moveSpeed: 0
					setStep: 4 4
					setScale: Scaler 25 75 189 60
					setCycle: 0
					setMotion: MoveTo 209 200 self
				)
			)
			(3
				(EgoDead 22 0 744 Fwd) ; "As you find yourself approaching the bottom of the falls at Mach One, you begin to believe that when your life hung in the balance, you were a klutz."
				(self dispose:)
			)
		)
	)
)

(instance thiefCrossRope of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 169 79 self)
			)
			(1
				(gEgo
					view: 11
					y: 79
					setLoop: 2
					setCycle: Fwd
					setMotion: MoveTo 264 79 self
				)
			)
			(2
				(gEgo view: 0 setLoop: -1 normalize:)
				(gMessager say: 2 6 38 0 self) ; "You recover the rope and magical grapnel and put them away in case you need to use them again."
			)
			(3
				(gWalkHandler delete: target)
				(bridge dispose:)
				(gEgo get: 6) ; theGrapnel
				(self setScript: exitRoom)
			)
		)
	)
)

(instance getVine of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 44 70 self)
			)
			(1
				(gEgo view: 31 cel: 0 setCycle: CT 3 1 self)
			)
			(2
				(if (== ((gInventory at: 24) state:) 0) ; theVine
					(gEgo get: 24) ; theVine
					((gInventory at: 24) state: 1) ; theVine
					(gMessager say: 2 6 23) ; "You take one of the vines, although it really doesn't look strong enough to support your weight."
					(vine dispose:)
				else
					(gEgo get: 24) ; theVine
					(gMessager say: 2 6 24) ; "You now have another vine that doesn't look quite strong enough to support your mass."
					((gInventory at: 24) state: 2) ; theVine
					(vine2 dispose:)
				)
				(= cycles 1)
			)
			(3
				(if (== ((gInventory at: 24) state:) 2) ; theVine
					(gMessager say: 2 6 9 0 self) ; "You tie the two vines together. You now have a strong vine rope."
				else
					(self cue:)
				)
			)
			(4
				(gEgo setCycle: End self)
			)
			(5
				(gEgo view: 0 normalize:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance crossBridge of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 166 71 self)
			)
			(1
				(gEgo
					view: 39
					y: 35
					setCycle: Fwd
					setMotion: MoveTo 265 35 self
				)
			)
			(2
				(gEgo view: 0 normalize: y: 75)
				(= seconds 2)
			)
			(3
				(gMessager say: 3 6 14) ; "Hurry. Hurry. Many bad things here. We see bad city, then we go home. Hurry, go home."
				(gWalkHandler delete: target)
				(bridge dispose:)
				(self setScript: exitRoom)
			)
		)
	)
)

(instance attemptVine of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 166 71 self)
			)
			(1
				(gEgo view: 39 loop: 0 cel: 0 y: 35)
				(= ticks 120)
			)
			(2
				(gEgo view: 0 y: 71)
				(gMessager say: 2 6 33) ; "You are not strong enough to attempt this feat in this manner."
				(= cycles 1)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance jumpToDoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo moveSpeed: 2 setMotion: PolyPath 166 78 self)
			)
			(1
				(gEgo setMotion: JumpTo 185 66 self)
			)
			(2
				(sFx number: 912 play:)
				(gEgo
					view: 6
					setLoop: 4
					moveSpeed: 0
					setCycle: 0
					setScale: Scaler 0 75 189 60
					setMotion: MoveTo 185 162 self
				)
			)
			(3
				(EgoDead 17 0 744 Fwd) ; "As you tumble toward impending doom, you remember an old adage, "Never jump something longer than you are tall, unless you are a grasshopper.""
				(self dispose:)
			)
		)
	)
)

(instance monkey of Actor
	(properties
		x -10
		y 60
		view 985
		signal 16384
	)
)

(instance rope of Prop
	(properties
		x 170
		y 79
		view 51
		signal 16384
	)

	(method (init)
		(super init:)
		(gWalkHandler addToFront: self)
	)

	(method (dispose)
		(gWalkHandler delete: self)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (< (gEgo x:) 250)
					(gCurRoom setScript: thiefCrossRope)
				else
					(gEgo get: 6) ; theGrapnel
					(self dispose:)
				)
			)
			(3 ; Walk
				(if (< (gEgo x:) 250)
					(gCurRoom setScript: thiefCrossRope)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance mist of Prop
	(properties
		x 202
		y 172
		view 740
		loop 1
		signal 16384
		detailLevel 3
	)
)

(instance vine of View
	(properties
		noun 7
		view 740
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gEgo setScript: getVine 0 vine)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance vine2 of View
	(properties
		x 29
		noun 7
		view 740
		cel 1
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gEgo setScript: getVine 0 vine2)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance egoVine of Actor
	(properties
		x 161
		y 74
		view 51
		signal 16384
	)
)

(instance target of Feature
	(properties
		x 252
		y 76
		noun 10
		nsLeft 233
		nsBottom 200
		nsRight 320
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(16 ; theGrapnel
				(if (not local47)
					(gCurRoom setScript: throwGrap)
				)
			)
			(52 ; theBridge
				(gMessager say: 2 6 19) ; "You need to find a way to attach it to the other side."
			)
			(3 ; Walk
				(if (== gEgoGait 1) ; running
					(gEgo setScript: jumpToDoom)
				else
					(gMessager say: 2 6 18) ; "You think about taking one giant step over the chasm, but decide against it."
					(gEgo setMotion: 0)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance bridge of Feature
	(properties
		x 200
		y 38
		nsTop 31
		nsLeft 133
		nsBottom 43
		nsRight 285
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((gCurRoom script:) 0)
					((or (== gHeroType 2) (== gHeroType 1)) ; Thief, Magic User
						(if (> (gEgo trySkill: 0 250) 0) ; strength
							(gCurRoom setScript: crossBridge)
						else
							(gCurRoom setScript: attemptVine)
						)
					)
					(else
						(gCurRoom setScript: crossBridge)
					)
				)
			)
			(3 ; Walk
				(cond
					((gCurRoom script:) 0)
					((== gHeroType 2) ; Thief
						(gCurRoom setScript: thiefCrossBridge)
					)
					((< local42 2)
						(gCurRoom setScript: attemptBridge)
					)
					(else
						(gCurRoom setScript: egoDeathFall)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance waterFall of Feature
	(properties
		x 180
		y 1
		noun 5
		sightAngle 40
		onMeCheck 16384
	)
)

(instance jungle of Feature
	(properties
		x 28
		y 168
		noun 6
		nsTop 148
		nsBottom 189
		nsRight 56
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance rightVines of Feature
	(properties
		x 221
		y 26
		noun 9
		nsTop -1
		nsLeft 196
		nsBottom 54
		nsRight 247
		sightAngle 180
	)
)

(instance lowPath of Feature
	(properties
		x 138
		y 80
		noun 11
		nsTop 68
		nsLeft 106
		nsBottom 93
		nsRight 171
		sightAngle 180
	)
)

(instance upperPath of Feature
	(properties
		x 122
		y 48
		noun 12
		nsTop 35
		nsLeft 100
		nsBottom 62
		nsRight 144
		sightAngle 180
	)
)

(instance sFx of Sound
	(properties)
)

(instance manuTell of Teller
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(super doVerb: theVerb)
			)
			(else
				(gCurRoom doVerb: theVerb)
			)
		)
	)
)

(instance egoTell of Teller
	(properties)

	(method (showDialog)
		(super
			showDialog:
				-4
				(and (== gHeroType 1) (< (gEgo x:) 240)) ; Magic User
				-10
				(== local48 1)
				-6
				(and
					(< (gEgo x:) 240)
					(gEgo has: 24) ; theVine
					(> ((gInventory at: 24) state:) 0) ; theVine
					(not local47)
					(not (== gHeroType 2)) ; Thief
				)
				-2
				(and
					(or (gEgo has: 41) (gEgo has: 26)) ; theBridge, theRope
					(not local47)
					(not local46)
					(not (== gHeroType 2)) ; Thief
				)
				-7
				(== local49 1)
		)
	)

	(method (doChild)
		(switch query
			(-2
				(cond
					((== gHeroType 1) ; Magic User
						(= local47 1)
						((ScriptID 41 1) setScript: manuPulls) ; Manu
					)
					((and (not local47) (not local46))
						(gCurRoom setScript: setBridge)
					)
				)
			)
			(-4
				(= local48 1)
			)
			(-10
				(= local43 1)
			)
			(-6
				(cond
					((== gHeroType 1) ; Magic User
						(= local47 1)
						((ScriptID 41 1) setScript: manuPulls) ; Manu
					)
					((not local47)
						(= local47 1)
						(gCurRoom setScript: setVine)
						(= query -5)
					)
				)
			)
			(-7
				(= local49 0)
				(gTheIconBar enable: 6)
				((ScriptID 41 1) setCycle: Beg) ; Manu
			)
		)
		(return 1)
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(2 ; Talk
				(super doVerb: theVerb)
			)
			(34 ; theVine
				(if (== gHeroType 1) ; Magic User
					(gMessager say: 2 6 37) ; "You tie the vine to you."
					(= local46 1)
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(gEgo doVerb: theVerb)
			)
		)
	)
)

