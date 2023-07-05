;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 80)
(include sci.sh)
(use Main)
(use KQ6Room)
(use n913)
(use Scaler)
(use PolyPath)
(use StopWalk)
(use Grooper)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rgCastle 0
	proc80_2 2
	guardsGetEgo 4
	guard1 5
	guard2 6
	proc80_7 7
)

(local
	local0
	local1
	local2
)

(procedure (proc80_2 param1 &tmp temp0 temp1)
	(gGame handsOff:)
	(switch param1
		(4
			(= temp0 -40)
			(= temp1 0)
		)
		(2
			(= temp0 40)
			(= temp1 0)
		)
		(1
			(= temp0 0)
			(= temp1 -40)
		)
	)
	(gEgo
		ignoreActors: 1
		setMotion: MoveTo (+ (gEgo x:) temp0) (+ (gEgo y:) temp1)
	)
)

(procedure (localproc_0 param1 param2 param3 &tmp temp0 temp1 temp2 temp3 temp4)
	(= temp2 (- (gEgo brLeft:) param2))
	(= temp0 (- (gEgo brTop:) param3))
	(= temp3 (+ (gEgo brRight:) param2))
	(= temp1 (+ (gEgo brBottom:) param3))
	(if (not local2)
		(if (gCurRoom moveOtherGuard:)
			(++ local2)
		)
		(= local0 (Max temp2 (Min temp3 (param1 x:))))
		(= local1 (Max temp0 (Min temp1 (param1 y:))))
	else
		(= local2 0)
		(= temp4 (- (* (<= (gEgo x:) (param1 x:)) 2) 1))
		(= local0
			(+
				(gEgo x:)
				(*
					(+ (/ (- (gEgo brRight:) (gEgo brLeft:)) 2) param2)
					temp4
				)
			)
		)
		(= local1 (Max temp0 (Min temp1 (param1 y:))))
	)
)

(procedure (proc80_7 &tmp temp0 temp1)
	(= temp0 (localproc_1 (ScriptID 80 5))) ; guard1
	(= temp1 (localproc_1 (ScriptID 80 6))) ; guard2
	(if (<= temp0 temp1)
		(ScriptID 80 5) ; guard1
	else
		(ScriptID 80 6) ; guard2
	)
)

(procedure (localproc_1 param1 &tmp temp0)
	(if (gCast contains: param1)
		(= temp0
			(GetDistance (param1 x:) (param1 y:) (gEgo x:) (gEgo y:) 60)
		)
	else
		(= temp0 500)
	)
	(return temp0)
)

(class CastleRoom of KQ6Room
	(properties
		spotEgoScr 0
		minScaleSize 10
		maxScaleSize 100
		minScaleY 0
		maxScaleY 190
		moveOtherGuard 0
		scalerCode 0
	)

	(method (doLoiter))

	(method (warnUser))

	(method (dispose)
		(= scalerCode (= spotEgoScr 0))
		(super dispose:)
	)

	(method (newRoom)
		(if (and (!= (gGlobalSound2 prevSignal:) -1) (== (gGlobalSound2 number:) 710))
			(gGlobalSound2 fade:)
		)
		(super newRoom: &rest)
	)

	(method (spotEgo param1)
		(gGlobalSound stop:)
		(gGlobalSound2 number: 710 loop: -1 play:)
		(if spotEgoScr
			(gCurRoom setScript: spotEgoScr 0 param1)
		else
			(param1 setScript: guardsGetEgo &rest)
		)
	)

	(method (scriptCheck param1 &tmp temp0)
		(= temp0 0)
		(if
			(and
				(OneOf param1 85 87 93)
				(OneOf
					gCurRoomNum
					710
					720
					730
					770
					780
					781
					800
					810
					820
					840
					850
					860
					870
					880
				)
			)
			(switch param1
				(85
					(gMessager say: 0 0 199 0 0 899) ; "The sound of the flute would doubtless bring the guard dogs down on Alexander's head! Even if it might cheer him up, he's not going to play it here in the castle!"
				)
				(87
					(gMessager say: 0 0 198 0 0 899) ; "This is no time to be experimenting around with an unknown potion; the castle is crawling with guard dogs! Alexander should have thought of that before!"
				)
				(93
					(gMessager say: 0 0 3 0 0 899) ; "The sound of the mechanical nightingale would doubtless bring the guard dogs down on Alexander's head! That might not be a good idea--at least, not at the present moment!"
				)
			)
		else
			(= temp0 1)
		)
		(return temp0)
	)
)

