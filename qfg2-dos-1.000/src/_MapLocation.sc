;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 96)
(include sci.sh)
(use Main)
(use n001)
(use n002)
(use Interface)
(use Polygon)
(use Sound)
(use Motion)
(use Actor)
(use System)

(local
	xRet
	yRet
	[palacePlazaPts 14] = [260 145 273 138 285 138 299 146 273 159 273 164 260 156]
	[gatesPlazaPts 14] = [66 123 79 115 96 115 107 122 107 134 93 140 93 135]
	[fighterPlazaEPts 14] = [36 29 63 14 69 17 69 29 57 34 42 34 36 31]
	[fighterPlazaWPts 14] = [36 29 63 14 55 9 42 11 30 16 29 27 36 31]
	[fountainPlazaNPts 14] = [150 77 150 81 177 96 183 92 183 80 171 73 155 73]
	[fountainPlazaSPts 14] = [150 81 150 77 144 80 144 91 156 99 171 99 177 96]
	[deltas 18] = [0 0 0 -5 5 -5 5 0 5 5 0 5 -5 5 -5 0 -5 -5]
	[headingLoops 4] = [8 6 7 9]
	lastMapX
	lastMapY
)

(class _MapLocation of Prop
	(properties
		view 710
		hasIcon 1
		isCycling 0
		theRoom 0
		alterRoom 0
		beenHere 0
		openAtNight 1
		points 0
		nPoints 0
		xEgoPos 0
		yEgoPos 0
		xCoord 0
		yCoord 0
		polygon 0
	)

	(method (init theCast)
		(if (not (self hasBeenHere:))
			(return 0)
		)
		(super init: &rest)
		(theCast add: self)
		(if points
			((= polygon (Polygon new:)) points: points size: nPoints)
		)
		(if isCycling
			(self setCycle: Fwd)
		else
			(self stopUpd:)
			(if (not hasIcon)
				(= loop 5)
				(= cel 9)
			)
		)
		(self ignoreActors:)
		(return 1)
	)

	(method (hasBeenHere)
		(return (or (== 0 beenHere) (IsFlag beenHere)))
	)

	(method (onMe aX aY)
		(if polygon
			(return (AvoidPath aX aY polygon))
		else
			(return (super onMe: aX aY))
		)
	)

	(method (isEgoInRoom theCurRoom)
		(if (== theCurRoom theRoom)
			(= xRet xEgoPos)
			(= yRet yEgoPos)
			(return 1)
		else
			(return 0)
		)
	)

	(method (canComeHere)
		(return (or openAtNight (<= 0 gTimeODay 4)))
	)

	(method (comeHere)
		(if (self canComeHere:)
			(return theRoom)
		else
			(return alterRoom)
		)
	)

	(method (dispose)
		(if polygon
			(polygon dispose:)
		)
		(self setCycle: 0)
		(super dispose:)
	)
)

(class _MapView of View
	(properties
		view 710
	)

	(method (init theCast)
		(super init: &rest)
		(theCast add: self)
	)
)

(class _MapPicView of _MapView
	(properties)

	(method (onMe)
		(return 0)
	)
)

(instance egoPosition of Prop
	(properties
		view 710
	)

	(method (init theCast)
		(super init: &rest)
		(theCast add: self)
		(self setCycle: Fwd)
	)

	(method (onMe)
		(return 0)
	)
)

