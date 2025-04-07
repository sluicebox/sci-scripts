;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 633)
(include sci.sh)
(use Main)
(use Teller)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm620Code 0
	pBottomDoor 1
	pUpperDoor 2
	wasMusic3 3
)

(local
	local0
	local1
	local2
	local3
	local4
	[local5 2]
	local7
	local8
	local9
)

(instance rm620Code of Code
	(properties)

	(method (init)
		(if (< (gEgo y:) 64)
			(gEgo setScaler: Scaler 100 37 189 31)
			(= local3 1)
		else
			(gEgo setScaler: Scaler 100 37 189 31)
		)
		(if (!= (gCurRoom style:) 0)
			(= local4 1)
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PContainedAccess
						init: 226 32 237 38 250 51 260 66 261 81 253 108 233 136 180 163 108 184 63 202 63 157 0 168 0 189 62 204 113 187 189 164 262 128 276 93 267 58 233 32
						yourself:
					)
			)
			(gCurRoom
				addPoly:
					((Polygon new:)
						type: PNearestAccess
						init: 222 30 232 32 271 54 250 58
						yourself:
					)
					30
					((Polygon new:)
						type: PNearestAccess
						init: 250 58 272 55 284 106 250 104
						yourself:
					)
					40
					((Polygon new:)
						type: PNearestAccess
						init: 249 104 284 106 260 138 235 128
						yourself:
					)
					50
					((Polygon new:)
						type: PNearestAccess
						init: 75 180 236 128 260 139 121 189 67 189
						yourself:
					)
					90
					((Polygon new:)
						type: PNearestAccess
						init: 28 185 60 166 51 158 73 155 69 189 5 189
						yourself:
					)
					50
					((Polygon new:)
						type: PNearestAccess
						init: 0 163 20 157 51 158 59 166 28 186 0 189
						yourself:
					)
					90
			)
			(pBottomDoor
				setLoop: 1
				posn: 82 141
				setCel:
					(cond
						(local3 0)
						((== gPrevRoomNum 810) 0) ; combat
						(else 7)
					)
				approachX: 48
				approachY: 158
				approachVerbs: 4 32 ; Do, theOil
				init:
			)
			(pUpperDoor
				setLoop: 3
				setCel: (if local3 7 else 0)
				posn: 214 25
				approachX: 229
				approachY: 30
				ignoreActors:
				approachVerbs: 4 32 ; Do, theOil
				init:
			)
			(pTorch1
				setLoop: 1
				posn: 130 142
				setPri: 0
				approachVerbs: 4 ; Do
				setCycle: Fwd
				init:
			)
			(pTorch2
				setLoop: 5 1
				cel: 0
				posn: 230 54
				setPri: 0
				approachVerbs: 4 ; Do
				init:
				setCycle: Fwd
			)
			(pTorch3
				setLoop: 7
				posn: 85 150
				setPri: 0
				approachVerbs: 4 ; Do
				setCycle: Fwd
				init:
			)
			(pTorch4
				setLoop: 9
				posn: 179 117
				setPri: 0
				approachVerbs: 4 ; Do
				setCycle: Fwd
				init:
			)
			(pTorch5
				setLoop: 11
				posn: 213 105
				setPri: 0
				approachVerbs: 4 ; Do
				setCycle: Fwd
				init:
			)
			(pTorch6
				setLoop: 13
				posn: 22 121
				setPri: 0
				approachVerbs: 4 ; Do
				setCycle: Fwd
				init:
			)
			(hSconce1 init: approachVerbs: 4) ; Do
			(hSconce2 init: approachVerbs: 4) ; Do
			(hSconce3 init: approachVerbs: 4) ; Do
			(hSconce4 init: approachVerbs: 4) ; Do
			(hSconce5 init: approachVerbs: 4) ; Do
			(hSconce6 init: approachVerbs: 4) ; Do
			(hStair1 init:)
			(hStair2 init:)
		else
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PContainedAccess
						init: 79 38 74 39 53 54 41 100 49 118 128 166 197 189 261 204 319 189 319 175 283 163 280 158 257 165 261 202 246 187 241 186 199 184 130 161 81 130 63 106 56 75 63 55 92 32 81 32
						yourself:
					)
			)
			(gCurRoom
				addPoly:
					((Polygon new:)
						init: 43 107 71 103 85 130 134 156 92 149 51 128
						yourself:
					)
					80
					((Polygon new:)
						type: PTotalAccess
						init: 39 108 33 76 62 73 71 102
						yourself:
					)
					50
					((Polygon new:)
						type: PTotalAccess
						init: 32 76 47 49 72 52 63 74
						yourself:
					)
					40
					((Polygon new:)
						type: PTotalAccess
						init: 46 48 83 28 103 29 72 52
						yourself:
					)
					30
					((Polygon new:)
						type: PTotalAccess
						init: 319 163 319 188 307 187 264 171 258 166 270 158 296 158
						yourself:
					)
					90
					((Polygon new:)
						type: PTotalAccess
						init: 270 158 258 166 264 171 313 189 252 189 248 154 256 150 275 149 300 158
						yourself:
					)
					60
			)
			(pBottomDoor
				setCel:
					(cond
						(local3 0)
						((== gPrevRoomNum 810) 0) ; combat
						(else 7)
					)
				init:
				approachVerbs: 4 32 ; Do, theOil
			)
			(pUpperDoor setCel: (if local3 7 else 0) init: approachVerbs: 4 32) ; Do, theOil
			(pTorch1 approachVerbs: 4 setCycle: Fwd init:) ; Do
			(pTorch2 approachVerbs: 4 setCycle: Fwd init:) ; Do
			(pTorch3 approachVerbs: 4 setCycle: Fwd init:) ; Do
			(pTorch4 approachVerbs: 4 setCycle: Fwd init:) ; Do
			(pTorch5 approachVerbs: 4 setCycle: Fwd init:) ; Do
			(pTorch6 approachVerbs: 4 setCycle: Fwd init:) ; Do
			(fSconce1 init: approachVerbs: 4) ; Do
			(fSconce2 init: approachVerbs: 4) ; Do
			(fSconce3 init: approachVerbs: 4) ; Do
			(fSconce4 init: approachVerbs: 4) ; Do
			(fSconce5 init: approachVerbs: 4) ; Do
			(fSconce6 init: approachVerbs: 4) ; Do
			(dStair1 init:)
			(dStair2 init:)
		)
		(if (== gHeroType 2) ; Thief
			(if (== (= local0 (Random 1 4)) 3)
				(= local0 1)
			else
				(= local0 0)
			)
		)
		(if (< (gEgo y:) 65)
			(= local1 0)
		else
			(= local1 1)
		)
		(doorBottomTeller init: pBottomDoor 620 8 155 2)
		(if (and (== gCurRoomNum 627) gNight)
			(doorTopTeller init: pUpperDoor 620 8 155 5)
		else
			(doorTopTeller init: pUpperDoor 620 8 155 1)
		)
		(if (!= gPrevRoomNum 810) ; combat
			(gCurRoom setScript: sEnter)
		)
	)
)

