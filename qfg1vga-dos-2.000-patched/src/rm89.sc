;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 89)
(include sci.sh)
(use Main)
(use n814)
(use PolyPath)
(use Polygon)
(use Feature)
(use Timer)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm89 0
)

(local
	local0
	local1
	[local2 2]
	local4
	local5
	local6
	local7
)

(instance leTimer of Timer
	(properties)
)

(instance rm89 of Rm
	(properties
		noun 4
		picture 89
		style 2
	)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 319 90 139 89 124 70 98 70 56 80 31 97 31 174 319 174 319 189 0 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 319 105 319 150 215 149 176 159 71 156 47 152 48 140 56 133 61 105
					yourself:
				)
		)
		(super init:)
		(water init: setScript: sWater)
		(rocks init:)
		(ceiling init:)
		(cave init:)
		(SolvePuzzle 704 2)
		(= local4
			(cond
				((or (IsFlag 247) (IsFlag 250)) 0)
				((== gPrevRoomNum 450) ; trollArena
					(= global279 0)
					2
				)
				((IsFlag 251)
					(troll
						view: 451
						posn: 94 189
						setLoop: 0
						setCel: 10
						init:
						addToPic:
					)
					3
				)
				(else 1)
			)
		)
		(switch gPrevRoomNum
			(450 ; trollArena
				(gEgo init: posn: 58 170 setHeading: 270)
				(self setScript: trollDies)
			)
			(84
				(if (!= local4 0)
					(= local7 1)
					(if (== local4 1)
						(troll init: posn: 167 95 setLoop: 0)
						(troll
							setCycle: Walk
							cycleSpeed: 8
							moveSpeed: 8
							setMotion: MoveTo 250 95
						)
					)
				)
				(gEgo init: posn: 345 92)
				(self setScript: sEnterFromEast)
			)
			(else
				(gEgo init: posn: 345 168)
				(self setScript: sEnterFromEast)
			)
		)
		(Load rsSCRIPT 930)
		(Load rsSCRIPT 927)
		(leTimer setReal: self 6)
		(gLongSong number: 23 loop: -1 play:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(78 ; dazzleSpell
				(if local7
					(gMessager say: 4 78 8) ; "You'd think a Cave Troll would make a perfect Dazzle victim, wouldn't you? Unfortunately, this one was blind to start with, and he can still smell you!"
				else
					(gMessager say: 4 78 7) ; "There is nothing here to dazzle."
				)
			)
			(81 ; flameDartSpell
				(if local7
					(gMessager say: 4 81 8) ; "Oops, it's one of those flame-resistant Trolls you've been warned about."
				else
					(gMessager say: 4 78 7) ; "There is nothing here to dazzle."
				)
			)
			(80 ; calmSpell
				(if local7
					(gMessager say: 4 80 8) ; "The Troll looks as though he will now calmly tear you to shreds."
				else
					(gMessager say: 4 78 7) ; "There is nothing here to dazzle."
				)
			)
			(else
				(gMessager say: 4 0 6) ; "That spell is useless here."
			)
		)
	)

	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber)
		(leTimer dispose: delete:)
	)

	(method (cue)
		(switch (++ local1)
			(1
				(if (not (IsFlag 79))
					(gMessager say: 4 0 4) ; "As your eyes adjust to the darkness, you see by the light of the fungus that this passageway twists its way through the mountain. It is cold in here, and you can smell stagnant water and faint hints of decay."
				)
				(leTimer setReal: self 12)
			)
			(2
				(gMessager say: 4 0 5) ; "You hear the constant "drip... drip..." of water."
			)
		)
	)

	(method (doit)
		(if (and (not (gCurRoom script:)) (> (gEgo x:) 300))
			(HandsOff)
			(gCurRoom setScript: sExitEast)
		)
		(super doit:)
	)

	(method (dispose)
		(= global451 0)
		(DisposeScript 927)
		(DisposeScript 930)
		(SetFlag 79)
		(super dispose:)
	)
)

