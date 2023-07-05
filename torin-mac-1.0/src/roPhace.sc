;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20700)
(include sci.sh)
(use Main)
(use oHandsOnWhenCued)
(use TPScript)
(use TPSound)
(use PArray)
(use foEExit)
(use Plane)
(use Array)
(use Talker)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	roPhace 0
)

(local
	oTileViews
	oTileInvs
	oTileVerbs
)

(procedure (TileFromVerb verb &tmp nSize i)
	(if (not oTileVerbs)
		(PrintDebug {TileVerbs not inited. 20700.sc djm})
		(return -1)
	)
	(= nSize (oTileVerbs size:))
	(for ((= i 0)) (< i nSize) ((++ i))
		(if (== verb (oTileVerbs at: i))
			(return i)
		)
	)
	(return -1)
)

(procedure (CheckForWin &tmp i bWin oTempArray)
	(= oTempArray (IntArray newWith: 9 2 1 0 5 4 3 8 7 6))
	(= bWin 1)
	(for ((= i 0)) (< i 9) ((++ i))
		(if (!= [gTileDirections i] 0)
			(= bWin 0)
		)
		(if (!= [gTilePositions i] (oTempArray at: i))
			(= bWin 0)
		)
	)
	(oTempArray dispose:)
	(= oTempArray 0)
	(if (not bWin)
		(return 0)
	)
	((ScriptID 64017 0) set: 111) ; oFlags
	(return (gCurRoom setScript: soSolved))
)

(instance soSolved of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 3)
			)
			(1
				(goSound1 preload: 20706 20702)
				(goSound1 playSound: 20702 self)
				(poPhenoPhace init: cycleSpeed: 8 setCycle: End self)
			)
			(2)
			(3
				(= ticks 180)
			)
			(4
				(voPhaceNormalMouth init:)
				(= gtPhace toPhace)
				(gMessager say: 0 0 1 0 self) ; "Welcome, traveler. The sacred chamber that lies ahead contains an ancient phenocryst column. For centuries, travelers have journeyed throughout the planet of Strata by means of these columns. Connecting the worlds within worlds, phenocrysts are able to transmit far more than mere light. Through the use of erresdy powder, discovered by Tor the First in the early Unity Period, people now have instant mobility. So step inside, and enjoy the latest in phenocryst travel."
			)
			(5
				(= ticks 60)
			)
			(6
				(= gtPhace 0)
				(goSound1 playSound: 20706)
				(poOpenMouth init: cycleSpeed: 12 setCycle: End self)
			)
			(7
				(= ticks 180)
			)
			(8
				(gCurRoom newRoom: 20800) ; roCliffTransporter
			)
		)
	)
)

(instance soGoToChamber of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(gCurRoom newRoom: 20800) ; roCliffTransporter
			)
		)
	)
)

(instance foToCliffExit of ExitFeature
	(properties)

	(method (init)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 1)) ; oNorthCursor
		(= onMeCheck
			((Polygon new:)
				type: PTotalAccess
				init: 470 265 492 229 482 176 485 146 507 109 531 84 559 72 605 49 629 20 567 20 514 20 471 11 468 0 631 0 634 78 560 119 530 153 529 197 546 278
				yourself:
			)
		)
	)

	(method (doVerb)
		(gEgo setScript: soClimbUpTree)
	)
)

(instance foPhaceMS of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 6)) ; oNorthWestCursor
		(= onMeCheck
			((Polygon new:)
				type: PTotalAccess
				init: 1 12 49 36 120 81 181 129 254 204 331 271 332 292 165 284 165 255 156 252 150 244 143 241 140 227 120 226 0 99
				yourself:
			)
		)
	)

	(method (doVerb)
		(if ((ScriptID 64017 0) test: 111) ; oFlags
			(gCurRoom newRoom: 20800) ; roCliffTransporter
		else
			(gEgo setScript: soClimbUpStairs)
		)
	)
)

(instance foExitCU of CUExitFeature
	(properties)

	(method (doVerb)
		(gCurRoom setScript: soClimbDownStairs)
	)
)

