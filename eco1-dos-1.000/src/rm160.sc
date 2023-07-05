;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 160)
(include sci.sh)
(use Main)
(use Interface)
(use eRS)
(use n819)
(use Talker)
(use PolyPath)
(use Polygon)
(use Feature)
(use DPath)
(use Motion)
(use Inventory)
(use User)
(use Actor)
(use System)

(public
	rm160 0
)

(local
	local0
	local1
	local2 = 33
	[local3 500]
)

(procedure (localproc_0 &tmp temp0)
	(while (not (tmpList isEmpty:))
		(= temp0 (Random 0 (- (tmpList size:) 1)))
		(columnList add: (tmpList at: temp0))
		(tmpList delete: (tmpList at: temp0))
	)
	(tmpList dispose:)
)

(procedure (localproc_1 &tmp temp0 temp1 temp2)
	(for ((= temp0 0)) (< temp0 (columnList size:)) ((++ temp0))
		(= temp2 (columnList at: temp0))
		(= [global175 temp0] (+ (* (temp2 placeHolder:) 10) (temp2 cel:)))
	)
)

(procedure (localproc_2 &tmp temp0 temp1)
	(for ((= temp0 0)) (< temp0 (tmpList size:)) ((++ temp0))
		((tmpList at: (= temp1 (/ [global175 temp0] 10)))
			cel: (mod [global175 temp0] 10)
		)
		(columnList add: (tmpList at: temp1))
	)
	(tmpList release: dispose:)
)

(procedure (localproc_3 &tmp temp0)
	(= temp0 1)
	(cond
		(
			(and
				(gCast contains: goldMask)
				(== (goldMask script:) whoDares)
				(IsFlag 4)
			)
			(whoDares dispose:)
			(SetScore 2 265)
			(gCurRoom setScript: senatorSpeech)
		)
		((not (IsFlag 4))
			(Narrator init: 3) ; "Adam has no reason to talk to the empty room."
		)
		((and (not (IsFlag 2)) (IsFlag 3))
			(Narrator init: 15) ; "Adam calls out to the disembodied voice, but gets no reply. HE must still be pondering."
		)
		(else
			(= temp0 0)
		)
	)
	(return temp0)
)

(procedure (localproc_4 &tmp temp0 temp1)
	(for
		((= temp0 0))
		(and
			(< temp0 (columnList size:))
			(not ((= temp1 (columnList at: temp0)) cel:))
		)
		((++ temp0))
		
		(temp1 locked: 1)
	)
)

(class Column of View
	(properties
		approachX 79
		approachY 145
		endCel 2
		placeHolder 0
		locked 0
		caller 0
		aligned 0
	)

	(method (init param1)
		(super init: &rest)
		(tmpList add: self)
		(self placeHolder: param1 setPri: 0 cel: (Random 1 2))
	)

	(method (dispose)
		(columnList delete: self)
		(super dispose:)
	)

	(method (moveColumn &tmp temp0)
		(if (and (not (IsFlag 2)) (not locked))
			(self nextCel:)
			(if (not (IsFlag 120))
				(= caller self)
			)
			(if (and (self lock:) (not (self checkAlignment: 1)))
				(if (not (SetFlag 119))
					(Narrator init: 40 caller) ; "The column piece locks into place. It now matches the corresponding column piece on the right side of the Council Chambers."
				else
					(Narrator init: 30 caller) ; "The column piece locks into place."
				)
			)
			(if (and (not aligned) (= temp0 (self whoDoIMove:)))
				(temp0 nextCel:)
			)
			(if (self checkAlignment: 1)
				(SetFlag 2)
				(SetScore 10 264)
				(gCurRoom setScript: maskFall)
			)
			(if (and (not gFastCast) caller)
				(caller cue:)
			)
		)
	)

	(method (lock &tmp temp0)
		(= temp0 0)
		(if (and (not locked) (= aligned (self checkAlignment:)) (not cel))
			(= locked 1)
			(gLongSong2 number: 169 loop: 1 play:)
			(= temp0 1)
		)
		(return temp0)
	)

	(method (nextCel)
		(if (> (++ cel) endCel)
			(= cel 0)
		)
		(self forceUpd:)
		(gSoundEffects number: 164 loop: 1 play:)
		(Animate (gCast elements:) 0)
	)

	(method (checkAlignment &tmp temp0)
		(if (not argc)
			(for ((= temp0 0)) (< temp0 (columnList indexOf: self)) ((++ temp0))
				(if (not ((columnList at: temp0) locked:))
					(return 0)
				)
			)
		else
			(for ((= temp0 0)) (< temp0 (columnList size:)) ((++ temp0))
				(if (not ((columnList at: temp0) locked:))
					(return 0)
				)
			)
		)
		(return 1)
	)

	(method (whoDoIMove &tmp temp0)
		(if (= temp0 (columnList indexOf: self))
			(return (columnList at: (- temp0 1)))
		)
		(return 0)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(cond
					((IsFlag 2)
						(Narrator init: 32) ; "The columns on the left of the Council Chambers now match the columns on the right."
					)
					(locked
						(Narrator init: 36) ; "That piece has locked into place and now matches it's corresponding piece in the columns on the opposite wall."
					)
					((IsFlag 3)
						(gCurRoom setScript: doRiddle)
					)
					(else
						(Narrator init: 4) ; "Six beautiful columns line the Council Chambers."
					)
				)
			)
			(3 ; Do
				(cond
					((not (IsFlag 3))
						(Narrator init: 2) ; "The columns interest Adam, but he's not sure what to do with them."
					)
					((IsFlag 2)
						(Narrator init: 37) ; "The columns are now perfectly aligned. Adam doesn't want to mess with perfection."
					)
					(locked
						(Narrator init: 5) ; "That piece is already locked in its correct position."
					)
					((and (!= (gEgo x:) 79) (!= (gEgo y:) 145))
						(gCurRoom setScript: moveEgoToColumns 0 self)
					)
					(else
						(self moveColumn:)
					)
				)
			)
			(4 ; Inventory
				(cond
					((not (IsFlag 3))
						(Narrator init: 52) ; "Adam can't do anything with the columns, at least not now."
					)
					((IsFlag 2)
						(Narrator init: 52) ; "Adam can't do anything with the columns, at least not now."
					)
					(else
						(Narrator init: 53) ; "That won't help Adam solve the challenge of the columns."
					)
				)
			)
			(10 ; Recycle
				(Narrator init: 51) ; "The Council Chamber columns have great symbolic meaning and are hardly garbage bag material."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (cue)
		(= caller 0)
		(SetFlag 120)
		((ScriptID 2 1) init: 42) ; Adam, "Whoa! The column pieces move! Now I wonder what order I should put them in?"
	)
)

