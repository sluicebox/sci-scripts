;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 160)
(include sci.sh)
(use Main)
(use n013)
(use verseScript)
(use RTEyeCycle)
(use Osc)
(use LoadMany)
(use Sound)
(use Motion)
(use Game)
(use Inventory)
(use Actor)
(use System)

(public
	rm160 0
)

(local
	[local0 8]
	[local8 7] = [225 149 192 138 236 125 211]
	[local15 7] = [23 44 60 18 10 54 69]
	[local22 8] = [10 11 12 10 11 12 10 0]
	local30 = 10
	[local31 8] = [1160 1 1 2 3 4 1 0]
	[local39 6] = [1160 6 2 2 1 0]
	[local45 6] = [1160 9 2 1 3 0]
	[local51 8] = [1160 12 2 1 2 2 1 0]
	[local59 5] = [1160 17 2 1 0]
	[local64 4] = [1160 19 1 0]
	[local68 4] = [1160 20 1 0]
	[local72 4] = [1160 21 1 0]
	[local76 5] = [1160 22 2 1 0]
	[local81 6] = [1160 24 2 3 1 0]
	[local87 4] = [1160 27 1 0]
	[local91 4] = [1160 28 1 0]
	[local95 12] = [1161 2 2 5 3 5 5 4 1 2 1 0]
	[local107 7] = [1161 11 2 1 2 3 0]
	[local114 10] = [1161 15 3 6 2 6 4 4 1 0]
	[local124 6] = [1161 22 2 2 1 0]
	[local130 4] = [1161 25 1 0]
	[local134 13] = [1162 1 3 2 2 5 4 1 1 1 3 5 0]
	[local147 15] = [1162 13 3 4 3 2 3 2 3 2 5 1 4 4 0]
	[local162 8] = [1162 25 3 4 3 1 2 0]
	[local170 7] = [1162 30 1 1 2 2 0]
	[local177 9] = [1164 7 3 1 2 4 5 6 0]
	[local186 14] = [1164 13 3 2 1 4 5 3 5 2 1 1 5 0]
	[local200 10] = [1164 24 3 3 1 2 1 5 4 0]
	[local210 8] = [1164 31 4 1 3 1 2 0]
	[local218 15] = [1164 36 1 4 3 1 1 5 4 2 1 2 1 4 0]
	[local233 5] = [1164 29 2 1 0]
	[local238 11] = [1166 2 4 2 3 6 5 1 2 1 0]
	[local249 13] = [1166 12 4 1 2 1 4 1 3 1 1 4 0]
	[local262 11] = [1167 3 4 2 1 3 5 3 6 6 0]
	[local273 5] = [1167 17 2 1 0]
	[local278 8] = [1167 11 4 1 3 2 3 0]
	[local286 4] = [1167 16 1 0]
	[local290 7] = [1168 4 1 2 2 2 0]
	[local297 6] = [1168 8 1 2 2 0]
	[local303 28] = [1168 11 5 3 2 4 2 6 2 6 2 2 1 2 2 2 2 2 1 2 1 2 1 2 4 4 6 0]
	[local331 4] = [1168 36 2 0]
	[local335 10] = [1168 37 1 2 1 2 2 3 2 0]
	[local345 8] = [2160 3 3 1 2 2 1 0]
	[local353 11] = [2160 12 2 1 3 1 1 4 2 1 0]
	[local364 7] = [2161 2 1 4 3 2 0]
	[local371 6] = [2161 6 1 1 1 0]
	[local377 14] = [2161 9 1 4 1 3 4 2 5 1 3 1 1 0]
	[local391 10] = [2161 20 3 1 2 4 5 1 1 0]
	[local401 7] = [2161 27 3 1 2 1 0]
	[local408 7] = [2162 1 4 3 2 1 0]
	[local415 8] = [2162 5 4 4 2 5 1 0]
	[local423 4] = [2162 10 1 0]
)

