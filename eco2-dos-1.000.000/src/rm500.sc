;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 500)
(include sci.sh)
(use Main)
(use ExitFeature)
(use Cibola)
(use ROsc)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use DPath)
(use Sound)
(use Jump)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm500 0
)

(local
	local0
	local1
)

(instance rm500 of Rm
	(properties
		noun 11
		picture 500
		style 10
		south 501
	)

	(method (init &tmp temp0 temp1 temp2 temp3)
		(LoadMany rsVIEW 500 1009 1059 52)
		(Load rsMESSAGE 500)
		(gEgo posn: 84 112 init: normalize: 0 setScale: 0)
		(if (!= gPrevRoomNum 501)
			(gGameSound1 fade:)
			(gGameSound2 fade:)
		)
		(super init:)
		(= temp0 (gCurrentRegionFlags test: 11))
		(= temp1 (gCurrentRegionFlags test: 4))
		(= temp2 (gCurrentRegionFlags test: 23))
		(= temp3 (gCurrentRegionFlags test: 9))
		(if (!= (gGameSound1 number:) 522)
			(gGameSound1 number: 522 loop: -1 play: 127)
		)
		(if temp2
			(pelt posn: 191 145 setCel: 0 init: approachVerbs: 4 1 stopUpd:) ; Do, Look
			(gCurrentRegionFlags clear: 4)
			(= temp1 0)
			(jagSquash init:)
			(suitcase setCel: 0 init: approachVerbs: 4 1 stopUpd:) ; Do, Look
			(gCurrentRegionFlags clear: 2)
			(cond
				(temp3
					(bundle init: approachVerbs: 4 1) ; Do, Look
					(gCurrentRegionFlags clear: 9)
					(= temp3 0)
				)
				((not (gEgo has: 17))
					(if (gCurrentRegionFlags test: 8)
						(bundle init: approachVerbs: 4 1) ; Do, Look
					else
						(theTopSheet init:)
					)
				)
				((and (not ((gInventory at: 17) cel:)) (not (gEgo has: 18)))
					(theBottomSheet init:)
				)
			)
			(pillow posn: 213 109 init: approachVerbs: 4 stopUpd:) ; Do
			(gCurrentRegionFlags clear: 11)
			(= temp0 0)
		else
			(pelt
				x: (if temp1 164 else 191)
				y: (if temp1 158 else 145)
				setCel:
					(if temp1
						(pelt lastCel:)
					else
						0
					)
				init:
				approachVerbs: 4 1 ; Do, Look
				stopUpd:
			)
			(if (not temp1)
				(jagSquash init:)
			)
			(suitcase
				approachVerbs: 4 1 ; Do, Look
				setCel: (if (gCurrentRegionFlags test: 2) 1 else 0)
				init:
				stopUpd:
			)
			(pillow
				x: (if temp0 186 else 213)
				y: (if temp0 117 else 109)
				init:
				approachVerbs: 4 ; Do
				stopUpd:
			)
			(if (not temp3)
				(cond
					((not (gEgo has: 17))
						(theTopSheet init:)
					)
					((and (not ((gInventory at: 17) cel:)) (not (gEgo has: 18)))
						(theBottomSheet init:)
					)
				)
			)
		)
		(jagHead
			setLoop: (if (== (pelt x:) 191) 11 else 12)
			x:
				(if (pelt cel:)
					(- (pelt x:) 26)
				else
					(- (pelt x:) 12)
				)
			y: (+ (pelt y:) 1)
			z: 10
			init:
			stopUpd:
		)
		(if (not (gEgo has: 21))
			(theOrganizer init: approachVerbs: 4 1 stopUpd:) ; Do, Look
		)
		(floorboard
			setCel:
				(if (gCurrentRegionFlags test: 7)
					(floorboard lastCel:)
				else
					0
				)
			noun: (if (gCurrentRegionFlags test: 7) 14 else 4)
			approachVerbs: 4 1 ; Do, Look
			init:
			stopUpd:
		)
		(if (gEgo has: 9)
			(faxMachine init: approachVerbs: 4 1 stopUpd:) ; Do, Look
		else
			(faxMachine
				setCel:
					(if (gCurrentRegionFlags test: 13)
						(faxMachine lastCel:)
					else
						0
					)
				init:
				approachVerbs: 4 1 ; Do, Look
				stopUpd:
				setScript: (if (gCurrentRegionFlags test: 13) 0 else sFaxComes)
			)
		)
		(if (and (gCurrentRegionFlags test: 2) (not (gEgo has: 16)))
			(theRacquet init: approachVerbs: 4 1) ; Do, Look
		)
		(if (not (gEgo has: 11))
			(cond
				((gCurrentRegionFlags test: 5)
					(paper posn: 175 159 loop: 14 cel: 1 init: stopUpd:)
				)
				((gCurrentRegionFlags test: 6)
					(paper posn: 144 165 loop: 14 cel: 1 init: stopUpd:)
				)
			)
		)
		(if temp3
			(aRope setCel: (aRope lastCel:) init:)
		)
		(if (gCurrentRegionFlags test: 12)
			(sTvSound number: 527 loop: -1 play: 127)
			(tele setCycle: ROsc -1 0 3 init:)
		)
		(calendar addToPic:)
		(safe approachVerbs: 1 addToPic:) ; Look
		(bed addToPic: approachVerbs: 4 1) ; Do, Look
		(table addToPic:)
		(slippers init: stopUpd:)
		(stool addToPic:)
		(stuffedanimal addToPic:)
		(bookshelf addToPic:)
		(gorillahand addToPic:)
		(netting addToPic:)
		(cond
			((gCurrentRegionFlags test: 7)
				(if temp1
					(self
						addObstacle:
							(jagPoly
								init: 160 159 135 159 135 142 152 142
								yourself:
							)
							(changePoly
								init: 99 118 71 146 64 146 64 162 205 162 205 189 0 189 0 0 319 0 319 189 257 189 257 159 239 159 239 150 259 150 258 137 242 134 231 132 231 129 224 133 197 137 163 144 133 134 168 118 184 123 166 110 160 111 117 120
								yourself:
							)
					)
				else
					(self
						addObstacle:
							(changePoly
								init: 99 118 71 146 64 146 64 162 205 162 205 189 0 189 0 0 319 0 319 189 257 189 257 159 239 159 239 150 259 150 258 137 242 134 231 132 231 129 224 133 202 140 182 150 164 131 164 115 184 123 166 110 160 111 117 120
								yourself:
							)
					)
				)
			)
			(temp1
				(self
					addObstacle:
						(jagPoly
							init: 160 159 135 159 135 142 152 142
							yourself:
						)
						(changePoly
							init: 99 118 71 146 64 146 64 162 205 162 205 189 0 189 0 0 319 0 319 189 257 189 257 159 239 159 239 150 259 150 258 137 242 134 231 132 231 129 224 133 202 140 164 131 164 115 184 123 166 110 160 111 117 120
							yourself:
						)
				)
			)
			(else
				(self
					addObstacle:
						(changePoly
							init: 99 118 71 146 64 146 64 162 205 162 205 189 0 189 0 0 319 0 319 189 257 189 257 159 239 159 239 150 259 150 258 137 242 134 231 132 231 129 224 133 202 140 182 150 164 131 164 115 184 123 166 110 160 111 117 120
							yourself:
						)
				)
			)
		)
		(ceiling init: setOnMeCheck: 1 8)
		(floor init: setOnMeCheck: 1 16)
		(doorExit init: setOnMeCheck: 1 2)
		(wall init: setOnMeCheck: 1 4)
		(if (or (gCast contains: paper) (not (gEgo has: 11)))
			(jagTail approachVerbs: 4 init:) ; Do
		)
		(southExit init:)
		(gKeyDownHandler addToFront: doorExit)
		(gMouseDownHandler addToFront: doorExit)
		(switch gPrevRoomNum
			(501
				(self setScript: sFromShackCell)
			)
			(530
				(if (gCurrentRegionFlags test: 10)
					(self setScript: sFromWestCamp)
				else
					(self setScript: sFromDoor)
				)
			)
			(else
				(self setScript: sFromWestCamp)
			)
		)
		(gCurrentRegionFlags clear: 10 23)
	)

	(method (doit)
		(super doit:)
		(cond
			((gEgo inRect: 175 118 186 124)
				(if (not local0)
					(= local0 1)
					(gEgo setPri: 7)
				)
			)
			(local0
				(= local0 0)
				(gEgo setPri: -1)
			)
		)
		(if (not (gCurrentRegionFlags test: 4))
			(cond
				((jagSquash onMe: gEgo)
					(if (not local1)
						(= local1 1)
						(pelt startUpd: view: 500 loop: 6 cel: 2)
						(sLocalSound number: 509 loop: 1 play: 127)
						(gEgo z: -2)
					)
				)
				(local1
					(= local1 0)
					(pelt view: 500 loop: 2 cel: 0 stopUpd:)
					(gEgo z: 0)
				)
			)
		)
	)

	(method (dispose)
		(gCurrentRegionFlags set: 13)
		(LoadMany 0 503 938 505)
		(gKeyDownHandler delete: doorExit)
		(gMouseDownHandler delete: doorExit)
		(sLocalSound dispose:)
		(sLocalSound2 dispose:)
		(sTvSound dispose:)
		(super dispose:)
	)
)

