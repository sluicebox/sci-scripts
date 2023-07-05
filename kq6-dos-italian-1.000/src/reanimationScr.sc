;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 282)
(include sci.sh)
(use Main)
(use KQ6Print)
(use rm280)
(use pawnShopGenie)
(use n913)
(use PolyPath)
(use StopWalk)
(use Grooper)
(use Motion)
(use System)

(public
	reanimationScr 0
	drinkPotionGenieScr 1
	genieTakeMintScr 2
	genieMirrorScr 3
	genieBadgerOwnerScr 4
	drinkPotionNoGenieScr 5
	givePeppermintScr 6
)

(instance reanimationScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo hide:)
				((ScriptID 280 2) ; shopOwner
					posn: 113 144
					view: 282
					loop: 6
					cel: 0
					setScript: 0
				)
				(= ticks 120)
			)
			(1
				(gGlobalSound4 number: 927 loop: 1 play: self)
				(= ticks 30)
			)
			(2
				(gMessager say: 1 0 8 1 self) ; "Alexander's heart lurches to life in his chest."
			)
			(3 0)
			(4
				(gGlobalSound4 client: 0)
				((ScriptID 280 2) setCycle: End self) ; shopOwner
			)
			(5
				((ScriptID 280 2) setCycle: Beg self) ; shopOwner
			)
			(6
				((ScriptID 280 2) loop: 2 cel: 0 setCycle: End self) ; shopOwner
			)
			(7
				(gMessager say: 1 0 8 2 self) ; "(AMAZED) Prince Alex! But...but...you were....!"
			)
			(8
				(gMessager say: 1 0 8 3 self) ; "(APOLOGETIC) Sorry, friend. I was doing a little acting, I'm afraid."
			)
			(9
				(gMessager say: 1 0 8 4 self) ; "(ENLIGHTENED) Ah! Of course! The strange cloaked man! You are quite clever--and a bit too exciting for an old man!"
			)
			(10
				(gGlobalSound number: 240 loop: -1 fade: 70 10 20 0)
				(gEgo show: posn: 123 140 reset: 3)
				((ScriptID 280 2) ; shopOwner
					posn: 135 136
					loop: 7
					cel: 0
					setCycle: End self
				)
			)
			(11
				(= cycles 2)
			)
			(12
				((ScriptID 280 2) ; shopOwner
					view: 2841
					loop: 0
					cel: 0
					posn: 236 127
					stopUpd:
					setScript: (ScriptID 280 9) ; shopOwnerScr
				)
				(gGame handsOn:)
				(gGlobalSound number: 240 loop: -1 play: 0 fade: 70 25 10 0)
				(self dispose:)
				(DisposeScript 282)
			)
		)
	)
)