(procedure (localproc_0 &tmp temp0)
	(gCast eachElementDo: #dispose)
	(= local30 0)
	(gCurRoom drawPic: 803 9)
)

(procedure (localproc_1)
	(log init: addToPic:)
	(gEgo view: 147 loop: 8 x: 250 y: 154 init:)
	(tuckView view: 155 loop: 3 x: 204 y: 185 init:)
	(willView view: 161 loop: 0 x: 162 y: 174 init:)
	(alanView view: 147 loop: 4 x: 234 y: 152 init:)
	(johnView view: 143 loop: 4 x: 177 y: 147 init:)
	(muchView view: 147 loop: 5 cel: 1 x: 144 y: 153 init:)
	(alanView setCycle: Fwd)
	(gSFX number: 161 loop: -1 play:)
)

(procedure (localproc_2)
	(log init: addToPic:)
	(gEgo view: 143 loop: 5 x: 169 y: 151 init:)
	(tuckView view: 155 loop: 3 x: 202 y: 180 init:)
	(willView view: 161 loop: 1 x: 259 y: 172 init:)
	(alanView view: 147 loop: 4 x: 234 y: 152 init:)
	(johnView view: 143 loop: 4 cel: 5 x: 115 y: 155 init:)
	(muchView view: 147 loop: 5 x: 153 y: 185 init:)
	(alanView setCycle: Fwd)
	(gSFX number: 162 loop: -1 play:)
)

(procedure (localproc_3)
	(alanView setCycle: Fwd)
	(gSFX number: 161 loop: -1 play:)
)

(procedure (localproc_4 &tmp temp0)
	(for ((= temp0 0)) (< temp0 7) ((++ temp0))
		(= [local0 temp0] (Prop new:))
		([local0 temp0]
			view: 147
			loop: [local22 temp0]
			x: [local8 temp0]
			y: [local15 temp0]
			init:
		)
	)
	(local0 setScript: stars)
)

(instance rm160 of Rm
	(properties
		picture 803
	)

	(method (init)
		(HandsOff)
		(gTheIconBar disable: 8)
		(= global142
			(= global149
				(= global159 (= global150 (= gBlowCount (= global167 0))))
			)
		)
		(ClearFlag 71)
		(ClearFlag 129)
		(ClearFlag 185)
		(super init:)
		(gRgnMusic number: 160 loop: -1 init: play:)
		(= gDisguiseNum 0) ; outlaw
		(self
			setScript:
				(switch gDay
					(1 nightOne)
					(2 night2)
					(3 night3)
					(4 night4)
					(5
						(cond
							((not (IsFlag 25)) nightFive)
							((IsFlag 125) boysStealthSaved)
							((== gPrevRoomNum 250) boysBattleSaved)
							(1 battleWO)
						)
					)
					(6
						(cond
							((IsFlag 25) nightSix)
							((IsFlag 125) boysStealthSaved)
							((== gPrevRoomNum 250) boysBattleSaved)
							(1 battleWO)
						)
					)
					(7 night7)
					(8 night8)
					(9 night9)
					(10 night10)
					(11 night11)
					(12 night12)
					(else 0)
				)
		)
	)

	(method (doit)
		(super doit:)
		(Palette palANIMATE 236 254 1)
	)

	(method (dispose &tmp temp0)
		(++ gDay)
		(= global150 0)
		(ClearFlag 66)
		(gRgnMusic stop:)
		(gSFX fade: 0 30 8 1)
		(gTheIconBar curIcon: (= temp0 (gTheIconBar at: 0)))
		(= gTheCursor (temp0 cursor:))
		(super dispose:)
	)
)

(instance stars of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(fireSound play:)
				(firePit init:)
				(= cycles 1)
			)
			(1
				([local0 (Random 0 6)]
					cycleSpeed: (Random 6 18)
					setCycle: Osc 1
				)
				(= ticks (Random 18 58))
				(-- state)
			)
		)
	)
)