(class TilePuzzleSlot of Prop
	(properties
		view 20712
		tile -1
		pos -1
	)

	(method (init)
		(self setPri: 5)
		(= tile [gTilePositions pos])
		(if (!= tile -1)
			(= loop [gTileDirections tile])
			(= view (oTileViews at: tile))
		else
			(= loop 0)
			(= view 20712)
		)
		(= cel 0)
		(super init: &rest)
		(self addHotspotVerb: 27 32 24 30 31 48 29 25 28 26)
		(if (!= tile -1)
			(self addHotspotVerb: 1)
		)
		(= cel 0)
	)

	(method (empty)
		(= tile -1)
		(= view 20712)
		(= cel (= loop 0))
		(self deleteHotspotVerb: 1)
		(= [gTilePositions pos] -1)
	)

	(method (setTile theTile)
		(= tile theTile)
		(= view (oTileViews at: tile))
		(= loop [gTileDirections tile])
		(= [gTilePositions pos] tile)
		(self addHotspotVerb: 1)
	)

	(method (rotate dir)
		(if (== tile -1)
			(PrintDebug {Attempt to rotate empty slot. 20700.sc djm})
			(return)
		)
		(goSound1 playSound: 20703)
		(if (== dir 1)
			(self setScript: (soRotLeft new:) self)
		else
			(self setScript: (soRotRight new:) self)
		)
	)

	(method (cue)
		(CheckForWin)
	)

	(method (handleEvent event &tmp curVerb nLocalX nLocalY nDistX nDistY)
		(if (not (self onMe: event))
			(return 0)
		)
		(if (== tile -1)
			(self forceCursor: 0)
		)
		(if (not (self testHotspotVerb: global101))
			(return 0)
		)
		(if (== global101 1)
			(= nLocalX (event x:))
			(= nLocalY (event y:))
			(= nDistX (Abs (- nsRight nLocalX)))
			(= nDistY (Abs (- nLocalY nsTop)))
			(if (< (+ nDistX nDistY) 40)
				(= curVerb -2)
				(self forceCursor: (ScriptID 64006 11)) ; oRotLCursor
			else
				(= nDistX (Abs (- nLocalX nsLeft)))
				(= nDistY (Abs (- nsBottom nLocalY)))
				(if (< (+ nDistX nDistY) 40)
					(= curVerb -1)
					(self forceCursor: (ScriptID 64006 12)) ; oRotRCursor
				else
					(= curVerb 1)
					(self forceCursor: 0)
				)
			)
		else
			(= curVerb global101)
			(self forceCursor: 0)
		)
		(if (== (event type:) evMOUSEBUTTON)
			(CueObj
				state: 0
				cycles: 0
				client: self
				theVerb: curVerb
				changeState: 3
			)
			(event claimed: 1)
			(return 1)
		else
			(super handleEvent: event &rest)
			(return)
		)
	)

	(method (doVerb theVerb)
		(cond
			((OneOf theVerb 27 32 24 30 31 48 25 28 26) ; ioSmallDoorTile, ioFloorTile, ioGuillotineTile, ioTubTile, ioSeatTile, ioCleanTile, ioStepTile, ioTableTopTile, ioTrivetTile
				((ScriptID 64017 0) set: 110) ; oFlags
				(goSound1 playSound: 20701)
				(gInventItem moveTo: 20700)
				(if (!= tile -1)
					((oTileInvs at: tile) moveTo: -2)
					(self empty:)
				)
				(self setTile: (TileFromVerb theVerb))
				((ScriptID 64017 0) set: (+ 99 tile)) ; oFlags
				(CheckForWin)
			)
			((== theVerb 29) ; ioWarningTile
				(goSound1 playSound: 20704)
			)
			((== theVerb 1) ; Do
				(if (== tile -1)
					(PrintDebug
						{attempt to pickup nonexistent tile. 20700.sc djm}
					)
					(Empty)
				)
				(goSound1 playSound: 20705)
				((oTileInvs at: tile) moveTo: -2)
				(self empty:)
			)
			((== theVerb -1) ; ???
				(self rotate: -1)
			)
			((== theVerb -2) ; ???
				(self rotate: 1)
			)
		)
	)
)