(instance rm160 of EcoRoom
	(properties
		picture 160
		style 10
		horizon 20
		south 120
	)

	(method (init)
		(NormalEgo)
		(gEgo init: posn: 160 215 ignoreHorizon: 1 setLoop: gStopGroop hide:)
		(if (== gPrevRoomNum 200)
			(= picture 901)
		)
		(self setRegions: 51) ; bubblesRegion
		(super init:)
		(gFeatures
			add: cols senatorMural seatedSenator opening floor
			eachElementDo: #init
		)
		(if (and (IsFlag 2) (not (IsFlag 11)))
			(crab init:)
			(ClearFlag 13)
		else
			(SetFlag 13)
		)
		(if (!= gPrevRoomNum 200)
			(cond
				((not (IsFlag 2))
					(column1_T init: 0)
					(column1_M init: 1)
					(column1_B init: 2)
					(column2_T init: 3)
					(column2_M init: 4)
					(column2_B init: 5)
					(column3_T init: 6)
					(column3_M init: 7)
					(column3_B init: 8)
					(goldMask init: stopUpd:)
					(if (not global175)
						(localproc_0)
					else
						(localproc_2)
					)
					(columnList eachElementDo: #stopUpd)
					(localproc_4)
				)
				((and (not (gEgo has: 19)) (!= ((Inv at: 19) owner:) 140)) ; goldMask, goldMask
					(goldMask loop: 1 cel: 15 x: 192 y: 93 init: stopUpd:)
				)
			)
		)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 189 0 0 319 0 319 189 305 189 305 8 11 8 11 189
					yourself:
				)
		)
		(if (== gPrevRoomNum 200)
			(gCurRoom setScript: thankYou)
		else
			(gCurRoom setScript: enterScript)
		)
		(gLongSong
			number:
				(+
					160
					(if (IsFlag 2)
						(not (IsFlag 11))
					)
				)
			loop: -1
			play:
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(self setScript: lookInRoom)
			)
			(10 ; Recycle
				(Narrator init: 48) ; "There is no garbage in the Council Chambers."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (doit)
		(super doit:)
		(cond
			(script 0)
			((== (gEgo edgeHit:) 1)
				(self setScript: noExit)
			)
		)
		(if (and (!= (gLongSong number:) 160) (== (gLongSong prevSignal:) -1))
			(gLongSong number: 160 loop: -1 play:)
		)
	)

	(method (newRoom newRoomNumber)
		(if (not (IsFlag 2))
			(localproc_1)
		)
		(gLongSong fade:)
		(super newRoom: newRoomNumber)
	)
)

(instance moveEgoToColumns of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 79 145 self)
			)
			(1
				(gEgo setHeading: 315 self)
			)
			(2
				(= cycles 6)
			)
			(3
				(register doVerb: 3 0)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance enterScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 1)
			)
			(1
				(gEgo show: setMotion: MoveTo 165 181 self)
			)
			(2
				(= cycles 12)
			)
			(3
				(HandsOn)
				(cond
					((and (IsFlag 4) (not (IsFlag 3)) (not (IsFlag 2)))
						(goldMask setScript: whoDares)
					)
					((and (IsFlag 2) (not (IsFlag 11)))
						(crab setScript: crabCry)
					)
				)
				(= cycles 2)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance maskFall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Narrator init: 31 self) ; "The last column piece shifts into place. Adam feels the water tremble..."
			)
			(1
				(gLongSong2 number: 165 loop: 1 play:)
				(ShakeScreen 12 ssLEFTRIGHT)
				(SetFlag 2)
				(= cycles 1)
			)
			(2
				(Narrator init: 34 self) ; "The room shakes as the building settles down on the columns! The gold mask is knocked from the wall!"
			)
			(3
				(Face gEgo goldMask)
				(goldMask loop: 1 cel: 0 x: 192 y: 93 setCycle: End self)
			)
			(4
				(gSoundEffects number: 168 loop: 1 play:)
				(goldMask stopUpd:)
				(= seconds 2)
			)
			(5
				(self setScript: walkOutOfShell self)
			)
			(6
				(Narrator init: 35 self) ; "A dazed hermit crab stumbles from the fallen mask."
			)
			(7
				(HandsOn)
				(crab setScript: crabCry)
				(self dispose:)
			)
		)
	)
)

