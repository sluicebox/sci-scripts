;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 96)
(include sci.sh)
(use Main)
(use Teller)
(use n814)
(use Talker)
(use MCyc)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use DPath)
(use Rev)
(use Chase)
(use Sound)
(use Jump)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm96 0
	finalExit 1
	doorFall 2
	rollOut 3
	yorickTalker 4
	yorick 5
	chain 6
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	[local9 22] = [0 0 0 0 0 0 0 0 160 164 160 156 155 155 157 14 15 9 12 13 10 8]
	local31
	[local32 3] = [-13 -7 11]
	[local35 3] = [-1 -10 -11]
	[local38 3] = [8 9 9]
	[local41 5] = [-11 -8 -3 4 7]
	[local46 5] = [-26 -26 -26 -26 -26]
	[local51 5] = [-1 1 2 3 1]
	[local56 21] = [1 0 161 69 1 1 161 66 1 2 160 62 1 3 159 59 1 4 159 59 -32768]
	local77
	local78
	local79
	[local80 14] = [0 -11 -27 -24 -30 999 0 34 20 32 26 29 37 999]
	[local94 3] = [0 -23 999]
	[local97 3] = [0 28 999]
	[local100 3] = [0 25 999]
	[local103 7] = [0 21 22 33 31 19 999]
	[local110 11]
	[local121 7] = [0 -11 -27 -24 -30 -23 999]
)

(procedure (localproc_0) ; UNUSED
	(if (IsFlag 259)
		(gMessager say: 9 0 18) ; "It looks like the talking is over."
	else
		(gMessager say: 9 0 16) ; "No more talking, my friend. Let's have fun!"
	)
)

(procedure (localproc_1)
	(switch (++ global111)
		(1
			(gMessager say: 7 0 10 1) ; "You feel disoriented."
		)
		(2
			(gMessager say: 7 0 10 2) ; "How does he DO this?"
		)
		(3
			(gMessager say: 7 0 10 3) ; "There's an ECHO IN HERE... Echo In Here... echo in here..."
		)
		(4
			(gMessager say: 7 0 10 4) ; "M. C. Escher would LOVE this place."
		)
		(5
			(gMessager say: 7 0 10 5) ; "OK, enough fooling around!"
		)
		(6
			(gMessager say: 7 0 10 6) ; "This is getting old!"
		)
		(7
			(gMessager say: 7 0 10 7) ; "A person COULD get used to this."
		)
	)
)

(procedure (localproc_2)
	(cond
		(
			(and
				(not (gEgo script:))
				(>= (gEgo x:) 2)
				(>= (gEgo y:) 99)
				(<= (gEgo x:) 16)
				(<= (gEgo y:) 111)
			)
			(if local6
				(= local5 1)
			)
			(SetFlag 263)
			(gEgo setScript: goTo12)
		)
		(
			(and
				(not (IsFlag 260))
				(not (gEgo script:))
				(>= (gEgo x:) 295)
				(>= (gEgo y:) 102)
			)
			(SetFlag 263)
			(gEgo setScript: goTo2)
		)
		(
			(and
				(not (gEgo script:))
				(>= (gEgo x:) 9)
				(>= (gEgo y:) 45)
				(<= (gEgo x:) 42)
				(<= (gEgo y:) 51)
			)
			(SetFlag 263)
			(gEgo setScript: goTo15)
		)
	)
)

