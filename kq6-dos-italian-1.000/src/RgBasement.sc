;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 81)
(include sci.sh)
(use Main)
(use rgCastle)
(use RegionPath)
(use System)

(public
	RgBasement 0
	guardPath1 1
	guardPath2 2
)

(local
	[local0 27] = [32767 840 16 52 79 52 100 114 131 134 178 134 192 113 152 113 32767 720 334 166 108 142 112 134 142 135 -32768]
	[local27 37] = [32767 720 142 135 112 134 108 142 -27 158 32767 710 164 114 126 115 125 182 343 182 32767 840 -17 182 145 182 167 134 131 134 100 114 79 52 6 52 -32768]
)

(class RgBasement of rgCastle
	(properties)

	(method (init)
		(super init: &rest)
		(if (self tstFlag: #rFlag1 1)
			((ScriptID 80 5) ; guard1
				view: 725
				regPathID: guardPath1
				setMotion: guardPath1 (ScriptID 80 5) (ScriptID 80 5) ; guard1, guard1
				init:
			)
		)
		(if (self tstFlag: #rFlag1 2)
			((ScriptID 80 6) ; guard2
				view: 727
				regPathID: guardPath2
				setMotion: guardPath2 (ScriptID 80 6) (ScriptID 80 6) ; guard2, guard2
				init:
			)
		)
		(if
			(and
				(or
					(not (OneOf gPrevRoomNum 840 710 720 770 820 780))
					(!= (gGlobalSound number:) 704)
				)
				(not ((ScriptID 80 0) tstFlag: #rFlag1 2)) ; rgCastle
				(not ((ScriptID 80 0) tstFlag: #rFlag1 8192)) ; rgCastle
			)
			(gGlobalSound fadeTo: 704 -1)
		)
	)

	(method (doit)
		(if
			(and
				(== loiterTimer -1)
				(not (gCurRoom script:))
				(not (self tstFlag: #rFlag1 1))
				(not (self tstFlag: #rFlag1 2))
			)
			(= loiterTimer 36)
		)
		(super doit:)
	)

	(method (newRoom newRoomNumber)
		(= keep (OneOf newRoomNumber 840 710 720 770 820 780))
		(= initialized 0)
		(super newRoom: newRoomNumber &rest)
	)

	(method (doLoiter &tmp temp0)
		(if (and (not (& rFlag1 $0004)) (not (OneOf gCurRoomNum 820 780)))
			(if (and (not (& rFlag1 $0001)) (not (& rFlag1 $0002)))
				(switch gCurRoomNum
					(710
						(|= rFlag1 $0002)
					)
					(else
						(|= rFlag1 $0001)
					)
				)
				(= loiterTimer 1)
				(gCurRoom doLoiter:)
			else
				(self startGuard:)
			)
		)
	)

	(method (startGuard)
		(if (and (& rFlag1 $0001) (not ((ScriptID 80 5) mover:))) ; guard1
			((ScriptID 80 5) ; guard1
				view: 725
				init:
				regPathID: guardPath1
				setMotion: guardPath1 (ScriptID 80 5) (ScriptID 80 5) 1 ; guard1, guard1
			)
		)
		(if (and (& rFlag1 $0002) (not ((ScriptID 80 6) mover:))) ; guard2
			((ScriptID 80 6) ; guard2
				view: 727
				init:
				regPathID: guardPath2
				setMotion: guardPath2 (ScriptID 80 6) (ScriptID 80 6) 1 ; guard2, guard2
			)
		)
		(self setupGuards:)
	)

	(method (resetGuard param1 param2)
		(&= rFlag1 (~ param2))
		(if (IsObject (param1 regPathID:))
			((param1 regPathID:) value: 0)
		)
	)

	(method (setupGuards)
		(if (and (!= gCurRoomNum 840) (& rFlag1 $0001))
			((ScriptID 80 5) ; guard1
				okToCheck: (>= 10 (/ (((ScriptID 80 5) regPathID:) value:) 2) 4) ; guard1
			)
		)
		(if (and (!= gCurRoomNum 840) (& rFlag1 $0002))
			((ScriptID 80 6) ; guard2
				okToCheck: (>= 13 (/ (((ScriptID 80 6) regPathID:) value:) 2) 3) ; guard2
			)
		)
		(super setupGuards:)
	)

	(method (dispose)
		((ScriptID 80 5) z: 0 setMotion: 0) ; guard1
		((ScriptID 80 6) z: 0 setMotion: 0) ; guard2
		(super dispose: &rest)
		(DisposeScript 918)
	)

	(method (warnUser param1 param2 param3 param4)
		(switch param1
			(1
				(if (and (> argc 3) param4)
					(gMessager say: param2 param3 param4)
				)
				(cond
					((>= ((ScriptID 80 0) weddingMusicCount:) 3) ; rgCastle
						(|= rFlag1 $0004)
						(self startGuard:)
					)
					((not ((ScriptID 80 0) weddingRemind:)) ; rgCastle
						((ScriptID 80 0) weddingRemind: 15) ; rgCastle
					)
				)
			)
		)
	)
)

(instance guardPath1 of RegionPath
	(properties
		endType 0
		theRegion 81
	)

	(method (init)
		(if (RgBasement tstFlag: #rFlag1 4)
			(= endType 2)
		)
		(super init: &rest)
	)

	(method (at param1)
		(return [local0 param1])
	)

	(method (nextRoom &tmp temp0)
		(= temp0 (== currentRoom gCurRoomNum))
		(super nextRoom: &rest)
		(if (and (IsObject gCurRoom) (not temp0))
			(cond
				((> value 2)
					(gCurRoom warnUser: 5 currentRoom)
				)
				((not ((ScriptID 81 0) tstFlag: #rFlag1 4)) ; RgBasement
					(gCurRoom warnUser: 6 7)
				)
			)
			(if (== currentRoom gCurRoomNum)
				(gGlobalSound4 number: 702 loop: 1 play:)
			)
		)
	)
)

(instance guardPath2 of RegionPath
	(properties
		endType 0
		theRegion 81
	)

	(method (at param1)
		(return [local27 param1])
	)

	(method (nextRoom &tmp temp0)
		(= temp0 (== currentRoom gCurRoomNum))
		(if
			(and
				(< value 2)
				(== gCurRoomNum 840)
				(not (RgBasement tstFlag: #rFlag1 8))
			)
			(RgBasement setFlag: #rFlag1 8)
			(= value 10)
		)
		(super nextRoom: &rest)
		(if (and (IsObject gCurRoom) (not temp0))
			(if (> value 2)
				(gCurRoom warnUser: 5 currentRoom)
			else
				(gCurRoom warnUser: 6 8)
			)
			(if (== currentRoom gCurRoomNum)
				(gGlobalSound4 number: 702 loop: 1 play:)
			)
		)
	)
)

