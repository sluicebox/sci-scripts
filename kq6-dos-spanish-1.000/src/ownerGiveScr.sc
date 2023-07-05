;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 286)
(include sci.sh)
(use Main)
(use rm280)
(use Scaler)
(use Motion)
(use Actor)
(use System)

(public
	ownerGiveScr 0
	alexGiveScr 1
	alexShowScr 2
	alexTakeMapScr 3
	genericShowScr 4
	fullMsgShowScr 5
)

(local
	local0
)

(instance ownerGiveScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if register
					((ScriptID 280 2) view: 286 loop: 1 cel: 0) ; shopOwner
					(= cycles 2)
				else
					(+= state 4)
					(self cue:)
				)
			)
			(1
				((ScriptID 280 2) setCycle: CT 2 1 self) ; shopOwner
			)
			(2
				(= cycles 2)
			)
			(3
				((ScriptID 280 2) setCycle: Beg self) ; shopOwner
			)
			(4
				(= cycles 2)
			)
			(5
				((ScriptID 280 2) view: 284 loop: 2 cel: 0) ; shopOwner
				(= cycles 2)
			)
			(6
				((ScriptID 280 2) setCycle: CT 1 1 self) ; shopOwner
			)
			(7
				(= cycles 2)
			)
			(8
				(gEgo
					normal: 0
					setSpeed: 6
					posn: 188 135
					view: 2811
					loop: 1
					setScale: 0
					cel: 0
				)
				(= cycles 2)
			)
			(9
				(gEgo setCycle: CT 2 1 self)
			)
			(10
				(= cycles 2)
			)
			(11
				((ScriptID 280 2) setCycle: Beg self) ; shopOwner
				(gEgo setCycle: End self)
			)
			(12 0)
			(13
				((ScriptID 280 2) view: 2841 loop: 0 cel: 0) ; shopOwner
				(gEgo
					posn:
						((ScriptID 280 2) approachX:) ; shopOwner
						((ScriptID 280 2) approachY:) ; shopOwner
					view: 280
					loop: 7
					cel: 0
					setScale: Scaler 105 90 139 121
				)
				(= cycles 2)
			)
			(14
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 286)
	)
)

(instance arm of Prop
	(properties
		x 199
		y 102
		view 281
		priority 15
		signal 16
	)

	(method (cue)
		(self dispose:)
	)
)

(instance alexShowScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					normal: 0
					setSpeed: 6
					posn: 188 135
					view: 2811
					setScale: 0
					loop: 1
					cel: 0
				)
				(if register
					(arm
						loop:
							(switch register
								(3 5)
								(2 6)
								(0 7)
								(1 8)
							)
						cel: 0
						init:
					)
				)
				(= cycles 2)
			)
			(1
				(gEgo setCycle: CT 2 1 self)
				(if register
					(arm setCycle: CT 2 1)
				)
			)
			(2
				(= cycles 2)
			)
			(3
				(if register
					(= local0 1)
					(= register 0)
				)
				(client cue:)
			)
			(4
				(if local0
					(arm dispose:)
				)
				(if register
					(arm
						loop:
							(switch register
								(3 5)
								(2 6)
								(0 7)
								(1 8)
							)
						cel: 2
						init:
					)
				)
				(= cycles 2)
			)
			(5
				(gEgo setCycle: End self)
				(if register
					(arm setCycle: End arm)
				)
			)
			(6
				(= cycles 2)
			)
			(7
				(gEgo
					posn:
						((ScriptID 280 2) approachX:) ; shopOwner
						((ScriptID 280 2) approachY:) ; shopOwner
					view: 280
					loop: 7
					cel: 0
					setScale: Scaler 105 90 139 121
				)
				(self dispose:)
			)
		)
	)

	(method (dispose &tmp temp0)
		(if (not (OneOf client fullMsgShowScr genericShowScr))
			(= temp0 1)
		else
			(= temp0 0)
		)
		(super dispose:)
		(if temp0
			(DisposeScript 286)
		)
	)
)

