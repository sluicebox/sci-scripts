;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 390)
(include sci.sh)
(use Main)
(use Village)
(use Feature)
(use ForwardCounter)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm390 0
)

(local
	[local0 8]
	[local8 20]
	local28 = 19
	local29
	local30
	local31
	local32
	local33
	local34 = 1
	local35
	local36
	local37
	local38
	local39
)

(procedure (localproc_0)
	(Graph grDRAW_LINE 12 142 12 303 0 -1 -1)
	(Graph grDRAW_LINE 12 303 63 303 0 -1 -1)
	(Graph grDRAW_LINE 63 303 63 142 0 -1 -1)
	(Graph grDRAW_LINE 63 142 12 142 0 -1 -1)
	(Graph grFILL_BOX 13 143 63 303 1 0 -1)
	(Graph grUPDATE_BOX 11 141 64 304 1)
)

(procedure (localproc_1 param1 param2 param3 param4 param5 &tmp temp0 temp1 [temp2 100] temp102 temp103 temp104 temp105)
	(localproc_0)
	(Message msgGET 390 param1 param2 param3 param4 @temp2)
	(= temp1 (Message msgSIZE 390 param1 param2 param3 param4))
	(Display @temp2 dsCOLOR 14 dsCOORD 149 22 dsWIDTH 152 dsFONT 68)
	(if (>= argc 5)
		(= temp102 0)
		(= temp103 0)
		(= temp105 1)
		(= temp104 temp1)
		(= temp0 (Event new:))
		(= local35 gCast)
		(= local36 (myList new:))
		(local36 add: tMouth)
		(local36 add: tEye)
		(= gCast local36)
		(while (and temp104 (not (OneOf (temp0 type:) evKEYBOARD evMOUSEBUTTON evJOYDOWN)))
			(if (and (> (++ temp102) 10) temp104)
				(= temp102 0)
				(if (> (+ (tMouth cel:) 1) 9)
					(tMouth cel: 0)
				else
					(tMouth cel: (+ (tMouth cel:) 1))
				)
				(-- temp104)
			)
			(cond
				(temp105
					(if (> (++ temp103) 15)
						(= temp103 0)
						(if (> (+ (tEye cel:) 1) 3)
							(= temp105 0)
							(tEye cel: 0)
						else
							(tEye cel: (+ (tEye cel:) 1))
						)
					)
				)
				((not (Random 0 250))
					(= temp105 1)
				)
			)
			(Animate (gCast elements:) 0)
			(temp0 dispose:)
			(= gGameTime (+ gTickOffset (GetTime)))
			(gSounds eachElementDo: #check)
			(gSounds eachElementDo: #doit)
			(= temp0 (Event new:))
		)
		(local36 dispose:)
		(= gCast local35)
		(tMouth cel: 0)
		(tEye cel: 0)
		(temp0 dispose:)
		(if (IsObject param5)
			(param5 cue:)
		)
	else
		(tMouth setCycle: (fc new:) (/ temp1 10))
	)
)

(procedure (localproc_2 &tmp temp0)
	(for ((= temp0 0)) (< temp0 20) ((++ temp0))
		(= [local8 temp0] (+ temp0 1))
	)
	(if (not (Random 0 99))
		(= local38 1)
	)
)

(procedure (localproc_3 &tmp temp0 temp1)
	(= temp0 [local8 (= temp1 (Random 0 local28))])
	(= [local8 temp1] [local8 local28])
	(-- local28)
	(= [local0 (++ local29)] temp0)
	(return temp0)
)

(procedure (localproc_4 param1 param2)
	(if (and local38 (not local39))
		(= local39 1)
		(param1 loop: 5 cel: 0)
	else
		(if (> param2 10)
			(param1 loop: 2 cel: (- param2 11))
		else
			(param1 loop: 1 cel: (- param2 1))
		)
		(param1 noun: (+ param2 3))
	)
)

(procedure (localproc_5)
	(if local38
		(= local30 [local0 (Random 2 8)])
	else
		(= local30 [local0 (Random 1 8)])
	)
)

(instance rm390 of Rm
	(properties
		picture 390
		style 10
	)

	(method (doVerb))

	(method (init)
		(gGame handsOff:)
		(SetFlag 7)
		(localproc_2)
		(tShaman init:)
		(tEye init:)
		(tMouth init:)
		(face init:)
		(v1 init:)
		(v2 init:)
		(v3 init:)
		(v4 init:)
		(v5 init:)
		(v6 init:)
		(v7 init:)
		(v8 init:)
		(gGameSound1 number: 389 play:)
		(super init:)
		(self setScript: doco)
	)

	(method (dispose)
		(ClearFlag 7)
		(super dispose:)
	)

	(method (cue)
		(face hide:)
		(DrawPic 390 9)
		(Animate (gCast elements:) 0)
		(tMouth setScript: (sm new:) tMouth 1)
	)

	(method (doit)
		(super doit:)
		(if
			(and
				local33
				(== ((gTheIconBar curIcon:) message:) 4)
				(== (gTheCursor view:) 960)
			)
			((= gTheCursor aCursor)
				view: (local32 view:)
				loop: (local32 loop:)
				cel: (local32 cel:)
				init:
			)
		)
	)
)

(instance doco of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(User canControl: 1 canInput: 1)
				(gTheIconBar enable: 2 1 curIcon: (gTheIconBar at: 2))
				(gGame setCursor: ((gTheIconBar curIcon:) cursor:) 1)
				(bowl init:)
				(stone init:)
				(= cycles 5)
			)
			(1
				(localproc_1 1 0 1 1 self)
			)
			(2
				(if (== local31 32767)
					(localproc_5)
					(localproc_1 1 0 2 local30)
				else
					(self cue:)
				)
			)
			(3
				(localproc_5)
				(localproc_1 1 0 2 local30)
			)
			(4
				(Village points: 10)
				(gCurrentRegionFlags set: 41)
				(localproc_1 1 0 3 1 self)
			)
			(5
				(gCurRoom newRoom: 380)
			)
		)
	)
)