(instance drinkPotionNoGenieScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo put: 33 gCurRoomNum) ; potion
				(gGame handsOff:)
				(proc280_10 self)
			)
			(1
				(gEgo setMotion: PolyPath 156 136 self)
				(gGlobalSound fade: 0 25 10 0)
			)
			(2
				(gEgo
					normal: 0
					setSpeed: 6
					posn: 146 140
					view: 934
					loop: 0
					cel: 0
					setCycle: CT 2 1 self
				)
			)
			(3
				(gGlobalSound4 number: 925 loop: 1 play: self)
			)
			(4
				(gEgo setCycle: End self)
			)
			(5
				(= ticks 30)
			)
			(6
				(gEgo posn: 147 141 loop: 1 cel: 0 setCycle: End self)
				(gGlobalSound3 number: 926 loop: 1 play:)
			)
			(7
				(gMessager say: 2 14 10 1 self) ; "Prince Alex! What is it?"
			)
			(8
				((ScriptID 280 2) ; shopOwner
					posn: 236 127
					view: 282
					loop: 3
					cel: 0
					setCycle: End self
				)
			)
			(9
				((ScriptID 280 2) ; shopOwner
					posn: 171 110
					loop: 4
					cel: 0
					setCycle: End self
				)
			)
			(10
				(= ticks 30)
			)
			(11
				(if (!= (gGlobalSound3 prevSignal:) -1)
					(-- state)
				)
				(= cycles 2)
			)
			(12
				((ScriptID 280 2) ; shopOwner
					posn: 171 110
					loop: 5
					cel: 0
					setCycle: End self
				)
			)
			(13
				(gMessager say: 2 14 10 2 self) ; "(SADLY) Oh, the poor young prince! His heart must have just given out on him!"
			)
			(14
				(= ticks 45)
			)
			(15
				(gGlobalSound3 number: 927 loop: 1 play: self)
			)
			(16
				(gGlobalSound3 client: 0)
				(gEgo hide:)
				((ScriptID 280 2) ; shopOwner
					posn: 113 144
					loop: 6
					cel: 0
					setCycle: End self
				)
			)
			(17
				(gMessager say: 2 14 10 3 self) ; "(AMAZED) Prince Alex! But...but...you were....!"
			)
			(18
				((ScriptID 280 2) loop: 2 cel: 0 setCycle: End self) ; shopOwner
			)
			(19
				(gMessager say: 2 14 10 4 self oneOnly: 0) ; "(CURIOUS) Yes, strange wasn't it? I feel fine now, though."
			)
			(20
				(gGlobalSound number: 240 loop: -1 play: 0 fade: 70 25 10 0)
				(gEgo show: posn: 123 140 reset: 3)
				((ScriptID 280 2) ; shopOwner
					posn: 135 136
					loop: 7
					cel: 0
					setCycle: End self
				)
			)
			(21
				(= cycles 2)
			)
			(22
				((ScriptID 280 2) ; shopOwner
					view: 2841
					loop: 0
					cel: 0
					posn: 236 127
					stopUpd:
					setScript: (ScriptID 280 9) ; shopOwnerScr
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 282)
	)
)

(instance drinkPotionGenieScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo put: 33 gCurRoomNum) ; potion
				(gGame handsOff:)
				(gGame givePoints: 3)
				(proc280_10 self)
			)
			(1
				(SetFlag 41)
				(SetFlag 82)
				(gMessager say: 2 14 9 1 self 280) ; "Alexander suddenly gets a very sneaky idea...."
				(gGlobalSound fade:)
			)
			(2
				(gEgo setMotion: PolyPath 156 136 self)
				(gGlobalSound2 number: 281 loop: -1 play:)
			)
			(3
				(gMessager say: 2 14 9 2 self 280) ; "I can't go on anymore! Without Cassima, I'd just rather not live!"
			)
			(4
				(gMessager say: 2 14 9 3 self 280) ; "Prince Alex! No!"
			)
			(5
				(proc281_1 self)
			)
			(6
				((ScriptID 281 0) ; pawnShopGenie
					view: 289
					posn: 88 129
					setLoop: Grooper
					loop: 3
				)
				(= cycles 2)
			)
			(7
				((ScriptID 281 0) setHeading: 90 self) ; pawnShopGenie
			)
			(8
				(gEgo
					normal: 0
					setSpeed: 6
					posn: 146 140
					view: 2821
					loop: 0
					cel: 0
					setCycle: End self
				)
			)
			(9
				(gMessager say: 2 14 9 4 self 280) ; "It's true! The vizier has beaten me! I give up! Poison is my last resort!"
			)
			(10
				(gMessager say: 2 14 9 5 self 280) ; "I beg you, stop!"
			)
			(11
				(gEgo loop: 1 cel: 0 setCycle: End self)
			)
			(12
				(gEgo
					normal: 0
					setSpeed: 6
					posn: 146 140
					view: 934
					loop: 0
					cel: 0
					setCycle: CT 2 1 self
				)
			)
			(13
				(gGlobalSound4 number: 925 loop: 1 play: self)
			)
			(14
				(gEgo setCycle: End self)
			)
			(15
				(gGlobalSound2 fade:)
				(= ticks 30)
			)
			(16
				(gMessager say: 2 14 9 6 self 280) ; "I am...no...more!"
			)
			(17
				(gEgo posn: 147 141 loop: 1 cel: 0 setCycle: End self)
				(gGlobalSound3 number: 926 loop: 1 play:)
			)
			(18
				((ScriptID 280 2) ; shopOwner
					setPri: -1
					posn: 236 127
					view: 282
					loop: 3
					cel: 0
					setCycle: End self
				)
			)
			(19
				(= ticks 120)
			)
			(20
				((ScriptID 280 2) ; shopOwner
					posn: 171 110
					setPri: 14
					loop: 4
					cel: 0
					setCycle: End self
				)
			)
			(21
				(if (!= (gGlobalSound3 prevSignal:) -1)
					(-- state)
				)
				(= cycles 2)
			)
			(22
				(gMessager say: 2 14 9 7 self 280) ; "(SADLY) Oh, what a waste! The poor, young fool!"
			)
			(23
				((ScriptID 280 2) loop: 5 cel: 0 setCycle: End self) ; shopOwner
			)
			(24
				(gMessager say: 2 14 9 8 self 280) ; "He's dead! He's dead! Wait until Abdul hears! He'll be SO pleased!"
			)
			(25
				(proc280_8 0)
				((ScriptID 281 0) view: 2833 loop: 0 cel: 0 setCycle: Fwd) ; pawnShopGenie
				(= ticks 90)
			)
			(26
				((ScriptID 281 0) setCycle: End self) ; pawnShopGenie
			)
			(27
				((ScriptID 281 0) view: 289 loop: 0 cel: 0 setHeading: 270 self) ; pawnShopGenie
			)
			(28
				(self setScript: genieExitScr self)
			)
			(29
				(= ticks 45)
			)
			(30
				(gCurRoom newRoom: 145)
			)
		)
	)
)