(instance sOpenSafe of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setMotion: PolyPath (safe approachX:) (safe approachY:) self
				)
			)
			(1
				(gCast eachElementDo: #stopUpd)
				(= seconds 2)
			)
			(2
				(sLocalSound2 stop:)
				(gCast eachElementDo: #hide)
				(gCurRoom drawPic: 888 9)
				(= cycles 10)
			)
			(3
				(gCurRoom setInset: (ScriptID 503 0) self) ; safeDial
			)
			(4
				(if (gCurrentRegionFlags test: 1)
					(gGame points: 10 9)
					(self cue:)
				else
					(+= state 1)
					(self cue:)
				)
			)
			(5
				(gCurRoom setInset: (ScriptID 503 1) self) ; safeInside
			)
			(6
				(gCurRoom drawPic: (gCurRoom picture:))
				(gCast eachElementDo: #show)
				(calendar addToPic:)
				(safe approachVerbs: 4 1 addToPic:) ; Do, Look
				(bed addToPic: approachVerbs: 4 1) ; Do, Look
				(table addToPic:)
				(stool addToPic:)
				(stuffedanimal addToPic:)
				(bookshelf addToPic:)
				(gorillahand addToPic:)
				(netting addToPic:)
				(if (gCurrentRegionFlags test: 1)
					(sLocalSound number: 520 loop: 1 play: 127)
				)
				(= cycles 15)
			)
			(7
				(DisposeScript 503)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sJagBarfs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo view: 5 loop: 2 cel: 0 setCycle: CT 3 1 self)
			)
			(1
				(if (gCurrentRegionFlags test: 4)
					(gCurrentRegionFlags set: 6)
				else
					(gCurrentRegionFlags set: 5)
				)
				(jagHead
					view: 500
					setLoop: (if (== (pelt x:) 191) 11 else 12)
					x:
						(if (pelt cel:)
							(- (pelt x:) 26)
						else
							(- (pelt x:) 12)
						)
					y: (+ (pelt y:) 1)
					z: 10
					setCycle: CT 3 1 self
				)
			)
			(2
				(sLocalSound number: 514 loop: 1 play: 127)
				(paper
					x: (+ (jagHead x:) 6)
					y: (- (+ (jagHead y:) 16) (jagHead z:))
					init:
					setCycle: End self
				)
				(jagHead setCycle: End self)
			)
			(3)
			(4
				(gMessager say: 11 0 0 1 self) ; "Ptui!"
				(gEgo setCycle: End self)
				(paper setLoop: 14 cel: 1)
			)
			(5
				(gGame points: 3)
				(gEgo normalize: 0 2)
				(paper stopUpd:)
				(jagHead dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGetBundle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 135 self)
			)
			(1
				(gEgo view: 4 cel: 0 setCycle: CT 2 1 self)
			)
			(2
				(bundle dispose:)
				(gEgo get: 17 setCycle: End self)
			)
			(3
				((gInventory at: 17) cel: 2 name: {rope} message: 5 noun: 15)
				(gEgo normalize: 0 setPri: 7)
				(gGame handsOn:)
			)
		)
	)
)