(instance series of Script
	(properties)

	(method (handleEvent event)
		(event claimed: 1)
		(if
			(or
				(and (& (event modifiers:) emSHIFT) (& (event type:) evMOUSEBUTTON))
				(and (& (event type:) evKEYBOARD) (== (event message:) KEY_ESCAPE))
			)
			(= register 0)
		)
		(self cue:)
	)

	(method (cue)
		(if (not register)
			(= start state)
		)
		(super cue:)
	)

	(method (init param1 param2 param3 param4 param5)
		(gGame setCursor: gWaitCursor 1 310 185)
		(= register 1)
		(= start param4)
		(super init: param1 param2 param3)
		(= start param5)
		(gKeyDownHandler addToFront: self)
		(gMouseDownHandler addToFront: self)
		(Load rsPIC 160)
		(LoadMany rsVIEW 140 143 147 158 161 164 152 155)
	)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3 [temp4 256])
		(if (<= (= state newState) start)
			(gCurRoom drawPic: 803 9)
			(GetFarText register state @temp4)
			(= temp2 @temp4)
			(= temp3 0)
			(= temp1 1)
			(if (< (StrLen temp2) 32)
				(= temp0 (StrLen temp2))
			else
				(= temp0 32)
			)
			(while (!= temp1 0)
				(= temp1 (StrAt @temp4 temp0))
				(if (OneOf temp1 32 9 10 13 0)
					(StrAt @temp4 temp0 0)
					(Display temp2 dsCOORD 45 (+ 40 (* 13 temp3)) dsCOLOR global185)
					(if temp1
						(while (OneOf (StrAt @temp4 (++ temp0)) 32 9 10 13 0)
						)
						(= temp2 (+ @temp4 temp0))
						(++ temp3)
						(if (< (StrLen temp2) 32)
							(+= temp0 (StrLen temp2))
							(continue)
						)
						(+= temp0 32)
					)
				else
					(++ temp0)
				)
			)
			(= ticks (+ global162 (* global163 temp0)))
		else
			(gKeyDownHandler delete: self)
			(gMouseDownHandler delete: self)
			(localproc_4)
			(gCurRoom drawPic: 160 9)
			(gTheIconBar enable: 8)
			(self dispose:)
		)
	)
)

(instance marian of Prop
	(properties
		x 233
		y 146
		view 147
		loop 6
		cycleSpeed 7
	)
)

(instance firePit of Prop
	(properties
		x 222
		y 159
		view 140
		signal 16384
	)

	(method (init)
		(self setCycle: End self)
		(super init:)
	)

	(method (cue &tmp temp0)
		(= temp0 (Random 0 1))
		(self cycleSpeed: (Random 6 18))
		(if temp0
			(self setCycle: End self)
		else
			(self setCycle: Beg self)
		)
		(super cue:)
	)
)

(instance log of View
	(properties
		x 246
		y 148
		view 143
		loop 1
		priority 8
		signal 16400
	)
)

(instance tuckView of View
	(properties
		x 270
		y 173
		view 155
		loop 1
	)
)

(instance johnView of Actor
	(properties
		x 229
		y 183
		view 152
		loop 3
	)
)

(instance willView of View
	(properties
		x 208
		y 151
		view 161
		loop 1
	)
)

(instance alanView of Prop
	(properties
		x 164
		y 148
		view 158
		cycleSpeed 36
	)
)

(instance muchView of View
	(properties
		x 189
		y 166
		view 164
		loop 3
	)
)