(instance isScript of Code
	(properties)

	(method (doit param1)
		(if (param1 respondsTo: #script)
			(param1 script:)
		)
	)
)

(instance rm96 of Rm
	(properties
		noun 7
		picture 96
		style 2
	)

	(method (dispose)
		(= global425 0)
		(gNarrator y: 14)
		(SetFlag 86)
		(= global111 0)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(super dispose:)
		(DisposeScript 964)
		(DisposeScript 942)
		(DisposeScript 98)
		(= global425 0)
	)

	(method (init)
		(|= global425 $0006)
		(gNarrator y: 21)
		(= [local110 0] @local80)
		(= [local110 1] @local94)
		(= [local110 2] @local97)
		(= [local110 3] @local100)
		(= [local110 4] @local103)
		(= [local110 5] @local80)
		(= [local110 6] 999)
		(LoadMany rsSCRIPT 969 991 972)
		MCyc
		DPath
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 275 122 283 114 298 116 303 129 268 129
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 14 127 14 115 45 115 43 127
					yourself:
				)
				((Polygon new:) type: PBarredAccess init: 4 113 4 146 0 146 0 113 yourself:)
				((Polygon new:)
					type: PBarredAccess
					init: 319 121 313 121 313 106 319 106
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 82 0 64 19 64 19 97 0 97
					yourself:
				)
		)
		(super init: &rest)
		(gLongSong stop:)
		(SolvePuzzle 707 8)
		(gMouseDownHandler add: self)
		(gKeyDownHandler add: self)
		(= local4 (= local3 300))
		(roomMusic init: play:)
		(= global111 0)
		(yorickTeller init: yorick @local80 @local110 @local121)
		(yorick init: setPri: 3 actions: yorickTeller stopUpd:)
		((ScriptID 98 31) init: setOnMeCheck: 1 256) ; theHandle
		((ScriptID 98 1) init: setOnMeCheck: 26505) ; Dor1
		((ScriptID 98 2) init: setOnMeCheck: 26505) ; Dor2
		((ScriptID 98 3) init: setOnMeCheck: 26505) ; Dor6
		((ScriptID 98 5) init: setOnMeCheck: 26505) ; lttleButton
		(littleSign init: setOnMeCheck: 26505)
		((ScriptID 98 33) init: setOnMeCheck: 26505) ; Dor15
		((ScriptID 98 34) init: setOnMeCheck: 26505) ; Chain1
		((ScriptID 98 35) init: setOnMeCheck: 26505) ; Chain2
		(unknown_96_2 init:)
		(if (== gHowFast 0)
			((ScriptID 98 25) init: setPri: 14 addToPic:) ; theGlobe
		else
			((ScriptID 98 25) init: setPri: 14 cycleSpeed: 6 setCycle: Fwd) ; theGlobe
		)
		((ScriptID 98 32) setPri: 7 init:) ; theHead
		((ScriptID 98 13) ignoreActors: init:) ; theTrap1
		((ScriptID 98 14) ignoreActors: setPri: 11 init: stopUpd:) ; theTrap2
		((ScriptID 98 15) ignoreActors: init: setPri: 8) ; theTrap3
		(trap4 ignoreActors: setPri: 5 init:)
		(chain ignoreActors: init:)
		(door11 ignoreActors: cycleSpeed: 6 init:)
		((ScriptID 98 20) ignoreActors: cycleSpeed: 6 init:) ; dor7
		(door3 ignoreActors: cycleSpeed: 6 init:)
		((ScriptID 98 16) ignoreActors: cycleSpeed: 6 setPri: 11 init: stopUpd:) ; theFrontTrap
		((ScriptID 98 24) ignoreActors: cycleSpeed: 6 init:) ; dor12
		(door13 ignoreActors: cycleSpeed: 6 init: stopUpd:)
		((ScriptID 98 21) ignoreActors: cycleSpeed: 6 init:) ; arow
		(EgoGait 0 0) ; walking
		(NormalEgo)
		(gEgo posn: 89 186 init: setScript: talksALot)
	)

	(method (handleEvent event)
		(if (== (gEgo script:) rollOut)
			(event claimed: 1)
			((ScriptID 98 31) handleEvent: event) ; theHandle
		else
			(super handleEvent: event)
		)
	)

	(method (doit)
		(cond
			(
				(and
					(!= (gEgo onControl: 1) 1)
					(not (IsFlag 257))
					(not (IsFlag 260))
					(not (IsFlag 271))
				)
				(switch (gEgo onControl: 1)
					(512
						(SetFlag 256)
						(SetFlag 257)
						(if local6
							(= local5 1)
						)
						(gEgo setPri: 14)
						((ScriptID 98 14) setScript: trapFall) ; theTrap2
					)
					(64
						(SetFlag 256)
						(SetFlag 257)
						(if local6
							(= local5 1)
						)
						(gEgo setPri: (+ (gEgo priority:) 1))
						((ScriptID 98 15) setScript: trapFall) ; theTrap3
					)
					(128
						(SetFlag 256)
						(SetFlag 257)
						(if local6
							(= local5 1)
						)
						((ScriptID 98 15) setScript: trapFall) ; theTrap3
					)
					(2048
						(SetFlag 256)
						(SetFlag 257)
						(if local6
							(= local5 1)
						)
						(trap4 setScript: trapFall)
					)
					(4
						(SetFlag 257)
						(if local6
							(= local5 1)
						)
						(if (gEgo inRect: 15 97 61 106)
							(SetFlag 256)
							((ScriptID 98 13) setScript: trapFall 0 0) ; theTrap1
						else
							(gEgo setScript: fallDownscreen)
						)
					)
					(2
						(SetFlag 257)
						(if local6
							(= local5 1)
						)
						(if (gEgo inRect: 42 91 90 105)
							(SetFlag 256)
							((ScriptID 98 13) setScript: trapFall 0 1) ; theTrap1
						else
							(gEgo setScript: fallUpscreen)
						)
					)
					(16
						(SetFlag 257)
						(SetFlag 258)
						(if local6
							(= local5 1)
						)
						(if (gEgo inRect: 66 95 84 105)
							(SetFlag 256)
							((ScriptID 98 13) setScript: trapFall 0 2) ; theTrap1
						else
							(gEgo setScript: fallSideways)
						)
					)
					(8
						(SetFlag 257)
						(if local6
							(= local5 1)
						)
						(cond
							((and (not (IsFlag 264)) (< (gEgo y:) 86))
								(gEgo setScript: fallDownscreen)
							)
							((> (gEgo y:) 135)
								(gEgo setScript: fallSideways 0 1)
							)
							((> (gEgo y:) 107)
								(gEgo setScript: fallSideways)
							)
							((> (gEgo y:) 86)
								(gEgo setScript: fallDownscreen)
							)
							(else
								(ClearFlag 257)
							)
						)
					)
					(32
						(SetFlag 257)
						(if (not (IsFlag 264))
							(SetFlag 256)
							(if local6
								(= local5 1)
							)
							((ScriptID 98 13) setScript: trapFall 0 2) ; theTrap1
						else
							(ClearFlag 257)
						)
					)
					(16384
						(if (and (not (IsFlag 263)) (not (IsFlag 257)))
							(localproc_2)
						)
					)
					(else
						(ClearFlag 257)
					)
				)
			)
			((gEgo inRect: 269 130 302 146)
				(gEgo priority: 14)
			)
		)
		(super doit: &rest)
	)

	(method (cue)
		(= local8 1)
		((ScriptID 98 21) setScript: takeADive) ; arow
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 51 50 77 78 80 81 82 79) ; openSpell, detectMagicSpell, triggerSpell or Pickup Inventory, dazzleSpell, calmSpell, flameDartSpell, fetchSpell, zapSpell
			(if (and (IsObject yorick) (not local8))
				(gMessager say: 7 81 11 1 self) ; ""ME" sees you preparing your spell and..."
				(return 1)
			else
				(unknown_96_2 setScript: unknown_96_3)
				(return 1)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance unknown_96_2 of Prop
	(properties
		x 500
		y 500
		view 0
	)
)