(instance genieMirrorScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 5 13 0 1 self) ; "Alexander decides to show the mirror to the old man in the cloak."
			)
			(1
				(gEgo setMotion: PolyPath 138 132 self)
			)
			(2
				(gEgo setHeading: 270 self)
				(proc281_1 self)
			)
			(3 0)
			(4
				(cond
					((> ((ScriptID 281 0) cel:) 3) ; pawnShopGenie
						((ScriptID 281 0) setCycle: CT 3 -1 self) ; pawnShopGenie
					)
					((< ((ScriptID 281 0) cel:) 3) ; pawnShopGenie
						((ScriptID 281 0) setCycle: CT 3 1 self) ; pawnShopGenie
					)
					(else
						(= ticks 1)
					)
				)
			)
			(5
				(gEgo
					setSpeed: 6
					normal: 0
					view: 283
					loop: 5
					cel: 0
					setCycle: End self
				)
			)
			(6
				(gMessager say: 5 13 0 2 self) ; "YIKES!"
			)
			(7
				(gEgo setCycle: Beg self)
			)
			(8
				(= cycles 2)
			)
			(9
				(gEgo reset: 7)
				(= cycles 2)
			)
			(10
				(proc280_8 0)
				(self setScript: genieExitScr self)
			)
			(11
				(gMessager say: 5 13 0 3 self oneOnly: 0) ; "Zounds! That citizen obviously didn't like what he just saw!"
			)
			(12
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 282)
	)
)

(instance genieExitScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 281 0) ; pawnShopGenie
					signal: 16384
					cycleSpeed: 3
					moveSpeed: 3
					view: 289
					setCycle: StopWalk -1
					setMotion: PolyPath 51 124 self
				)
			)
			(1
				((ScriptID 280 3) setPri: 14 setCycle: End self) ; shopDoor
				(gGlobalSound4 number: 901 loop: 1 play:)
			)
			(2
				((ScriptID 281 0) setMotion: MoveTo 35 124 self) ; pawnShopGenie
			)
			(3
				((ScriptID 281 0) dispose:) ; pawnShopGenie
				((ScriptID 280 3) setPri: -1 setCycle: Beg self) ; shopDoor
			)
			(4
				(gGlobalSound4 number: 902 loop: 1 play:)
				(= cycles 2)
			)
			(5
				(self dispose:)
			)
		)
	)
)