(instance sEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= ticks 24)
			)
			(1
				(if local3
					(pUpperDoor ignoreActors: 1)
				else
					(pBottomDoor ignoreActors: 1)
				)
				(= ticks 12)
			)
			(2
				(if local3
					(gEgo ignoreActors: 1)
					(if local4
						(gEgo setMotion: MoveTo 252 44 self)
					else
						(gEgo setMotion: MoveTo 83 38 self)
					)
				else
					(gEgo ignoreActors: 1)
					(if local4
						(gEgo setMotion: MoveTo 48 170 self)
					else
						(gEgo setMotion: MoveTo 278 172 self)
					)
				)
			)
			(3
				(wasMusic3 number: 973 loop: 1 play:)
				(if local3
					(pUpperDoor setCycle: Beg self)
				else
					(pBottomDoor setCycle: Beg self)
				)
			)
			(4
				(gGlory handsOn:)
				(wasMusic3 stop: dispose:)
				(self dispose:)
			)
		)
	)
)

(instance sPeepingTom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(cond
					((!= (gCurRoom style:) 0)
						(if (< (gEgo y:) 64)
							(gEgo setLoop: 0)
						else
							(gEgo setLoop: 1)
						)
					)
					((< (gEgo y:) 64)
						(gEgo setLoop: 1)
					)
					(else
						(gEgo setLoop: 0)
					)
				)
				(gEgo view: 4 setCel: 0 setCycle: End self)
			)
			(1
				(cond
					((and (< (gEgo y:) 64) (== gCurRoomNum 620))
						(gMessager say: 8 155 32 1 self 620) ; "Through the keyhole you can see what appears to be a child's bedroom. A large (and dangerous-looking) ape-like creature sits near the door."
					)
					((and (< (gEgo y:) 64) (== gCurRoomNum 627) gNight)
						(gMessager say: 8 155 31 1 self 620) ; "You are looking into the castle Great Hall. The room is eerily lit by flickering flames from a fire, but you can't really make out much else from this angle."
					)
					(else
						(gMessager say: 8 155 27 1 self 620) ; "Peering through the keyhole, you see no threatening activity on the other side of the door."
					)
				)
			)
			(2
				(= seconds 3)
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(gEgo normalize:)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sListened2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gMessager say: 8 155 10 1 self 620) ; "Ignoring the voices, you fling the door open and stride through into the castle's great hall."
			)
			(1
				(wasMusic3 number: 972 setLoop: 1 play:)
				(pUpperDoor setCycle: CT 3 1 self)
			)
			(2
				(if (or (not (IsFlag 114)) (IsFlag 113))
					(wasMusic3 number: 143 setLoop: 1 play:)
					(gMessager say: 4 6 6 0 self 620) ; "The door's rusty hinges give out a SQUEAK as you open it."
				else
					(self cue:)
				)
			)
			(3
				(gLongSong2 stop:)
				(wasMusic3 stop: dispose:)
				(= cycles 5)
			)
			(4
				(Palette 2 66 85 100) ; PalIntensity
				(gCurRoom newRoom: 630)
			)
		)
	)
)