(instance unknown_96_3 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(gMessager say: 7 81 1 1 self) ; "Your magic has no effect. It must be something about this room."
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance littleSign of Feature
	(properties
		noun 6
		nsTop 35
		nsLeft 243
		nsBottom 48
		nsRight 258
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 51 50 77 78 80 81 82 79) ; openSpell, detectMagicSpell, triggerSpell or Pickup Inventory, dazzleSpell, calmSpell, flameDartSpell, fetchSpell, zapSpell
			(gCurRoom doVerb: theVerb &rest)
			(return 1)
		)
		(return
			(switch theVerb
				(1 ; Look
					(gMessager say: 6 1) ; "Engraved on the button are the words: "PUSH ME"."
				)
				(4 ; Do
					(if
						(and
							(== (gEgo onControl: 1) 256)
							(> (gEgo x:) 100)
						)
						(door13 setScript: happyFace)
					else
						(gMessager say: 6 4 1) ; "It looks a button, but you'll have to be closer to push it."
					)
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance chain of View
	(properties
		x 65
		y 1
		noun 1
		view 290
		loop 7
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 51 50 77 78 80 81 82 79) ; openSpell, detectMagicSpell, triggerSpell or Pickup Inventory, dazzleSpell, calmSpell, flameDartSpell, fetchSpell, zapSpell
			(gCurRoom doVerb: theVerb &rest)
			(return 1)
		)
		(return
			(switch theVerb
				(4 ; Do
					(if (== (gEgo onControl: 1) 8192)
						(= local6 1)
						(= local5 1000)
						(door11 setScript: (ScriptID 98 36)) ; PullChain
					else
						(gMessager say: 1 4) ; "You can't do that from where you're standing."
					)
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance trap4 of Prop
	(properties
		x 159
		y 76
		noun 8
		view 296
		loop 3
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 51 50 77 78 80 81 82 79) ; openSpell, detectMagicSpell, triggerSpell or Pickup Inventory, dazzleSpell, calmSpell, flameDartSpell, fetchSpell, zapSpell
			(gCurRoom doVerb: theVerb &rest)
			(return 1)
		else
			(super doVerb: theVerb &rest)
		)
	)

	(method (doit)
		(if (and (IsFlag 270) (not script))
			(ClearFlag 270)
			(self setScript: fallDownscreen)
		)
		(super doit:)
	)
)

(instance door11 of Prop
	(properties
		x 214
		y 66
		noun 2
		view 96
	)

	(method (doit)
		(cond
			((> local5 1)
				(if (== (gEgo onControl: 1) 1024)
					(= local5 0)
					(= local6 0)
					(self setScript: goTo6)
				else
					(-- local5)
				)
			)
			((== local5 1)
				(= local5 0)
				(= local6 0)
				(self setCycle: Beg)
			)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 51 50 77 78 80 81 82 79) ; openSpell, detectMagicSpell, triggerSpell or Pickup Inventory, dazzleSpell, calmSpell, flameDartSpell, fetchSpell, zapSpell
			(gCurRoom doVerb: theVerb &rest)
			(return 1)
		)
		(return
			(switch theVerb
				(4 ; Do
					(if (== (gEgo onControl: 1) 1024)
						(door11 setScript: brickWall)
					else
						(gMessager say: 2 4 1) ; "You're not close enough."
					)
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance door3 of Prop
	(properties
		x 59
		y 86
		noun 4
		view 290
		loop 4
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 51 50 77 78 80 81 82 79) ; openSpell, detectMagicSpell, triggerSpell or Pickup Inventory, dazzleSpell, calmSpell, flameDartSpell, fetchSpell, zapSpell
			(gCurRoom doVerb: theVerb &rest)
			(return 1)
		)
		(return
			(switch theVerb
				(4 ; Do
					(if (gEgo inRect: 49 86 83 91)
						(SetFlag 257)
						(door3 setScript: knockOut)
					else
						(gMessager say: 4 4 1) ; "Get closer."
					)
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance door13 of Prop
	(properties
		x 260
		y 5
		noun 3
		view 290
		loop 5
	)

	(method (doit)
		(if (IsFlag 269)
			(ClearFlag 269)
			(SetFlag 257)
			(gEgo setPri: (+ (gEgo priority:) 1) setScript: fallSideways)
		)
		(super doit:)
	)
)

(instance yorick of Prop
	(properties
		x 161
		y 69
		noun 9
		view 297
		loop 1
	)

	(method (init)
		(super init:)
	)

	(method (doit)
		(cond
			((> local4 1)
				(-- local4)
			)
			((== local4 1)
				(= local4 local3)
				(if
					(and
						(IsFlag 267)
						(not (gCast firstTrue: #perform isScript))
						(not (IsFlag 263))
						(not global102)
						(< (gEgo x:) 295)
						(!= (gEgo onControl: 1) 16384)
						(!= (gEgo onControl: 1) 8192)
						(not local2)
						(> (gEgo y:) 83)
					)
					(SetFlag 265)
					(self setScript: throwIt)
				)
			)
		)
		(if (IsFlag 259)
			(cond
				(
					(<
						(= local1
							(GetAngle
								(yorick x:)
								(yorick y:)
								(gEgo x:)
								(gEgo y:)
							)
						)
						145
					)
					(if (!= (yorick cel:) 2)
						(yorick setCel: 2)
					)
				)
				((< local1 215)
					(if (!= (yorick cel:) 1)
						(yorick setCel: 1)
					)
				)
				((!= (yorick cel:) 0)
					(yorick setCel: 0)
				)
			)
		)
		(cond
			((and (IsFlag 268) (not local7) (not local8))
				(= local7 1)
				((ScriptID 98 32) dispose:) ; theHead
				(self view: 298 setLoop: 0 setCel: 0)
			)
			((and local7 (gEgo mover:))
				(NormalEgo)
				(= local7 0)
				(= local8 1)
				((ScriptID 98 21) setScript: takeADive) ; arow
			)
		)
		(super doit:)
	)
)

(instance yorickTeller of Teller
	(properties)

	(method (showDialog &tmp temp0)
		(if (== (= temp0 (super showDialog:)) -23)
			(SolvePuzzle 709 8)
		)
		(return temp0)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 51 50 77 78 80 81 82 79) ; openSpell, detectMagicSpell, triggerSpell or Pickup Inventory, dazzleSpell, calmSpell, flameDartSpell, fetchSpell, zapSpell
			(gCurRoom doVerb: theVerb &rest)
			(return 1)
		)
		(switch theVerb
			(2 ; Talk
				(SolvePuzzle 708 2)
				(super doVerb: theVerb &rest)
			)
			(4 ; Do
				(gMessager say: 9 4) ; "Take yourself there."
				(return 1)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance fallUpscreen of Script
	(properties)

	(method (dispose)
		(SetFlag 267)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 1)
			)
			(1
				(if (not (IsFlag 259))
					((ScriptID 98 32) setCel: 3) ; theHead
					(yorick setLoop: 3 cel: 0 cycleSpeed: 8 setCycle: Fwd)
				)
				(gEgo view: 537 setLoop: 0 cel: 0 setCycle: CT 2 1 self)
				(if (and register (> (gEgo x:) 75))
					(gEgo x: (- (gEgo x:) 20))
				)
			)
			(2
				(gEgo
					setPri:
						(cond
							((< (gEgo y:) 107) 6)
							((< (gEgo y:) 135) 10)
							(else 12)
						)
				)
				(gEgo
					yStep: 15
					illegalBits: 0
					moveSpeed: 0
					setMotion: MoveTo (gEgo x:) 250 self
				)
			)
			(3
				(if (not (TakeDamage 5))
					(EgoDead 114 115 2 5 517) ; "You're mad as heck, and you're not going to take it anymore. As a matter of fact, you CAN'T take it anymore. Restore your strength and health and try again."
				else
					(ClearFlag 258)
					(ClearFlag 257)
					(SetFlag 260)
					(if (IsFlag 256)
						(ClearFlag 256)
						(gEgo setScript: rollOut)
						(if (or (== client trap4) (== client (ScriptID 98 13))) ; theTrap1
							(client setPri: (+ (client priority:) 1))
						)
						(client setCel: 0 setScript: 0)
					else
						(gEgo setScript: rollOut)
					)
				)
			)
		)
	)
)

(instance fallDownscreen of Script
	(properties)

	(method (dispose)
		(SetFlag 267)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 1)
			)
			(1
				(if (not (IsFlag 264))
					((ScriptID 98 20) setPri: 1) ; dor7
				)
				(if (and (< (gEgo y:) 110) (!= client trap4))
					(trap4 setPri: 4)
					(gEgo setPri: (- (gEgo priority:) 1))
				)
				(if (not (IsFlag 259))
					((ScriptID 98 32) setCel: 3) ; theHead
					(yorick setLoop: 3 cel: 0 cycleSpeed: 8 setCycle: Fwd)
				)
				(gEgo view: 536 setLoop: 0 cel: 0 setCycle: CT 2 1 self)
			)
			(2
				(gEgo
					setPri:
						(cond
							((< (gEgo y:) 82) 3)
							((< (gEgo y:) 107) 6)
							((< (gEgo y:) 135) 10)
							(else 12)
						)
				)
				(if (< (gEgo y:) 110)
					(gEgo setPri: (- (gEgo priority:) 2))
				)
				(gEgo
					yStep: 12
					illegalBits: 0
					setCycle: End
					setMotion: MoveTo (gEgo x:) 220 self
				)
			)
			(3
				((ScriptID 98 20) setPri: -1) ; dor7
				(if (not (TakeDamage 5))
					(EgoDead 114 115 2 5 517) ; "You're mad as heck, and you're not going to take it anymore. As a matter of fact, you CAN'T take it anymore. Restore your strength and health and try again."
				else
					(ClearFlag 258)
					(ClearFlag 257)
					(SetFlag 260)
					(if (IsFlag 256)
						(ClearFlag 256)
						(gEgo setScript: rollOut)
						(client
							setCel: 0
							setPri: (+ (client priority:) 1)
							setScript: 0
						)
					else
						(trap4 setPri: 5)
						(gEgo setPri: (+ (gEgo priority:) 2))
						(gEgo setScript: rollOut)
					)
				)
			)
		)
	)
)

(instance rollOut of Script
	(properties)

	(method (dispose)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOn)
				(gTheIconBar disable: 1 2 4 3 6 5 7 8)
				(= local79 global100)
				(gGame setCursor: 942 1)
				(= cycles 1)
			)
			(1
				(if (IsFlag 264)
					(ClearFlag 264)
					((ScriptID 98 20) setCycle: Beg) ; dor7
				)
				(if (not (IsFlag 259))
					(yorick setLoop: 3 setCycle: Fwd)
				)
				(if (trap4 cel:)
					(trap4 setCycle: Beg)
				)
				(door11 setCycle: End self)
			)
			(2
				(gEgo edgeHit: EDGE_NONE)
				(gEgo
					view: 296
					setLoop: 4
					setPri: 3
					illegalBits: 0
					posn: 195 55
					cycleSpeed: 4
					moveSpeed: 4
					setStep: 6 4
					setCycle: Fwd
					setMotion: MoveTo 258 88 self
				)
			)
			(3
				(if (IsFlag 264)
					(ClearFlag 264)
					((ScriptID 98 19) dispose:) ; bhindDoor7
				)
				(if (not (IsFlag 259))
					(yorick setLoop: 3)
				)
				(gEgo setPri: 7 setMotion: MoveTo 312 109 self)
			)
			(4
				(gEgo setPri: 14 setMotion: MoveTo 318 116 self)
				((ScriptID 98 14) setCel: 1) ; theTrap2
				((ScriptID 98 16) setCel: 1) ; theFrontTrap
				(HandsOff)
				(door11 setCycle: Beg)
			)
			(5
				(if (not (IsFlag 259))
					(yorick setLoop: 3)
				)
				((ScriptID 98 14) setCel: 2) ; theTrap2
				((ScriptID 98 16) setCel: 2) ; theFrontTrap
				(gEgo setCycle: Fwd yStep: 20 setMotion: MoveTo 316 200 self)
			)
			(6
				(if (not (TakeDamage 5))
					(EgoDead 114 115 2 5 517) ; "You're mad as heck, and you're not going to take it anymore. As a matter of fact, you CAN'T take it anymore. Restore your strength and health and try again."
				else
					((ScriptID 98 14) setCel: 0) ; theTrap2
					((ScriptID 98 16) setCel: 0) ; theFrontTrap
					(self changeState: 0)
				)
			)
			(7
				(gEgo
					setLoop: 5
					cel: 0
					setStep: 3 2
					setPri: 9
					posn: (+ (gEgo x:) 8) (+ (gEgo y:) 14)
					setMotion: MoveTo 309 114 self
					cycleSpeed: 6
					setCycle: CT 2 1
				)
				(door11 setCycle: Beg)
			)
			(8
				(gEgo setPri: 10 setCel: 3)
				(= ticks 30)
			)
			(9
				(gEgo setCel: 4)
				(if (not (IsFlag 259))
					(yorick setLoop: 1 cel: 0 setCycle: 0 stopUpd:)
					((ScriptID 98 32) setCel: 1) ; theHead
				)
				(= ticks 30)
			)
			(10
				(gEgo x: (- (gEgo x:) 4))
				(HandsOn)
				(gEgo setLoop: 1 illegalBits: -32768)
				(NormalEgo)
				(ClearFlag 260)
				(gGame setSpeed: local79)
				(trap4 setPri: 5)
				(self dispose:)
			)
		)
	)
)

(instance happyFace of Script
	(properties)

	(method (dispose)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local78 1)
				(proc814_32 1)
				(HandsOff)
				(gEgo setMotion: MoveTo 243 91 self)
			)
			(1
				(Face gEgo (ScriptID 98 5)) ; lttleButton
				(door13 setCycle: End self)
				((ScriptID 98 30) ; ball2
					illegalBits: 0
					ignoreActors:
					posn: 258 5
					setCycle: Fwd
					init:
				)
			)
			(2
				((ScriptID 98 30) setMotion: JumpTo 243 31 self) ; ball2
			)
			(3
				(gEgo view: 296 setLoop: 6 setCel: 0 setCycle: End self)
				((ScriptID 98 30) setMotion: JumpTo 220 200 self) ; ball2
				(door13 setCycle: Beg)
			)
			(4
				(SetFlag 269)
				(SetFlag 258)
			)
			(5
				((ScriptID 98 30) dispose:) ; ball2
				(= ticks 30)
			)
			(6
				(if (not (IsFlag 259))
					((ScriptID 98 32) setCel: 3) ; theHead
					(yorick setLoop: 3 cel: 0 cycleSpeed: 8 setCycle: Fwd)
				)
				(client setScript: 0)
			)
		)
	)
)