(instance nightOne of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: series self 1160 0 0)
			)
			(1
				(= notKilled 1)
				(log posn: 246 148 init: addToPic:)
				(gEgo view: 143 loop: 5 x: 159 y: 162 cycleSpeed: 18 init:)
				(tuckView view: 143 loop: 0 x: 257 y: 153 init:)
				(johnView view: 143 loop: 4 x: 132 y: 169 init:)
				(willView x: 212 y: 180 init:)
				(alanView
					view: 147
					loop: 4
					posn: (+ (log x:) -12) (+ (log y:) 2)
					init:
				)
				(muchView x: 159 y: 188 init:)
				(= cycles 2)
			)
			(2
				(localproc_3)
				(Converse 4 @local31 1 0 15 1 16 2 13 3 self) ; "Fill my mug again, Tuck."
			)
			(3
				(gEgo setCycle: Osc 1 self)
			)
			(4
				(Converse 2 @local39 15 0 14 1 self) ; "Perhaps an enemy has cast a spell on you."
			)
			(5
				(gEgo setCycle: Osc 1 self)
			)
			(6
				(cond
					((IsFlag 75)
						(Converse 3 @local45 1 0 13 1 15 2 self) ; "Is it the death of the woman that haunts you?"
					)
					((IsFlag 103)
						(Converse 2 @local51 1 0 13 1 self) ; "Perhaps it's the fate of the peasant woman that weighs upon you."
					)
					(else
						(self cue:)
					)
				)
			)
			(7
				(if (IsFlag 103)
					(SetScore -100)
					(= seconds 3)
				else
					(self cue:)
				)
			)
			(8
				(if (IsFlag 103)
					(Converse 2 @local59 1 0 15 1 self) ; "You mustn't dwell upon it. What happens is God's will."
				else
					(self cue:)
				)
			)
			(9
				(if notKilled
					(gEgo setCycle: Osc 1 self)
				else
					(= cycles 1)
				)
			)
			(10
				(Converse @local64 1 0 self) ; "I know full well the nature of this melancholy, for we all feel it from time to time."
			)
			(11
				(if notKilled
					(gEgo setCycle: Osc 1 self)
				else
					(= cycles 1)
				)
			)
			(12
				(Converse @local68 1 0 self) ; "'Tis that we're outlaws, forced away from kith and kin, living as we can in the forest."
			)
			(13
				(if notKilled
					(gEgo setCycle: Osc 1 self)
				else
					(= cycles 1)
				)
			)
			(14
				(Converse @local72 1 0 self) ; "Knowing death waits in an arrow's flight, or worse yet, a rope's bite."
			)
			(15
				(if notKilled
					(gEgo setCycle: Osc 1 self)
				else
					(= cycles 1)
				)
			)
			(16
				(Converse 2 @local76 1 0 13 3 self) ; "A short life but a merry one, that's the way of it."
			)
			(17
				(if notKilled
					(gEgo setCycle: Osc 1 self)
				else
					(= cycles 1)
				)
			)
			(18
				(Converse 3 @local81 1 0 16 1 17 2 self) ; "Ah, there's the nub of the matter. You need a good woman, Robin. I know this lass with huge tracts of land--"
			)
			(19
				(gEgo view: 145 loop: 1 cel: 0 setCycle: Osc 1 self)
			)
			(20
				(Converse @local87 1 0 self) ; "...I'm off...to bed....now lesse...which way is it....."
			)
			(21
				(gEgo dispose:)
				(johnView view: 145 loop: 0 setCycle: End self)
			)
			(22
				(Converse 1 @local91 13 1 self) ; "Good night, lads. I'll assist Master Hood to his bed and see you on the morrow."
			)
			(23
				(johnView
					setLoop: 2
					cel: 0
					setCycle: Walk
					setMotion: MoveTo 128 157 self
				)
			)
			(24
				(gSFX fade: 0 30 8 1)
				(gCurRoom newRoom: 140)
			)
		)
	)
)

(instance night2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (IsFlag 5)
					(self setScript: series self 1161 1 1)
				else
					(self setScript: series self 1161 0 0)
				)
			)
			(1
				(if (IsFlag 5)
					(localproc_1)
				else
					(localproc_2)
				)
				(= seconds 2)
			)
			(2
				(Converse
					6
					(if (IsFlag 5) @local114 else @local95)
					1
					0
					15
					1
					13
					2
					14
					3
					3
					0
					2
					0
					self
				)
				(if (gEgo has: 3) ; slipper
					(++ state)
				)
			)
			(3
				(Converse
					3
					(if (IsFlag 5) @local124 else @local107)
					1
					0
					17
					1
					3
					0
					self
				)
				(gEgo get: 3) ; slipper
			)
			(4
				(if (IsFlag 5)
					(Converse @local130 1 0 self) ; "We'll see what the morrow brings and hope for a kinder fate."
				else
					(= cycles 1)
				)
			)
			(5
				(localproc_0)
				(= ticks 90)
			)
			(6
				(gSFX fade: 0 30 8 1)
				(gCurRoom newRoom: 140)
			)
		)
	)
)

(instance night3 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: series self 1162 0 0)
			)
			(1
				(localproc_2)
				(= seconds 2)
			)
			(2
				(Converse 5 @local134 1 0 15 1 16 2 13 3 3 0 self) ; "Pheuw! The stench of those burning rags does nothing to improve my digestion!"
			)
			(3
				(localproc_0)
				(= ticks 90)
			)
			(4
				(gSFX fade: 0 30 8 1)
				(gCurRoom newRoom: 140)
			)
		)
	)
)

