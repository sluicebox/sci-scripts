;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7)
(include sci.sh)
(use Main)
(use SyncedView)
(use PolyPath)
(use Grooper)
(use Ego_64988)
(use Motion)
(use System)

(local
	local0
	local1
	local2
	local3
)

(class ego of Ego
	(properties
		modNum 7
		sightAngle 10
		state 2
		view 0
		intensity 100
		stopView 5
		accesories 0
	)

	(method (setTalker param1)
		(if (and argc param1)
			(= global130 param1)
		else
			(= global130 0)
		)
	)

	(method (init)
		(super init:)
		(if (& signal $0800)
			(&= state $fffd)
		)
	)

	(method (putOn param1 &tmp temp0)
		(for ((= temp0 0)) (< temp0 argc) ((++ temp0))
			(|= accesories [param1 temp0])
			(switch [param1 temp0]
				(1
					(if (not local0)
						(= local0 (SyncedView new:))
						(local0 offset: 10000 init: self)
					)
				)
				(2
					(if (not local1)
						(= local1 (SyncedView new:))
						(local1 offset: 10100 init: self)
					)
				)
				(4
					(if (not local2)
						(= local2 (SyncedView new:))
						(local2 offset: 10200 init: self)
					)
				)
				(8
					(if (not local3)
						(= local3 (SyncedView new:))
						(local3 offset: 10300 init: self)
					)
				)
			)
		)
	)

	(method (takeOff param1 &tmp temp0)
		(for ((= temp0 0)) (< temp0 argc) ((++ temp0))
			(if (& accesories [param1 temp0])
				(&= accesories (~ [param1 temp0]))
				(switch [param1 temp0]
					(1
						(gCast delete: local0)
						(local0 dispose: delete:)
						(= local0 0)
					)
					(2
						(gCast delete: local1)
						(local1 dispose: delete:)
						(= local1 0)
					)
					(4
						(gCast delete: local2)
						(local2 dispose: delete:)
						(= local2 0)
					)
					(8
						(gCast delete: local3)
						(local3 dispose: delete:)
						(= local3 0)
					)
				)
			)
		)
	)

	(method (dispose)
		(= local0 0)
		(= local1 0)
		(= local2 0)
		(= local3 0)
		(= global130 0)
		(= scaleSignal 0)
		(super dispose:)
	)

	(method (setHeading param1 param2 &tmp temp0 temp1 temp2)
		(= temp2 (if (>= argc 2) param2 else 0))
		(if argc
			(if (and (not mover) (< (Abs (- param1 heading)) sightAngle))
				(if temp2
					(temp2 cue: &rest)
				)
				(= heading param1)
				(return heading)
			else
				(= heading param1)
			)
		)
		(if (& signal $0800)
			(if temp2
				(temp2 cue: &rest)
			)
			(return heading)
		)
		(if looper
			(looper doit: self heading temp2)
		else
			(= temp0
				(cond
					((< 68 heading 113) 0)
					((< 247 heading 293) 1)
					((< 157 heading 203) 2)
					((or (> heading 337) (< heading 23)) 3)
					((< 112 heading 158) 4)
					((< 202 heading 248) 5)
					((< 22 heading 68) 6)
					((< 292 heading 338) 7)
				)
			)
			(self loop: temp0)
			(if temp2
				(temp2 cue: &rest)
			)
		)
		(return heading)
	)

	(method (setIntensity param1 param2)
		(cond
			((and (> argc 1) param2)
				(if (== param1 intensity)
					(return)
				else
					(= intensity param1)
					(Palette 2 34 36 intensity) ; PalIntensity
					(Palette 2 38 68 param1) ; PalIntensity
				)
			)
			((< param1 intensity)
				(Palette 2 34 36 param1) ; PalIntensity
				(Palette 2 38 68 param1) ; PalIntensity
			)
			(else
				(Palette 2 34 36 intensity) ; PalIntensity
				(Palette 2 38 68 intensity) ; PalIntensity
			)
		)
	)

	(method (setScaler param1)
		(if scaler
			(scaler dispose:)
			(= scaler 0)
		)
		(cond
			((or (not argc) (not param1))
				(&= scaleSignal $fffc)
				(return)
			)
			((param1 respondsTo: #scaler)
				((= scaler ((param1 scaler:) new:)) init: self &rest)
				(= scaleSignal (param1 scaleSignal:))
				(= maxScale (param1 maxScale:))
			)
			(else
				(= scaler
					(if (& (param1 -info-:) $8000)
						(param1 new:)
					else
						param1
					)
				)
				(|= scaleSignal $0001)
				(&= scaleSignal $fffd)
				(scaler init: self &rest)
			)
		)
	)

	(method (setLoop)
		(super setLoop: &rest)
		(if (& signal $0800)
			(&= state $fffd)
		else
			(|= state $0002)
		)
	)

	(method (put param1 param2 &tmp temp0)
		(if (self has: param1)
			((= temp0 (gInventory at: param1))
				moveTo: (if (== argc 1) gCurRoomNum else param2)
			)
			(if (and gTheIconBar (== (gTheIconBar curInvIcon:) temp0))
				(gTheIconBar
					curInvIcon: 0
					disableIcon:
						((gTheIconBar useIconItem:) setCursor: gNormalCursor yourself:)
					show: 0
				)
				(if (& (gTheIconBar state:) $0004)
					(gGame setCursor: gWaitCursor 1)
					(gTheIconBar curIcon: (gTheIconBar at: 7))
				)
			)
		)
	)

	(method (normalize param1 param2 &tmp temp0 temp1)
		(if argc
			(= view param1)
		else
			(= view 0)
		)
		(if (> argc 1)
			(= loop param2)
		else
			(= loop
				(= temp0
					(cond
						((< 68 heading 113) 0)
						((< 247 heading 293) 1)
						((< 157 heading 203) 2)
						((or (> heading 337) (< heading 23)) 3)
						((< 112 heading 158) 4)
						((< 202 heading 248) 5)
						((< 22 heading 68) 6)
						((< 292 heading 338) 7)
					)
				)
			)
		)
		(switch view
			(0
				(= cel 0)
				(= stopView 5)
				(= origStep 1539)
			)
			(9120
				(= cel 0)
				(= stopView 9125)
				(= origStep 2052)
			)
			(9127
				(= cel 0)
				(= stopView 9128)
				(= origStep 2052)
			)
			(9740
				(= cel 0)
				(= stopView 9741)
				(= origStep 2052)
			)
			(9797
				(= cel 0)
				(= stopView 9798)
				(= origStep 2052)
			)
			(9830
				(= cel temp0)
				(= origStep 1539)
				(= stopView -1)
			)
		)
		(if (== stopView 9125)
			(self setStep: 8 4)
		else
			(self setStep: 4 2)
		)
		(self
			setLoop: -1
			setCel: -1
			setPri: -1
			setMotion: 0
			setLooper: Grooper
			setCycle: StopWalk stopView
			z: 0
			illegalBits: 0
			ignoreActors: 0
			setSpeed: global112
			sightAngle: 10
		)
		(self signal: (| signal $1000))
		(for ((= temp1 32768)) temp1 ((>>= temp1 $0001))
			(if (& accesories temp1)
				(self putOn: temp1)
			)
		)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2)
		(= temp1 (event type:))
		(= temp2 (event message:))
		(cond
			((and script (script handleEvent: event)) 1)
			((& temp1 $0010) ; direction
				(event claimed: 1)
				(return)
			)
			((& temp1 evVERB)
				(if (& temp1 evMOVE)
					(if (and (== (event x:) x) (== (event y:) y))
						(event claimed: 1)
					else
						(switch gUseObstacles
							(0
								(self
									setMotion:
										MoveTo
										(event x:)
										(+ (event y:) z)
								)
							)
							(1
								(self
									setMotion:
										PolyPath
										(event x:)
										(+ (event y:) z)
								)
							)
							(2
								(self
									setMotion:
										PolyPath
										(event x:)
										(+ (event y:) z)
										0
										0
								)
							)
						)
						(gUser prevDir: 0)
						(event claimed: 1)
					)
				else
					(super handleEvent: event)
				)
			)
			(else
				(super handleEvent: event)
			)
		)
		(event claimed:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(66 ; parkerID
				(if (== gCurRoomNum 510)
					(self put: 43 -999) ; parkerID
					(gGame points: 3 63)
					(gMessager say: 1 theVerb 1 0 0 7) ; "You attach your Parker Center ID to your suit."
				else
					(gMessager say: 1 theVerb 0 0 0 7) ; "There's no need to wear your Parker Center ID at this time."
				)
				(return 1)
			)
			(15 ; vest
				(if (OneOf gCurRoomNum 170 725 735 745 750 755)
					(if (== gCurRoomNum 170)
						(gPqFlags set: 180)
					)
					(self put: 5) ; vest
					((gInventory at: 5) state: 1) ; vest
					(if (== gCurRoomNum 170)
						(gGame points: 3)
					)
					(gMessager say: 1 theVerb 1 0 0 7) ; "That should provide some protection."
					(return 1)
				)
			)
		)
		(return
			(cond
				((== (gCurRoom modNum:) -1)
					(if (Message msgSIZE gCurRoomNum noun theVerb 0 0)
						(gMessager say: noun theVerb 0 0 0 gCurRoomNum)
					else
						(gMessager say: 1 theVerb 0 0 0 7)
					)
				)
				((Message msgSIZE (gCurRoom modNum:) noun theVerb 0 0)
					(gMessager say: noun theVerb 0 0 0 (gCurRoom modNum:))
				)
				(else
					(gMessager say: 1 theVerb 0 0 0 7)
				)
			)
		)
	)

	(method (showInv)
		(cond
			((gInventory firstTrue: #ownedBy gEgo)
				(gInventory showSelf: gEgo)
			)
			((== gDay 6)
				(gMessager say: 48 0 10 1 0 11) ; "Everything has been removed from your pockets!"
			)
			(else
				(gMessager say: 48 0 0 1 0 11) ; "Your pockets are empty!"
			)
		)
	)
)

