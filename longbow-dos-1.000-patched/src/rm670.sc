;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 670)
(include sci.sh)
(use Main)
(use n013)
(use Monastery)
(use verseScript)
(use RTEyeCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Game)
(use Inventory)
(use Actor)
(use System)

(public
	rm670 0
)

(local
	[local0 4]
	local4
	[local5 5]
	[local10 5]
	[local15 26] = [1670 0 2 1 2 1 2 1 2 1 2 1 2 1 2 2 1 2 1 2 1 2 1 2 2 0]
	[local41 6] = [1670 23 2 1 2 0]
	[local47 8] = [1670 26 2 1 2 1 2 0]
	[local55 6] = [1670 31 2 1 2 0]
	[local61 4] = [1670 34 1 0]
	[local65 4] = [1670 45 1 0]
)

(procedure (localproc_0 &tmp temp0)
	(for ((= temp0 0)) (< temp0 5) ((++ temp0))
		(= [local5 temp0] (oRat new:))
		([local5 temp0]
			loop:
				(switch temp0
					(0 0)
					(1 1)
					(2 3)
					(3 5)
					(4 10)
				)
			x:
				(switch temp0
					(0 101)
					(1 243)
					(2 93)
					(3 167)
					(4 70)
				)
			y:
				(switch temp0
					(0 150)
					(1 173)
					(2 159)
					(3 150)
					(4 160)
				)
			cycleSpeed: 3
			init:
			setScript: (= [local10 temp0] (runAround new:))
		)
	)
)

(instance rm670 of Rm
	(properties
		picture 670
	)

	(method (init &tmp temp0 temp1)
		(super init:)
		(localproc_0)
		(AddToFeatures
			bucket
			highWindow
			rack
			strappado
			wheel
			leftRope
			rightRope
			rightTopRope
			wallChain
			highChain
			walls
			floor
		)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 78 189 0 189 0 -1 319 -1 319 189 243 189 251 183 229 178 226 167 266 166 265 164 215 166 188 159 158 151 47 151 48 176 83 176 83 184
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 56 154 162 154 187 160 179 169 147 169 124 163 61 163
					yourself:
				)
		)
		(NormalEgo)
		(= temp0 (Monastery wherePrior:))
		(if (== (= temp1 (Monastery fulkStatus:)) 0)
			(if (> temp0 1)
				(SetScore -50)
			)
			((ScriptID 15) ; fulk
				setLoop: 2
				setCel: 0
				posn: 171 126
				init:
				approachX: 178
				approachY: 155
				approachVerbs: 3 ; Do
			)
		else
			((ScriptID 15) ; fulk
				loop: 3
				cel: 9
				posn: 162 165
				init:
				approachX: 172
				approachY: 165
				approachVerbs: 3 ; Do
			)
		)
		(switch temp0
			(0
				(gEgo posn: 95 230 init:)
				((ScriptID 625 1) loop: 5 cel: 4 posn: 161 170 init:) ; chip
				(self setScript: meetTheMonk)
			)
			(1
				(gEgo posn: 95 230 init:)
				((ScriptID 625 2) loop: 1 cel: 3 posn: 206 169 init:) ; prior
				(self setScript: meetThePrior)
			)
			(else
				(gEgo posn: 160 240 init:)
				(self setScript: walkIn self)
			)
		)
		(sqeakSound init: play:)
	)

	(method (doit)
		(cond
			((gEgo script:))
			((and (gEgo edgeHit:) (not (gCurRoom script:)))
				(gCurRoom newRoom: 630)
			)
			((== global115 2)
				(gEgo setScript: burnedByFire)
			)
		)
		(super doit:)
	)

	(method (dispose)
		(DisposeScript 927)
		(super dispose:)
	)
)