(instance sMovePillow of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (or (!= (gEgo x:) 184) (!= (gEgo y:) 123))
					(gEgo setMotion: PolyPath 184 123 self)
				else
					(self cue:)
				)
			)
			(1
				(gEgo setHeading: 135 self)
			)
			(2
				(gEgo view: 513 loop: 0 setCel: 0 setCycle: CT 4 1 self)
			)
			(3
				(pillow setMotion: JumpTo 186 117 self)
				(gEgo setCel: 1 setCycle: CT 0 -1 self)
				(gCurrentRegionFlags set: 11)
				(if (not (gEgo has: 21))
					(theOrganizer init: approachVerbs: 4 1 stopUpd:) ; Do, Look
				)
			)
			(4)
			(5
				(pillow stopUpd:)
				(gEgo normalize: 0 4 setPri: 7)
				(= cycles 1)
			)
			(6
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGetOrganizer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (or (!= (gEgo x:) 184) (!= (gEgo y:) 123))
					(gEgo setMotion: PolyPath 184 123 self)
				else
					(= cycles 1)
				)
			)
			(1
				(gEgo setHeading: 135 self)
			)
			(2
				(gEgo view: 513 loop: 0 cel: 0 setCycle: CT 4 1 self)
			)
			(3
				(theOrganizer dispose:)
				(gEgo get: 21 setCel: 1 setCycle: CT 0 -1 self)
			)
			(4
				(gGame points: 2)
				(gEgo normalize: 0 4 setPri: 7)
				(= cycles 1)
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGetSheet of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (or (!= (gEgo x:) 184) (!= (gEgo y:) 123))
					(gEgo setMotion: PolyPath 184 123 self)
				else
					(self cue:)
				)
			)
			(1
				(gEgo view: 513 setLoop: 0 setCel: 0 setCycle: CT 3 1 self)
				(if (== register theTopSheet)
					(theBottomSheet init:)
					(gEgo get: 17)
					(gGame points: 2)
				else
					(gEgo get: 18)
					(gGame points: 5)
				)
				(pillow startUpd: y: (- (pillow y:) 2))
			)
			(2
				(sLocalSound number: 517 loop: 1 play: 127)
				(register view: 513 loop: 1 setCycle: CT 3 1 self)
				(gEgo setCycle: CT 6 1 self)
				(pillow y: (+ (pillow y:) 2))
			)
			(3)
			(4
				(pillow stopUpd:)
				(gEgo setPri: 6 setCycle: CT 7 1 self)
				(register setPri: 7 setCycle: CT 4 1 self)
			)
			(5)
			(6
				(register setCycle: CT 6 1 self)
			)
			(7
				(gEgo loop: 8 cel: 4 normalize: 0 setPri: 7)
				(register dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sPullRug of Script
	(properties)

	(method (doit)
		(super doit:)
		(gEgo x: (- (pelt x:) 58) y: (+ (pelt y:) 1))
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(jagSquash dispose:)
				(jagHead dispose:)
				(changePoly dispose:)
				(gEgo loop: 8 cel: 6)
				(= cycles 1)
			)
			(1
				(gEgo view: 513 setLoop: 3 cel: 0 setCycle: CT 2 1 self)
			)
			(2
				(pelt
					moveSpeed: (gEgo moveSpeed:)
					cycleSpeed: (gEgo cycleSpeed:)
					setStep: (gEgo xStep:) (gEgo yStep:)
					setCycle: CT 4 1 self
				)
				(gEgo setCycle: CT 6 1 self)
				(sLocalSound number: 513 loop: -1 play: 127)
			)
			(3)
			(4
				(gEgo loop: 9 cel: 0 setCycle: Fwd)
				(pelt setMotion: MoveTo 164 158 self)
			)
			(5
				(sLocalSound stop:)
				(pelt stopUpd:)
				(gEgo loop: 3 cel: 6 setCycle: Beg self)
			)
			(6
				(gCurRoom
					addObstacle:
						(jagPoly
							init: 160 159 135 159 135 142 160 142
							yourself:
						)
				)
				(= cycles 1)
			)
			(7
				(if (gCurrentRegionFlags test: 7)
					(gCurRoom
						addObstacle:
							(changePoly
								init: 99 118 71 146 64 146 64 162 205 162 205 189 0 189 0 0 319 0 319 189 257 189 257 159 239 159 239 150 259 150 258 137 242 134 231 132 231 129 224 133 197 137 163 144 133 134 168 118 184 123 166 110 160 111 117 120
								yourself:
							)
					)
				else
					(gCurRoom
						addObstacle:
							(changePoly
								init: 99 118 71 146 64 146 64 162 205 162 205 189 0 189 0 0 319 0 319 189 257 189 257 159 239 159 239 150 259 150 258 137 242 134 231 132 231 129 224 133 202 140 164 131 164 115 184 123 166 110 160 111 117 120
								yourself:
							)
					)
				)
				(= cycles 1)
			)
			(8
				(gEgo view: 0 loop: 8 cel: 6 normalize:)
				(jagHead
					setLoop: (if (== (pelt x:) 191) 11 else 12)
					x:
						(if (pelt cel:)
							(- (pelt x:) 26)
						else
							(- (pelt x:) 12)
						)
					y: (+ (pelt y:) 1)
					z: 10
					init:
					stopUpd:
				)
				(gGame points: 3 8)
				(gCurrentRegionFlags set: 4)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sAdamMovesBoard of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo loop: 8 cel: 6)
				(= cycles 1)
			)
			(1
				(gEgo view: 513 loop: 2 setCycle: CT 2 1 self)
			)
			(2
				(floorboard setCycle: End self)
				(sLocalSound number: 515 loop: 1 play: 127)
				(gEgo setCycle: End self)
				(changePoly dispose:)
			)
			(3)
			(4
				(gEgo view: 0 loop: 8 cel: 6 normalize:)
				(gCurRoom
					addObstacle:
						(changePoly
							init: 99 118 71 146 64 146 64 162 205 162 205 189 0 189 0 0 319 0 319 189 257 189 257 159 239 159 239 150 259 150 258 137 242 134 231 132 231 129 224 133 197 137 163 144 133 134 168 118 184 123 166 110 160 111 117 120
							yourself:
						)
				)
				(gCurrentRegionFlags set: 7)
				(gGame points: 10)
				(floorboard noun: 14 stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sEscapeWithRope of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 156 142 self)
			)
			(1
				(cond
					((gCurrentRegionFlags test: 14)
						(= cycles 1)
					)
					((gCurrentRegionFlags test: 16)
						(= cycles 1)
					)
					(else
						(switch (Cibola timesCaptured:)
							(0
								(gMessager say: 11 2 14 0 self) ; "Ah, this is exciting! We are escaping, yes?"
							)
							(1
								(gMessager say: 11 2 15 0 self) ; "Be more careful, that Gonzales is a nasty customer. I do not care for the look on his face!"
							)
							(else
								(gMessager say: 11 2 13 0 self) ; "Do not forget to give me the big signal when you have gotten rid of the big guy."
							)
						)
					)
				)
			)
			(2
				(if (not (gCurrentRegionFlags test: 19))
					(gGame points: 2)
				)
				(gEgo view: 513 loop: 10 cel: 0 setCycle: CT 5 1 self)
			)
			(3
				(gCurrentRegionFlags set: 10)
				(gCurRoom newRoom: 530)
				(self dispose:)
			)
		)
	)
)