(instance crabCry of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Superfluous init: 24 0 self) ; "Boo HOO. Oh, BOO HOO!"
			)
			(1
				(Superfluous say: 8 1 self)
			)
			(2
				(= seconds 6)
			)
			(3
				(Superfluous init: 24 1 self) ; "Boo HOO. Oh, BOO HOO!"
			)
			(4
				(= seconds 6)
			)
			(5
				(self changeState: 3)
			)
		)
	)
)

(instance whoDares of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Print (GetMessage 5 gCurRoomNum 1 @local3))
				(Narrator init: 29 self) ; "The booming voice seems to come from nowhere."
			)
			(1
				(= seconds 10)
			)
			(2
				(Print (GetMessage 5 gCurRoomNum 2 @local3))
				(= seconds 30)
			)
			(3
				(= local2 55)
				(gCurRoom setScript: senatorSpeech)
				(self dispose:)
			)
		)
	)
)

(instance senatorSpeech of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 1)
			)
			(1
				(Narrator init: local2 self)
			)
			(2
				((ScriptID 2 1) init: 1 1 self) ; Adam, "Who... who are you?"
			)
			(3
				(Print (GetMessage 5 gCurRoomNum 3 @local3))
				(= cycles 1)
			)
			(4
				((ScriptID 2 1) init: 2 1 self) ; Adam, "Oh. Well, okay. I'm Adam. Delphineus brought me here to help."
			)
			(5
				(Print (GetMessage 5 gCurRoomNum 4 @local3))
				(= cycles 1)
			)
			(6
				((ScriptID 2 1) init: 3 1 self) ; Adam, "What whale? You mean Cetus?"
			)
			(7
				(Print (GetMessage 5 gCurRoomNum 5 @local3))
				(= cycles 1)
			)
			(8
				(Print (GetMessage 5 gCurRoomNum 31 @local3))
				(= cycles 1)
			)
			(9
				((ScriptID 2 1) init: 4 1 self) ; Adam, "But Cetus is missing."
			)
			(10
				(Print (GetMessage 5 gCurRoomNum 6 @local3))
				(= cycles 1)
			)
			(11
				(Print (GetMessage 5 gCurRoomNum 32 @local3))
				(= cycles 1)
			)
			(12
				((ScriptID 2 1) init: 5 1 self) ; Adam, "How will you replace Cetus, Great Senator? Things look a mess to me. Maybe I could help."
			)
			(13
				(Print (GetMessage 5 gCurRoomNum 7 @local3))
				(= cycles 1)
			)
			(14
				((ScriptID 2 1) init: 44 1 self) ; Adam, "What challenge of the columns?"
			)
			(15
				(Print (GetMessage 5 gCurRoomNum 36 @local3))
				(= cycles 1)
			)
			(16
				(Print (GetMessage 5 gCurRoomNum 33 @local3))
				(SetFlag 3)
				(= cycles 1)
			)
			(17
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance crabWhine of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((ScriptID 2 1) init: 6 1 self) ; Adam, "Who are you?"
			)
			(1
				(= cycles 1)
			)
			(2
				(Superfluous init: 9 1 self) ; "I'm the Great Senator - I mean... oh, I'm a nobody! Boo-hoo! I'm a failure! Boo-hoo-dee-hoo!"
			)
			(3
				(= cycles 1)
			)
			(4
				((ScriptID 2 1) init: 7 1 self) ; Adam, "Well, why were you hiding in the mask?"
			)
			(5
				(= cycles 1)
			)
			(6
				(Superfluous init: 10 1 self) ; "My name is Superfluous. I've always been the Mayor, but I never actually had to DO anything. Cetus took care of it all, you see. Now he's gone and I ought to do SOMETHING, but I don't know what!"
			)
			(7
				(= cycles 1)
			)
			(8
				((ScriptID 2 1) init: 8 1 self) ; Adam, "Well, gosh, you need to call a meeting or something. Get everyone to help."
			)
			(9
				(= cycles 1)
			)
			(10
				(Superfluous init: 11 0 self) ; "Oh, they won't listen! Why do you think I pretended to be the Great Senator? They might have respected HIM! But NO! They're all huddled in their homes! Scared! They won't come out for a meeting!"
			)
			(11
				(Superfluous say: 25 1 self)
			)
			(12
				(= cycles 1)
			)
			(13
				((ScriptID 2 1) init: 9 1 self) ; Adam, "Well, maybe I can get the citizens to come out."
			)
			(14
				(= cycles 1)
			)
			(15
				(Superfluous init: 12 0 self) ; "Why should they listen to you - a human boy? Why, I don't even trust you! No, sorry. I don't think it would work. It would be nice if it could, though."
			)
			(16
				(Superfluous say: 26 1 self)
			)
			(17
				(SetFlag 11)
				(self setScript: walkUnderShell self)
			)
			(18
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance getInCleanShell of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(crab setScript: 0)
				(if (not (IsFlag 13))
					(self changeState: 2)
				else
					((ScriptID 2 1) init: 18 1 self) ; Adam, "Superfluous! Come out and see what I brought you!"
				)
			)
			(1
				(self setScript: walkOutOfShell self)
			)
			(2
				((ScriptID 2 1) init: 14 1 self) ; Adam, "I found you a new shell. You said your old one was pinching you."
			)
			(3
				(gEgo setMotion: MoveTo 191 96 self)
			)
			(4
				(= cycles 12)
			)
			(5
				(gEgo
					setCycle: 0
					view: 168
					loop: 0
					cel: 0
					posn: 169 115
					cycleSpeed: 11
					setCycle: End self
				)
			)
			(6
				(Superfluous init: 21 1 self) ; "Oh, a nice clean shell! Thank you, it's ever so roomy! But why would a human boy do such a thing?"
			)
			(7
				((ScriptID 2 1) init: 16 1 self) ; Adam, "I told you, I want to help Eluria."
			)
			(8
				(gEgo hide:)
				(goldMask hide:)
				(INSET init:)
				(crab
					view: 163
					loop: 1
					cel: 0
					x: 155
					y: 133
					cycleSpeed: 10
					setPri: 8
					illegalBits: 0
					setCycle: End
				)
				(= cycles 10)
			)
			(9
				(crab
					view: 163
					loop: 2
					x: 155
					y: 133
					cycleSpeed: 10
					setCycle: End self
				)
			)
			(10
				(gSoundEffects number: 603 loop: 1 play:)
				(crab
					view: 163
					loop: 3
					x: 155
					y: 133
					cycleSpeed: 8
					setCycle: End self
				)
			)
			(11
				(gSoundEffects number: 163 loop: 1 play:)
				(crab view: 163 loop: 4 x: 186 y: 106 cel: 0 cycleSpeed: 9)
				(= cycles 9)
			)
			(12
				(gSoundEffects number: 163 loop: 1 play:)
				(crab cel: 1 cycleSpeed: 4 setCycle: End self)
			)
			(13
				(gSoundEffects stop:)
				(= seconds 2)
			)
			(14
				(gSoundEffects number: 163 loop: 1 play:)
				(crab setCycle: Beg self)
			)
			(15
				(gSoundEffects stop:)
				(= cycles 10)
			)
			(16
				(Superfluous init: 22 0 self) ; "Nice fit! I don't know how to thank you! You know, maybe the citizens would listen to you after all. Oh, if only you could get them to come here... why! <sniff>, maybe together we could all think of a way to save ourselves."
			)
			(17
				(Superfluous say: 29 1 self)
			)
			(18
				((ScriptID 2 1) init: 19 1 self) ; Adam, "I'll do my best, Mr. Mayor."
			)
			(19
				(= cycles 10)
			)
			(20
				(gSoundEffects number: 163 loop: 1 play:)
				(crab setCycle: End self)
			)
			(21
				(= seconds 2)
			)
			(22
				(gSoundEffects number: 163 loop: 1 play:)
				(crab
					view: 163
					loop: 5
					cel: 0
					x: 186
					y: 106
					cycleSpeed: 8
					setCycle: CT 4 1 self
				)
			)
			(23
				(gSoundEffects number: 167 loop: 1 play:)
				(crab setCycle: End self)
			)
			(24
				(SetScore 5 267)
				(gEgo put: 22 160 get: 20) ; hermetShell, starFish
				(Superfluous init: 30 1 self) ; "Here. Here's the badge. Now off with ya, son, and don't let me down!"
			)
			(25
				(Narrator posn: -1 15 init: 1 self) ; "Adam takes the deputy badge from Superfluous. Why... it's a starfish!"
			)
			(26
				(gSoundEffects number: 163 loop: 1 play:)
				(crab
					view: 163
					loop: 4
					x: 186
					y: 106
					cycleSpeed: 9
					setCycle: End self
				)
			)
			(27
				(= seconds 1)
			)
			(28
				(INSET dispose:)
				(goldMask show:)
				(crab view: 162 loop: 0 cel: 0 posn: 194 130 setCycle: Walk)
				(ClearFlag 116)
				(gEgo show: posn: 160 127)
				(NormalEgo)
				(gEgo ignoreHorizon: 1)
				(= seconds 2)
			)
			(29
				(self setScript: walkUnderShell self)
			)
			(30
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance getInOilyShell of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(crab setScript: 0)
				(if (not (IsFlag 13))
					(self changeState: 2)
				else
					((ScriptID 2 1) init: 18 1 self) ; Adam, "Superfluous! Come out and see what I brought you!"
				)
			)
			(1
				(self setScript: walkOutOfShell self)
			)
			(2
				((ScriptID 2 1) init: 14 1 self) ; Adam, "I found you a new shell. You said your old one was pinching you."
			)
			(3
				(gEgo setMotion: MoveTo 191 96 self)
			)
			(4
				(= cycles 12)
			)
			(5
				(gEgo
					setCycle: 0
					view: 168
					loop: 0
					cel: 0
					posn: 169 115
					cycleSpeed: 11
					setCycle: End self
				)
			)
			(6
				(if (== local1 1)
					(Superfluous init: 28 1 self) ; "Oh, that dirty thing. <sniff> I told you I can't use it with all that oil and tar on it like that."
				else
					(self changeState: 8)
				)
			)
			(7
				(self changeState: 11)
			)
			(8
				(Superfluous init: 19 1 self) ; "Why how thoughtful. It looks like a nice shell, too, but I'm afraid I can't live in all that tar. The toxins would soak into my sensitive underskin and kill me within days."
			)
			(9
				((ScriptID 2 1) init: 15 1 self) ; Adam, "Oh. I'm sorry."
			)
			(10
				(Superfluous init: 20 1 self) ; "Well <sniff>, what can you expect from a human?"
			)
			(11
				(= local1 1)
				(SetFlag 116)
				(NormalEgo)
				(gEgo posn: 160 127 ignoreHorizon: 1)
				(= cycles 12)
			)
			(12
				(self setScript: walkUnderShell self)
			)
			(13
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance walkOutOfShell of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gLongSong number: 161 loop: -1 play:)
				(goldMask hide:)
				(crab
					view: 167
					loop: 0
					cel: 0
					posn: 181 125
					cycleSpeed: 14
					setPri: 0
					init:
					setCycle: End self
				)
			)
			(1
				(crab view: 162 loop: 0 cel: 1 posn: 184 125)
				(goldMask view: 160 loop: 1 cel: 15 posn: 192 97 show:)
				(= cycles 3)
			)
			(2
				(ClearFlag 13)
				(crab setCycle: Walk setMotion: DPath 194 125 194 130 self)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance walkUnderShell of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 0)
				(goldMask hide:)
				(crab
					view: 167
					loop: 1
					cel: 0
					posn: 179 130
					cycleSpeed: 14
					setCycle: End self
				)
				(gLongSong fade: 30 25 10 1)
			)
			(1
				(crab dispose:)
				(goldMask show:)
				(SetFlag 13)
				(= cycles 1)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance superflBeforeNewShell of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (IsFlag 13)
					((ScriptID 2 1) init: 17 1 self) ; Adam, "Superfluous, come out!"
				else
					(self changeState: 2)
				)
			)
			(1
				(self setScript: walkOutOfShell self)
			)
			(2
				(if (== local0 1)
					(Superfluous init: 27 1 self) ; "What more can I say to you, human child?"
				else
					(Superfluous init: 17 1 self) ; "What...? Oh, it's only you. I told you, I don't trust a human boy, and I don't think the citizens will either. So far, you've done nothing to change my mind."
				)
			)
			(3
				(if (not (gEgo has: 22)) ; hermetShell
					(self setScript: walkUnderShell self)
				else
					(= cycles 1)
				)
			)
			(4
				(= local0 1)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance keepWorkingOnApts of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (IsFlag 13)
					((ScriptID 2 1) init: 17 1 self) ; Adam, "Superfluous, come out!"
				else
					(self changeState: 2)
				)
			)
			(1
				(self setScript: walkOutOfShell self)
			)
			(2
				(Superfluous init: 18 1 self) ; "Oh, Adam. I see you're still working on the citizens. Keep at it, boy."
			)
			(3
				(self setScript: walkUnderShell self)
			)
			(4
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance thankYou of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Display
					(GetMessage 99 gCurRoomNum 61 @local3)
					dsCOORD
					104
					85
					dsCOLOR
					global207
					dsFONT
					300
				)
				(= seconds 3)
			)
			(1
				(gCurRoom drawPic: 160 10)
				(NormalEgo 3)
				(gEgo
					posn: 165 200
					show:
					ignoreHorizon: 1
					setCycle: Walk
					setMotion: MoveTo 165 181 self
				)
				(gDelph
					view: 831
					posn: 115 210
					setLoop: 3
					cel: 5
					setPri: 3
					yStep: 2
					ignoreActors:
					illegalBits: 0
					init:
					setCycle: 0
					setMotion: MoveTo 115 180
				)
				(goldMask loop: 1 cel: 15 x: 192 y: 93 init:)
				(crab init: illegalBits: 0 ignoreActors:)
				(cleaningFish1
					init:
					setCycle: Walk
					setMotion: MoveTo 335 198 self
				)
				(cleaningFish2
					init:
					setCycle: Walk
					setMotion: MoveTo 240 200 self
				)
				(cleaningFish3
					init:
					setCycle: Walk
					setMotion: MoveTo 30 200 self
				)
			)
			(2 0)
			(3 0)
			(4 0)
			(5
				(cleaningFish1 dispose:)
				(cleaningFish2 dispose:)
				(cleaningFish3 dispose:)
				(= cycles 1)
			)
			(6
				(Superfluous init: 13 0 self) ; "Oh, Adam, you did it! Because of you, we Elurians are ready to help ourselves! The new Clean-Up Committee will keep the dangerous garbage from building up around the city, and the Flesh-Eater Watch will sound the alarms whenever that horrible monster gets close."
			)
			(7
				(Superfluous say: 14 1 self)
			)
			(8
				(= cycles 1)
			)
			(9
				((ScriptID 2 1) init: 10 1 self) ; Adam, "I wish I could do more. I wish I could stop all this stuff from bothering you at all!"
			)
			(10
				(= cycles 1)
			)
			(11
				(Superfluous init: 15 0 self) ; "Well, when you return to your world, just remember that feeling and maybe you can help things get better someday."
			)
			(12
				(Superfluous say: 16 1 self)
			)
			(13
				(= cycles 10)
			)
			(14
				(gEgo setMotion: PolyPath 165 121 self)
			)
			(15
				(gEgo view: 161 loop: 0 cel: 0 setCycle: CT 4 1 self)
			)
			(16
				(goldMask dispose:)
				(gEgo setCycle: End self)
			)
			(17
				(SetScore 2 268)
				(NormalEgo)
				(gEgo get: 19 ignoreHorizon: 1) ; goldMask
				(= cycles 1)
			)
			(18
				((ScriptID 2 1) init: 11 1 self) ; Adam, "Thanks, Superfluous - I mean, Mr. Mayor."
			)
			(19
				(gSoundEffects number: 603 loop: -1 flags: 1 play:)
				(crab setCycle: Walk setMotion: PolyPath 300 210 self)
				(gDelph setCycle: Walk setMotion: PolyPath 115 110 self)
			)
			(20 0)
			(21
				(gSoundEffects flags: 1 stop:)
				(gDelph setLoop: 0 cel: 7 setCycle: 0)
				(crab dispose:)
				(= cycles 13)
			)
			(22
				(Face gEgo gDelph self)
			)
			(23
				((ScriptID 2 0) init: 1 1 self) ; Delphineus, "Whew! Eluria is safe... for the moment."
			)
			(24
				(= cycles 1)
			)
			(25
				((ScriptID 2 1) init: 12 1 self) ; Adam, "What do you mean?"
			)
			(26
				(= cycles 1)
			)
			(27
				((ScriptID 2 0) init: 2 0 self) ; Delphineus, "Well, the clean-up crews can't stop that horrid green ooze in the water - and Flesh-Eater will keep haunting us. And then there's our food supply <sigh>..."
			)
			(28
				((ScriptID 2 0) say: 4 1 self) ; Delphineus
			)
			(29
				(= cycles 1)
			)
			(30
				((ScriptID 2 1) init: 13 1 self) ; Adam, "How do we start?"
			)
			(31
				(= cycles 1)
			)
			(32
				((ScriptID 2 0) init: 3 1 self) ; Delphineus, "Remember, the Oracle wanted to see you again. Let's see what she has to say."
			)
			(33
				(gDelph setLoop: 2 setCycle: Walk setMotion: MoveTo 115 190)
				(gEgo setMotion: MoveTo 160 200 self)
			)
			(34
				(HandsOn)
				(gCurRoom newRoom: 140)
			)
		)
	)
)