(instance oRat of Actor
	(properties
		yStep 4
		view 705
		signal 16384
		cycleSpeed 40
		illegalBits 0
		xStep 6
		moveSpeed 0
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1670 50) ; "This place is overrun with rats."
			)
			(3 ; Do
				(Say 1670 51) ; "They'd make good rat stew, but I've no time for that now."
			)
			(5 ; Talk
				(SetMessageColor 32)
				(Say 1670 52 80 {Rat}) ; "Yeah, whaddayawant?"
				(SetMessageColor 0)
			)
			(4 ; Inventory
				(SetMessageColor 32)
				(Say 1670 53 80 {Rat}) ; "If it ain't cheese, I don't want it."
				(SetMessageColor 0)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bucket of Feature
	(properties
		x 73
		y 175
		nsTop 164
		nsLeft 68
		nsBottom 186
		nsRight 79
		sightAngle 90
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1670 43) ; "A bucket of water for reviving tortured prisoners."
			)
			(3 ; Do
				(Say 1670 44) ; "It smells of the fens. I'll leave it be."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance walls of Feature
	(properties
		y 10
		nsLeft 47
		nsBottom 150
		nsRight 268
		lookStr 40 ; "Mist from the fens slimes the dank walls."
	)
)

(instance floor of Feature
	(properties
		y 10
		nsTop 150
		nsLeft 47
		nsBottom 189
		nsRight 268
		lookStr 42 ; "The straw strewn upon the floor does nothing to hide the stench of blood and fear."
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Say 1670 46) ; "The filthy straw on this floor is more than I care to smell, let alone touch."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance highWindow of Feature
	(properties
		x 198
		y 24
		nsTop 4
		nsLeft 190
		nsBottom 44
		nsRight 207
		sightAngle 90
		lookStr 41 ; "It's too high and small to afford any means of escape."
	)
)

(instance rack of Feature
	(properties
		y 20
		lookStr 37 ; "I've never seen such a thing, but I can guess its purpose is to cause physical torment."
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 67 141 77 135 79 128 81 128 81 133 110 122 110 117 114 117 116 120 130 119 132 116 136 116 137 120 137 124 120 134 123 156 120 157 118 147 107 148 104 159 99 159 100 155 91 155 88 159 82 159 67 155
			yourself:
		)
		(super init:)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance strappado of Feature
	(properties
		y 20
		lookStr 35 ; "It's a hideous device known as the strappado."
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 115 27 124 24 180 42 179 48 165 47 159 52 158 136 167 158 147 165 132 161 144 137 147 54 136 38 115 32
			yourself:
		)
		(super init:)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance wheel of Feature
	(properties
		y 20
		lookStr 38 ; "Whatever it is, it must surely have an evil purpose."
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 248 108 248 162 241 162 233 154 230 140 232 128 237 116
			yourself:
		)
		(super init:)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance leftRope of Feature
	(properties
		y 20
		lookStr 36 ; "The ropes of the strappado are designed to slowly tear a victim's limbs from their sockets by the weight of his own body."
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 69 44 77 48 98 48 113 43 123 35 130 35 131 40 128 42 129 66 122 83 119 83 117 78 120 72 123 42 121 42 116 45 94 53 73 53 69 50
			yourself:
		)
		(super init:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Say 1670 47) ; "They're beyond my reach and of no use to me."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance rightRope of Feature
	(properties
		y 44
		lookStr 36 ; "The ropes of the strappado are designed to slowly tear a victim's limbs from their sockets by the weight of his own body."
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 224 44 228 48 229 54 221 59 220 76 219 102 219 130 219 149 215 148 214 135 210 136 207 130 213 127 213 117 215 93 213 63 217 59 211 59 209 52 211 48 217 44
			yourself:
		)
		(super init:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(if (== (Monastery fulkStatus:) 0)
					(gEgo setScript: freeFulk)
				else
					(Say 1670 49) ; "I've no more interest in those wretched ropes."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance rightTopRope of Feature
	(properties
		y 48
		lookStr 36 ; "The ropes of the strappado are designed to slowly tear a victim's limbs from their sockets by the weight of his own body."
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 208 57 186 55 195 60 205 63 215 60 216 63 204 67 189 64 177 56 177 75 174 77 174 127 168 124 170 56 169 55 169 51 172 48 208 53
			yourself:
		)
		(super init:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(if (== (Monastery fulkStatus:) 0)
					(Say 1670 48) ; "I cannot reach that part of the ropes, but they run through a pulley attached to the wall and made fast to a post lower down."
				else
					(Say 1670 49) ; "I've no more interest in those wretched ropes."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance wallChain of Feature
	(properties
		y 20
		lookStr 39 ; "Who knows how many victims have hung in torment from these chains?"
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 182 95 186 95 190 99 187 104 184 106 186 110 186 119 182 122 182 142 180 142 179 116 180 108 181 105 177 103 177 97
			yourself:
		)
		(super init:)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance highChain of Feature
	(properties
		y 20
		lookStr 39 ; "Who knows how many victims have hung in torment from these chains?"
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 230 22 250 16 250 25 249 36 241 32 243 37 241 55 240 70 241 76 239 77 236 68 238 37 235 34 237 31 232 30
			yourself:
		)
		(super init:)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance meetThePrior of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 106 180 self)
			)
			(1
				(Face gEgo (ScriptID 625 2)) ; prior
				(Converse @local47 8 (Monastery tPRIOR:) self) ; "Answer me! Speak, or I'll put weights on your feet and rip your arms from their sockets!"
			)
			(2
				((ScriptID 625 2) setCycle: Walk setMotion: MoveTo 180 250 self) ; prior
			)
			(3
				(Monastery wherePrior: 2)
				(HandsOn)
				((ScriptID 625 2) dispose:) ; prior
				(self dispose:)
			)
		)
	)
)