(instance sEnterWestCamp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 84 121 self)
			)
			(1
				(cond
					((gCurrentRegionFlags test: 14)
						(= cycles 1)
					)
					((gCurrentRegionFlags test: 16)
						(= cycles 1)
					)
					(else
						(switch (Cibola timesCaptured:)
							(0
								(gMessager say: 11 2 14 0 self) ; "Ah, this is exciting! We are escaping, yes?"
							)
							(1
								(gMessager say: 11 2 15 0 self) ; "Be more careful, that Gonzales is a nasty customer. I do not care for the look on his face!"
							)
							(else
								(gMessager say: 11 2 13 0 self) ; "Do not forget to give me the big signal when you have gotten rid of the big guy."
							)
						)
					)
				)
			)
			(2
				(gEgo setMotion: DPath 84 118 65 118 self)
			)
			(3
				(gCurRoom newRoom: 530)
				(self dispose:)
			)
		)
	)
)

(instance sPaquitaHang of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(paquita
					posn: 257 160
					ignoreActors:
					init:
					setCycle: Walk
					setSpeed: 2
					setPri: 13
					setMotion: MoveTo 201 33 self
				)
			)
			(1
				(paquita
					posn: 201 45
					view: 52
					loop: 0
					cel: 0
					setCycle: End self
				)
			)
			(2
				(paquita stopUpd:)
				(= cycles 1)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sFollowAdam of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (gCast contains: paquita)
					(paquita setCycle: Beg self)
				else
					(self cue:)
				)
			)
			(1
				(if (gCast contains: paquita)
					(paquita
						posn: 201 33
						view: 50
						setCycle: Walk
						setMotion: MoveTo 278 190 self
					)
				else
					(++ state)
				)
				(gEgo setPri: 13 setMotion: MoveTo 278 190 self)
			)
			(2)
			(3
				(self dispose:)
			)
		)
	)
)

(instance sFromShackCell of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo posn: 277 169 setMotion: MoveTo 257 160 self)
				(if (not (gCurrentRegionFlags test: 14))
					(paquita setScript: sPaquitaHang)
				)
			)
			(1
				(if (gCurrentRegionFlags test: 14)
					(gGame handsOn:)
				)
				(self dispose:)
			)
		)
	)
)