(instance goTo2 of Script
	(properties)

	(method (dispose)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setMotion: PolyPath (+ (gEgo x:) 25) (gEgo y:) self
				)
			)
			(1
				(localproc_1)
				(= cycles 10)
			)
			(2
				(gEgo
					setPri: 1
					illegalBits: 0
					posn: 33 48
					setMotion: MoveTo 55 50 self
				)
			)
			(3
				(HandsOn)
				(gEgo illegalBits: -32768)
				(ClearFlag 263)
				(client setScript: 0)
			)
		)
	)
)

(instance goTo6 of Script
	(properties)

	(method (dispose)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					illegalBits: 0
					setLoop: 3
					setMotion: MoveTo 198 64 self
				)
			)
			(1
				(door11 setCycle: Beg self)
			)
			(2
				(localproc_1)
				(= ticks 60)
			)
			(3
				(NormalEgo)
				(gEgo posn: 84 73 setMotion: MoveTo 116 73 self)
			)
			(4
				(HandsOn)
				(User canInput: 1)
				(ClearFlag 263)
				(client setScript: 0)
			)
		)
	)
)

(instance goTo12 of Script
	(properties)

	(method (dispose)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local79 global100)
				(gEgo
					illegalBits: 0
					setMotion: MoveTo (- (gEgo x:) 25) (gEgo y:) self
				)
			)
			(1
				(localproc_1)
				(gEgo
					view: 296
					setLoop: 8
					cel: 0
					posn: 290 91
					cycleSpeed: 6
					setPri: 3
					moveSpeed: 6
				)
				((ScriptID 98 24) setCycle: End self) ; dor12
			)
			(2
				(gEgo setCycle: Fwd setMotion: MoveTo 238 91 self)
			)
			(3
				(gEgo setLoop: 9 setCel: 0 posn: 240 91)
				(= ticks 30)
			)
			(4
				(gEgo setLoop: 1 setPri: -1)
				(NormalEgo)
				((ScriptID 98 24) setCycle: Beg self) ; dor12
			)
			(5
				(HandsOn)
				(SetFlag 267)
				(ClearFlag 263)
				(gGame setSpeed: local79)
				(client setScript: 0)
			)
		)
	)
)