(instance sListened of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gMessager say: 8 155 9 1 self 620) ; "You carefully open the door just a little so you can hear better and look through the crack."
			)
			(1
				(wasMusic3 number: 972 setLoop: 1 play:)
				(pUpperDoor setCycle: CT 3 1 self)
			)
			(2
				(if (or (not (IsFlag 114)) (IsFlag 113))
					(wasMusic3 number: 143 setLoop: 1 play:)
					(gMessager say: 4 6 6 0 self 620) ; "The door's rusty hinges give out a SQUEAK as you open it."
				else
					(self cue:)
				)
			)
			(3
				(gLongSong2 stop:)
				(wasMusic3 stop: dispose:)
				(= cycles 5)
			)
			(4
				(Palette 2 66 85 100) ; PalIntensity
				(gCurRoom newRoom: 630)
			)
		)
	)
)

(instance sPickLock of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= seconds 2)
			)
			(1
				(cond
					(
						(and
							(or
								(and (IsFlag 222) (< (gEgo y:) 64))
								(and (IsFlag 220) (not (< (gEgo y:) 64)))
							)
							(== gCurRoomNum 620)
						)
						(self cue:)
					)
					(
						(and
							(or
								(and (IsFlag 221) (< (gEgo y:) 64))
								(and (IsFlag 223) (not (< (gEgo y:) 64)))
							)
							(== gCurRoomNum 621)
						)
						(self cue:)
					)
					(
						(and
							(or
								(and (IsFlag 216) (< (gEgo y:) 64))
								(and (IsFlag 215) (not (< (gEgo y:) 64)))
							)
							(== gCurRoomNum 624)
						)
						(self cue:)
					)
					(
						(and
							(or
								(and (IsFlag 214) (< (gEgo y:) 64))
								(and (IsFlag 207) (not (< (gEgo y:) 64)))
							)
							(== gCurRoomNum 625)
						)
						(self cue:)
					)
					(
						(and
							(not (IsFlag 517))
							(not (IsFlag 114))
							(== gCurRoomNum 627)
							(< (gEgo y:) 64)
						)
						(wasMusic3 number: 143 setLoop: 1 play:)
						(gMessager say: 4 6 6 0 self 620) ; "The door's rusty hinges give out a SQUEAK as you open it."
					)
					(
						(and
							(or
								(and (IsFlag 114) (< (gEgo y:) 64))
								(and (IsFlag 208) (not (< (gEgo y:) 64)))
							)
							(== gCurRoomNum 627)
						)
						(self cue:)
					)
					((and (IsFlag 118) (== gCurRoomNum 629))
						(self cue:)
					)
					(
						(and
							(or
								(and (IsFlag 212) (< (gEgo y:) 64))
								(and (IsFlag 211) (not (< (gEgo y:) 64)))
							)
							(== gCurRoomNum 632)
						)
						(self cue:)
					)
					(else
						(wasMusic3 number: 143 setLoop: 1 play:)
						(self cue:)
					)
				)
			)
			(2
				(if (== gCurRoomNum 629)
					(gMessager say: 6 6 23 0 self 620) ; "De Master is really somting, ain't she?"
				else
					(= ticks 12)
				)
			)
			(3
				(wasMusic3 number: 972 setLoop: 1 play:)
				(if (< (gEgo y:) 45)
					(pUpperDoor setCycle: End self)
				else
					(pBottomDoor setCycle: End self)
				)
			)
			(4
				(if (>= global422 300)
					(= global422 300)
				else
					(++ global422)
				)
				(= ticks 24)
			)
			(5
				(gLongSong2 stop:)
				(wasMusic3 stop: dispose:)
				(= cycles 5)
			)
			(6
				(Palette 2 66 85 100) ; PalIntensity
				(if (< (gEgo y:) 60)
					(gCurRoom newRoom: (gCurRoom north:))
				else
					(gCurRoom
						newRoom:
							(switch gCurRoomNum
								(620 640)
								(621 660)
								(624 643)
								(625 630)
								(627 662)
								(629 670)
								(632 644)
							)
					)
				)
			)
		)
	)
)