(instance sFromWestCamp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					posn: 156 142
					view: 513
					loop: 10
					cel: 5
					setCycle: CT 0 -1 self
				)
				(if (not (gCurrentRegionFlags test: 14))
					(paquita
						posn: 201 45
						view: 52
						loop: 0
						setCel: (paquita lastCel:)
						init:
						stopUpd:
					)
				)
			)
			(1
				(gEgo view: 0 loop: 8 cel: 6 normalize:)
				(= cycles 1)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sFromDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (not (gCurrentRegionFlags test: 14))
					(paquita
						posn: 201 45
						view: 52
						loop: 0
						setCel: (paquita lastCel:)
						init:
						stopUpd:
					)
				)
				(gEgo setMotion: MoveTo 85 113 self)
			)
			(1
				(gEgo setMotion: DPath 105 120 125 145 self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sRopeBed of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (and (!= (gEgo x:) 172) (!= (gEgo y:) 139))
					(gEgo setMotion: PolyPath 172 139 self)
				else
					(self cue:)
				)
			)
			(1
				(gCurrentRegionFlags set: 9)
				(gEgo loop: 8 cel: 6)
				(= cycles 1)
			)
			(2
				(gEgo view: 513 loop: 4 cel: 0 setCycle: CT 5 1 self)
			)
			(3
				(aRope init:)
				(gEgo setCycle: End self)
			)
			(4
				(gMessager say: 15 1 4 0 self) ; "Adam's rope falls neatly through the hole in the floor. He sees that it reaches almost to the ground."
			)
			(5
				(gGame points: 5 11)
				(gEgo put: 17 view: 0 loop: 8 cel: 6 normalize:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGetFax of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo loop: 8 cel: 3)
				(= cycles 1)
			)
			(1
				(gEgo view: 4 loop: 3 cel: 0 setCycle: End self)
			)
			(2
				(gMessager say: 9 4 9 0 self) ; "Adam pulls the fax transmission out of the machine. It has a Cibola Development letterhead."
			)
			(3
				(faxMachine startUpd: setCel: 0)
				(gGame points: 2)
				(gEgo view: 0 loop: 8 cel: 3 normalize: get: 9)
				(= cycles 1)
			)
			(4
				(faxMachine stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sOpenSuitcase of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (and (!= (gEgo x:) 84) (!= (gEgo y:) 138))
					(gEgo setMotion: PolyPath 84 138 self)
				else
					(self cue:)
				)
			)
			(1
				(gEgo loop: 8 cel: 1)
				(= cycles 1)
			)
			(2
				(slippers
					view: 506
					setLoop: 0
					cel: 0
					posn: 217 132
					setSpeed: 2
					setCycle: CT 4 1 self
				)
			)
			(3
				(sLocalSound number: 526 loop: 1 play: 127)
				(slippers setMotion: JumpTo 220 135 self)
			)
			(4
				(slippers setCycle: End self)
			)
			(5
				(slippers cel: 0 setCycle: CT 4 1 self)
			)
			(6
				(sLocalSound number: 526 loop: 1 play: 127)
				(slippers setMotion: JumpTo 223 138 self)
			)
			(7
				(slippers setCycle: End self)
			)
			(8
				(= seconds 2)
			)
			(9
				(slippers setCycle: CT 5 -1 self)
			)
			(10
				(sLocalSound number: 526 loop: 1 play: 127)
				(slippers setMotion: JumpTo 220 135 self)
			)
			(11
				(slippers setCycle: Beg self)
			)
			(12
				(slippers cel: (slippers lastCel:) setCycle: CT 5 -1 self)
			)
			(13
				(sLocalSound number: 526 loop: 1 play: 127)
				(slippers setMotion: JumpTo 217 132 self)
			)
			(14
				(slippers setCycle: Beg self)
			)
			(15
				(slippers view: 500 loop: 14 cel: 6 posn: 208 128)
				(gEgo setHeading: 180 self)
			)
			(16
				(slippers stopUpd:)
				(gEgo
					view: 506
					loop: 1
					cel: 0
					setSpeed: 15
					setCycle: End self
				)
			)
			(17
				(= ticks 60)
			)
			(18
				(gEgo view: 0 loop: 8 cel: 2 normalize:)
				(= cycles 1)
			)
			(19
				(gEgo setHeading: 270 self)
			)
			(20
				(gEgo
					view: 5
					loop: 1
					cel: 0
					setPri: 11
					setCycle: CT 3 1 self
				)
			)
			(21
				(suitcase startUpd: setCel: 1)
				(sLocalSound number: 510 loop: 1 play: 127)
				(if (not (gEgo has: 16))
					(theRacquet approachVerbs: 4 1 init:) ; Do, Look
				)
				(= cycles 2)
			)
			(22
				(gEgo setCycle: CT 5 1 self)
			)
			(23
				(suitcase stopUpd:)
				(gEgo view: 0 loop: 8 cel: 1 normalize:)
				(gCurrentRegionFlags set: 2)
				(gGame points: 3 10 handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGetRacquet of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (and (!= (gEgo x:) 72) (!= (gEgo y:) 152))
					(gEgo setMotion: PolyPath 72 152 self)
				else
					(self cue:)
				)
			)
			(1
				(gEgo loop: 8 cel: 3)
				(= cycles 1)
			)
			(2
				(gEgo view: 5 loop: 3 cel: 0 setCycle: CT 3 1 self)
			)
			(3
				(theRacquet dispose:)
				(gEgo setCycle: CT 5 1 self)
			)
			(4
				(gEgo view: 0 loop: 8 cel: 3 get: 16 normalize:)
				(gCurrentRegionFlags set: 3)
				(gGame points: 2 handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGetPaper of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if
					(and
						(!= (gEgo x:) (+ (paper x:) 42))
						(!= (gEgo y:) (- (paper y:) 7))
					)
					(gEgo
						setMotion:
							PolyPath
							(+ (paper x:) 42)
							(- (paper y:) 7)
							self
					)
				else
					(self cue:)
				)
			)
			(1
				(gEgo setHeading: 270 self)
			)
			(2
				(gEgo view: 5 loop: 1 cel: 0 setCycle: CT 3 1 self)
			)
			(3
				(= ticks 15)
			)
			(4
				(paper dispose:)
				(gEgo get: 11 setCycle: End self)
			)
			(5
				(gEgo loop: 8 cel: 1 normalize: 0)
				(gGame points: 5 handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sFaxComes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(sLocalSound2 number: 507 loop: -1 play: 127)
				(faxMachine setCycle: End self)
			)
			(1
				(faxMachine stopUpd:)
				(sLocalSound2 stop:)
				(self dispose:)
			)
		)
	)
)

