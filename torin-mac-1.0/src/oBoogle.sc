;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64018)
(include sci.sh)
(use Main)
(use TPOrbit)
(use TPWander)
(use TPChase)
(use TPSound)
(use CueMe)
(use Array)
(use Scaler)
(use PolyPath)
(use Feature)
(use StopWalk)
(use Grooper)
(use Motion)
(use Actor)
(use System)

(public
	oBoogle 0
	soBoogleIntoPouch 1
	soBoogleOutOfPouch 2
	GetDestLoc 3
	IsBadDestLoc 4
	oBoogleStartWandering 5
	BoogleBoogie 6
)

(local
	bibtx
	bibty
	bibbx
	bibby
	BoogleZipX
	BoogleZipY
	BoogleIsFidget
	BoogleIsFlat
	BoogleSquashTime
	bBoogleZipping
)

(procedure (BoogleBoogie nX nY opCuee &tmp oCuee nDist)
	(if (> argc 2)
		(= oCuee opCuee)
	else
		(= oCuee 0)
	)
	(if (< (= nDist (GetDistance nX nY (oBoogle x:) (oBoogle y:))) 100)
		(= BoogleZipX nX)
		(= BoogleZipY nY)
		(oBoogle setWander: 0)
		(oBoogle setMotion: 0)
		(poNull setScript: soBoogleBoogie oCuee)
	else
		(oBoogle setWander: 0 zipTo: nX nY oCuee)
	)
)

(procedure (GetDestLoc anActor destX destY obstacleList &tmp ppDest pathData aPlane obst i tmpArray)
	(= aPlane (anActor plane:))
	(if (== 4 argc)
		(= obst obstacleList)
	else
		(= obst (gCurRoom obstacles:))
	)
	(= tmpArray
		(AvoidPath
			(anActor x:)
			(anActor y:)
			destX
			destY
			obst
			(+ (- (aPlane right:) (aPlane left:)) 1)
			(+ (- (aPlane bottom:) (aPlane top:)) 1)
			1
		)
	)
	((= pathData (IntArray new:)) copy: tmpArray)
	(KArray 4 tmpArray) ; ArrayFree
	(for ((= i 2)) (!= (pathData at: i) 30583) ((+= i 2))
	)
	(= ppDest
		(IntArray newWith: 2 (pathData at: (- i 2)) (pathData at: (- i 1)))
	)
	(pathData dispose:)
	(return ppDest)
)

(procedure (IsBadDestLoc anActor destX destY &tmp ppDest badLoc)
	(= ppDest (GetDestLoc anActor destX destY))
	(= badLoc (or (!= destX (ppDest at: 0)) (!= destY (ppDest at: 1))))
	(ppDest dispose:)
	(return badLoc)
)

(procedure (MatchScaler propA propB)
	(if (& (propA scaleSignal:) $0001)
		(propB setScale: scaleX: (propA scaleX:) scaleY: (propA scaleY:))
	else
		(propB setScale: 0)
	)
	(if (propA scaler:)
		(propB
			setScaler:
				Scaler
				((propA scaler:) frontSize:)
				((propA scaler:) backSize:)
				((propA scaler:) frontY:)
				((propA scaler:) backY:)
		)
	)
)

(procedure (getPouchJumpLocs intoPouch &tmp rightSide scale realBoogle nAttempts)
	(= scale (gEgo scaleX:))
	(= bibtx (gEgo x:))
	(= bibty (gEgo y:))
	(= bibbx (+ bibtx (MulDiv 54 scale 128)))
	(= bibby (+ bibty 1))
	(= rightSide 1)
	(if (and intoPouch (IsBadDestLoc gEgo bibbx bibby))
		(= bibbx (+ bibtx (MulDiv -64 scale 128)))
		(= bibby (+ bibty 1))
		(= rightSide 0)
		(for ((= nAttempts 0)) (IsBadDestLoc gEgo bibbx bibby) ((++ nAttempts))
			(if (> bibty 190)
				(-= bibty (Random 10 30))
			else
				(+= bibty (Random 10 30))
			)
			(= bibbx (+ bibtx (MulDiv 54 scale 128)))
			(= bibby (+ bibty 1))
			(= rightSide 1)
			(if (IsBadDestLoc gEgo bibbx bibby)
				(= bibbx (+ bibtx (MulDiv -64 scale 128)))
				(= bibby (+ bibty 1))
				(= rightSide 0)
			)
			(if (> nAttempts 10)
				(break)
			)
		)
	)
	(return rightSide)
)