(class GuardDog of Actor
	(properties
		sightAngle 95
		cycleSpeed 10
		moveSpeed 10
		okToCheck 0
		checkCode 0
		regPathID 0
	)

	(method (init)
		(self setScale:)
		(super init: &rest)
		(self
			setCycle: StopWalk -1
			setLoop: Grooper
			setStep: 4 2
			ignoreHorizon:
			illegalBits: 0
			ignoreActors: 1
			signal: (| signal $1000)
		)
	)

	(method (doit)
		(super doit:)
		(if
			(and
				okToCheck
				(or (not (IsObject okToCheck)) (self perform: okToCheck))
				(IsObject checkCode)
				(self perform: checkCode)
			)
			(= checkCode 0)
			(gGame handsOff:)
			(self setMotion: 0)
			(gCurRoom spotEgo: self)
		)
		(if (and (IsObject gCurRoom) (gCurRoom scalerCode:))
			(self perform: (gCurRoom scalerCode:))
		)
	)

	(method (dispose)
		(= regPathID (= checkCode (= okToCheck 0)))
		(if (IsObject scaler)
			(scaler dispose:)
		)
		(= scaler 0)
		(super dispose:)
	)
)

(class rgCastle of Rgn
	(properties
		rFlag1 0
		rFlag2 0
		rFlag3 0
		dungeonEntered 0
		lastSeconds 0
		loiterTimer -1
		weddingRemind 0
		guardTimer 0
		guard2Timer 0
		guard1Code 0
		guard2Code 0
		stopTimers 0
		weddingMusicCount -1
	)

	(method (doit &tmp temp0)
		(= temp0 (GetTime 1)) ; SysTime12
		(cond
			(
				(and
					(not gFastCast)
					(not (& (gTheIconBar state:) $0020))
					(!= lastSeconds temp0)
					(== gCurRoomNum gNewRoomNum)
					(not stopTimers)
				)
				(= lastSeconds temp0)
				(if
					(and
						(> loiterTimer 0)
						(not (gCurRoom script:))
						(== (-- loiterTimer) 0)
					)
					(self doLoiter:)
				)
				(if (and (> weddingRemind 0) (== (-- weddingRemind) 0))
					(if
						(or
							weddingMusicCount
							(and
								(== (gRegions size:) 3)
								(not ((ScriptID 81 0) tstFlag: #rFlag1 1)) ; RgBasement
								(not ((ScriptID 81 0) tstFlag: #rFlag1 2)) ; RgBasement
							)
							1
						)
						(if (!= (gGlobalSound number:) 701)
							(gGlobalSound fadeTo: 701 -1)
						)
						(|= rFlag1 $0002)
						(++ weddingMusicCount)
						(gCurRoom warnUser: 1)
					else
						(= weddingRemind 5)
					)
				)
				(if (and (> guardTimer 0) (== (-- guardTimer) 0))
					(cond
						((not (& rFlag2 $0001))
							(|= rFlag2 $0001)
							(if (OneOf gCurRoomNum 850 880 781)
								(gCurRoom warnUser: 2)
							)
						)
						((== gCurRoomNum 850)
							(gGame handsOff:)
							(gCurRoom spotEgo: (ScriptID 80 5)) ; guard1
						)
					)
				)
				(if (and (> guard2Timer 0) (== (-- guard2Timer) 0))
					(cond
						((not (& rFlag2 $0020))
							(|= rFlag2 $0020)
							(if (== gCurRoomNum 870)
								(gCurRoom warnUser: 3 0)
							)
						)
						((== gCurRoomNum 870)
							(gGame handsOff:)
							(gCurRoom warnUser: 3 1)
						)
					)
				)
			)
			((& (gTheIconBar state:) $0020)
				(= lastSeconds temp0)
			)
		)
		(super doit:)
	)

	(method (newRoom newRoomNumber)
		((ScriptID 80 0) ; rgCastle
			keep:
				(OneOf
					newRoomNumber
					700
					710
					720
					730
					740
					750
					760
					770
					780
					781
					790
					800
					810
					820
					840
					850
					860
					870
					880
					180
					743
				)
		)
		(= initialized 0)
		(= loiterTimer -1)
		(super newRoom: newRoomNumber &rest)
		(= guard1Code (= guard2Code 0))
	)

	(method (doLoiter)
		(= loiterTimer 0)
		(gCurRoom doLoiter:)
	)

	(method (setupGuards)
		(if (gCast contains: guard1)
			(guard1 checkCode: guard1Code)
			(if (not (IsObject (guard1 scaler:)))
				(guard1
					setScale:
						Scaler
						(gCurRoom maxScaleSize:)
						(gCurRoom minScaleSize:)
						(gCurRoom maxScaleY:)
						(gCurRoom minScaleY:)
				)
				((guard1 scaler:) doit:)
			)
		)
		(if (gCast contains: guard2)
			(guard2 checkCode: guard2Code)
			(if (not (IsObject (guard2 scaler:)))
				(guard2
					setScale:
						Scaler
						(gCurRoom maxScaleSize:)
						(gCurRoom minScaleSize:)
						(gCurRoom maxScaleY:)
						(gCurRoom minScaleY:)
				)
				((guard2 scaler:) doit:)
			)
		)
	)

	(method (setFlag param1 &tmp temp0 temp1)
		(if argc
			(= temp0 [param1 0])
		)
		(for ((= temp1 1)) (< temp1 argc) ((++ temp1))
			(self temp0: (| (self temp0:) [param1 temp1]))
		)
	)

	(method (clrFlag param1 &tmp temp0 temp1)
		(if argc
			(= temp0 [param1 0])
		)
		(for ((= temp1 1)) (< temp1 argc) ((++ temp1))
			(self temp0: (& (self temp0:) (~ [param1 temp1])))
		)
	)

	(method (tstFlag param1 param2)
		(return (if (& (self param1:) param2) 1 else 0))
	)
)

(instance guardsGetEgo of Script
	(properties)

	(method (dispose)
		(rgCastle rFlag1: (| (rgCastle rFlag1:) $2000) dungeonEntered: 3)
		(= register 0)
		(super dispose:)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo ignoreActors: setMotion: 0)
				(if
					(and
						(not (& (gEgo signal:) $0800))
						(not (gEgo facingMe: client))
					)
					(Face gEgo client self)
				else
					(= cycles 2)
				)
			)
			(1
				(= cycles 4)
			)
			(2
				(localproc_0 client 8 5)
				(client
					setSpeed: 3
					ignoreHorizon: 1
					ignoreActors: 1
					setMotion: PolyPath local0 local1 self
				)
				(if (gCurRoom moveOtherGuard:)
					(switch client
						(guard1
							(= temp0 guard2)
						)
						(guard2
							(= temp0 guard1)
						)
					)
					(localproc_0 temp0 25 0)
					(temp0
						setSpeed: 3
						ignoreHorizon: 1
						ignoreActors: 1
						setMotion: PolyPath local0 local1 self
					)
				)
			)
			(3
				(if (gCurRoom moveOtherGuard:)
					0
				else
					(= ticks 1)
				)
			)
			(4
				(if (gCurRoom moveOtherGuard:)
					(switch client
						(guard1
							(= temp0 guard2)
						)
						(guard2
							(= temp0 guard1)
						)
					)
					(Face temp0 gEgo self)
				else
					(self cue:)
				)
			)
			(5
				(if register
					(self dispose:)
				else
					(= cycles 1)
				)
			)
			(6
				(gGlobalSound2 fade:)
				(gCurRoom newRoom: 820)
			)
		)
	)
)

(instance guard1 of GuardDog
	(properties
		view 724
	)

	(method (init)
		(super init: &rest)
		(if (== (gRegions size:) 3)
			(= checkCode ((ScriptID 81 0) guard1Code:)) ; RgBasement
		)
	)

	(method (cue param1 &tmp temp0)
		(cond
			(argc
				(= temp0 okToCheck)
				(= okToCheck (>= 10 [param1 0] 4))
				(if (and temp0 (> param1 10))
					(gCurRoom warnUser: 4 (regPathID currentRoom:))
				)
			)
			((== (gRegions size:) 3)
				((ScriptID 81 0) clrFlag: #rFlag1 1 loiterTimer: 36) ; RgBasement
			)
		)
	)
)

(instance guard2 of GuardDog
	(properties
		x 99
		y 181
		view 726
		loop 3
	)

	(method (init)
		(super init: &rest)
		(if (== (gRegions size:) 3)
			(= checkCode ((ScriptID 81 0) guard2Code:)) ; RgBasement
		)
	)

	(method (cue param1 &tmp temp0)
		(cond
			(argc
				(= temp0 okToCheck)
				(= okToCheck (>= 13 [param1 0] 3))
				(if
					(and
						temp0
						(not okToCheck)
						(== (regPathID currentRoom:) 840)
					)
					(gCurRoom warnUser: 4 (regPathID currentRoom:))
				)
			)
			((== (gRegions size:) 3)
				((ScriptID 81 0) ; RgBasement
					rFlag1: (& ((ScriptID 81 0) rFlag1:) $fffd) ; RgBasement
					loiterTimer: 36
				)
			)
		)
	)
)