(instance cave of Feature
	(properties
		x 159
		y 1
		z 100
		noun 1
		nsTop -1
		nsBottom 189
		nsRight 319
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(switch (Random 1 3)
					(1
						(gMessager say: 1 1 1) ; "Water lies in stagnant pools."
					)
					(2
						(gMessager say: 1 1 2) ; "You have lost your sense of direction, as the cave passage twists around."
					)
					(3
						(gMessager say: 1 1 3) ; "The only entrance to this cave is the one you came through."
					)
				)
			)
			(4 ; Do
				(gMessager say: 1 4) ; "The fungus is slimy and stuck tight to the cave walls."
			)
			(57 ; Talk [ REMOVED ]
				(gMessager say: 1 57) ; "No one answers."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance ceiling of Feature
	(properties
		x 159
		y 29
		noun 2
		nsBottom 59
		nsRight 319
		sightAngle 40
		onMeCheck 2
	)
)

(instance rocks of Feature
	(properties
		x 159
		y 106
		noun 3
		nsTop 23
		nsBottom 189
		nsRight 319
		sightAngle 40
		onMeCheck 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(switch (Random 1 3)
					(1
						(gMessager say: 3 1 1) ; "You can watch the water drop down from the stalactites and ooze down the sides of the stalagmites."
					)
					(2
						(gMessager say: 3 1 2) ; "The rocks look slick and are slimy to the touch."
					)
					(3
						(gMessager say: 3 1 3) ; "The light from the fungus is eerie and vaguely unpleasant."
					)
				)
			)
			(4 ; Do
				(gMessager say: 2 4) ; "The fungus is slimy and stuck tight to the cave walls."
			)
			(2 ; Talk
				(gMessager say: 2 57) ; "All you hear is a distant "Echo"."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance water of Prop
	(properties
		view 89
		signal 18448
	)
)

(instance troll of Actor
	(properties
		noun 5
		view 450
		signal 24576
		illegalBits 0
	)

	(method (init)
		(= global451 1450)
		(PalVary pvCHANGE_TARGET 1450)
		(AssertPalette 450)
		(super init:)
	)

	(method (doit)
		(super doit:)
		(if (and (not (IsFlag 250)) (< (gEgo distanceTo: troll) 25))
			(HandsOff)
			(sEnterFromEast cue:)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(switch local4
					(1
						(gMessager say: 5 1 19) ; "A mean-looking Troll looms before you, a snarl on his lips."
					)
					(2
						(gMessager say: 5 1 17) ; "The Troll lies dying upon the slimy floor of the cave."
					)
					(3
						(gMessager say: 5 1 16) ; "A dead Troll lies in a pool of blue blood."
					)
					(else
						(gMessager say: 5 1 18) ; "You see no such creature here."
					)
				)
			)
			(4 ; Do
				(if (!= local4 3)
					(gMessager say: 5 4 10) ; "You shouldn't have done that! Now he's mad!"
					(HandsOff)
					(gEgo setMotion: PolyPath x y self)
				else
					(switch (++ local0)
						(1
							(gMessager say: 5 4 11) ; "The dead Troll's huge club is much too heavy for you to lift."
						)
						(2
							(= local6 0)
							(self setScript: egoSearch)
						)
						(3
							(= local6 1)
							(self setScript: egoSearch)
						)
						(4
							(= local0 3)
							(gMessager say: 5 4 18) ; "There's nothing else worth taking from the Troll."
						)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance trollDies of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 251)
				(SetFlag 250)
				(HandsOff)
				(troll
					init:
					view: 451
					setLoop: 0
					setCel: 0
					illegalBits: 0
					posn: 94 189
					cycleSpeed: 6
					setPri: 4
					setCycle: End self
				)
			)
			(1
				(HandsOn)
				(NormalEgo)
				(= local4 3)
				(troll addToPic:)
				(client setScript: 0)
				(self dispose:)
			)
		)
	)
)

(instance egoSearch of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setMotion: PolyPath (- (troll x:) 33) (- (troll y:) 19) self
				)
			)
			(1
				(Face gEgo troll self)
			)
			(2
				(gEgo
					loop: (mod (+ (gEgo loop:) 4) 2)
					setPri: 15
					view: 510
					setCycle: End self
				)
			)
			(3
				(switch local6
					(0
						(if (IsFlag 340)
							(gMessager say: 5 4 12) ; "You find nothing on the Troll."
						else
							(gMessager say: 5 4 13) ; "You find nothing on the Troll but a little hair."
						)
					)
					(1
						(if (IsFlag 340)
							(gMessager say: 5 4 14) ; "You find no more beard hair on the dead Troll."
						else
							(gMessager say: 5 4 15) ; "You cut off the Troll's beard and put it away."
						)
					)
				)
				(gEgo setPri: 13 setCycle: Beg self)
			)
			(4
				(if (and (== local6 1) (not (IsFlag 340)))
					(SetFlag 340)
					(gEgo get: 37) ; trollBeard
				)
				(NormalEgo)
				(HandsOn)
			)
		)
	)
)

(instance sExitEast of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 340 (gEgo y:) self)
			)
			(1
				(if (> (gEgo y:) 110)
					(gCurRoom newRoom: 93)
				else
					(gCurRoom newRoom: 84)
				)
			)
		)
	)
)

(instance sWater of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch (Random 1 3)
					(1
						(water
							setPri: 4
							posn: 187 86
							setCel: 0
							cycleSpeed: (Random 2 8)
							setCycle: End self
						)
					)
					(2
						(water
							setPri: 14
							posn: 268 110
							setCel: 0
							cycleSpeed: (Random 2 8)
							setCycle: End self
						)
					)
					(3
						(water
							setPri: 4
							posn: 222 83
							setCel: 0
							cycleSpeed: (Random 2 8)
							setCycle: End self
						)
					)
				)
			)
			(1
				(drip play:)
				(= seconds (Random 2 5))
			)
			(2
				(self init:)
			)
		)
	)
)

(instance sEnterFromEast of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= ticks 18)
			)
			(1
				(gEgo setMotion: MoveTo 295 (gEgo y:) self)
			)
			(2
				(HandsOn)
				(NormalEgo)
				(if (== local4 1)
					(troll setMotion: 0)
					(gMessager say: 5 0 9 0 self) ; "Before you can react, the Troll is upon you, and the encounter begins."
				else
					(self cue:)
				)
			)
			(3
				(if (== local4 1)
					(gCurRoom newRoom: 450) ; trollArena
				else
					(client setScript: 0)
					(self dispose:)
				)
			)
		)
	)
)

(instance drip of Sound
	(properties
		number 116
	)
)