(instance genieTakeMintScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc280_8 0)
				(proc281_1 self)
			)
			(1
				((ScriptID 281 0) ; pawnShopGenie
					signal: 16384
					view: 289
					setCycle: Walk
					setMotion: PolyPath 183 132 self
				)
			)
			(2
				(gMessager say: 4 70 19 10 self) ; "Suddenly, the old man in the concealing cloak sneaks past Alexander and, with a sneaky dart of his hand, steals a mint from the candy jar."
			)
			(3
				((ScriptID 281 0) ; pawnShopGenie
					view: 2834
					setPri: 1
					loop: 0
					cel: 0
					posn: 187 134
					setCycle: End self
				)
			)
			(4
				(UnLoad 128 289)
				((ScriptID 281 0) loop: 1 cel: 0 setCycle: End self) ; pawnShopGenie
			)
			(5
				((ScriptID 281 0) cel: 0 setCycle: End self) ; pawnShopGenie
			)
			(6
				((ScriptID 281 0) setCycle: Beg self) ; pawnShopGenie
			)
			(7
				((ScriptID 281 0) ; pawnShopGenie
					cel: ((ScriptID 281 0) lastCel:) ; pawnShopGenie
					setCycle: Beg self
				)
			)
			(8
				(= cycles 2)
			)
			(9
				(gMessager say: 4 70 19 11 self) ; "The old man stuffs the mint into his mouth and wobbles unsteadily out of the pawn shop."
			)
			(10
				((ScriptID 281 0) ; pawnShopGenie
					view: 2835
					loop: 2
					cel: 0
					posn: 190 134
					setCycle: End self
				)
			)
			(11
				(UnLoad 128 2834)
				((ScriptID 281 0) ; pawnShopGenie
					posn: 168 133
					setLoop: 3
					cel: 0
					setStep: 4 3
					setCycle: Walk
				)
				(= cycles 2)
			)
			(12
				((ScriptID 281 0) setMotion: PolyPath 51 124 self) ; pawnShopGenie
			)
			(13
				((ScriptID 281 0) view: 289 setLoop: -1 loop: 1 posn: 51 124) ; pawnShopGenie
				((ScriptID 280 3) setPri: 14 setCycle: End) ; shopDoor
				(gGlobalSound4 number: 901 loop: 1 play:)
				(= ticks 12)
			)
			(14
				(UnLoad 128 2835)
				((ScriptID 281 0) setMotion: MoveTo 35 124 self) ; pawnShopGenie
			)
			(15
				((ScriptID 281 0) dispose:) ; pawnShopGenie
				((ScriptID 280 3) setCycle: Beg self) ; shopDoor
			)
			(16
				(UnLoad 128 289)
				(gGlobalSound4 number: 902 loop: 1 play:)
				(self dispose:)
			)
		)
	)
)