(instance sGetPaquita of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 13 2 19 0 self) ; "Let's get out of here, OK?"
			)
			(1
				(gGame points: 5)
				(paquita setCycle: Beg self)
			)
			(2
				(paquita posn: 201 33 view: 50)
				(= cycles 2)
			)
			(3
				(paquita setCycle: Fwd setMotion: DPath 91 74 67 76 self)
			)
			(4
				(gEgo setScript: sEscapeWithRope)
				(self dispose:)
			)
		)
	)
)

(instance sTurnTvOff of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 141 124 self)
			)
			(1
				(gEgo setHeading: 315 self)
			)
			(2
				(gEgo view: 4 loop: 6 cel: 0 setCycle: CT 2 1 self)
			)
			(3
				(gEgo setCycle: End self)
				(tele setCycle: End self)
			)
			(4)
			(5
				(sTvSound stop:)
				(gEgo normalize: 0 7)
				(gCurrentRegionFlags clear: 12)
				(tele dispose:)
				(= cycles 1)
			)
			(6
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sTurnTvOn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 141 124 self)
			)
			(1
				(gEgo setHeading: 315 self)
			)
			(2
				(gEgo view: 4 loop: 6 cel: 0 setCycle: CT 2 1 self)
			)
			(3
				(gEgo setCycle: End self)
				(sTvSound number: 527 loop: -1 play: 127)
				(tele setCel: (tele lastCel:) init: setCycle: Beg self)
			)
			(4)
			(5
				(gEgo normalize: 0 7)
				(gCurrentRegionFlags set: 12)
				(if (<= (tele detailLevel:) (gGame detailLevel:))
					(tele setCycle: ROsc -1 0 3)
				else
					(tele setCycle: ROsc -1 0 3 stopUpd:)
				)
				(= cycles 1)
			)
			(6
				(gMessager say: 21 4 0 0 self) ; "Reception seems poor - or else it is snowing a lot in the Andes."
			)
			(7
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance paquita of Actor
	(properties
		x 91
		y 91
		noun 13
		view 50
		loop 2
		cel 3
		signal 16384
		scaleSignal 5
		scaleX 93
		scaleY 93
	)

	(method (doit)
		(if (not (IsEcorderFlag 36))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 36))
			(switch theVerb
				(4 ; Do
					(cond
						((gCurrentRegionFlags test: 16)
							(gMessager say: 13 4 16) ; "Admire me only! My wings are very delicate."
						)
						((Random 0 1)
							(gMessager say: 13 4 0 1) ; "It makes me too, too nervous for humans to touch me! So I'll just hang out, as you say."
						)
						(else
							(gMessager say: 13 4 0 2) ; "Do you think I am pretty from this angle? I think upside down is my best side."
						)
					)
				)
				(2 ; Talk
					(cond
						((gCurrentRegionFlags test: 21)
							(gCurrentRegionFlags set: 14)
							(gCurRoom setScript: sGetPaquita)
						)
						((gCurrentRegionFlags test: 16)
							(gMessager say: 13 2 21 0) ; "You don't have to worry, Paquita! Gonzo is off chasing the birds !"
						)
						((gCurrentRegionFlags test: 13)
							(switch (Random 1 2)
								(1
									(gMessager say: 13 2 11) ; "Oh, hurry! I don't like the smell of that cooking fire. I don't think I will look well char-broiled."
								)
								(2
									(gMessager say: 13 2 12) ; "I do not wish to end in someone's cooking pot! Do you think we can get out of here?"
								)
							)
						)
						(else
							(gMessager say: 13 2 10) ; "Are we about to make a big escape? That ugly one makes me nervous with his knives."
						)
					)
				)
				(else
					(super doVerb: theVerb)
				)
			)
		)
	)
)

(instance pelt of Actor
	(properties
		x 191
		y 145
		noun 5
		approachX 133
		approachY 146
		view 500
		loop 2
		priority 2
		signal 22544
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 49))
			(switch theVerb
				(4 ; Do
					(if (not (gCurrentRegionFlags test: 4))
						(gCurRoom setScript: sPullRug)
					else
						(gMessager say: 5 4 2 1) ; "No point in moving the rug again."
					)
				)
				(else
					(super doVerb: theVerb)
				)
			)
		)
	)

	(method (doit)
		(if (not (IsEcorderFlag 49))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
		(if cel
			(jagTail
				x: (- x 54)
				y: (+ y 1)
				nsLeft: (+ nsLeft 9)
				nsRight: (- nsRight 53)
				nsTop: (- nsTop 1)
				nsBottom: (- nsBottom 19)
				approachX: (+ (jagTail nsLeft:) 3)
				approachY: (- (jagTail nsTop:) 2)
			)
		else
			(jagTail
				x: (- x 57)
				y: (+ y 1)
				nsLeft: nsLeft
				nsRight: (- nsRight 65)
				nsTop: (- nsTop 1)
				nsBottom: (- nsBottom 24)
				approachX: (+ (jagTail nsLeft:) 2)
				approachY: (- (jagTail nsTop:) 2)
			)
		)
	)
)