(instance meetTheMonk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 106 180 self)
			)
			(1
				(Face (ScriptID 625 1) gEgo) ; chip
				(Face gEgo (ScriptID 625 1) self) ; chip
			)
			(2
				(Converse @local61 11 0 self) ; "You may not enter, Brother. Prior's orders."
			)
			(3
				((ScriptID 625 1) setCycle: Walk setMotion: MoveTo 126 180) ; chip
				(gEgo setMotion: PolyPath 106 250 self)
			)
			(4
				(self dispose:)
				(gCurRoom newRoom: 630)
			)
		)
	)
)

(instance walkIn of Script
	(properties)

	(method (dispose)
		(HandsOn)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 202 172 self)
			)
			(1
				(Face gEgo (ScriptID 15) self) ; fulk
			)
			(2
				(if (== (Monastery fulkStatus:) 2)
					(if (gEgo has: 17) ; handScroll
						(Converse @local55 8 (Monastery tFULK:) self) ; "Thank God! I'd begun to despair of you. Have you found the scroll you need?"
					else
						(Converse @local41 8 (Monastery tFULK:) self) ; "Did you find the scroll you need?"
					)
				else
					(self dispose:)
				)
			)
			(3
				(if (gEgo has: 17) ; handScroll
					(Monastery fulkStatus: 3)
					((ScriptID 15) setCycle: CT 6 -1 self) ; fulk
				else
					(= cycles 2)
				)
			)
			(4
				(if (gEgo has: 17) ; handScroll
					((ScriptID 15) ; fulk
						view: 671
						loop: 2
						cel: 0
						setCycle: Walk
						setMotion: PolyPath 110 250
					)
					(gEgo setMotion: PolyPath 170 250 self)
				else
					(self dispose:)
				)
			)
			(5
				(gCurRoom newRoom: 630)
				(self dispose:)
			)
		)
	)
)