(instance poNull of Prop
	(properties)
)

(instance soBoogleBoogie of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register (oBoogle cycleSpeed:))
				(oBoogle
					setSpeed: (Min (oBoogle cycleSpeed:) 2)
					setMotion: PolyPath BoogleZipX BoogleZipY self
				)
			)
			(1
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(oBoogle setSpeed: register)
		(oBoogle setMotion: 0)
		(super dispose: &rest)
	)
)

(instance poBoogle of Prop
	(properties)

	(method (init)
		(MatchScaler gEgo self)
		(super init: &rest)
	)
)

(class soBooglePouch of Script
	(properties
		intoPouch 0
		rightSide 0
		destX 0
		destY 0
		destHeading 0
	)

	(method (init)
		(= gbUnflattenBoogle 1)
		(= rightSide (getPouchJumpLocs intoPouch))
		(= destX (gEgo x:))
		(= destY (gEgo y:))
		(= destHeading (gEgo heading:))
		(super init: &rest)
	)

	(method (dispose)
		(= gbUnflattenBoogle 0)
		(super dispose:)
	)
)

(instance soMoveTorin of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath bibtx bibty self)
			)
			(1
				(gEgo setHeading: 180 self)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance oBoogleSound of TPSound
	(properties)
)

(instance soBoogleIntoPouch of soBooglePouch
	(properties)

	(method (init)
		(oBoogleSound preload: 60012)
		(= intoPouch 1)
		(super init: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo face: oBoogle self)
			)
			(1
				(if (<= 1 gnBoogleInBagMsg 5)
					(gMessager say: 1 0 27 gnBoogleInBagMsg self 0)
				else
					(gMessager say: 1 0 27 (Random 1 5) self 0)
				)
			)
			(2
				(self setScript: soMoveTorin self)
				(oHereBoy
					approachX: bibbx
					approachY: bibby
					morphScript: self
					init:
				)
				(oBoogle setSpeed: (Min (oBoogle cycleSpeed:) 2))
				(if (not ((gCurRoom oBoogleFeatures:) size:))
					(oBoogle nDoits: 0)
				)
				(oBoogle setWander: 1)
			)
			(3)
			(4
				(if rightSide
					(oBoogle setHeading: 270 self)
					(poBoogle loop: 3)
				else
					(oBoogle setHeading: 90 self)
					(poBoogle loop: 2)
				)
			)
			(5
				(oBoogle hide:)
				(poBoogle
					view: 60202
					setCel: 0
					posn: (gEgo x:) (gEgo y:)
					init:
					setPri: (oBoogle priority:)
					setCycle: CT 7 1 self
				)
			)
			(6
				(oBoogleSound playSound: 60012)
				(poBoogle setCycle: End self)
			)
			(7
				(poBoogle dispose:)
				((ScriptID 64017 0) set: 232) ; oFlags
				(self dispose:)
			)
		)
	)

	(method (dispose)
		((ScriptID 64017 0) set: 232) ; oFlags
		(poBoogle dispose:)
		(gCurRoom delBoogleFeature: oHereBoy)
		(super dispose: &rest)
	)
)