(instance goTo15 of Script
	(properties)

	(method (dispose)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					illegalBits: 0
					setMotion:
						MoveTo
						(- (gEgo x:) 10)
						(- (gEgo y:) 5)
						self
				)
			)
			(1
				(localproc_1)
				(gEgo
					posn: 325 107
					setPri: -1
					setMotion: MoveTo 300 107 self
				)
			)
			(2
				(if (IsFlag 259)
					(SetFlag 267)
				)
				(NormalEgo)
				(HandsOn)
				(ClearFlag 263)
				(client setScript: 0)
			)
		)
	)
)

(instance poof of Prop
	(properties
		view 297
		loop 7
	)
)

(instance thingThrown of Actor
	(properties
		z 30
		yStep 10
		view 297
		xStep 15
	)
)

(instance throwIt of Script
	(properties)

	(method (dispose)
		(super dispose:)
	)

	(method (doit)
		(if
			(and
				(not local31)
				(or
					(IsFlag 257)
					(== (gEgo onControl: 1) 16384)
					(door11 script:)
				)
			)
			(= local31 1)
			(= cycles 0)
			(self changeState: 7)
		)
		(super doit:)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= temp0 ((gTheIconBar curIcon:) cursor:))
				(HandsOff)
				(gEgo setCycle: 0 setMotion: 0)
				(SetFlag 271)
				(User canInput: 0)
				(if (IsFlag 259)
					(switch (yorick cel:)
						(0
							(poof
								posn:
									(+ (yorick x:) [local41 0])
									(+ (yorick y:) [local46 0])
							)
						)
						(1
							(poof
								posn:
									(+ (yorick x:) [local41 1])
									(+ (yorick y:) [local46 1])
							)
						)
						(2
							(poof
								posn:
									(+ (yorick x:) [local41 2])
									(+ (yorick y:) [local46 2])
							)
						)
						(3
							(poof
								posn:
									(+ (yorick x:) [local41 3])
									(+ (yorick y:) [local46 3])
							)
						)
						(4
							(poof
								posn:
									(+ (yorick x:) [local41 4])
									(+ (yorick y:) [local46 4])
							)
						)
					)
				else
					(yorick setLoop: 2 setCel: ((ScriptID 98 32) cel:) stopUpd:) ; theHead
					((ScriptID 98 32) setCel: 3) ; theHead
					(switch (yorick cel:)
						(0
							(poof
								posn:
									(+ (yorick x:) [local32 0])
									(+ (yorick y:) [local35 0])
							)
						)
						(1
							(poof
								posn:
									(+ (yorick x:) [local32 1])
									(+ (yorick y:) [local35 1])
							)
						)
						(2
							(poof
								posn:
									(+ (yorick x:) [local32 2])
									(+ (yorick y:) [local35 2])
							)
						)
					)
				)
				(poof
					setPri: (+ (yorick priority:) 2)
					ignoreActors:
					init:
					setCycle: CT 3 1 self
				)
			)
			(1
				(if (IsFlag 259)
					(switch (yorick cel:)
						(0
							(thingThrown
								posn:
									(+ (yorick x:) [local41 0])
									(+ (yorick y:) [local51 0])
							)
						)
						(1
							(thingThrown
								posn:
									(+ (yorick x:) [local41 1])
									(+ (yorick y:) [local51 1])
							)
						)
						(2
							(thingThrown
								posn:
									(+ (yorick x:) [local41 2])
									(+ (yorick y:) [local51 2])
							)
						)
						(3
							(thingThrown
								posn:
									(+ (yorick x:) [local41 3])
									(+ (yorick y:) [local51 3])
							)
						)
						(4
							(thingThrown
								posn:
									(+ (yorick x:) [local41 4])
									(+ (yorick y:) [local51 4])
							)
						)
					)
				else
					(switch (yorick cel:)
						(0
							(thingThrown
								posn:
									(+ (yorick x:) [local32 0])
									(+ (yorick y:) [local38 0])
							)
						)
						(1
							(thingThrown
								posn:
									(+ (yorick x:) [local32 1])
									(+ (yorick y:) [local38 1])
							)
						)
						(2
							(thingThrown
								posn:
									(+ (yorick x:) [local32 2])
									(+ (yorick y:) [local38 2])
							)
						)
					)
				)
				(thingThrown
					setLoop: 8
					setCel: (Random 0 5)
					setPri: (gEgo priority:)
					ignoreActors:
					illegalBits: 0
					init:
					setMotion: Chase gEgo 20 self
				)
				(poof setCycle: End)
			)
			(2
				(HandsOff)
				(thingThrown
					setPri: (- (gEgo priority:) 1)
					setMotion: Chase gEgo 0 self
				)
			)
			(3
				(SetFlag 260)
				(gEgo
					view: 296
					setMotion: 0
					setCycle: 0
					loop:
						(cond
							((mod (gEgo loop:) 2) 7)
							((== (gEgo loop:) 6) 7)
							(else 6)
						)
					setCel: 0
				)
				(if (== (gEgo loop:) 6)
					(gEgo setCycle: End)
				else
					(gEgo setCycle: CT 1 1)
				)
				(TakeDamage 1)
				(cond
					((> (gEgo x:) (yorick x:))
						(if (and (< (gEgo x:) 313) (< (gEgo y:) 186))
							(gEgo
								posn: (+ (gEgo x:) 6) (+ (gEgo y:) 3)
							)
						)
					)
					((and (> (gEgo x:) 6) (< (gEgo y:) 186))
						(gEgo posn: (- (gEgo x:) 6) (+ (gEgo y:) 3))
					)
				)
				(if (not (IsFlag 259))
					((ScriptID 98 32) setCel: 1) ; theHead
					(yorick setLoop: 1 setCel: 0 stopUpd:)
				)
				(poof dispose:)
				(= cycles 1)
			)
			(4
				(if (> (gEgo x:) (yorick x:))
					(thingThrown
						setPri:
							(cond
								((> (gEgo y:) 138) 11)
								((> (gEgo y:) 115) 8)
								(else 7)
							)
						setMotion:
							JumpTo
							(- (gEgo x:) (Random 30 60))
							210
							self
					)
				else
					(thingThrown
						setMotion:
							JumpTo
							(+ (gEgo x:) (Random 30 60))
							210
							self
					)
				)
			)
			(5
				(thingThrown dispose:)
				(HandsOn)
				(ClearFlag 260)
				(NormalEgo)
				(Face gEgo yorick)
				(User canInput: 1)
				(= cycles 2)
			)
			(6
				(if (and (not (IsFlag 259)) (IsFlag 257))
					((ScriptID 98 32) setCel: 3) ; theHead
					(yorick setLoop: 3 cel: 0 cycleSpeed: 8 setCycle: Fwd)
				)
				(poof dispose:)
				(thingThrown dispose:)
				(User canInput: 1)
				(= cycles 2)
			)
			(7
				(HandsOn)
				(gGame setCursor: temp0) ; UNINIT
				(ClearFlag 271)
				(client setScript: 0)
			)
		)
	)
)