(instance theRacquet of Prop
	(properties
		x 62
		y 141
		z 22
		noun 16
		approachX 84
		approachY 138
		view 500
		loop 14
		priority 10
		signal 16401
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (not (gCurrentRegionFlags test: 3))
				(gCurRoom setScript: sGetRacquet)
			else
				(super doVerb: theVerb)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance aRope of Prop
	(properties
		x 173
		y 124
		noun 15
		view 500
		loop 10
		priority 9
		signal 20497
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurRoom setScript: sEscapeWithRope)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance suitcase of Prop
	(properties
		x 60
		y 140
		noun 8
		approachX 84
		approachY 138
		view 500
		loop 1
		priority 9
		signal 20497
	)

	(method (doit)
		(if (not (IsEcorderFlag 49))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 49))
			(switch theVerb
				(4 ; Do
					(if (gCurrentRegionFlags test: 2)
						(if (gEgo has: 16)
							(gMessager say: 8 4 7) ; "There's nothing more in the footlocker."
						else
							(theRacquet doVerb: theVerb)
						)
					else
						(gCurRoom setScript: sOpenSuitcase)
					)
				)
				(1 ; Look
					(if (gCurrentRegionFlags test: 2)
						(gMessager say: 8 1 7) ; "The footlocker is open."
					else
						(gMessager say: 8 1 6) ; "A footlocker lined with zebra skin sits on the floor."
					)
				)
				(else
					(super doVerb: theVerb)
				)
			)
		)
	)
)

(instance table of Prop
	(properties
		x 128
		y 99
		noun 21
		approachX 133
		approachY 117
		view 511
		loop 3
		priority 5
		signal 20497
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (gCurrentRegionFlags test: 12)
				(gCurRoom setScript: sTurnTvOff)
			else
				(gCurRoom setScript: sTurnTvOn)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance theTopSheet of Prop
	(properties
		x 173
		y 151
		z 40
		noun 25
		view 500
		priority 9
		signal 20497
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurRoom setScript: sGetSheet 0 theTopSheet)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance theBottomSheet of Prop
	(properties
		x 173
		y 151
		z 40
		noun 25
		view 500
		priority 9
		signal 20497
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurRoom setScript: sGetSheet 0 theBottomSheet)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance floorboard of Prop
	(properties
		x 175
		y 121
		z -20
		noun 4
		approachX 142
		approachY 142
		view 500
		loop 3
		priority 2
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (not (gCurrentRegionFlags test: 7))
					(if (gCurrentRegionFlags test: 4)
						(gCurRoom setScript: sAdamMovesBoard)
					)
				else
					(super doVerb: theVerb)
				)
			)
			(5 ; rope
				(bed doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance faxMachine of Prop
	(properties
		x 114
		y 101
		noun 9
		approachX 110
		approachY 123
		view 500
		loop 4
		signal 20480
		cycleSpeed 100
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (gEgo has: 9)
					(gMessager say: 9 4 8) ; "Adam wishes he could remember the fax number of the Ecology Network office. Unfortunately, he doesn't know it."
				else
					(gCurRoom setScript: sGetFax)
				)
			)
			(1 ; Look
				(if (gEgo has: 9)
					(gMessager say: 9 1 0 1) ; "A fax machine keeps Slaughter in touch with important deals - also with catalogue shopping."
				else
					(gMessager say: 9 1 0 0) ; "A fax machine keeps Slaughter in touch with important deals - also with catalogue shopping."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance jagHead of Prop
	(properties
		noun 6
		view 500
		priority 2
		signal 20496
	)

	(method (doit)
		(if (not (IsEcorderFlag 49))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 49))
			(super doVerb: theVerb)
		)
	)
)

(instance paper of Prop
	(properties
		noun 30
		view 500
		loop 13
		priority 1
		signal 16400
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurRoom setScript: sGetPaper)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance tele of Prop
	(properties
		x 128
		y 99
		noun 21
		view 500
		loop 5
		cel 7
		signal 16384
		detailLevel 2
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (gCurrentRegionFlags test: 12)
				(gCurRoom setScript: sTurnTvOff)
			else
				(gCurRoom setScript: sTurnTvOn)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance calendar of View
	(properties
		x 179
		y 68
		noun 12
		view 511
		loop 7
		signal 20481
	)
)

(instance safe of View
	(properties
		x 248
		y 133
		noun 2
		approachX 238
		approachY 138
		view 511
		loop 6
		signal 20481
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (gEgo has: 13)
					(gMessager say: 2 4 16 1) ; "The safe is empty."
				else
					(gGame handsOff:)
					(gCurRoom setScript: sOpenSafe)
				)
			)
			(1 ; Look
				(gMessager say: 2 1 5) ; "A heavy, industrial safe rests on the floor and serves also as a night stand."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance bed of View
	(properties
		x 223
		y 102
		noun 1
		approachX 184
		approachY 123
		view 511
		loop 9
		priority 8
		signal 20496
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gMessager say: 1 4 1) ; "There's nothing underneath the mattress."
			)
			(5 ; rope
				(if (and (floorboard cel:) (gCurrentRegionFlags test: 4))
					(gCurRoom setScript: sRopeBed)
				else
					(super doVerb: theVerb)
				)
			)
			(1 ; Look
				(if
					(and
						(not (gCast contains: theTopSheet))
						(not (gCast contains: theBottomSheet))
					)
					(gMessager say: 1 1 1 1) ; "Only the bare mattress is left - along with a monogrammed pillow."
				else
					(gMessager say: 1 1 0 1) ; "Slaughter has made up this simple cot with fancy silk sheets."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pillow of Actor
	(properties
		x 213
		y 109
		noun 26
		approachX 184
		approachY 123
		view 500
		loop 8
		priority 9
		signal 22545
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gMessager say: 26 4 16 1) ; "Adam doesn't want a monogrammed pillow."
		else
			(super doVerb: theVerb)
		)
	)
)

(instance theOrganizer of View
	(properties
		x 195
		y 103
		noun 27
		approachX 184
		approachY 123
		view 500
		loop 15
		priority 9
		signal 16401
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if
				(or
					(gCast contains: bundle)
					(gCast contains: theBottomSheet)
					(gCast contains: theTopSheet)
				)
				(gMessager say: 27 4 20) ; "The bed sure is lumpy here!"
			else
				(gCurRoom setScript: sGetOrganizer)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance slippers of Actor
	(properties
		x 208
		y 128
		noun 36
		view 500
		loop 14
		cel 6
		signal 20481
	)

	(method (doit)
		(if (not (IsEcorderFlag 49))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 49))
			(super doVerb: theVerb)
		)
	)
)