(instance soBoogleOutOfPouch of soBooglePouch
	(properties)

	(method (init)
		(oBoogleSound preload: 30304)
		(= intoPouch 0)
		(super init: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(self setScript: soMoveTorin self)
			)
			(1
				(MatchScaler gEgo poBoogle)
				(poBoogle
					view: 60202
					loop: (if rightSide 0 else 1)
					setCel: 0
					posn: (gEgo x:) (gEgo y:)
					init:
					setPri: (gEgo priority:)
					setCycle: CT 3 1 self
				)
			)
			(2
				(oBoogleSound playSound: 30304)
				(poBoogle setCycle: End self)
			)
			(3
				(poBoogle dispose:)
				((ScriptID 64017 0) clear: 232) ; oFlags
				(oBoogle
					normalize:
					loop: 8
					cel: (if rightSide 4 else 5)
					posn: bibbx bibby
				)
				(MatchScaler gEgo oBoogle)
				(oBoogle init:)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		((ScriptID 64017 0) clear: 232) ; oFlags
		(poBoogle dispose:)
		(super dispose: &rest)
	)
)

(class BoogleLearnMeClass of Feature
	(properties
		morphScript 0
	)

	(method (init whoCue)
		(if argc
			(= morphScript whoCue)
		)
		(super init: &rest)
	)

	(method (learn)
		(oBoogle approachThenFace: self self)
	)

	(method (cue)
		(oBoogle setScript: morphScript oBoogleStartWandering)
	)
)

(class oBoogleStartWandering of CueMe
	(properties)

	(method (cue)
		(oBoogle setWander: 1)
	)
)

(instance soBoogleZip of Script
	(properties)

	(method (cue)
		(self changeState: (+ state 1) &rest)
	)

	(method (changeState newState &tmp newView dest)
		(switch (= state newState)
			(0
				(= bBoogleZipping 1)
				(oBoogleSound preload: 60022 60023)
				(oBoogle setMotion: 0)
				(= dest (GetDestLoc oBoogle BoogleZipX BoogleZipY))
				(= BoogleZipX (dest at: 0))
				(= BoogleZipY (dest at: 1))
				(dest dispose:)
				(MatchScaler oBoogle poBoogle)
				(poBoogle
					view: 60204
					posn: (oBoogle x:) (oBoogle y:)
					setCel: 0
					setLoop: (if (> BoogleZipX (oBoogle x:)) 1 else 0)
					init:
					setPri: (oBoogle priority:)
					setCycle: CT 3 1 self
				)
				(oBoogle hide: posn: BoogleZipX BoogleZipY)
			)
			(1
				(oBoogleSound playSound: 60023)
				(poBoogle setCycle: End self)
			)
			(2
				(oBoogleSound playSound: 60022)
				(poBoogle
					posn: BoogleZipX BoogleZipY
					setCel: 0
					setLoop: (+ (poBoogle loop:) 2)
					setCycle: End self
					setPri: (oBoogle priority:)
				)
			)
			(3
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(= bBoogleZipping 0)
		(poBoogle dispose:)
		(oBoogle show:)
		(if (oBoogle scaler:)
			((oBoogle scaler:) doit:)
		)
		(super dispose:)
	)
)

(instance soBoogleWag of Script
	(properties)

	(method (changeState newState &tmp newView)
		(switch (= state newState)
			(0
				(= BoogleIsFidget 1)
				(= newView 60250)
				(if (== (oBoogle loop:) 8)
					(+= newView (oBoogle cel:))
				else
					(+= newView (oBoogle loop:))
				)
				(MatchScaler oBoogle poBoogle)
				(poBoogle
					view: newView
					setCel: 0
					setLoop: 0
					posn: (oBoogle x:) (oBoogle y:)
					init:
					setPri: (oBoogle priority:)
					setCycle: Fwd self
				)
				(oBoogle hide:)
				(= ticks (oBoogle nDoits:))
			)
			(1
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(= BoogleIsFidget 0)
		(super dispose:)
		(poBoogle dispose:)
		(oBoogle show:)
	)
)

(instance oBoogleChase of TPChase
	(properties)

	(method (init)
		(= obstacles (oBoogle obstacles:))
		(super init: &rest)
	)
)

(instance oBoogleOrbit of TPOrbit
	(properties)

	(method (init)
		(= obstacles (oBoogle obstacles:))
		(super init: &rest)
	)
)

(instance oBoogleWander of TPWander
	(properties)

	(method (init)
		(= obstacles (oBoogle obstacles:))
		(super init: &rest)
	)
)

(class BoogleActor of Actor
	(properties
		nDoits 0
		bWander 1
		obstacles 0
	)

	(method (setWander wanderOn)
		(if wanderOn
			(= bWander 1)
			(= nDoits 0)
		else
			(= bWander 0)
			(self stopIdler:)
		)
	)

	(method (stopIdler)
		(self setMotion: 0)
		(if (== soBoogleWag (oBoogle script:))
			(oBoogle setScript: 0)
		)
		(if bBoogleZipping
			(soBoogleZip dispose:)
		)
		(if (poNull script:)
			(poNull setScript: 0)
		)
		(if BoogleIsFlat
			(self unSquash:)
		)
	)

	(method (unSquash)
		(= BoogleIsFlat 0)
		(self show:)
		(poBoogle dispose:)
	)

	(method (doSquash &tmp tooClose)
		(= tooClose (Max 1 (MulDiv 15 scaleY 128)))
		(cond
			((and (not gbUnflattenBoogle) (< (self distanceTo: gEgo) tooClose))
				(if
					(and
						bWander
						(not BoogleIsFlat)
						(not (gEgo isStopped:))
						(or (self isNotHidden:) BoogleIsFidget)
					)
					(oBoogleSound playSound: 60024)
					(self hide:)
					(poBoogle
						view: 60299
						loop: 0
						cel: 0
						posn: x y
						init:
						setPri: (oBoogle priority:)
					)
					(= BoogleSquashTime gGameTime)
					(= BoogleIsFlat 1)
				)
			)
			(BoogleIsFlat
				(self unSquash:)
			)
		)
		(if BoogleIsFlat
			(poBoogle setPri: (- (gEgo priority:) 1))
		)
	)

	(method (doit)
		(super doit: &rest)
		(if
			(and
				(gEgo bIsInitialized:)
				(gEgo isNotHidden:)
				(gEgo plane:)
				((gEgo plane:) isEnabled:)
			)
			(self doSquash:)
		)
		(if (and BoogleIsFlat (not (gEgo isNotHidden:)))
			(self unSquash:)
		)
		(if (and BoogleIsFlat (> (- gGameTime BoogleSquashTime) 300))
			(self unSquash:)
		)
		(if (> nDoits 0)
			(-- nDoits)
		)
		(if (and (self isNotHidden:) bWander (<= nDoits 0))
			(self selectBoogleMover:)
		)
	)

	(method (zipTo zx zy zCuee)
		(= BoogleZipX zx)
		(= BoogleZipY zy)
		(soBoogleZip caller: zCuee init:)
	)

	(method (selectBoogleMover &tmp temp0 temp1 temp2 temp3 temp4 temp5 [temp6 3])
		(= nDoits (Random 50 250))
		(if BoogleIsFlat
			(return)
		)
		(self stopIdler:)
		(= temp1 (Random 1 100))
		(cond
			(
				(and
					(= temp2 (gCurRoom oBoogleFeatures:))
					(> (temp2 size:) 0)
					(= temp3 (temp2 at: 0))
				)
				(self setWander: 0)
				(temp3 learn:)
			)
			((> (= temp4 (self distanceTo: gEgo)) 500)
				(= temp5 (GetAngle (gEgo x:) (gEgo y:) x y))
				(= temp4 50)
				(= bWander 0)
				(self
					zipTo:
						(+ (gEgo x:) (SinMult temp5 temp4))
						(+ (gEgo y:) (CosMult temp5 temp4))
						oBoogleStartWandering
				)
			)
			(
				(and
					(!= mover oBoogleChase)
					(> (= temp4 (self distanceTo: gEgo)) 200)
				)
				(self setMotion: oBoogleChase gEgo 50 oBoogleStartWandering)
			)
			((and (< temp1 10) (!= oBoogleWander mover))
				(self setMotion: oBoogleWander 100)
			)
			((and (< temp1 15) (!= oBoogleOrbit mover))
				(self
					setMotion:
						oBoogleOrbit
						gEgo
						50
						(GetAngle (gEgo x:) (gEgo y:) x y)
						(if (& $0001 temp1) -15 else 15)
				)
			)
			((and (< temp1 35) (not (oBoogle script:)))
				(oBoogle setScript: soBoogleWag)
			)
		)
	)

	(method (addObstacle obstacle)
		(if (not obstacles)
			(= obstacles (List new:))
		)
		(obstacles add: obstacle &rest)
	)

	(method (removeObstacle)
		(if obstacles
			(obstacles dispose:)
			(= obstacles 0)
		)
	)

	(method (dispose)
		(self stopIdler:)
		(self removeObstacle:)
		(super dispose:)
	)
)

(instance oBoogle of BoogleActor
	(properties
		view 60200
	)

	(method (init)
		(= BoogleIsFlat 0)
		(= BoogleIsFidget 0)
		(super init: &rest)
	)

	(method (normalize)
		(self
			view: 60200
			z: 0
			removeObstacle:
			setStep: 6 4
			setSpeed: (gGame nGameSpeed:)
			setScale: 0
			setScaler: 0
			scaleX: 128
			scaleY: 128
			setLooper: Grooper
			setLoop: -1
			setPri: -1
			setMotion: 0
			setCycle: StopWalk -1
			ignoreActors: 1
			setWander: (not ((ScriptID 64017 0) test: 232)) ; oFlags
		)
	)
)

(instance oHereBoy of BoogleLearnMeClass
	(properties)

	(method (init)
		(super init: &rest)
		(gCurRoom addBoogleFeature: self)
	)

	(method (learn)
		(gCurRoom delBoogleFeature: self)
		(oBoogle approachThenFace: self morphScript)
	)
)