(instance night4 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (or (IsFlag 153) (IsFlag 174))
					(self setScript: series self 1162 11 11)
				else
					(self setScript: series self 1162 12 12)
				)
			)
			(1
				(if (IsFlag 184)
					(localproc_1)
				else
					(localproc_2)
				)
				(= seconds 2)
			)
			(2
				(if (IsFlag 184)
					(Converse 4 @local162 2 0 14 1 16 2 13 3 self) ; "You're all quite glum tonight. Is something amiss?"
				else
					(Converse 5 @local147 1 0 14 1 16 2 13 3 3 0 self) ; "Well, treasure-seeker, you've been uncommon quiet upon the lady's virtues now that you've truly met her."
				)
			)
			(3
				(if (IsFlag 184)
					(SetScore -100)
					(= seconds 3)
				else
					(self cue:)
				)
			)
			(4
				(if (IsFlag 184)
					(Converse 2 @local170 16 2 15 3 self) ; "Ah, then you have cause to be glum."
				else
					(self cue:)
				)
			)
			(5
				(localproc_0)
				(= ticks 90)
			)
			(6
				(gSFX fade: 0 30 8 1)
				(gCurRoom newRoom: 140)
			)
		)
	)
)

(instance boysStealthSaved of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: series self 1164 1 1)
			)
			(1
				(localproc_2)
				(= cycles 2)
			)
			(2
				(Converse 5 @local200 3 0 15 1 16 2 14 3 13 1 self) ; "'May you get all you deserve and may I live to see it!' Robin, you've a wicked wit!"
			)
			(3
				(localproc_0)
				(= ticks 90)
			)
			(4
				(ClearFlag 125)
				(gSFX fade: 0 30 8 1)
				(gCurRoom newRoom: 140)
			)
		)
	)
)

(instance boysBattleSaved of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: series self 1164 2 2)
			)
			(1
				(localproc_1)
				(= cycles 2)
			)
			(2
				(Converse 4 @local210 1 0 14 1 15 2 13 3 self) ; "You should rejoice more, Master. We fought well and the Widow's sons are free men."
			)
			(3
				(Converse 2 @local233 14 0 13 1 self) ; "And I'm as proud as a man can be to call Robin Hood my leader. Let us toast him, men!"
			)
			(4
				(localproc_0)
				(= ticks 90)
			)
			(5
				(gSFX fade: 0 30 8 1)
				(gCurRoom newRoom: 140)
			)
		)
	)
)

(instance battleWO of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: series self 1164 3 5)
			)
			(1
				(AddOutlaws -4)
				(localproc_1)
				(= cycles 2)
			)
			(2
				(Converse 5 @local218 1 0 14 1 17 2 13 3 15 2 self) ; "Well done, men. You've made the Widow a happy woman this day."
			)
			(3
				(localproc_0)
				(= ticks 90)
			)
			(4
				(gSFX fade: 0 30 8 1)
				(gCurRoom newRoom: 140)
			)
		)
	)
)

(instance nightFive of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: series self 1164 0 0)
			)
			(1
				(localproc_2)
				(= cycles 2)
			)
			(2
				(Converse 6 @local177 1 0 15 1 14 2 16 3 13 2 2 0 self) ; "Would that this ring Fulk gave you could make you invisible. Then you could walk into Nottingham Castle and free the Widow's sons."
			)
			(3
				(localproc_0)
				(= ticks 90)
			)
			(4
				(gCurRoom newRoom: 140)
			)
		)
	)
)

(instance nightSix of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: series self 1164 6 6)
			)
			(1
				(localproc_2)
				(= cycles 2)
			)
			(2
				(Converse 5 @local186 1 0 14 1 16 2 13 3 15 1 self) ; "Gargoyles and a dwarf and secret waterways and a magic ring! Truly wondrous elements from which to spin a tale."
			)
			(3
				(localproc_0)
				(= ticks 90)
			)
			(4
				(gSFX fade: 0 30 8 1)
				(gCurRoom newRoom: 140)
			)
		)
	)
)