(instance stool of View
	(properties
		x 255
		y 145
		noun 31
		view 511
		loop 14
		cel 3
		priority 12
		signal 20497
	)

	(method (init)
		(super init:)
		(gTheDoits add: self)
	)

	(method (dispose)
		(gTheDoits delete: self)
		(super dispose:)
	)

	(method (doit)
		(if (not (IsEcorderFlag 49))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 49))
			(super doVerb: theVerb)
		)
	)
)

(instance stuffedanimal of View
	(properties
		x 83
		y 47
		noun 34
		view 511
		loop 14
		cel 2
		priority 9
		signal 20497
	)

	(method (init)
		(super init:)
		(gTheDoits add: self)
	)

	(method (dispose)
		(gTheDoits delete: self)
		(super dispose:)
	)

	(method (doit)
		(if (not (IsEcorderFlag 49))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 49))
			(super doVerb: theVerb)
		)
	)
)

(instance bookshelf of View
	(properties
		x 105
		y 62
		noun 33
		view 511
		loop 14
		cel 5
		signal 20481
	)

	(method (init)
		(super init:)
		(gTheDoits add: self)
	)

	(method (dispose)
		(gTheDoits delete: self)
		(super dispose:)
	)

	(method (doit)
		(if (not (IsEcorderFlag 49))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 49))
			(super doVerb: theVerb)
		)
	)
)

(instance gorillahand of View
	(properties
		x 241
		y 136
		z 30
		noun 32
		view 511
		loop 14
		cel 4
		priority 9
		signal 20497
	)

	(method (init)
		(super init:)
		(gTheDoits add: self)
	)

	(method (dispose)
		(gTheDoits delete: self)
		(super dispose:)
	)

	(method (doit)
		(if (not (IsEcorderFlag 49))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 49))
			(super doVerb: theVerb)
		)
	)
)

(instance netting of View
	(properties
		x 208
		y 56
		noun 35
		view 511
		loop 9
		cel 1
		signal 20481
	)
)

(instance bundle of View
	(properties
		x 199
		y 111
		noun 15
		approachX 184
		approachY 123
		view 500
		cel 1
		priority 9
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: sGetBundle)
			)
			(1 ; Look
				(gMessager say: 15 1 3) ; "Gonzales has thrown the rope of silken sheets back on the bed. However, he hasn't untied it."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance ceiling of Feature
	(properties
		x 197
		y 46
		noun 22
		onMeCheck 8
	)
)

(instance floor of Feature
	(properties
		x 157
		y 101
		noun 3
		onMeCheck 16
	)
)

(instance doorExit of Feature
	(properties
		x 88
		y 97
		noun 23
		onMeCheck 2
	)

	(method (handleEvent event)
		(if
			(and
				(OneOf ((ScriptID 0 9) cel:) 0 2) ; eco2Cursor
				(or
					(and
						(== (event type:) evMOUSEBUTTON)
						(not (& (event modifiers:) emSHIFT))
						(not (& (event modifiers:) emCTRL))
					)
					(and (== (event type:) evKEYBOARD) (== (event message:) KEY_RETURN))
				)
			)
			(if (doorExit onMe: event)
				(if (not (gCurRoom script:))
					(event claimed: 1)
					(gCurRoom setScript: sEnterWestCamp)
				)
				(super handleEvent: event)
			else
				0
			)
		else
			(super handleEvent: event)
		)
	)
)

(instance wall of Feature
	(properties
		x 202
		y 44
		noun 24
		onMeCheck 4
	)
)

(instance jagTail of Feature
	(properties
		noun 7
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (and (not (gCurrentRegionFlags test: 5)) (not (gCurrentRegionFlags test: 6)))
				(gCurRoom setScript: sJagBarfs)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance jagSquash of Feature
	(properties
		x 161
		y 134
		noun 5
		nsTop 130
		nsLeft 154
		nsBottom 139
		nsRight 168
		approachX 161
		approachY 134
	)

	(method (doVerb theVerb)
		(pelt doVerb: theVerb)
	)
)

(instance southExit of ExitFeature
	(properties
		nsTop 162
		nsLeft 205
		nsBottom 190
		nsRight 280
		cursor 10
		exitDir 3
	)

	(method (doit)
		(super doit:)
		(if
			(and
				(<= 163 (gEgo y:) 165)
				(not (gCurRoom script:))
				(not (gEgo script:))
			)
			(gCurRoom setScript: sFollowAdam)
		)
	)
)

(instance changePoly of Polygon
	(properties
		type PBarredAccess
	)

	(method (dispose)
		((gCurRoom obstacles:) delete: self)
		(super dispose:)
	)
)

(instance jagPoly of Polygon
	(properties
		type PBarredAccess
	)

	(method (dispose)
		((gCurRoom obstacles:) delete: self)
		(super dispose:)
	)
)

(instance sLocalSound of Sound
	(properties)
)

(instance sLocalSound2 of Sound
	(properties)
)

(instance sTvSound of Sound
	(properties)
)