(instance muralLook of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Narrator init: 28 self) ; "A mural of Greek Senators highlights the back wall of the Council Chambers."
			)
			(1
				(if (not (IsFlag 2))
					(Narrator init: 8 self) ; "The council leader's face is covered by an elaborate gold mask. It looks out of place on the painted mural."
				else
					(= cycles 1)
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance handOnMask of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (IsFlag 2)
					(gEgo setMotion: MoveTo 181 142 self)
				else
					(gEgo setMotion: MoveTo 197 89 self)
				)
			)
			(1
				(gEgo setHeading: 0 self)
			)
			(2
				(= cycles 12)
			)
			(3
				(if (and (IsFlag 2) (not (gEgo has: 19))) ; goldMask
					(cond
						((IsFlag 13)
							(Narrator init: 27 self) ; "Adam doesn't want to disturb Superfluous' mask. He might ask Superfluous to come out, though."
						)
						(
							(and
								(not (IsFlag 13))
								(== ((Inv at: 17) owner:) 226) ; spine
							)
							(Narrator init: 38 self) ; "That mask belongs to the hermit crab. If Adam wants it, he'll have to earn it."
						)
					)
				else
					(Narrator init: 14 self) ; "While out of place on the mural, the mask is firmly held down. It's not going anywhere."
				)
			)
			(4
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance potionOnSuperfl of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 2 1) init: 43 1 self) ; Adam, "I've got some healing potion here from Demeter if you need it."
			)
			(1
				(Superfluous init: 35 1 self) ; "My shell might be too small, but I'm not an invalid! Save it for something really important."
			)
		)
	)
)