(instance genieBadgerOwnerScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc280_8 0)
				((ScriptID 281 0) ; pawnShopGenie
					view: 289
					loop: 0
					setLoop: Grooper
					cycleSpeed: 6
					setCycle: StopWalk -1
					ignoreActors:
					posn: 192 138
				)
				(= register 0)
				(= cycles 1)
			)
			(1
				(gEgo setMotion: MoveTo 80 145 self)
			)
			(2
				(gEgo setHeading: 90 self)
			)
			(3
				(= cycles 2)
			)
			(4
				(KQ6Print
					font: gUserFont
					posn: 120 40
					width: 175
					say: 0 1 0 3 1 ; "(ANGRY) Your candy dish is empty!"
					init: self
				)
			)
			(5
				(gMessager say: 1 0 3 2 self 280) ; "(APOLOGETIC BUT FIRM) I am sorry, sir, but I have no more mints. Somebody has eaten them all."
			)
			(6
				(KQ6Print
					font: gUserFont
					posn: 120 40
					width: 175
					say: 0 1 0 3 3 ; "(IMPATIENT) Well, get some more then!"
					init: self
				)
			)
			(7
				(gMessager say: 1 0 3 4 self 280) ; "(FIRM) I fear that is impossible. Without the ferry, I can no longer get imports from the other islands, and we do not grow mint extract on the Isle of the Crown."
			)
			(8
				(KQ6Print
					font: gUserFont
					posn: 120 40
					width: 175
					say: 0 1 0 3 5 ; "(TEMPER TANTRUM) OOOH! I HATE not getting what I want!"
					init: self
				)
			)
			(9
				((ScriptID 281 0) setHeading: 270 self) ; pawnShopGenie
			)
			(10
				(self setScript: genieExitScr self)
			)
			(11
				(= cycles 2)
			)
			(12
				((ScriptID 280 2) setScript: (ScriptID 280 9)) ; shopOwner, shopOwnerScr
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 282)
	)
)

(instance givePeppermintScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc281_1 self)
			)
			(1
				(gMessager say: 5 67 0 1 self) ; "Alexander decides to offer the old man some peppermint leaves."
			)
			(2
				(gEgo setMotion: PolyPath 118 133 self)
			)
			(3
				(gEgo view: 2832 loop: 0 cel: 0 setSpeed: 6 normal: 0)
				(= cycles 2)
			)
			(4
				(gEgo setCycle: End self)
			)
			(5
				(= cycles 2)
			)
			(6
				(gMessager say: 5 67 0 2 self) ; "(FRIENDLY) Can I offer you some peppermint, sir?"
			)
			(7
				(gMessager say: 5 67 0 3 self) ; "Mmmmmm! Mint!"
			)
			(8
				((ScriptID 281 0) ; pawnShopGenie
					view: 2834
					loop: 0
					cel: 0
					cycleSpeed: 9
					posn: 92 134
				)
				(= cycles 2)
			)
			(9
				((ScriptID 281 0) setCycle: End self) ; pawnShopGenie
			)
			(10
				(gEgo setCycle: Beg)
				((ScriptID 281 0) loop: 1 cel: 0 setCycle: End self) ; pawnShopGenie
			)
			(11
				(gEgo reset: 1)
				((ScriptID 281 0) cel: 0 setCycle: End self) ; pawnShopGenie
			)
			(12
				((ScriptID 281 0) setCycle: Beg self) ; pawnShopGenie
			)
			(13
				((ScriptID 281 0) ; pawnShopGenie
					cel: ((ScriptID 281 0) lastCel:) ; pawnShopGenie
					setCycle: Beg self
				)
			)
			(14
				(gMessager say: 5 67 0 4 self) ; "Yum! <Hic> Tee, hee, hee."
			)
			(15
				((ScriptID 281 0) view: 2835 loop: 2 cel: 0 setCycle: End self) ; pawnShopGenie
			)
			(16
				(proc280_8 0)
				((ScriptID 281 0) ; pawnShopGenie
					setLoop: 3
					setCycle: Walk
					posn: 70 133
					setMotion: PolyPath 51 124 self
				)
			)
			(17
				((ScriptID 281 0) view: 289 setLoop: -1 loop: 1 posn: 51 124) ; pawnShopGenie
				((ScriptID 280 3) setPri: 14 setCycle: End) ; shopDoor
				(gGlobalSound4 number: 901 loop: 1 play:)
				(= ticks 12)
			)
			(18
				((ScriptID 281 0) setMotion: MoveTo 35 124 self) ; pawnShopGenie
			)
			(19
				((ScriptID 281 0) dispose:) ; pawnShopGenie
				((ScriptID 280 3) setCycle: Beg self) ; shopDoor
			)
			(20
				(gGlobalSound4 number: 902 loop: 1 play:)
				(= cycles 2)
			)
			(21
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 282)
	)
)