(instance talksALot of Script
	(properties)

	(method (dispose)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 1)
			)
			(1
				(gEgo illegalBits: 0 setMotion: MoveTo 80 189 self)
			)
			(2
				(gEgo loop: 2)
				(= cycles 2)
			)
			(3
				(gMessager say: 7 0 7 0 self) ; "You bar the door behind you."
			)
			(4
				(Face gEgo yorick self)
			)
			(5
				(= ticks 60)
			)
			(6
				(gEgo illegalBits: -32768)
				(gMessager say: 7 0 8 0 self) ; "You behold a most fascinating place."
			)
			(7
				(yorick stopUpd:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance knockOut of Script
	(properties)

	(method (dispose)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc814_32 1)
				(HandsOff)
				(gEgo setLoop: 1 setCycle: Rev setMotion: MoveTo 83 91 self)
			)
			(1
				(gEgo setCycle: 0)
				(door3 setCycle: CT 6 1 self)
			)
			(2
				(= ticks 12)
			)
			(3
				(gEgo view: 296 setLoop: 7 setCel: 0)
				(door3 setCel: 7)
				(= ticks 12)
			)
			(4
				(gEgo setCel: 1 posn: 94 91)
				(door3 setCel: 8)
				(= ticks 12)
			)
			(5
				(door3 setCycle: End)
				(gEgo setCel: 2)
				(if (not (IsFlag 259))
					((ScriptID 98 32) setCel: 3) ; theHead
					(yorick setLoop: 3 cel: 0 cycleSpeed: 8 setCycle: Fwd)
				)
				(= ticks 12)
			)
			(6
				(gEgo
					setCel: 3
					setPri: 6
					moveSpeed: 0
					setStep: 10 10
					illegalBits: 0
					setMotion: DPath 135 109 139 178 self
				)
			)
			(7
				(door3 setCel: 0)
				(if (not (TakeDamage 5))
					(EgoDead 114 115 2 5 517) ; "You're mad as heck, and you're not going to take it anymore. As a matter of fact, you CAN'T take it anymore. Restore your strength and health and try again."
				else
					(= cycles 10)
				)
			)
			(8
				(ClearFlag 258)
				(ClearFlag 257)
				(SetFlag 260)
				(gEgo setScript: rollOut)
				(client setScript: 0)
			)
		)
	)
)