(instance facePainting of Script
	(properties)

	(method (dispose)
		(if (not local37)
			(= local31 0)
			(= local33 0)
			(User canControl: 1 canInput: 1)
			(gTheIconBar enable: 2 1 curIcon: (gTheIconBar at: 2))
			(gGame setCursor: ((gTheIconBar curIcon:) cursor:) 1)
		)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(face loop: (+ (local32 loop:) 2) cel: (local32 cel:) show:)
				(DrawPic 390 9)
				(Animate (gCast elements:) 0)
				(= cycles 5)
			)
			(1
				(local32 dispose:)
				(cond
					((== local31 local30)
						(doco cue:)
						(= local37 1)
						(self dispose:)
					)
					((== local31 32767)
						(localproc_1 1 0 8 1 gCurRoom)
					)
					(local34
						(-- local34)
						(localproc_1 1 0 4 1 gCurRoom)
					)
					(else
						(localproc_1 1 0 6 1 self)
					)
				)
			)
			(2
				(doco dispose:)
				(face hide:)
				(DrawPic 390 9)
				(Animate (gCast elements:) 0)
				(= cycles 5)
			)
			(3
				(= local37 1)
				(gCurRoom newRoom: 380)
			)
		)
	)
)

(instance bowl of Feature
	(properties
		x 238
		y 131
		noun 2
		nsTop 98
		nsLeft 189
		nsBottom 164
		nsRight 288
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (IsObject local32)
					(tMouth setScript: facePainting)
				else
					(localproc_1 1 0 5 1 tMouth)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance stone of Feature
	(properties
		x 94
		y 100
		noun 3
		nsTop 116
		nsLeft 11
		nsBottom 185
		nsRight 178
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(localproc_1 noun theVerb 0 1 tMouth)
			)
			(4 ; Do
				(if (IsObject local32)
					(local32 show:)
					(= local32 0)
					(= local33 0)
					(gGame setCursor: ((gTheIconBar curIcon:) cursor:) 1)
				)
			)
		)
	)
)