(instance freeFulk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 233 157 self)
			)
			(1
				(gEgo setHeading: 270 self)
			)
			(2
				((ScriptID 15) setPri: 10) ; fulk
				(gGame setSpeed: global141)
				(gEgo view: 20 loop: 3 cel: 3 setCycle: Beg self)
				((ScriptID 15) ; fulk
					moveSpeed: (* global141 3)
					yStep: 6
					setMotion:
						MoveTo
						((ScriptID 15) x:) ; fulk
						(+ ((ScriptID 15) y:) 30) ; fulk
				)
			)
			(3
				(pulleySound play:)
				(ropeSound play:)
				(gEgo view: 20 loop: 3 cel: 3 setCycle: Beg self)
			)
			(4
				(gEgo view: 20 loop: 3 cel: 3 setCycle: Beg self)
			)
			(5
				(gEgo view: 20 loop: 3 cel: 3 setCycle: Beg self)
			)
			(6
				(gEgo view: 20 loop: 3 cel: 3 setCycle: Beg self)
			)
			(7
				((ScriptID 15) setPri: -1) ; fulk
				(pulleySound stop:)
				(ropeSound stop:)
				(NormalEgo)
				(gEgo setMotion: PolyPath 168 164 self)
			)
			(8
				(Face gEgo (ScriptID 15)) ; fulk
				(= cycles 1)
			)
			(9
				(if (== ((Inv at: 16) owner:) 670) ; fulkScroll
					(if (gEgo has: 17) ; handScroll
						(Monastery fulkStatus: 3)
					else
						(Monastery fulkStatus: 2)
					)
				else
					(Monastery fulkStatus: 1)
				)
				((ScriptID 15) yStep: 2 moveSpeed: 6 view: 671) ; fulk
				(= cycles 10)
			)
			(10
				((ScriptID 15) loop: 2) ; fulk
				((ScriptID 15) cel: 5) ; fulk
				(= cycles 2)
			)
			(11
				((ScriptID 15) setCycle: Walk setMotion: MoveTo 162 165 self) ; fulk
				(gEgo setMotion: PolyPath 195 168 self)
			)
			(12)
			(13
				(Face (ScriptID 15) gEgo) ; fulk
				(Face gEgo (ScriptID 15)) ; fulk
				(= cycles 3)
			)
			(14
				((ScriptID 15) view: 674 loop: 3 cel: 5 setCycle: End self) ; fulk
			)
			(15
				(Converse @local15 8 (Monastery tFULK:) self) ; "You...you set me free. B-But the Prior bade you--"
			)
			(16
				(SetScore 100)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(class runAround of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks (Random 30 120))
			)
			(1
				(if (< (client cel:) (client lastCel:))
					(client setCycle: End self)
				else
					(client setCycle: Beg self)
				)
			)
			(2
				(= state -1)
				(self cue:)
			)
		)
	)
)

(instance burnedByFire of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= gDeathNum 20)
				(gEgo setMotion: PolyPath 168 163 self)
			)
			(1
				((= local4 ((ScriptID 625 1) new:)) ; chip
					view: 16
					setLoop: 0
					cel: 0
					posn: 85 238
					init:
					setCycle: Walk
					setMotion: PolyPath 168 183 self
				)
			)
			(2
				(Face gEgo local4 self)
			)
			(3
				(Face local4 gEgo self)
			)
			(4
				(Converse @local65 11 0 self) ; "That ring! You're the thief the Abbot wants!"
			)
			(5
				(local4 view: 585 setLoop: 3 setCel: 0 setCycle: End)
				(= cycles 2)
			)
			(6
				(dieSound play:)
				(gEgo view: 22 setLoop: 2 setCel: 0 setCycle: End self)
			)
			(7
				(gCurRoom newRoom: 170) ; robinDeath
			)
		)
	)
)

(instance sqeakSound of Sound
	(properties
		flags 1
		number 671
		loop -1
	)
)

(instance ropeSound of Sound
	(properties
		flags 1
		number 670
		loop -1
	)
)

(instance pulleySound of Sound
	(properties
		flags 1
		number 672
		loop -1
	)
)

(instance dieSound of Sound
	(properties
		flags 1
		number 588
	)
)