(instance takeADive of Script
	(properties)

	(method (dispose)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 1)
			)
			(1
				(if (not (IsFlag 259))
					((ScriptID 98 32) hide:) ; theHead
					(yorick view: 298 loop: 0 cel: 0 setCycle: End self)
				else
					(= ticks 1)
				)
			)
			(2
				(if (not (IsFlag 259))
					(yorick view: 298 loop: 0 cel: 3)
					(= ticks 12)
				else
					(= ticks 1)
				)
			)
			(3
				(if (IsFlag 268)
					(gMessager say: 7 0 6 1 self) ; "Elsa is right next door. I'll go set up the secret exit for your escape."
				else
					(= cycles 1)
				)
			)
			(4
				(yorick view: 298 loop: 1 cel: 0 setCycle: MCyc @local56 self)
			)
			(5
				(yorick dispose:)
				(client view: 96 loop: 3 cel: 0 setCycle: End self)
			)
			(6
				(client view: 96 loop: 3 cel: 12 setPri: 3)
				(= cycles 1)
			)
			(7
				((ScriptID 98 32) dispose:) ; theHead
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance doorFall of Script
	(properties)

	(method (dispose)
		(gEgo illegalBits: (& (gEgo illegalBits:) $ffff))
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register 0)
				(gEgo illegalBits: (| (gEgo illegalBits:) $0028))
				(++ local77)
				((ScriptID 98 20) ; dor7
					posn: (- ((ScriptID 98 20) x:) 1) ((ScriptID 98 20) y:) ; dor7, dor7
				)
				(= ticks 20)
			)
			(1
				((ScriptID 98 20) ; dor7
					posn: (+ ((ScriptID 98 20) x:) 1) ((ScriptID 98 20) y:) ; dor7, dor7
				)
				(= ticks 20)
			)
			(2
				(if (< local77 7)
					(= state -1)
					(= ticks 1)
				else
					(= local77 0)
					(= ticks 1)
				)
			)
			(3
				((ScriptID 98 19) ignoreActors: setPri: 1 init:) ; bhindDoor7
				(HandsOff)
				(cond
					(
						(and
							(== (gEgo onControl: 1) 4096)
							(not (gEgo script:))
						)
						(gEgo setPri: 14)
						(= register 1)
						((ScriptID 98 20) view: 291 loop: 10 cel: 0) ; dor7
						(= ticks 12)
					)
					(((ScriptID 98 13) script:) ; theTrap1
						((ScriptID 98 20) setCel: 0) ; dor7
						((ScriptID 98 19) delete:) ; bhindDoor7
						(client setScript: 0)
					)
					(else
						(= ticks 1)
					)
				)
			)
			(4
				(if register
					((ScriptID 98 20) view: 291 loop: 10 cel: 1) ; dor7
					(gEgo hide: forceUpd:)
				)
				(= ticks 1)
			)
			(5
				(if register
					((ScriptID 98 20) ; dor7
						view: 291
						loop: 10
						cel: 1
						setCycle: End self
					)
				else
					((ScriptID 98 20) cel: 2 setCycle: End self) ; dor7
				)
			)
			(6
				(if register
					(= ticks 30)
				else
					((ScriptID 98 20) view: 96 setLoop: 1 setCel: 3) ; dor7
					(self changeState: 11)
				)
			)
			(7
				(if (TakeDamage 10)
					(= ticks 15)
				else
					(EgoDead 169 170 5 6 516) ; "This time the joke fell flat. That was a truly dirty trick. Too bad you won't have a chance to get even... or will you?"
				)
			)
			(8
				(= ticks 60)
			)
			(9
				((ScriptID 98 20) setCycle: Beg) ; dor7
				(gEgo view: 291 loop: 12 cel: 0 show: setCycle: End self)
			)
			(10
				((ScriptID 98 19) dispose:) ; bhindDoor7
				(gMessager say: 7 0 3 1 self) ; "What a miserable experience!"
				(= cycles 1)
			)
			(11
				(if (not (gEgo script:))
					(NormalEgo)
				)
				(if register
					(gEgo setMotion: MoveTo 112 74 self)
				else
					(= ticks 20)
				)
			)
			(12
				(HandsOn)
				(if (!= ((ScriptID 98 20) cel:) 0) ; dor7
					((ScriptID 98 19) setPri: -1) ; bhindDoor7
					(SetFlag 264)
				)
				(gEgo illegalBits: -32768)
				(client setScript: 0)
				(= cycles 1)
			)
			(13
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance finalExit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetFlag 257)
				((ScriptID 98 19) setPri: 1 setCycle: End self) ; bhindDoor7
			)
			(1
				(gEgo illegalBits: 0 setMotion: MoveTo 123 62 self)
			)
			(2
				(ClearFlag 257)
				(gCurRoom newRoom: 97)
			)
		)
	)
)