(instance soRotLeft of Script
	(properties)

	(method (changeState newState &tmp nLoop)
		(switch (= state newState)
			(0
				(client setPri: 10)
				(if (== (= nLoop (client loop:)) 0)
					(= nLoop 3)
				else
					(-= nLoop 1)
				)
				(client loop: nLoop)
				(= [gTileDirections (client tile:)] nLoop)
				(client cel: (client lastCel:))
				(= ticks (- (client cycleSpeed:) 1))
			)
			(1
				(client setCycle: Beg self)
			)
			(2
				(client setPri: 5)
				(= cycles 1)
			)
			(3
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(client setCycle: 0)
		(super dispose:)
	)
)

(instance soRotRight of Script
	(properties)

	(method (changeState newState &tmp nLoop)
		(switch (= state newState)
			(0
				(client setPri: 10)
				(client setCycle: End self)
			)
			(1
				(if (== (= nLoop (client loop:)) 3)
					(= nLoop 0)
				else
					(+= nLoop 1)
				)
				(client loop: nLoop)
				(= [gTileDirections (client tile:)] nLoop)
				(client cel: 0)
				(client setPri: 5)
				(= cycles 1)
			)
			(2
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(client setCycle: 0)
		(super dispose:)
	)
)

(instance poPhenoPhace of Prop
	(properties
		x 223
		y 5
		priority 45
		fixPriority 1
		view 20701
		loop 3
	)
)

(instance poOpenMouth of Prop
	(properties
		x 268
		y 134
		priority 55
		fixPriority 1
		view 20701
		loop 2
	)
)

(instance voPhaceNormalMouth of View
	(properties
		x 261
		y 127
		priority 50
		fixPriority 1
		view 20701
		loop 1
	)
)

(instance toPhace of Talker
	(properties
		x 261
		y 127
		view 20701
		loop 1
		priority 50
	)

	(method (init)
		(voPhaceNormalMouth hide:)
		(super init: &rest)
	)

	(method (dispose)
		(voPhaceNormalMouth show:)
		(super dispose: &rest)
	)
)

(instance poTorin of Prop
	(properties)
)

(instance soClimbDownTree of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(goSound1 preload: 20118)
				(gGame handsOff:)
				(poTorin
					view: 20700
					loop: 0
					cel: 0
					posn: 434 307
					init:
					setCycle: CT 10 1 self
				)
			)
			(1
				(goSound1 playSound: 20118)
				(poTorin setCycle: End self)
			)
			(2
				(poTorin dispose:)
				(gEgo posn: 434 307 normalize: 1 60100 5 show:)
				((ScriptID 64017 0) set: 108) ; oFlags
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soClimbUpTree of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 496 309 self)
			)
			(1
				(gGame handsOff:)
				(gEgo setHeading: 45 self)
			)
			(2
				(gEgo hide:)
				(poTorin
					view: 20700
					loop: 1
					cel: 0
					posn: 496 309
					init:
					setCycle: End self
				)
			)
			(3
				(if (not ((ScriptID 64017 0) test: 109)) ; oFlags
					((ScriptID 64017 0) clear: 108) ; oFlags
				)
				(gCurRoom newRoom: 20100) ; roCliffScroller
				(self dispose:)
			)
		)
	)
)

(instance soClimbUpStairs of TPScript
	(properties
		bHasFF 1
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 325 320 self)
			)
			(1
				(gGame handsOff:)
				(gEgo setHeading: 315 self)
			)
			(2
				(gEgo hide:)
				(poTorin
					view: 20700
					loop: 2
					cel: 0
					posn: 317 315
					init:
					setCycle: End self
				)
			)
			(3
				(poTorin dispose:)
				(gCurRoom addRoomPlane: oPhaceCUPlane)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)

	(method (ff)
		(gEgo hide:)
		(poTorin dispose:)
		(gCurRoom addRoomPlane: oPhaceCUPlane)
		(gGame handsOn:)
		(self dispose:)
	)
)

(instance soClimbDownStairs of TPScript
	(properties
		bHasFF 1
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gCurRoom deleteRoomPlane: oPhaceCUPlane)
				(poTorin
					view: 20700
					loop: 3
					cel: 0
					posn: 234 297
					init:
					setCycle: End self
				)
			)
			(1
				(poTorin dispose:)
				(gEgo posn: 234 297 normalize: 1 60100 4 show:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)

	(method (ff)
		(poTorin dispose:)
		(gEgo posn: 234 297 normalize: 1 60100 4 show:)
		(gGame handsOn:)
		(self dispose:)
	)
)

