;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 278)
(include sci.sh)
(use Main)
(use Motion)
(use System)

(public
	giveMintScr 0
	genieSpyScr 1
	offerItemScr 2
)

(instance genieLookScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 271 0) setScript: 0) ; bookShopGenie
				(if (and ((ScriptID 271 0) loop:) (> ((ScriptID 271 0) cel:) 3)) ; bookShopGenie, bookShopGenie
					(++ state)
					((ScriptID 271 0) setCycle: End self) ; bookShopGenie
				else
					((ScriptID 271 0) loop: 1 cel: 0) ; bookShopGenie
					(= ticks 10)
				)
			)
			(1
				((ScriptID 271 0) cel: 4 setCycle: End self) ; bookShopGenie
			)
			(2
				(client cue:)
			)
			(3
				((ScriptID 271 0) setCycle: Beg self) ; bookShopGenie
			)
			(4
				((ScriptID 271 0) setScript: (ScriptID 271 1)) ; bookShopGenie, genieKickingItScr
				(if caller
					(caller cycles: 2)
					(= caller 0)
				)
				(self dispose:)
			)
		)
	)
)

(instance genieSpyScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 271 0) ; bookShopGenie
					setScript: 0
					setMotion:
						MoveTo
						(+ ((ScriptID 271 0) x:) 10) ; bookShopGenie
						((ScriptID 271 0) y:) ; bookShopGenie
						self
				)
			)
			(1
				((ScriptID 271 0) loop: 1 cel: 0) ; bookShopGenie
				(= start 2)
				(self dispose:)
			)
			(2
				((ScriptID 271 0) ; bookShopGenie
					setMotion:
						MoveTo
						(- ((ScriptID 271 0) x:) 10) ; bookShopGenie
						((ScriptID 271 0) y:) ; bookShopGenie
						self
				)
			)
			(3
				((ScriptID 271 0) loop: 1 cel: 0 setScript: (ScriptID 271 1)) ; bookShopGenie, genieKickingItScr
				(= start 0)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(if (== start 0)
			(DisposeScript 278)
		)
	)
)

(instance giveMintScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo put: 23 gCurRoomNum) ; mint
				(gGame handsOff:)
				(self setScript: genieLookScr self)
			)
			(1
				(gMessager say: 9 63 0 1 self 270) ; "Would you care for a mint, stranger?"
			)
			(2
				(gMessager say: 9 63 0 2 self 270) ; "MMMM! Give it to me!"
			)
			(3
				(gEgo
					normal: 0
					setSpeed: 6
					view: 2832
					loop: 0
					setCycle: End self
				)
			)
			(4
				(= ticks 15)
			)
			(5
				((ScriptID 271 0) ; bookShopGenie
					view: 2834
					loop: 0
					cel: 0
					posn: 185 118
					setCycle: End self
				)
			)
			(6
				(= ticks 30)
			)
			(7
				(gMessager say: 9 63 0 3 self 270) ; "Yum! <Hic> Tee, hee, hee."
			)
			(8
				(gEgo setCycle: Beg self)
			)
			(9
				(gEgo reset: 7)
				((ScriptID 271 0) ; bookShopGenie
					loop: 1
					cel: 0
					posn: 185 118
					cycleSpeed: 14
					setCycle: End self
				)
			)
			(10
				(= ticks 15)
			)
			(11
				((ScriptID 271 0) cel: 0 setCycle: End self) ; bookShopGenie
			)
			(12
				(= ticks 15)
			)
			(13
				((ScriptID 271 0) setCycle: Beg self) ; bookShopGenie
			)
			(14
				(= ticks 15)
			)
			(15
				((ScriptID 271 0) setCycle: Beg self) ; bookShopGenie
			)
			(16
				(= ticks 45)
			)
			(17
				(gMessager say: 9 63 0 4 self 270) ; "Odd. The old man sways momentarily, but seems to quickly recover. That must be some strong mint!"
			)
			(18
				((ScriptID 271 0) view: 275 loop: 1 cel: 0 posn: 179 117) ; bookShopGenie
				(script cue:)
			)
			(19
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 278)
	)
)

(instance offerItemScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(self setScript: genieLookScr self)
			)
			(1
				(gMessager say: 9 0 0 0 self) ; "The old man would not be interested in anything that Alexander might show him."
			)
			(2
				(script cue:)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 278)
	)
)

