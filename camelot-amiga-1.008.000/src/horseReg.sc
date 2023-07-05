;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 113)
(include sci.sh)
(use Main)
(use Interface)
(use TurnLooper)
(use StopWalk)
(use Game)
(use System)

(public
	horseReg 0
)

(instance horseTurnLooper of TurnLooper
	(properties
		viewChange 31
	)
)

(instance horseBaseSetter of Code
	(properties)

	(method (doit param1 &tmp temp0 temp1)
		(if
			(or
				(== (param1 view:) 408)
				(== (param1 view:) 8)
				(== (param1 view:) 64)
			)
			(= temp0
				(/ (CelWide (param1 view:) (param1 loop:) (param1 cel:)) 2)
			)
			(= temp1 (+ (param1 yStep:) 4))
			(if (<= (param1 loop:) 1)
				(-= temp0 8)
				(+= temp1 2)
			else
				(+= temp1 6)
			)
			(param1
				brTop: (- (param1 y:) temp1)
				brBottom: (param1 y:)
				brLeft: (- (param1 x:) temp0)
				brRight: (+ (param1 x:) temp0)
			)
		else
			(BaseSetter param1)
		)
	)
)

(instance horseStopWalk of StopWalk
	(properties)
)

(instance horseReg of Rgn
	(properties)

	(method (init)
		(= gHorseStopWalk horseStopWalk)
		(= gHorseTurnLooper horseTurnLooper)
		(Load rsSCRIPT 119)
		(if (<= 8 gCurRoomNum 17)
			(Load rsVIEW 401)
			(Load rsVIEW 9)
			(Load rsVIEW 65)
			(Load rsVIEW 13)
			(Load rsVIEW 31)
			(if (== global116 1)
				(gEgo view: 9 setStep: 3 2 setCycle: gHorseStopWalk 65)
			)
			(gHorseObj view: 401)
			(horseTurnLooper viewChange: 31)
		else
			(Load rsVIEW 408)
			(Load rsVIEW 8)
			(Load rsVIEW 66)
			(Load rsVIEW 64)
			(Load rsVIEW 30)
			(if (== global116 1)
				(gEgo view: 8 setStep: 4 2 setCycle: gHorseStopWalk 64)
			)
			(gHorseObj view: 408)
			(horseTurnLooper viewChange: 30)
		)
		(super init:)
		(switch global116
			(1
				(gEgo looper: gHorseTurnLooper baseSetter: horseBaseSetter)
			)
			(2
				(gHorseObj init:)
			)
		)
	)

	(method (doit)
		(super doit:)
		(switch global116
			(3
				(if (not (gEgo script:))
					(gEgo setScript: (ScriptID 119 0)) ; DoMount
				)
			)
			(4
				(if (not (gEgo script:))
					(gEgo setScript: (ScriptID 119 1)) ; DoDismount
				)
			)
			(5
				(if (not (gEgo script:))
					(gEgo setScript: (ScriptID 119 1)) ; DoDismount
				)
			)
		)
		(if (and (== global116 3) (== (gEgo baseSetter:) 0))
			(gEgo baseSetter: horseBaseSetter)
		)
	)

	(method (handleEvent event)
		(cond
			(
				(or
					(event claimed:)
					(and
						(!= (event type:) evSAID)
						(not
							(and
								(== (event type:) evMOUSEBUTTON)
								(& (event modifiers:) emSHIFT)
							)
						)
					)
				)
				(return)
			)
			((Said 'mount,(get<on)[/charger]')
				(cond
					((== global116 1)
						(Print 113 0) ; "One must be off a horse to get on a horse."
					)
					((> (gEgo distanceTo: gHorseObj) 50)
						(NotClose) ; "Perhaps you should move closer."
					)
					(
						(or
							(and
								(== (gHorseObj loop:) 0)
								(> (gEgo y:) (gHorseObj y:))
							)
							(and
								(== (gHorseObj loop:) 1)
								(< (gEgo y:) (gHorseObj y:))
							)
						)
						(Print 113 1) ; "Your warhorse is trained to be mounted from the left side."
					)
					(else
						(= global116 3)
						(gEgo setScript: (ScriptID 119 0)) ; DoMount
					)
				)
			)
			((Said 'dismount,(get<off)[/charger]')
				(cond
					((== global116 2)
						(Print 113 2) ; "You must be on a horse to get off a horse."
					)
					(
						(and
							(== global116 1)
							(or
								(== gCurRoomNum 8)
								(== gCurRoomNum 15)
								(== gCurRoomNum 17)
								(== gCurRoomNum 24)
								(== gCurRoomNum 25)
								(== gCurRoomNum 33)
							)
						)
						(= global116 6)
						(gEgo setScript: (ScriptID 119 1)) ; DoDismount
					)
					((and (== gCurRoomNum 9) (== gPrevRoomNum 8))
						(Print 113 3) ; "You have only begun your journey. You can surely stay in your saddle longer than this."
					)
					((>= 17 gCurRoomNum 10)
						(Print 113 4) ; "There are very few places in the forest where that would be either safe or advisable. This is not one of them."
					)
					(else
						(Print 113 5) ; "This is no time to wander about on foot. Do get on with your mission."
					)
				)
			)
			((Said 'use/whip')
				(Print 113 6) ; "Being a superb rider, you do not carry one."
			)
			(
				(or
					(Said 'remove,(get<off)/gear,bridle')
					(Said 'unsaddle/charger')
				)
				(Print 113 7) ; "Not now. You have places to go."
			)
			((or (Said 'hide/charger') (Said 'drop/blanket/charger'))
				(Print 113 8) ; "Your horse is not cold, Arthur."
			)
			((Said 'get/rein')
				(if (== global116 1)
					(Print 113 9) ; "You already have the reins."
				else
					(Print 113 10) ; "Mount your horse first, Arthur."
				)
			)
			((Said 'tie/charger')
				(Print 113 11) ; "You need not tie a trained warhorse."
			)
			((Said '/charger>')
				(cond
					((Said 'look')
						(Print 113 12) ; "He looks much the same as last time you looked at him."
					)
					((or (Said 'jump') (Said 'make//jump'))
						(if (== global116 1)
							(Print 113 13) ; "Your horse is built for power, stamina and solidity to carry you with armor and weaponry into battle. This does not make him a very good jumper."
						else
							(Print 113 14) ; "Do you suffer from the delusion that you are on a horse?"
						)
					)
					((Said 'ride')
						(cond
							((!= global116 1)
								(Print 113 15) ; "One must generally be on a horse to do that."
							)
							((IsFlag 20)
								(Print 113 16) ; "It would be best to go at a pace the mule can match."
							)
							(else
								(Print 113 17) ; "Trust the instincts of your well-trained steed. He knows when to hurry and when to tread with care."
							)
						)
					)
					((Said 'feed,water,rest')
						(Print 113 18) ; "There will be time enough for that later."
					)
				)
			)
		)
	)
)