(instance sCastOpenDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo trySkill: 20) ; openSpell
				(= seconds 2)
			)
			(1
				(cond
					(
						(and
							(or
								(and (IsFlag 222) (< (gEgo y:) 64))
								(and (IsFlag 220) (not (< (gEgo y:) 64)))
							)
							(== gCurRoomNum 620)
						)
						(self cue:)
					)
					(
						(and
							(or
								(and (IsFlag 221) (< (gEgo y:) 64))
								(and (IsFlag 223) (not (< (gEgo y:) 64)))
							)
							(== gCurRoomNum 621)
						)
						(self cue:)
					)
					(
						(and
							(or
								(and (IsFlag 216) (< (gEgo y:) 64))
								(and (IsFlag 215) (not (< (gEgo y:) 64)))
							)
							(== gCurRoomNum 624)
						)
						(self cue:)
					)
					(
						(and
							(or
								(and (IsFlag 214) (< (gEgo y:) 64))
								(and (IsFlag 207) (not (< (gEgo y:) 64)))
							)
							(== gCurRoomNum 625)
						)
						(self cue:)
					)
					(
						(and
							(not (IsFlag 517))
							(not (IsFlag 114))
							(== gCurRoomNum 627)
							(< (gEgo y:) 64)
						)
						(wasMusic3 number: 143 setLoop: 1 play:)
						(gMessager say: 4 6 6 0 self 620) ; "The door's rusty hinges give out a SQUEAK as you open it."
					)
					(
						(and
							(or
								(and (IsFlag 114) (< (gEgo y:) 64))
								(and (IsFlag 208) (not (< (gEgo y:) 64)))
							)
							(== gCurRoomNum 627)
						)
						(self cue:)
					)
					((and (IsFlag 118) (== gCurRoomNum 629))
						(self cue:)
					)
					(
						(and
							(or
								(and (IsFlag 212) (< (gEgo y:) 64))
								(and (IsFlag 211) (not (< (gEgo y:) 64)))
							)
							(== gCurRoomNum 632)
						)
						(self cue:)
					)
					(else
						(wasMusic3 number: 143 setLoop: 1 play:)
						(self cue:)
					)
				)
			)
			(2
				(if (== gCurRoomNum 629)
					(gMessager say: 6 6 23 0 self 620) ; "De Master is really somting, ain't she?"
				else
					(= ticks 12)
				)
			)
			(3
				(wasMusic3 number: 972 setLoop: 1 play:)
				(if (== local1 0)
					(pUpperDoor setCycle: End self)
				else
					(pBottomDoor setCycle: End self)
				)
			)
			(4
				(if (>= global422 300)
					(= global422 300)
				else
					(++ global422)
				)
				(= ticks 24)
			)
			(5
				(gLongSong2 stop:)
				(wasMusic3 stop: dispose:)
				(= cycles 5)
			)
			(6
				(if (== local1 0)
					(gEgo
						setMotion:
							PolyPath
							(pUpperDoor approachX:)
							(pUpperDoor approachY:)
							self
					)
				else
					(gEgo
						setMotion:
							PolyPath
							(pBottomDoor approachX:)
							(pBottomDoor approachY:)
							self
					)
				)
			)
			(7
				(Palette 2 66 85 100) ; PalIntensity
				(if (== local1 0)
					(gCurRoom newRoom: (gCurRoom north:))
				else
					(gCurRoom
						newRoom:
							(switch gCurRoomNum
								(620 640)
								(621 660)
								(624 643)
								(625 630)
								(627 662)
								(629 670)
								(632 644)
							)
					)
				)
			)
		)
	)
)