(class Map of Obj
	(properties
		x 0
		y 0
		egoLoc 0
		csrLoc 0
		mapCast 0
		theKey 0
		roomToGoTo 0
		distance 0
		notHiddenList 0
		soundPaused 0
	)

	(method (init &tmp egoLocLoop rmnEvent)
		(if
			(or
				(and (OneOf gCurRoomNum 303 300) (== gElementalState 1)) ; rmSPlazaGates
				(and (OneOf gCurRoomNum 240 335) (== gElementalState 3)) ; rmPalaceGatesE, rmSPlazaPalace
				(and (OneOf gCurRoomNum 310 315) (== gElementalState 7)) ; FPN, FPS
			)
			(HighPrint 96 0) ; "You're up to your compass in elementals! You can't use your map now."
			(return)
		)
		(if
			(or
				(IsFlag 133)
				(gEgo script:)
				(gCurRoom script:)
				(gGame script:)
				gCantMove
			)
			(HighPrint 96 1) ; "There's too much going on to take time out for the map right now."
			(return)
		)
		(= soundPaused (Sound pause: 1))
		(= roomToGoTo 0)
		(= mapCast (Collect new:))
		(= notHiddenList (Collect new:))
		(gCast eachElementDo: #perform hideCastMember notHiddenList)
		(compass init: mapCast)
		(Fighters_Plaza_b init: mapCast)
		(Fighters_Plaza_a init: mapCast)
		(Fountain_Plaza_a init: mapCast)
		(Fountain_Plaza_b init: mapCast)
		(Palace_Plaza init: mapCast)
		(Gates_Plaza init: mapCast)
		(Palace init: mapCast)
		(Guild_Hall init: mapCast)
		(Moneychanger init: mapCast)
		(Saurus_Lot init: mapCast)
		(Weapons_Shop init: mapCast)
		(Apothecary init: mapCast)
		(Astrologer init: mapCast)
		(Katta_s_Tail_Inn init: mapCast)
		(Enchantress init: mapCast)
		(Magic_Shop init: mapCast)
		(W__I__T_ init: mapCast)
		(= egoLocLoop 6)
		(if (= egoLoc (mapCast firstTrue: #perform seeIfEgoIsInRoom gCurRoomNum))
			(= gXEgo (egoLoc xCoord:))
			(= gYEgo (egoLoc yCoord:))
		else
			(if (gCurRoom respondsTo: #facingHeading)
				(= egoLocLoop [headingLoops (- (gCurRoom facingHeading:) 1)])
				(gCurRoom egoPos2Coords:)
			)
			(self map2ScreenCoords: gXEgo gYEgo)
		)
		(egoPosition
			init: mapCast
			x: xRet
			y: yRet
			loop: egoLocLoop
			cel: 0
			cycleSpeed: 2
			ignoreActors:
			setPri: 15
		)
		(= rmnEvent (Event new:))
		(= lastMapX (rmnEvent x:))
		(= lastMapY (rmnEvent y:))
		(rmnEvent dispose:)
		(DrawPic 710 100 1 0)
		(self handleEvent:)
	)

	(method (handleEvent &tmp key event)
		(repeat
			(= event (Event new:))
			(MapKeyToDir event)
			(GlobalToLocal event)
			(= x (event x:))
			(= y (event y:))
			(self displayCurLocation:)
			(cond
				((== (event type:) $0040) ; direction
					(if (== (= key (event message:)) theKey)
						(= theKey JOY_NULL)
					else
						(= theKey key)
					)
				)
				((== (event message:) KEY_ESCAPE)
					(break)
				)
				((== (event message:) KEY_CONTROL)
					(PromptQuit)
					(if gQuit
						(break)
					)
				)
				((or (== (event type:) evMOUSEBUTTON) (== (event message:) KEY_RETURN))
					(if csrLoc
						(AdvanceTime
							0
							(GetDistance
								(csrLoc xCoord:)
								(csrLoc yCoord:)
								gXEgo
								gYEgo
							)
						)
						(= roomToGoTo (csrLoc comeHere:))
					)
					(break)
				)
				((or (!= x lastMapX) (!= y lastMapY))
					(= theKey JOY_NULL)
				)
			)
			(event dispose:)
			(Wait gSpeed)
			(Animate (mapCast elements:) 1)
			(self moveCursor:)
		)
		(event dispose:)
		(self dispose:)
	)

	(method (displayCurLocation &tmp theLoc)
		(if (= theLoc (mapCast firstTrue: #onMe x y))
			(if (!= theLoc csrLoc)
				(Print (theLoc name:) #font 999 #at 80 160 #dispose)
				(= csrLoc theLoc)
			)
		else
			(if gModelessDialog
				(gModelessDialog dispose:)
			)
			(= csrLoc 0)
		)
	)

	(method (moveCursor &tmp i dist)
		(if (!= theKey 0)
			(= i (* theKey 2))
			(+= x [deltas i])
			(+= y [deltas (+ i 1)])
			(if (< x 0)
				(= x (= theKey 0))
			)
			(if (> x 319)
				(= theKey 0)
				(= x 319)
			)
			(if (< y 0)
				(= y (= theKey 0))
			)
			(if (> y 189)
				(= theKey 0)
				(= x 189)
			)
			(gGame setCursor: gTheCursor 1 x y)
			(= lastMapX x)
			(= lastMapY y)
		)
	)

	(method (map2ScreenCoords xMap yMap)
		(= xRet
			(+ (/ (* (+ xMap yMap) 25) 8) (if (< xMap 40) -25 else -22))
		)
		(= yRet
			(+
				(- (/ (* xMap 7) 4) (/ (* yMap 5) 3))
				(if (< xMap 40) 51 else 53)
			)
		)
	)

	(method (dispose)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(mapCast
			eachElementDo: #dispose
			eachElementDo: #delete
			release:
			dispose:
		)
		(notHiddenList eachElementDo: #show release: dispose:)
		(if (and roomToGoTo (or (!= roomToGoTo gCurRoomNum) (== gCurRoomNum 704))) ; alleyRoom
			(SetFlag 28)
			(= gRoomExitDir 3)
			(= gCurRoomNum 0)
			(gCurRoom newRoom: roomToGoTo)
		else
			(DrawPic (gCurRoom curPic:) 100 1 global61)
			(if (!= global57 -1)
				(DrawPic global57 100 0 global61)
			)
			(gAddToPics doit:)
		)
		(Sound pause: soundPaused)
		(super dispose:)
	)
)

(instance hideCastMember of Code
	(properties)

	(method (doit aObj aList)
		(if (not (& (aObj signal:) $0008))
			(aList add: aObj)
			(aObj hide:)
		)
	)
)

(instance seeIfEgoIsInRoom of Code
	(properties)

	(method (doit aObj roomNum)
		(if (aObj respondsTo: #isEgoInRoom)
			(return (aObj isEgoInRoom: roomNum))
		else
			(return 0)
		)
	)
)

(instance compass of _MapPicView
	(properties
		x 41
		y 169
		loop 2
	)
)

(instance Palace of _MapLocation
	(properties
		x 294
		y 172
		loop 1
		cel 1
		theRoom 240
		alterRoom 335
		xEgoPos 276
		yEgoPos 154
		xCoord 78
		yCoord 20
	)

	(method (canComeHere)
		(return (and (super canComeHere:) (!= gElementalState 3)))
	)
)

(instance Guild_Hall of _MapLocation
	(properties
		name {Guild Hall}
		x 34
		y 19
		loop 4
		cel 1
		priority 14
		signal 16
		theRoom 160
		alterRoom 320
		beenHere 127
		openAtNight 0
		xEgoPos 29
		yEgoPos 14
		yCoord 20
	)
)

(instance Moneychanger of _MapLocation
	(properties
		x 85
		y 68
		loop 5
		theRoom 120
		beenHere 9
		xEgoPos 91
		yEgoPos 68
		xCoord 19
		yCoord 13
	)
)

(instance Saurus_Lot of _MapLocation
	(properties
		name {Saurus Lot}
		x 68
		y 135
		loop 3
		cel 1
		priority 14
		signal 16
		theRoom 290
		alterRoom 300
		beenHere 152
		xEgoPos 67
		yEgoPos 131
		xCoord 37
		yCoord -5
	)

	(method (init theCast)
		(if (super init: theCast)
			(saurusLotIcon init: theCast)
		)
	)

	(method (onMe aX aY)
		(if (not (super onMe: aX aY))
			(return (saurusLotIcon onMe: aX aY))
		)
		(return 1)
	)

	(method (canComeHere)
		(return (and (super canComeHere:) (!= gElementalState 1)))
	)
)

(instance saurusLotIcon of _MapView
	(properties
		x 55
		y 130
		loop 5
		cel 1
	)
)

(instance Weapons_Shop of _MapLocation
	(properties
		name {Weapons Shop}
		x 76
		y 26
		loop 5
		cel 2
		priority 14
		signal 16
		theRoom 140
		alterRoom 330
		beenHere 128
		openAtNight 0
		xEgoPos 80
		yEgoPos 24
		xCoord 8
		yCoord 24
	)
)

(instance Apothecary of _MapLocation
	(properties
		x 165
		y 106
		loop 5
		cel 3
		theRoom 130
		alterRoom 315
		openAtNight 0
		xEgoPos 131
		yEgoPos 94
		xCoord 36
		yCoord 16
	)

	(method (hasBeenHere)
		(return gHarikVisits)
	)

	(method (canComeHere)
		(return (and (super canComeHere:) (!= gElementalState 7)))
	)
)

(instance Astrologer of _MapLocation
	(properties
		x 248
		y 186
		loop 5
		cel 4
		theRoom 200
		alterRoom 704
		beenHere 131
		openAtNight 0
		xEgoPos 238
		yEgoPos 189
		xCoord 81
		yCoord 6
	)
)

(instance Katta_s_Tail_Inn of _MapLocation
	(properties
		name {Katta's Tail Inn}
		x 113
		y 132
		loop 5
		cel 5
		theRoom 100
		alterRoom 300
		xEgoPos 118
		yEgoPos 136
		xCoord 45
	)

	(method (canComeHere)
		(return (and (super canComeHere:) (!= gElementalState 1)))
	)
)

(instance Enchantress of _MapLocation
	(properties
		x 245
		y 91
		loop 5
		cel 6
		theRoom 199
		beenHere 130
		xEgoPos 239
		yEgoPos 87
		xCoord 56
		yCoord 32
	)
)

(instance Magic_Shop of _MapLocation
	(properties
		name {Magic Shop}
		x 189
		y 88
		loop 5
		cel 7
		theRoom 250
		alterRoom 310
		beenHere 129
		openAtNight 0
		xEgoPos 192
		yEgoPos 92
		xCoord 45
		yCoord 24
	)

	(method (canComeHere)
		(return (and (super canComeHere:) (!= gElementalState 7)))
	)
)

(instance W__I__T_ of _MapLocation
	(properties
		name {W. I. T.}
		x 225
		y 49
		loop 5
		cel 8
		theRoom 229
		beenHere 62
		xEgoPos 216
		yEgoPos 51
		xCoord 40
		yCoord 40
	)

	(method (init theCast)
		(if (super init: theCast)
			(WIT2 init: theCast loop: loop cel: cel)
		)
	)

	(method (onMe aX aY)
		(if (not (super onMe: aX aY))
			(return (WIT2 onMe: aX aY))
		)
		(return 1)
	)
)

(instance WIT2 of _MapView
	(properties
		x 232
		y 53
	)
)

(instance Gates_Plaza of _MapLocation
	(properties
		name {Gates Plaza}
		x 87
		y 139
		loop 3
		theRoom 300
		xEgoPos 86
		yEgoPos 128
		xCoord 40
		yCoord -2
	)

	(method (init)
		(= points @gatesPlazaPts)
		(= nPoints 7)
		(super init: &rest)
	)
)

(instance Palace_Plaza of _MapLocation
	(properties
		name {Palace Plaza}
		x 278
		y 162
		loop 1
		theRoom 335
		xEgoPos 270
		yEgoPos 146
		xCoord 75
		yCoord 20
	)

	(method (init)
		(= points @palacePlazaPts)
		(= nPoints 7)
		(super init: &rest)
	)
)

(instance Fighters_Plaza_a of _MapLocation
	(properties
		name {Fighters Plaza}
		x 49
		y 33
		loop 4
		theRoom 320
		xEgoPos 35
		yEgoPos 23
		xCoord 3
		yCoord 20
	)

	(method (init)
		(= points @fighterPlazaWPts)
		(= nPoints 7)
		(super init: &rest)
	)
)

(instance Fighters_Plaza_b of _MapLocation
	(properties
		name {Fighters Plaza}
		loop 5
		cel 9
		theRoom 330
		xEgoPos 52
		yEgoPos 27
		xCoord 6
		yCoord 20
	)

	(method (init)
		(= points @fighterPlazaEPts)
		(= nPoints 7)
		(super init: &rest)
	)
)

(instance Fountain_Plaza_a of _MapLocation
	(properties
		name {Fountain Plaza}
		x 162
		y 89
		isCycling 1
		theRoom 310
		xEgoPos 170
		yEgoPos 85
		xCoord 40
		yCoord 22
	)

	(method (init)
		(= points @fountainPlazaNPts)
		(= nPoints 7)
		(super init: &rest)
	)
)

(instance Fountain_Plaza_b of _MapLocation
	(properties
		name {Fountain Plaza}
		hasIcon 0
		theRoom 315
		xEgoPos 155
		yEgoPos 91
		xCoord 40
		yCoord 18
	)

	(method (init)
		(= points @fountainPlazaSPts)
		(= nPoints 7)
		(super init: &rest)
	)
)