(instance v1 of View
	(properties
		x 38
		y 122
		view 383
		signal 16384
	)

	(method (init &tmp temp0)
		(super init:)
		(localproc_4 self (= maxScale (localproc_3)))
		(self stopUpd:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if local38
					(= local31 32767)
				else
					(= local31 maxScale)
				)
				(self hide:)
				(if (IsObject local32)
					(local32 show:)
				)
				((= gTheCursor aCursor) view: view loop: loop cel: cel init:)
				(= local33 1)
				(= local32 self)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance v2 of View
	(properties
		x 69
		y 125
		view 383
		loop 1
		cel 1
		signal 16384
	)

	(method (init)
		(super init:)
		(localproc_4 self (= maxScale (localproc_3)))
		(self stopUpd:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(= local31 maxScale)
				(self hide:)
				(if (IsObject local32)
					(local32 show:)
				)
				((= gTheCursor aCursor) view: view loop: loop cel: cel init:)
				(= local33 1)
				(= local32 self)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance v3 of View
	(properties
		x 100
		y 135
		view 383
		loop 1
		cel 2
		signal 16384
	)

	(method (init)
		(super init:)
		(localproc_4 self (= maxScale (localproc_3)))
		(self stopUpd:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(= local31 maxScale)
				(self hide:)
				(if (IsObject local32)
					(local32 show:)
				)
				((= gTheCursor aCursor) view: view loop: loop cel: cel init:)
				(= local33 1)
				(= local32 self)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance v4 of View
	(properties
		x 17
		y 146
		view 383
		loop 1
		cel 3
		signal 16384
	)

	(method (init)
		(super init:)
		(localproc_4 self (= maxScale (localproc_3)))
		(self stopUpd:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(= local31 maxScale)
				(self hide:)
				(if (IsObject local32)
					(local32 show:)
				)
				((= gTheCursor aCursor) view: view loop: loop cel: cel init:)
				(= local33 1)
				(= local32 self)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance v5 of View
	(properties
		x 48
		y 149
		view 383
		loop 1
		cel 4
		signal 16384
	)

	(method (init)
		(super init:)
		(localproc_4 self (= maxScale (localproc_3)))
		(self stopUpd:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(= local31 maxScale)
				(self hide:)
				(if (IsObject local32)
					(local32 show:)
				)
				((= gTheCursor aCursor) view: view loop: loop cel: cel init:)
				(= local33 1)
				(= local32 self)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance v6 of View
	(properties
		x 79
		y 157
		view 383
		loop 1
		cel 5
		signal 16384
	)

	(method (init)
		(super init:)
		(localproc_4 self (= maxScale (localproc_3)))
		(self stopUpd:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(= local31 maxScale)
				(self hide:)
				(if (IsObject local32)
					(local32 show:)
				)
				((= gTheCursor aCursor) view: view loop: loop cel: cel init:)
				(= local33 1)
				(= local32 self)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance v7 of View
	(properties
		x 110
		y 160
		view 383
		loop 1
		cel 6
		signal 16384
	)

	(method (init)
		(super init:)
		(localproc_4 self (= maxScale (localproc_3)))
		(self stopUpd:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(= local31 maxScale)
				(self hide:)
				(if (IsObject local32)
					(local32 show:)
				)
				((= gTheCursor aCursor) view: view loop: loop cel: cel init:)
				(= local33 1)
				(= local32 self)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance v8 of View
	(properties
		x 141
		y 162
		view 383
		loop 1
		cel 7
		signal 16384
	)

	(method (init)
		(super init:)
		(localproc_4 self (= maxScale (localproc_3)))
		(self stopUpd:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(= local31 maxScale)
				(self hide:)
				(if (IsObject local32)
					(local32 show:)
				)
				((= gTheCursor aCursor) view: view loop: loop cel: cel init:)
				(= local33 1)
				(= local32 self)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance tShaman of View
	(properties
		x 42
		y 12
		view 1069
		loop 1
		signal 16384
	)

	(method (init)
		(super init:)
		(self stopUpd:)
	)

	(method (doVerb))
)

(instance tMouth of Prop
	(properties
		x 79
		y 71
		view 1069
		signal 16384
	)

	(method (cue)
		(localproc_1 1 0 2 local30)
		(if script
			((self script:) dispose:)
		)
	)

	(method (doVerb))
)

(instance face of View
	(properties
		x 224
		y 119
		view 383
		priority 14
		signal 16400
	)

	(method (init)
		(super init:)
		(self hide:)
	)

	(method (doVerb theVerb)
		(bowl doVerb: theVerb)
	)
)

(instance tEye of Prop
	(properties
		x 79
		y 50
		view 1069
		loop 2
		signal 16384
	)

	(method (init)
		(super init:)
		(self setCycle: End self)
	)

	(method (cue)
		(if (not (Random 0 3))
			(self setCycle: Beg self)
		else
			(self setScript: (sm new:) self 2)
		)
	)

	(method (doVerb))
)

(instance sm of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds register)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance fc of ForwardCounter
	(properties)

	(method (cycleDone)
		(if (-- count)
			(client cel: 0)
		else
			(= completed 1)
			(client cel: 0)
			(self motionCue:)
		)
	)
)

(instance aCursor of Cursor
	(properties)
)

(instance myList of List
	(properties)

	(method (dispose)
		(if elements
			(DisposeList elements)
		)
		(= size (= elements 0))
		(super dispose:)
	)
)