(instance night7 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (IsFlag 120)
					(self setScript: series self 1166 0 0)
				else
					(self setScript: series self 1166 1 1)
				)
			)
			(1
				(if (IsFlag 120)
					(localproc_2)
				else
					(localproc_1)
				)
				(= cycles 2)
			)
			(2
				(Converse
					6
					(if (IsFlag 120) @local238 else @local249)
					1
					0
					15
					1
					16
					2
					13
					3
					14
					2
					3
					0
					self
				)
			)
			(3
				(localproc_0)
				(= ticks 60)
			)
			(4
				(Say 1166 10 self) ; "The days to the Saturday Fair speed by. Merchants, vendors and travellers of every description come up from London, down from York on foot, horse, mule, in carts and wagons, or by boat and barge upon the river Trent."
			)
			(5
				(Say 1166 11 self) ; "We leave Watling Street alone, having no desire to hinder those going to the Fair or stir up trouble with the Sheriff...until the time is right."
			)
			(6
				(gSFX fade: 0 30 8 1)
				(gCurRoom newRoom: 140)
			)
		)
	)
)

(instance night8 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (IsFlag 10)
					(self setScript: series self 1167 0 1)
				else
					(self setScript: series self 1167 2 2)
				)
			)
			(1
				(if (IsFlag 10)
					(localproc_2)
				else
					(localproc_1)
				)
				(= cycles 2)
			)
			(2
				(if (IsFlag 10)
					(Converse 6 @local262 3 0 15 1 16 2 13 3 14 1 1 0 self) ; "I watched the Tournament from the crowd, Robin. Never have I seen you shoot better."
					(+= state 2)
				else
					(Converse 4 @local278 1 0 14 1 16 2 13 3 self) ; "Cheer up, Robin. You found the scholar and performed the task Marian asked."
				)
			)
			(3
				(willView setLoop: 0)
				(= ticks 24)
			)
			(4
				(Converse @local286 15 0 self) ; "Hush, you two. You're worse than a pair of cuckoos."
			)
			(5
				(Converse 2 @local273 3 0 13 3 self) ; "There's another place to look for riches--the Sheriff's own coffers."
			)
			(6
				(localproc_0)
				(= ticks 90)
			)
			(7
				(gSFX fade: 0 30 8 1)
				(gCurRoom newRoom: 140)
			)
		)
	)
)

(instance night9 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (IsFlag 122)
					(self setScript: series self 1168 0 1)
				else
					(self setScript: series self 1168 2 3)
				)
			)
			(1
				(localproc_2)
				(gEgo view: 147 loop: 7 x: 251 y: 149)
				(marian view: 147 loop: 6 cel: 0 x: 233 y: 146 init:)
				(alanView
					view: 147
					loop: 4
					x: 81
					y: 142
					priority: 15
					signal: 16
				)
				(willView view: 161 loop: 0 x: 140 y: 149)
				(= cycles 2)
			)
			(2
				(Converse
					2
					(if (IsFlag 122) @local290 else @local297)
					1
					0
					22
					1
					self
				)
			)
			(3
				(Converse 6 @local303 1 0 22 1 14 2 15 3 13 0 3 0 self) ; "Worry not about us, Lady."
				(if
					(or
						(gEgo has: 12) ; puzzleBox
						(IsFlag 101)
						(== ((Inv at: 12) owner:) 140) ; puzzleBox
					)
					(++ state)
				)
			)
			(4
				(self setScript: getPuzzBox self)
			)
			(5
				(localproc_0)
				(= ticks 90)
			)
			(6
				(gSFX fade: 0 30 8 1)
				(gCurRoom newRoom: 140)
			)
		)
	)
)

(instance getPuzzBox of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Converse 2 @local331 1 0 22 1 self) ; "One last thing. I've brought you this puzzle box. I relieved the Abbot from his possession of it."
			)
			(1
				(= seconds 2)
			)
			(2
				(marian setCycle: End self)
				(= ticks 13)
			)
			(3
				(gEgo setCycle: End self)
			)
			(4)
			(5
				(= ticks 27)
			)
			(6
				(marian setCycle: Beg self)
				(gEgo setCycle: Beg)
			)
			(7
				(gEgo get: 12) ; puzzleBox
				(Converse 3 @local335 1 0 22 1 3 0 self) ; "From the Abbot? How did you come by it?"
			)
			(8
				(self dispose:)
			)
		)
	)
)