(instance oPhaceCUPlane of Plane
	(properties
		picture 20701
		priority 20
	)

	(method (init &tmp nPos nX nY i j)
		(super
			init:
				(gThePlane left:)
				(gThePlane top:)
				(gThePlane right:)
				(gThePlane bottom:)
		)
		(= nPos 0)
		(= nY 38)
		(for ((= i 0)) (< i 3) ((++ i))
			(= nX 261)
			(for ((= j 0)) (< j 3) ((++ j))
				((TilePuzzleSlot new:) pos: nPos x: nX y: nY init:)
				(+= nX 54)
				(++ nPos)
			)
			(+= nY 54)
		)
		(foExitCU init:)
		((ScriptID 64017 0) set: 109) ; oFlags
		(goSound1 preload: 20701 20703 20704)
	)
)

(instance oPhaceMusic of TPSound
	(properties
		type 1
	)
)

(instance roPhace of TPRoom
	(properties
		picture 20700
	)

	(method (dispose)
		(if oTileViews
			(oTileViews dispose:)
			(= oTileViews 0)
		)
		(if oTileInvs
			(oTileInvs dispose:)
			(= oTileInvs 0)
		)
		(if oTileVerbs
			(oTileVerbs dispose:)
			(= oTileVerbs 0)
		)
		(super dispose: &rest)
	)

	(method (init)
		(super init: &rest)
		(= oTileViews
			(PArray
				newWith: 9 20703 20704 20705 20706 20707 20708 20709 20710 20711
			)
		)
		(= oTileInvs
			(PArray
				newWith:
					9
					((ScriptID 64001 0) get: 17) ; oInvHandler, ioSmallDoorTile
					((ScriptID 64001 0) get: 22) ; oInvHandler, ioFloorTile
					((ScriptID 64001 0) get: 14) ; oInvHandler, ioGuillotineTile
					((ScriptID 64001 0) get: 20) ; oInvHandler, ioTubTile
					((ScriptID 64001 0) get: 21) ; oInvHandler, ioSeatTile
					((ScriptID 64001 0) get: 33) ; oInvHandler, ioCleanTile
					((ScriptID 64001 0) get: 15) ; oInvHandler, ioStepTile
					((ScriptID 64001 0) get: 18) ; oInvHandler, ioTableTopTile
					((ScriptID 64001 0) get: 16) ; oInvHandler, ioTrivetTile
			)
		)
		(= oTileVerbs (PArray newWith: 9 27 32 24 30 31 48 25 28 26))
		(goMusic1 setMusic: 0)
		(oPhaceMusic setRelVol: 130 setMusic: 20700)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 1 286 1 313 479 314 462 300
					yourself:
				)
		)
		(foPhaceMS init:)
		(foToCliffExit init:)
		(gEgo init: normalize: hide:)
		(gGame handsOn:)
		(gEgo setScript: soClimbDownTree)
	)

	(method (gimme)
		(if (!= -1 [gTilePositions 0])
			((ScriptID 64017 0) set: 111) ; oFlags
			(gCurRoom setScript: soSolved)
			(return)
		)
		(gEgo get: ((ScriptID 64001 0) get: 17)) ; oInvHandler, ioSmallDoorTile
		(gEgo get: ((ScriptID 64001 0) get: 22)) ; oInvHandler, ioFloorTile
		(gEgo get: ((ScriptID 64001 0) get: 14)) ; oInvHandler, ioGuillotineTile
		(gEgo get: ((ScriptID 64001 0) get: 20)) ; oInvHandler, ioTubTile
		(gEgo get: ((ScriptID 64001 0) get: 21)) ; oInvHandler, ioSeatTile
		(gEgo get: ((ScriptID 64001 0) get: 19)) ; oInvHandler, ioWarningTile
		(gEgo get: ((ScriptID 64001 0) get: 15)) ; oInvHandler, ioStepTile
		(gEgo get: ((ScriptID 64001 0) get: 18)) ; oInvHandler, ioTableTopTile
		(gEgo get: ((ScriptID 64001 0) get: 16)) ; oInvHandler, ioTrivetTile
		(gEgo get: ((ScriptID 64001 0) get: 33)) ; oInvHandler, ioCleanTile
	)
)