(instance noExit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Narrator init: 43 self) ; "Adam can leave the Council Chambers the way he came in."
			)
			(1
				(gEgo
					setMotion: MoveTo (gEgo x:) (+ (gCurRoom horizon:) 5) self
				)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance lookInRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Narrator init: 12 self) ; "This is a Greek Tholos, a round building in which the Greek Senators met to hold council. Alas, despite the sad state of the city, there's nobody meeting here now."
			)
			(1
				(if (not (IsFlag 2))
					(Narrator init: 13 self) ; "The room seems empty."
				else
					(= cycles 1)
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance doRiddle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Narrator init: 57 self) ; "Adam thinks about the Great Senator's column challenge:"
			)
			(1
				(Print (GetMessage 5 160 36 @local3))
				(= cycles 1)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance columnList of List
	(properties)

	(method (delete)
		(super delete: &rest)
		(if (not size)
			(self dispose:)
		)
	)
)

(instance tmpList of List
	(properties)
)

(instance column1_T of Column
	(properties
		x 16
		y 21
		view 164
		cel 2
	)
)

(instance column1_M of Column
	(properties
		x 19
		y 73
		view 164
		loop 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(if (not (IsFlag 3))
					(Narrator init: 4) ; "Six beautiful columns line the Council Chambers."
					(switch cel
						(0
							(Narrator store: 19)
						)
						(1
							(Narrator store: 18)
						)
						(2
							(Narrator store: 17)
						)
					)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance column1_B of Column
	(properties
		x 17
		y 135
		view 164
		loop 2
		cel 1
	)
)

(instance column2_T of Column
	(properties
		x 52
		y 25
		view 164
		loop 3
	)
)

(instance column2_M of Column
	(properties
		x 57
		y 72
		view 164
		loop 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(if (not (IsFlag 3))
					(Narrator init: 4) ; "Six beautiful columns line the Council Chambers."
					(switch cel
						(0
							(Narrator store: 18)
						)
						(1
							(Narrator store: 17)
						)
						(2
							(Narrator store: 19)
						)
					)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance column2_B of Column
	(properties
		x 53
		y 129
		view 164
		loop 5
	)
)

(instance column3_T of Column
	(properties
		x 89
		y 39
		view 164
		loop 6
	)
)

(instance column3_M of Column
	(properties
		x 90
		y 89
		view 164
		loop 7
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(if (not (IsFlag 3))
					(Narrator init: 4) ; "Six beautiful columns line the Council Chambers."
					(switch cel
						(0
							(Narrator store: 17)
						)
						(1
							(Narrator store: 19)
						)
						(2
							(Narrator store: 18)
						)
					)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance column3_B of Column
	(properties
		x 90
		y 126
		view 164
		loop 8
		cel 2
	)
)

(instance cols of Feature
	(properties
		onMeCheck 2
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(cond
					((and (IsFlag 3) (not (IsFlag 2)))
						(gCurRoom setScript: doRiddle)
					)
					((IsFlag 2)
						(Narrator init: 32) ; "The columns on the left of the Council Chambers now match the columns on the right."
					)
					(else
						(Narrator init: 4) ; "Six beautiful columns line the Council Chambers."
					)
				)
			)
			(3 ; Do
				(if (IsFlag 3)
					(if (< ((User curEvent:) x:) 160)
						(if (IsFlag 2)
							(Narrator init: 32) ; "The columns on the left of the Council Chambers now match the columns on the right."
						else
							(Narrator init: 37) ; "The columns are now perfectly aligned. Adam doesn't want to mess with perfection."
						)
					else
						(Narrator init: 46) ; "The columns on the right side of the Council Chambers are already aligned and Adam doesn't need to move them."
					)
				else
					(Narrator init: 2) ; "The columns interest Adam, but he's not sure what to do with them."
				)
			)
			(4 ; Inventory
				(if (and (IsFlag 3) (not (IsFlag 2)))
					(Narrator init: 53) ; "That won't help Adam solve the challenge of the columns."
				else
					(Narrator init: 52) ; "Adam can't do anything with the columns, at least not now."
				)
			)
			(10 ; Recycle
				(Narrator init: 51) ; "The Council Chamber columns have great symbolic meaning and are hardly garbage bag material."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance senatorMural of Feature
	(properties
		onMeCheck 4
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(gCurRoom setScript: muralLook)
			)
			(3 ; Do
				(Narrator init: 44) ; "The mural of the Senators is interesting to look at, but Adam can't do anything with it."
			)
			(4 ; Inventory
				(Narrator init: 44) ; "The mural of the Senators is interesting to look at, but Adam can't do anything with it."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance seatedSenator of Feature
	(properties
		onMeCheck 32
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(gCurRoom setScript: senatorLook)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance senatorLook of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Narrator init: 9 self) ; "The seated Senator must have been the head of the council."
			)
			(1
				(if (not (IsFlag 2))
					(Narrator init: 10 self) ; "A gold mask looks out of place on his face."
				else
					(= cycles 1)
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance opening of Feature
	(properties
		onMeCheck 8
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 42) ; "The ceiling of the Council Chambers is open to the sea as it once was open to the night sky."
			)
			(3 ; Do
				(Narrator init: 43) ; "Adam can leave the Council Chambers the way he came in."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance floor of Feature
	(properties
		onMeCheck 16
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 41) ; "The Council Chambers floor is decorated with a large inlaid star."
			)
			(3 ; Do
				(Narrator init: 45) ; "There's nothing to do with the floor. Adam can't break dance under the ocean - not enough gravity."
			)
			(4 ; Inventory
				(Narrator init: 54) ; "Adam doesn't need to mess with the floor of the Council Chambers."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance goldMask of Prop
	(properties
		x 196
		y 71
		sightAngle 90
		view 160
		priority 1
		signal 16401
	)

	(method (init)
		(super init: &rest)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event)
		(if
			(and
				(User canInput:)
				(!= (event type:) evVERB)
				(not
					(OneOf
						(event message:)
						KEY_TAB
						KEY_CONTROL
						KEY_F1
						KEY_F2
						KEY_F5
						KEY_F7
						KEY_F9
					)
				)
				(not (event modifiers:))
			)
			(cond
				(
					(and
						(== (gTheIconBar curIcon:) (gTheIconBar at: 3))
						(== (crab script:) crabCry)
						(not (crab onMe: event))
					)
					(Narrator init: 58) ; "If Adam wants to talk to someone, he can talk to the hermit crab."
					(event claimed: 1)
				)
				(
					(and
						(== (gTheIconBar curIcon:) (gTheIconBar at: 4))
						(== (gTheIconBar curInvIcon:) (Inv at: 22)) ; hermetShell
						(== (crab script:) crabCry)
						(crab onMe: event)
					)
					(Narrator init: 60) ; "Adam might want to ask the hermit crab what he needs before he starts giving things to him."
					(event claimed: 1)
				)
				((and (== (gTheIconBar curIcon:) (gTheIconBar at: 3)) (localproc_3))
					(if (== (CueObj client:) self)
						(super handleEvent: event)
					else
						(event claimed: 1)
					)
				)
				(
					(and
						(== (gTheIconBar curIcon:) (gTheIconBar at: 4))
						(== (gTheIconBar curInvIcon:) (Inv at: 22)) ; hermetShell
						(not (self onMe: event))
						(or
							(and
								(gCast contains: crab)
								(not (crab onMe: event))
							)
							(not (gCast contains: crab))
						)
					)
					(Narrator init: 39) ; "There's no one there to give the shell to."
					(event claimed: 1)
				)
				(
					(and
						(== (gTheIconBar curIcon:) (gTheIconBar at: 4))
						(not (IsFlag 13))
						(self onMe: event)
					)
					(Narrator init: 59) ; "Adam doesn't need to mess with the hermit crab's mask right now."
					(event claimed: 1)
				)
				(else
					(super handleEvent: event)
				)
			)
		else
			(super handleEvent: event)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (IsFlag 2)
					(if (IsFlag 12)
						(Narrator init: 26) ; "On the floor is the gold mask that once covered the Great Senator's face. The mask is made of beaten gold and is fit for a king."
					else
						(Narrator init: 20) ; "Wow! The gold mask fell right off of the mural! It must have happened when the columns set into place and the room shifted!"
						(SetFlag 12)
					)
				else
					(Narrator init: 11) ; "An elaborate gold mask has been placed over the seated Senator's face."
				)
			)
			(3 ; Do
				(gCurRoom setScript: handOnMask)
			)
			(5 ; Talk
				(cond
					((IsFlag 13)
						(cond
							((not (== ((Inv at: 22) owner:) 160)) ; hermetShell
								(gCurRoom setScript: superflBeforeNewShell)
							)
							(
								(and
									(== ((Inv at: 22) owner:) 160) ; hermetShell
									(== ((Inv at: 17) owner:) 226) ; spine
								)
								(gCurRoom setScript: keepWorkingOnApts)
							)
						)
					)
					((IsFlag 2)
						(Narrator init: 49) ; "The gold mask can't talk!"
					)
				)
			)
			(10 ; Recycle
				(Narrator init: 47) ; "The gold mask looks much too important and valuable to throw away!"
			)
			(4 ; Inventory
				(switch invItem
					(22 ; hermetShell
						(if (IsFlag 2)
							(if (IsFlag 13)
								(if (== global232 4)
									(gCurRoom setScript: getInCleanShell)
								else
									(gCurRoom setScript: getInOilyShell)
								)
							else
								(Narrator init: 39) ; "There's no one there to give the shell to."
							)
						else
							(Narrator init: 50) ; "Adam doesn't see anyone there to give the shell to."
						)
					)
					(else
						(if (IsFlag 2)
							(if (IsFlag 13)
								(Narrator init: 27) ; "Adam doesn't want to disturb Superfluous' mask. He might ask Superfluous to come out, though."
							else
								(Narrator init: 38) ; "That mask belongs to the hermit crab. If Adam wants it, he'll have to earn it."
							)
						else
							(Narrator init: 16) ; "That won't get the gold mask off of the wall."
						)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance crab of Actor
	(properties
		x 194
		y 130
		view 162
		loop 2
		cel 2
		signal 16384
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (IsFlag 11)
					(Narrator init: 24) ; "Superfluous is a hermit crab. Hermit crabs move from shell to shell as they outgrow their old ones (like getting a new pair of shoes)!"
				else
					(Narrator init: 21) ; "Hmmm. It's a little hermit crab. He must have been inside the mask when it fell. He appears quite upset."
				)
			)
			(3 ; Do
				(if (IsFlag 11)
					(Narrator init: 56) ; "The Mayor is too dignified to be toyed with."
				else
					(Narrator init: 22) ; "Maybe Adam should talk to him instead - the hermit crab might not like being picked up."
				)
			)
			(5 ; Talk
				(cond
					((or (not (IsFlag 11)) (== script crabCry))
						(if (== (crab script:) crabCry)
							(crabCry dispose:)
						)
						(SetScore 2 266)
						(gCurRoom setScript: crabWhine)
					)
					((not (== ((Inv at: 22) owner:) 160)) ; hermetShell
						(gCurRoom setScript: superflBeforeNewShell)
					)
					(
						(and
							(== ((Inv at: 22) owner:) 160) ; hermetShell
							(== ((Inv at: 17) owner:) 226) ; spine
						)
						(gCurRoom setScript: keepWorkingOnApts)
					)
				)
			)
			(4 ; Inventory
				(switch invItem
					(22 ; hermetShell
						(cond
							((not (IsFlag 11))
								(Narrator init: 60) ; "Adam might want to ask the hermit crab what he needs before he starts giving things to him."
							)
							((== global232 4)
								(gCurRoom setScript: getInCleanShell)
							)
							(else
								(gCurRoom setScript: getInOilyShell)
							)
						)
					)
					(21 ; healingPotion
						(if (not (IsFlag 11))
							(Narrator init: 60) ; "Adam might want to ask the hermit crab what he needs before he starts giving things to him."
						else
							(gCurRoom setScript: potionOnSuperfl)
						)
					)
					(else
						(if (not (IsFlag 11))
							(Narrator init: 60) ; "Adam might want to ask the hermit crab what he needs before he starts giving things to him."
						else
							(Narrator init: 23) ; "That won't help the hermit crab."
						)
					)
				)
			)
			(10 ; Recycle
				(Superfluous init: 34 1) ; "I trust you're joking about throwing me away, though since you're human, I'd believe anything <sniff>."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance cleaningFish1 of Actor
	(properties
		x 234
		y 145
		view 123
		priority 1
		signal 18448
	)
)

(instance cleaningFish2 of Actor
	(properties
		x 181
		y 167
		view 123
		loop 2
		priority 1
		signal 18448
	)
)

(instance cleaningFish3 of Actor
	(properties
		x 104
		y 152
		view 123
		loop 4
		priority 1
		signal 18448
	)
)

(instance INSET of View
	(properties
		x 72
		y 47
		view 163
		priority 1
		signal 17
	)
)

(instance Superfluous of Talker
	(properties
		nsTop 16
		nsLeft 10
		view 166
		viewInPrint 1
		charNum 5
		keepWindow 1
	)

	(method (init)
		(super init: sBust sEyes sMouth &rest)
	)
)

(instance sBust of Prop
	(properties
		view 166
		cel 1
	)
)

(instance sEyes of Prop
	(properties
		nsTop 2
		view 166
		loop 2
		cycleSpeed 30
	)
)

(instance sMouth of Prop
	(properties
		view 166
		loop 1
		cycleSpeed 10
	)
)