(instance night10 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (IsFlag 62)
					(self setScript: series self 2160 0 1)
				else
					(self setScript: series self 2160 2 2)
				)
			)
			(1
				(if (IsFlag 62)
					(localproc_2)
				else
					(localproc_1)
				)
				(= seconds 2)
			)
			(2
				(if (IsFlag 62)
					(Converse 4 @local353 1 0 15 1 14 2 13 3 self) ; "How fares the Lady?"
				else
					(Converse 3 @local345 2 0 14 1 13 2 self) ; "Robin, if there is anything we could say--"
				)
			)
			(3
				(localproc_0)
				(= ticks 90)
				(if (IsFlag 62)
					(+= state 2)
				)
			)
			(4
				(Say 2160 8 self) ; "Marian was laid to rest in the willow grove. I fancied I could hear her voice whispering to me when the wind stirred the long willow leaves."
			)
			(5
				(Say 2160 9 self) ; "Dark, heavy days for me pass in painful slowness. I set aside mourning only because I must, or my grief will infect the men and destroy their morale."
			)
			(6
				(Say 2160 10 self) ; "We sent scouts to the north and wait for their signal. Long, weary days creep past."
			)
			(7
				(Say 2160 11 self) ; "I fear that Prince John's nerve has failed and the treasure will never come."
			)
			(8
				(gSFX fade: 0 30 8 1)
				(gCurRoom newRoom: 140)
			)
		)
	)
)

(instance noPass of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Converse 3 @local401 1 0 14 1 13 2 self) ; "Robin, it pains me to remind you, but...what of the password you must give the Knight?"
			)
			(1
				(localproc_0)
				(= ticks 90)
			)
			(2
				(Say 2161 32 self) ; "But I did not dream of Marian, only of the empty willow grove and leaves whispering softly in the wind."
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance night11 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (IsFlag 65)
					(self setScript: series self 2161 0 0)
				else
					(self setScript: series self 2161 1 1)
				)
			)
			(1
				(= register
					(cond
						((IsFlag 65) 2)
						((== global146 63) 0)
						(else 1)
					)
				)
				(if (or (== register 0) (== register 1))
					(localproc_1)
				else
					(localproc_2)
				)
				(= cycles 2)
			)
			(2
				(switch register
					(0
						(Converse 5 @local391 1 0 14 1 17 2 13 3 15 1 self) ; "I'm sorry. It's all my fault."
						(AddOutlaws -1)
						(+= state 2)
					)
					(2
						(Converse 4 @local364 3 0 15 1 14 2 13 3 self) ; "A toast to all my brave lads! To the loyal outlaws of Sherwood!"
					)
					(1
						(localproc_3)
						(Converse 5 @local377 1 0 15 1 14 2 13 3 16 3 self) ; "Speak up, men. The blame lies with me."
						(+= state 2)
					)
				)
			)
			(3
				(gEgo cycleSpeed: 18 setCycle: Osc 1 self)
			)
			(4
				(Converse @local371 3 0 self) ; "A finer day's work we've never done."
			)
			(5
				(if (not (or (IsFlag 51) (IsFlag 62)))
					(self setScript: noPass self)
				else
					(localproc_0)
					(= ticks 90)
				)
			)
			(6
				(gSFX fade: 0 30 8 1)
				(gCurRoom newRoom: 140)
			)
		)
	)
)

(instance night12 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: series self 2162 0 0)
			)
			(1
				(localproc_1)
				(= cycles 2)
			)
			(2
				(if (gEgo has: 9) ; message
					(++ state)
				)
				(Converse 4 @local408 1 0 15 3 17 1 13 2 self) ; "I grow weary of these Sheriff's men tramping through our territory like vermin."
			)
			(3
				(gEgo get: 9) ; message
				(Converse 5 @local415 1 0 15 3 17 1 13 2 14 2 self) ; "When we buried the Knight you killed, we found a letter upon him, written from the Prior to the Sheriff."
			)
			(4
				(Converse 1 @local423 14 2 self) ; "We'd better sleep on it, then. Tomorrow may well be a desperate day."
			)
			(5
				(localproc_0)
				(= ticks 90)
			)
			(6
				(gSFX fade: 0 30 8 1)
				(gCurRoom newRoom: 140)
			)
		)
	)
)

(instance fireSound of Sound
	(properties
		flags 1
		number 537
		loop -1
	)
)