(instance brickWall of Script
	(properties)

	(method (dispose)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= ticks 1)
			)
			(1
				(NormalEgo)
				((ScriptID 98 8) init:) ; bhindDoor11
				(door11 setCycle: End self)
			)
			(2
				(gMessager say: 7 0 2) ; "Oops! You thought this door led SOMEWHERE!"
				(= cycles 4)
			)
			(3
				(door11 setCycle: Beg self)
			)
			(4
				((ScriptID 98 8) dispose:) ; bhindDoor11
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance fallSideways of Script
	(properties)

	(method (dispose)
		(SetFlag 267)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (not (IsFlag 259))
					((ScriptID 98 32) setCel: 3) ; theHead
					(yorick setLoop: 3 cel: 0 cycleSpeed: 8 setCycle: Fwd)
				)
				(if (== client (ScriptID 98 14)) ; theTrap2
					(client setPri: (- (client priority:) 1))
				)
				(gEgo
					setPri:
						(cond
							((< (gEgo y:) 111) 6)
							((< (gEgo y:) 135) 10)
							(else 12)
						)
				)
				(cond
					(local78
						(= local78 0)
						(gEgo x: (- (gEgo x:) 24))
					)
					((IsFlag 258)
						(gEgo x: (+ (gEgo x:) 2))
					)
					(else
						(gEgo x: (- (gEgo x:) 5))
					)
				)
				(gEgo
					view: 517
					setLoop: (if (IsFlag 258) 3 else 2)
					cel: 0
					cycleSpeed: 8
					setCycle: CT 2 1 self
				)
				(if (== client (ScriptID 98 15)) ; theTrap3
					(gEgo
						setMotion: MoveTo (+ (gEgo x:) 12) (gEgo y:) self
					)
				)
			)
			(1
				(gEgo
					yStep: 10
					illegalBits: 0
					setCycle: End
					setMotion: MoveTo (gEgo x:) 220 self
				)
			)
			(2
				(if (not (TakeDamage 5))
					(EgoDead 114 115 2 5 517) ; "You're mad as heck, and you're not going to take it anymore. As a matter of fact, you CAN'T take it anymore. Restore your strength and health and try again."
				else
					(ClearFlag 258)
					(ClearFlag 257)
					(SetFlag 260)
					(if (IsFlag 256)
						(ClearFlag 256)
						(gEgo setScript: rollOut)
						(if (== client (ScriptID 98 14)) ; theTrap2
							(client setPri: (+ (client priority:) 2))
							((ScriptID 98 16) ; theFrontTrap
								setCel: 0
								setPri: (+ ((ScriptID 98 16) priority:) 2) ; theFrontTrap
							)
						)
						(client setCel: 0 setScript: 0)
					else
						(gEgo setScript: rollOut)
					)
				)
			)
		)
	)
)

(instance trapFall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (== client trap4)
					(gEgo setPri: 14)
				)
				(if (!= client (ScriptID 98 15)) ; theTrap3
					(client setPri: (- (client priority:) 1))
				)
				(cond
					((== client (ScriptID 98 14)) ; theTrap2
						(client setCel: 1)
						((ScriptID 98 16) ; theFrontTrap
							setPri: (- ((ScriptID 98 16) priority:) 2) ; theFrontTrap
						)
						(= ticks 12)
					)
					((and (== register 2) (!= client trap4))
						(= ticks 12)
					)
					(else
						(client setCycle: End self)
					)
				)
			)
			(1
				(if (== client (ScriptID 98 14)) ; theTrap2
					(client setCycle: End self)
					((ScriptID 98 16) setCycle: End) ; theFrontTrap
				else
					(= ticks 12)
				)
			)
			(2
				(cond
					((== client trap4)
						(SetFlag 270)
						(= register 0)
						(self dispose:)
					)
					((== client (ScriptID 98 13)) ; theTrap1
						(cond
							((== register 1)
								(client setScript: fallUpscreen 0 1)
							)
							((== register 2)
								(client setScript: fallDownscreen)
							)
							((== register 3)
								(client setScript: fallSideways)
							)
							(else
								(client setScript: fallDownscreen)
							)
						)
						(= register 0)
					)
					(else
						(= register 0)
						(if
							(and
								(< (gEgo x:) 295)
								(== client (ScriptID 98 14)) ; theTrap2
							)
							(gEgo x: (+ (gEgo x:) 25))
						)
						(client setScript: fallSideways)
					)
				)
			)
		)
	)
)

(instance roomMusic of Sound
	(properties
		flags 1
		number 82
		priority 1
		loop -1
	)
)

(instance yorickTalker of Talker
	(properties
		x 10
		y 10
		view 1096
		talkWidth 260
		textX 15
		textY 110
	)

	(method (init)
		(= font gUserFont)
		(super init: yorickBust yorickEye yorickMouth &rest)
	)

	(method (dispose)
		(LoadMany 0 128 1096)
		(super dispose:)
	)
)

(instance yorickBust of Prop
	(properties
		view 1096
	)
)

(instance yorickMouth of Prop
	(properties
		nsTop 39
		nsLeft 34
		view 1096
		loop 1
	)
)

(instance yorickEye of Prop
	(properties
		nsTop 25
		nsLeft 33
		view 1096
		loop 2
	)
)

