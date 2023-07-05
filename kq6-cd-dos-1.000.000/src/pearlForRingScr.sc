;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 285)
(include sci.sh)
(use Main)
(use rm280)
(use System)

(public
	pearlForRingScr 0
	pearlForMapScr 1
	mapForPearlOrRingScr 2
)

(instance pearlForRingScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo put: 30 gCurRoomNum get: 39) ; pearl, royalRing
				(gGame handsOff:)
				(proc280_10 self)
				(gEgo normal: 0 view: 280 loop: 7 cel: 0)
				(= cycles 2)
			)
			(1
				(UnLoad 128 900)
			)
			(2
				(if register
					(= register 27)
					(self setScript: (ScriptID 286 1) self) ; alexGiveScr
				else
					(= register 26)
					(gGame givePoints: 2)
					(self setScript: (ScriptID 286 1) self 16384) ; alexGiveScr
				)
			)
			(3
				(gMessager say: 4 66 register 1 (ScriptID 286 1)) ; alexGiveScr
			)
			(4
				(gMessager
					say:
						4
						66
						register
						2
						(if (== register 26)
							(ScriptID 286 1) ; alexGiveScr
						else
							self
						)
				)
			)
			(5
				(= cycles 2)
			)
			(6
				(self setScript: (ScriptID 286 0) self 1) ; ownerGiveScr
			)
			(7
				(gMessager say: 4 66 register 3 self)
			)
			(8
				(if (== register 27)
					(++ state)
				)
				(= ticks 1)
			)
			(9
				(gMessager say: 4 66 register 4 self)
			)
			(10
				((ScriptID 280 2) setScript: (ScriptID 280 9)) ; shopOwner, shopOwnerScr
				(gEgo reset: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 285)
	)
)

(instance pearlForMapScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo put: 30 gCurRoomNum get: 0) ; pearl, map
				(gGame handsOff:)
				(proc280_10 self)
				(gEgo normal: 0 view: 280 loop: 7 cel: 0)
				(= cycles 2)
			)
			(1
				(UnLoad 128 900)
			)
			(2
				(self
					setScript:
						(ScriptID 286 1) ; alexGiveScr
						self
						(if register
							(= register 29)
							-32768
						else
							(= register 28)
							-16384
						)
				)
			)
			(3
				(gMessager say: 4 66 register 1 script)
			)
			(4
				(gMessager
					say:
						4
						66
						register
						2
						(if (== register 28)
							script
						else
							(++ state)
							self
						)
				)
			)
			(5
				(gMessager say: 4 66 register 3 self)
			)
			(6
				(self setScript: (ScriptID 286 3) self) ; alexTakeMapScr
			)
			(7
				((ScriptID 280 2) setScript: (ScriptID 280 9)) ; shopOwner, shopOwnerScr
				(gEgo reset: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 285)
	)
)

(instance mapForPearlOrRingScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo put: 0 gCurRoomNum) ; map
				(gGame handsOff:)
				(proc280_10 self)
				(gEgo normal: 0 view: 280 loop: 7 cel: 0)
				(= cycles 2)
			)
			(1
				(UnLoad 128 900)
			)
			(2
				(if (== ((gInventory at: 30) owner:) gCurRoomNum) ; pearl
					(= register 30)
					(gEgo get: 30) ; pearl
				else
					(= register 31)
					(gEgo get: 39) ; royalRing
				)
				(gMessager say: 4 12 register 1 self 280)
			)
			(3
				(gMessager say: 4 12 register 2 self 280)
			)
			(4
				(self setScript: (ScriptID 286 3) self 1) ; alexTakeMapScr
			)
			(5
				(gMessager say: 4 12 register 3 self 280)
			)
			(6
				(self setScript: (ScriptID 286 0) self 1) ; ownerGiveScr
			)
			(7
				((ScriptID 280 2) setScript: (ScriptID 280 9)) ; shopOwner, shopOwnerScr
				(gEgo reset: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 285)
	)
)