(instance sDisplay of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (and gNight (== gCurRoomNum 627))
					(if (or local2 (IsFlag 112))
						(gGlory handsOn:)
						(self dispose:)
					else
						(gGlory handsOff:)
						(= local2 1)
						(gMessager say: 4 6 13 0 self 620) ; "You hear voices beyond the upper door. Two people seem to be having an argument in the next room."
					)
				else
					(self dispose:)
				)
			)
			(1
				(if (== gHeroType 3) ; Paladin
					(gMessager say: 4 6 14 0 self 620) ; "You feel an almost-overwhelming sense of danger beyond the upper door. Something -- or someone -- lies in wait there for the unwary."
				else
					(self cue:)
				)
			)
			(2
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance pBottomDoor of Prop
	(properties
		noun 2
		modNum 620
		sightAngle 180
		approachX 264
		approachY 155
		x 238
		y 143
		priority 34
		fixPriority 1
		view 620
	)

	(method (doVerb theVerb)
		(switch theVerb
			(42 ; theToolkit
				(gEgo trySkill: 9 global422) ; pick locks
				(gEgo trySkill: 9 global422) ; pick locks
				(if (== (gEgo trySkill: 9 global422) 1) ; pick locks
					(pBottomDoor setScript: sPickLock)
				else
					(gMessager say: 2 42 25 1 0 620) ; "You need more practice at this. You'd swear these doors are getting tougher as you go."
				)
			)
			(32 ; theOil
				(switch gCurRoomNum
					(620
						(SetFlag 220)
					)
					(621
						(SetFlag 223)
					)
					(624
						(SetFlag 215)
					)
					(625
						(SetFlag 207)
					)
					(627
						(SetFlag 208)
					)
					(632
						(IsFlag 211)
					)
				)
				(super doVerb: theVerb)
			)
			(-80 ; openSpell (part 2)
				(= local1 1)
				(gCurRoom setScript: sCastOpenDoor)
			)
			(80 ; openSpell
				(= global441 ((User curEvent:) x:))
				(= global442 ((User curEvent:) y:))
				(gCurRoom setScript: (ScriptID 13) 0 self) ; castOpenScript
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pUpperDoor of Prop
	(properties
		noun 1
		modNum 620
		sightAngle 180
		approachX 92
		approachY 32
		x 107
		y 24
		view 620
		loop 2
	)

	(method (init)
		(super init: &rest)
		(= heading
			(((ScriptID 49 0) new:) ; doorMat
				init:
					((Polygon new:)
						type: PNearestAccess
						init: 97 31 87 42 69 39 79 31
						yourself:
					)
					3
					6
					7
					sDisplay
				yourself:
			)
		)
	)

	(method (dispose)
		(if heading
			(heading dispose:)
		)
		(super dispose: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(42 ; theToolkit
				(if (and gNight (== gCurRoomNum 627))
					(SetFlag 113)
					(pUpperDoor setScript: sListened)
				else
					(gEgo trySkill: 9 global422) ; pick locks
					(gEgo trySkill: 9 global422) ; pick locks
					(if (== (gEgo trySkill: 9 global422) 1) ; pick locks
						(pUpperDoor setScript: sPickLock)
					else
						(gMessager say: 2 42 25 1 0 620) ; "You need more practice at this. You'd swear these doors are getting tougher as you go."
					)
				)
			)
			(32 ; theOil
				(switch gCurRoomNum
					(620
						(SetFlag 222)
					)
					(621
						(SetFlag 221)
					)
					(624
						(SetFlag 216)
					)
					(625
						(SetFlag 214)
					)
					(627
						(SetFlag 114)
						(gEgo solvePuzzle: 517 2 4)
					)
					(629
						(SetFlag 118)
					)
					(632
						(IsFlag 212)
					)
				)
				(super doVerb: theVerb)
			)
			(-80 ; openSpell (part 2)
				(= local1 0)
				(gCurRoom setScript: sCastOpenDoor)
			)
			(80 ; openSpell
				(= global441 ((User curEvent:) x:))
				(= global442 ((User curEvent:) y:))
				(gCurRoom setScript: (ScriptID 13) 0 self) ; castOpenScript
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pTorch1 of Prop
	(properties
		noun 3
		modNum 620
		sightAngle 180
		x 140
		y 117
		view 621
		loop 8
		cel 3
		detailLevel 2
	)

	(method (doit)
		(super doit:)
		(if (> (gEgo y:) 140)
			(= local9 1)
		else
			(= local9 0)
		)
		(= local7 ((User curEvent:) x:))
		(= local8 ((User curEvent:) y:))
		(if (> (gGlory detailLevel:) 1)
			(cond
				((OneOf cel 1 2)
					(if (< (GetDistance x y (gEgo x:) (gEgo y:) 0) 45)
						(Palette 2 66 85 88) ; PalIntensity
					)
				)
				((OneOf cel 0 5)
					(if (< (GetDistance x y (gEgo x:) (gEgo y:) 0) 45)
						(Palette 2 66 85 62) ; PalIntensity
					)
				)
				(else
					(Palette 2 66 85 75) ; PalIntensity
				)
			)
		)
	)
)

(instance pTorch2 of Prop
	(properties
		noun 3
		modNum 620
		sightAngle 180
		x 89
		y 55
		view 621
		loop 4
		cel 5
		detailLevel 2
	)

	(method (doit)
		(super doit:)
		(if (> (gGlory detailLevel:) 1)
			(cond
				((OneOf cel 1 2)
					(if (< (GetDistance x y (gEgo x:) (gEgo y:) 0) 45)
						(Palette 2 66 85 88) ; PalIntensity
					)
				)
				((OneOf cel 0 5)
					(if (< (GetDistance x y (gEgo x:) (gEgo y:) 0) 45)
						(Palette 2 66 85 62) ; PalIntensity
					)
				)
				(else
					(Palette 2 66 85 75) ; PalIntensity
				)
			)
		)
	)
)

(instance pTorch3 of Prop
	(properties
		noun 3
		modNum 620
		sightAngle 180
		x 234
		y 150
		view 621
		loop 6
		cel 3
		detailLevel 2
	)

	(method (doit)
		(super doit:)
		(if (> (gGlory detailLevel:) 1)
			(cond
				((OneOf cel 1 2)
					(if (< (GetDistance x y (gEgo x:) (gEgo y:) 0) 45)
						(Palette 2 66 85 88) ; PalIntensity
					)
				)
				((OneOf cel 0 5)
					(if (< (GetDistance x y (gEgo x:) (gEgo y:) 0) 45)
						(Palette 2 66 85 62) ; PalIntensity
					)
				)
				(else
					(Palette 2 66 85 75) ; PalIntensity
				)
			)
		)
	)
)

(instance pTorch4 of Prop
	(properties
		noun 3
		modNum 620
		sightAngle 180
		x 189
		y 142
		view 621
		detailLevel 2
	)

	(method (doit)
		(super doit:)
		(if (> (gGlory detailLevel:) 1)
			(cond
				((OneOf cel 1 2)
					(if (< (GetDistance x y (gEgo x:) (gEgo y:) 0) 45)
						(Palette 2 66 85 88) ; PalIntensity
					)
				)
				((OneOf cel 0 5)
					(if (< (GetDistance x y (gEgo x:) (gEgo y:) 0) 45)
						(Palette 2 66 85 62) ; PalIntensity
					)
				)
				(else
					(Palette 2 66 85 75) ; PalIntensity
				)
			)
		)
	)
)

(instance pTorch5 of Prop
	(properties
		noun 3
		modNum 620
		sightAngle 180
		x 106
		y 104
		view 621
		loop 10
		detailLevel 2
	)

	(method (doit)
		(super doit:)
		(if (> (gGlory detailLevel:) 1)
			(cond
				((OneOf cel 1 2)
					(if (< (GetDistance x y (gEgo x:) (gEgo y:) 0) 45)
						(Palette 2 66 85 88) ; PalIntensity
					)
				)
				((OneOf cel 0 5)
					(if (< (GetDistance x y (gEgo x:) (gEgo y:) 0) 45)
						(Palette 2 66 85 62) ; PalIntensity
					)
				)
				(else
					(Palette 2 66 85 75) ; PalIntensity
				)
			)
		)
	)
)

(instance pTorch6 of Prop
	(properties
		noun 3
		modNum 620
		sightAngle 180
		x 298
		y 119
		view 621
		loop 12
		detailLevel 2
	)

	(method (doit)
		(super doit:)
		(if (> (gGlory detailLevel:) 1)
			(cond
				((OneOf cel 1 2)
					(if (< (GetDistance x y (gEgo x:) (gEgo y:) 0) 45)
						(Palette 2 66 85 88) ; PalIntensity
					)
				)
				((OneOf cel 0 5)
					(if (< (GetDistance x y (gEgo x:) (gEgo y:) 0) 45)
						(Palette 2 66 85 62) ; PalIntensity
					)
				)
				(else
					(Palette 2 66 85 75) ; PalIntensity
				)
			)
		)
	)
)

(instance fSconce1 of Feature
	(properties
		noun 3
		modNum 620
		nsLeft 87
		nsTop 48
		nsRight 94
		nsBottom 59
		sightAngle 180
		x 90
		y 53
	)
)

(instance fSconce2 of Feature
	(properties
		noun 3
		modNum 620
		nsLeft 100
		nsTop 101
		nsRight 110
		nsBottom 126
		sightAngle 180
		x 105
		y 113
	)
)

(instance fSconce3 of Feature
	(properties
		noun 3
		modNum 620
		nsLeft 134
		nsTop 113
		nsRight 146
		nsBottom 137
		sightAngle 180
		x 140
		y 125
	)
)

(instance fSconce4 of Feature
	(properties
		noun 3
		modNum 620
		nsLeft 182
		nsTop 133
		nsRight 193
		nsBottom 158
		sightAngle 180
		x 187
		y 145
	)
)

(instance fSconce5 of Feature
	(properties
		noun 3
		modNum 620
		nsLeft 232
		nsTop 143
		nsRight 241
		nsBottom 169
		sightAngle 180
		x 236
		y 156
	)
)

(instance fSconce6 of Feature
	(properties
		noun 3
		modNum 620
		nsLeft 295
		nsTop 114
		nsRight 309
		nsBottom 135
		sightAngle 180
		x 302
		y 124
	)
)

(instance dStair1 of Feature
	(properties
		noun 3
		modNum 620
		nsLeft 243
		nsTop 184
		nsRight 262
		nsBottom 189
		sightAngle 180
		x 245
		y 184
	)
)

(instance dStair2 of Feature
	(properties
		modNum 620
		nsLeft 63
		nsTop 128
		nsRight 138
		nsBottom 93
		sightAngle 180
		x 65
		y 134
	)
)

(instance hStair1 of Feature
	(properties
		modNum 620
		nsLeft 57
		nsTop 182
		nsRight 80
		nsBottom 189
		sightAngle 180
		x 57
		y 184
	)
)

(instance hStair2 of Feature
	(properties
		modNum 620
		nsLeft 218
		nsTop 130
		nsRight 269
		nsBottom 141
		sightAngle 180
		x 130
		y 218
	)
)

(instance hSconce1 of Feature
	(properties
		noun 3
		modNum 620
		nsLeft 71
		nsTop 129
		nsRight 92
		nsBottom 175
		sightAngle 180
		x 81
		y 139
	)
)

(instance hSconce2 of Feature
	(properties
		noun 3
		modNum 620
		nsLeft 121
		nsTop 131
		nsRight 136
		nsBottom 173
		sightAngle 180
		x 128
		y 152
	)
)

(instance hSconce3 of Feature
	(properties
		noun 3
		modNum 620
		nsLeft 171
		nsTop 113
		nsRight 183
		nsBottom 138
		sightAngle 180
		x 177
		y 125
	)
)

(instance hSconce4 of Feature
	(properties
		noun 3
		modNum 620
		nsLeft 204
		nsTop 101
		nsRight 216
		nsBottom 128
		sightAngle 180
		x 210
		y 114
	)
)

(instance hSconce5 of Feature
	(properties
		noun 3
		modNum 620
		nsLeft 15
		nsTop 113
		nsRight 22
		nsBottom 132
		sightAngle 180
		x 18
		y 122
	)
)

(instance hSconce6 of Feature
	(properties
		noun 3
		modNum 620
		nsLeft 53
		nsTop 128
		nsRight 58
		nsBottom 140
		sightAngle 180
		x 55
		y 134
	)
)

(instance doorBottomTeller of Teller
	(properties
		modNum 620
		actionVerb 4
	)

	(method (showCases)
		(super
			showCases:
				4 ; Pick Lock
				(and (gEgo has: 24) (> [gEgoStats 9] 0) local0) ; theToolkit, pick locks
				1 ; Open Door
				(or (== local0 0) (== local1 1))
				26 ; Open Door
				(and (== local0 1) (== local1 0))
		)
	)

	(method (sayMessage)
		(switch iconValue
			(4 ; Pick Lock
				(gEgo trySkill: 9 global422) ; pick locks
				(gEgo trySkill: 9 global422) ; pick locks
				(if (== (gEgo trySkill: 9 global422) 1) ; pick locks
					(self clean:)
					(pBottomDoor setScript: sPickLock)
				else
					(gMessager say: 2 42 25 0 0 620) ; "You need more practice at this. You'd swear these doors are getting tougher as you go."
				)
			)
			(1 ; Open Door
				(self clean:)
				(pBottomDoor setScript: sPickLock)
			)
			(27 ; Peer Through Keyhole
				(self clean:)
				(pBottomDoor setScript: sPeepingTom)
			)
			(else
				(super sayMessage:)
			)
		)
	)
)

(instance doorTopTeller of Teller
	(properties
		modNum 620
		actionVerb 4
	)

	(method (showCases)
		(super
			showCases:
				4 ; Pick Lock
				(and (gEgo has: 24) (> [gEgoStats 9] 0) local0) ; theToolkit, pick locks
				12 ; Pick Lock
				(and (gEgo has: 24) (> [gEgoStats 9] 0) local0) ; theToolkit, pick locks
				1 ; Open Door
				(or (== local0 0) (== local1 0))
				26 ; Open Door
				(and (== local0 1) (== local1 1))
		)
	)

	(method (sayMessage)
		(switch iconValue
			(9 ; Listen at Door
				(self clean:)
				(pUpperDoor setScript: sListened)
			)
			(4 ; Pick Lock
				(if (and gNight (== gCurRoomNum 627))
					(self clean:)
					(SetFlag 113)
					(pUpperDoor setScript: sListened)
				else
					(gEgo trySkill: 9 global422) ; pick locks
					(gEgo trySkill: 9 global422) ; pick locks
					(if (== (gEgo trySkill: 9 global422) 1) ; pick locks
						(self clean:)
						(pUpperDoor setScript: sPickLock)
					else
						(gMessager say: 2 42 25 0 self 620) ; "You need more practice at this. You'd swear these doors are getting tougher as you go."
					)
				)
			)
			(12 ; Pick Lock
				(if (and gNight (== gCurRoomNum 627))
					(SetFlag 113)
					(self clean:)
					(pUpperDoor setScript: sListened)
				else
					(gEgo trySkill: 9 global422) ; pick locks
					(gEgo trySkill: 9 global422) ; pick locks
					(if (== (gEgo trySkill: 9 global422) 1) ; pick locks
						(self clean:)
						(pUpperDoor setScript: sPickLock)
					else
						(gMessager say: 2 42 25 0 self 620) ; "You need more practice at this. You'd swear these doors are getting tougher as you go."
					)
				)
			)
			(27 ; Peer Through Keyhole
				(self clean:)
				(pUpperDoor setScript: sPeepingTom)
			)
			(1 ; Open Door
				(if (and gNight (== gCurRoomNum 627))
					(SetFlag 113)
					(self clean:)
					(pUpperDoor setScript: sListened)
				else
					(self clean:)
					(pUpperDoor setScript: sPickLock)
				)
			)
			(10 ; Open Door
				(if (and gNight (== gCurRoomNum 627))
					(SetFlag 113)
					(self clean:)
					(pUpperDoor setScript: sListened2)
				else
					(self clean:)
					(pUpperDoor setScript: sPickLock)
				)
			)
			(11 ; Knock on Door
				(SetFlag 113)
				(self clean:)
				(pUpperDoor setScript: sListened)
			)
			(3 ; Listen at Door
				(if (and (not (IsFlag 115)) (== gCurRoomNum 620))
					(gMessager say: 8 155 36 0 self 620) ; "You hear heavy breathing beyond the door. It reminds you of a hibernating bear."
				else
					(super sayMessage:) ; You put your ear up against the door and listen. You don't hear anything.
				)
			)
			(else
				(super sayMessage:)
			)
		)
	)
)

(instance wasMusic3 of Sound
	(properties)
)