(instance alexGiveScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					normal: 0
					setSpeed: 6
					posn: 188 135
					view: 2811
					loop: 1
					cel: 0
					setScale: 0
				)
				(= cycles 2)
			)
			(1
				(gEgo setCycle: CT 2 1 self)
			)
			(2
				(= cycles 2)
			)
			(3
				(client cue:)
			)
			(4
				((ScriptID 280 2) view: 284 loop: 2 cel: 0) ; shopOwner
				(= cycles 2)
			)
			(5
				((ScriptID 280 2) setCycle: CT 1 1 self) ; shopOwner
			)
			(6
				(= cycles 2)
			)
			(7
				(gEgo setCycle: End self)
				(if (& register $4000)
					((ScriptID 280 2) setCycle: End self) ; shopOwner
				else
					(+= state 3)
					(self cue:)
				)
			)
			(8 0)
			(9
				(= cycles 2)
			)
			(10
				(client cue:)
			)
			(11
				((ScriptID 280 2) setCycle: Beg self) ; shopOwner
			)
			(12
				(if (not (& register $4000))
					0
				else
					(self cue:)
				)
			)
			(13
				(= cycles 2)
			)
			(14
				(if (& register $8000)
					((ScriptID 280 2) ; shopOwner
						view: 286
						loop: 1
						cel: 1
						setCycle: CT 2 1 self
					)
				else
					(+= state 2)
					(self cue:)
				)
			)
			(15
				(= cycles 2)
			)
			(16
				((ScriptID 280 2) setCycle: Beg self) ; shopOwner
			)
			(17
				(= cycles 2)
			)
			(18
				(gEgo
					posn:
						((ScriptID 280 2) approachX:) ; shopOwner
						((ScriptID 280 2) approachY:) ; shopOwner
					view: 280
					loop: 7
					cel: 0
					setScale: Scaler 105 90 139 121
				)
				((ScriptID 280 2) view: 280 loop: 8 cel: 0) ; shopOwner
				(= cycles 2)
			)
			(19
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 286)
	)
)

(instance alexTakeMapScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					normal: 0
					setSpeed: 6
					view: 2861
					posn: 199 143
					loop: 0
					setScale: 0
				)
				(if (not register)
					(gEgo cel: 0)
				else
					(gEgo cel: 4)
				)
				(= cycles 2)
			)
			(1
				(gEgo setCycle: CT 2 (if register -1 else 1) self)
			)
			(2
				(= cycles 2)
			)
			(3
				(if register
					((ScriptID 280 1) init:) ; map
				else
					((ScriptID 280 1) dispose:) ; map
				)
				(= cycles 2)
			)
			(4
				(if register
					(gEgo setCycle: Beg self put: 0) ; map
				else
					(gEgo setCycle: End self get: 0) ; map
				)
			)
			(5
				(= cycles 2)
			)
			(6
				(gEgo
					posn:
						((ScriptID 280 2) approachX:) ; shopOwner
						((ScriptID 280 2) approachY:) ; shopOwner
					view: 280
					loop: 7
					cel: 0
					setScale: Scaler 105 90 139 121
				)
				(= ticks 12)
			)
			(7
				(= cycles 2)
			)
			(8
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 286)
	)
)

(instance fullMsgShowScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc280_10 self)
				(gEgo normal: 0 view: 280 loop: 7 cel: 0)
				(= cycles 2)
			)
			(1
				(UnLoad 128 900)
			)
			(2
				(self setScript: alexShowScr self)
			)
			(3
				(gMessager say: 4 register 0 1 alexShowScr)
			)
			(4
				(gMessager say: 4 register 0 2 self)
			)
			(5
				(gEgo reset: 0)
				((ScriptID 280 2) setScript: (ScriptID 280 9)) ; shopOwner, shopOwnerScr
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 286)
	)
)

(instance genericShowScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc280_10 self)
				(gEgo normal: 0 view: 280 loop: 7 cel: 0)
				(= cycles 2)
			)
			(1
				(UnLoad 128 900)
			)
			(2
				(self setScript: alexShowScr self)
			)
			(3
				(if (not register)
					(= register 0)
				)
				(gMessager say: 4 0 0 1 alexShowScr) ; "(HOPEFUL, POLITE) Would you be interested in making a trade for this, merchant?"
			)
			(4
				(gMessager say: 4 register 0 (if (== register 0) 2 else 1) self)
			)
			(5
				((ScriptID 280 2) setScript: (ScriptID 280 9)) ; shopOwner, shopOwnerScr
				(gEgo reset: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 286)
	)
)

