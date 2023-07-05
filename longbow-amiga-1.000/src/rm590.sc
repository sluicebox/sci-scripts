;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 590)
(include sci.sh)
(use Main)
(use n013)
(use Fens)
(use verseScript)
(use RTEyeCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Rev)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm590 0
)

(local
	local0
	local1
	[local2 2]
	[local4 5]
	[local9 14]
	[local23 10]
	[local33 4] = [188 164 124 189]
	[local37 4] = [146 137 133 130]
	[local41 12] = [0 319 90 225 159 136 244 0 160 319 57 15]
	[local53 12] = [109 109 116 122 105 131 139 128 145 129 139 119]
	[local65 12] = [1 1 0 2 2 2 0 2 1 2 0 1]
	[local77 9] = [2 3 3 3 2 3 3 3 2]
	[local86 9] = [1 2 5 5 6 5 7 7 4]
	[local95 9] = [21 7 66 -15 -27 -12 22 157 234]
	[local104 9] = [145 145 142 190 182 169 144 170 168]
	[local113 5] = [1590 0 1 2 0]
	[local118 5] = [1590 2 1 2 0]
	[local123 4] = [1590 4 1 0]
)

(procedure (localproc_0 &tmp temp0)
	(for ((= temp0 0)) (< temp0 12) ((++ temp0))
		((= [local9 temp0] (cloud new:))
			x: [local41 temp0]
			y: [local53 temp0]
			priority:
				(cond
					((== temp0 2) 7)
					((== temp0 11) 1)
					(else -1)
				)
			loop: [local65 temp0]
			signal: (| $4000 (if (or (== temp0 11) (== temp0 2)) 16 else 0))
			init:
		)
		(gAddToPics add: [local9 temp0])
	)
	(gAddToPics doit:)
)

(procedure (localproc_1 &tmp temp0)
	(for ((= temp0 0)) (< temp0 8) ((++ temp0))
		(= [local23 temp0] (aPlant new:))
		([local23 temp0]
			view: 600
			loop: [local77 temp0]
			cel: [local86 temp0]
			signal: 16384
			x: [local95 temp0]
			y: [local104 temp0]
			init:
		)
		(gAddToPics add: [local23 temp0])
	)
	(gAddToPics doit:)
)

(procedure (localproc_2 &tmp temp0)
	(for ((= temp0 0)) (< temp0 4) ((++ temp0))
		((= [local4 temp0] (wave new:))
			x: [local33 temp0]
			y: [local37 temp0]
			setPri: 1
			init:
		)
	)
)

(instance rm590 of Rm
	(properties
		picture 590
		style 5
		north 610
	)

	(method (init)
		(LoadMany rsVIEW 0 792 16 585)
		(if (and (== gPrevRoomNum 600) (== gEgoEdgeHit 4))
			(self style: 11)
		)
		(SetFlag 15)
		(proc601_11 1)
		(= local0 (proc601_5 1))
		(super init:)
		(NormalEgo)
		(gEgo actions: (ScriptID 601 7)) ; egoActions
		(localproc_0)
		(localproc_1)
		(if (not (IsFlag 0))
			(localproc_2)
		)
		(AddToFeatures gate monastery lilTree fog waters roundGround sky)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 319 165 294 165 271 173 177 173 150 177 143 171 131 166 98 154 98 150 134 149 156 145 137 142 111 142 106 146 0 148
					yourself:
				)
		)
		(cond
			(
				(and
					(< (Abs (- (GetTime 1) global129)) 440) ; SysTime12
					(!= (- (GetTime 1) global129) 0) ; SysTime12
					(!= global129 0)
				)
				(Load rsVIEW 792)
				(gCurRoom setScript: beKilled)
			)
			(global129
				(= global129 0)
			)
			((or (== gPrevRoomNum 580) (and (== gPrevRoomNum 600) (== gEgoEdgeHit 3)))
				(gEgo setScript: walkUp)
			)
			((== gPrevRoomNum 600)
				(gEgo
					posn: 305 (gEgo y:)
					init:
					setMotion: PolyPath 256 182 self
				)
				(HandsOff)
			)
			(else
				(gEgo posn: 160 185 init:)
			)
		)
	)

	(method (notify)
		((ScriptID 601) notify: 1) ; Fens
	)

	(method (cue)
		(if local0
			(= local0 0)
			(Converse 1 @local123 11 0 self) ; "I'm not going to wait here all day."
		)
		(if (and (not (Random 0 10)) (!= gDisguiseNum 6)) ; fens monk
			(self setScript: nessie)
		)
		(HandsOn)
		(super cue:)
	)

	(method (doit)
		(if (== global202 256)
			(++ local1)
			(if (and (not global200) (== (mod local1 5) 0))
				(Palette palANIMATE 225 255 -1)
			)
		)
		(cond
			((gEgo script:))
			((or (== (gEgo edgeHit:) 3) (== (gEgo edgeHit:) 2))
				(gEgo setScript: walkOut)
			)
			((<= (gEgo x:) 5)
				(gEgo setMotion: 0 setScript: bumpBog)
			)
			(else
				(super doit:)
			)
		)
	)

	(method (dispose)
		(ClearFlag 15)
		(self setScript: 0)
		(super dispose:)
	)
)

(instance cloud of PicView
	(properties
		z 15
		view 590
		signal 24576
	)

	(method (handleEvent event)
		(if (self onMe: event)
			(event claimed: 0)
			(cond
				((lilTree onMe: event)
					(lilTree handleEvent: event)
				)
				((gate onMe: event)
					(gate handleEvent: event)
				)
				((sky onMe: event)
					(sky handleEvent: event)
				)
				((fog onMe: event)
					(fog handleEvent: event)
				)
				((waters onMe: event)
					(waters handleEvent: event)
				)
				((roundGround onMe: event)
					(roundGround handleEvent: event)
				)
			)
		else
			(super handleEvent: event)
		)
	)
)

(instance aPlant of PicView
	(properties
		lookStr 5 ; "Only stunted bushes and thick reeds grow near these fens."
	)
)

(instance wave of Prop
	(properties
		view 590
		loop 3
		signal 16384
		cycleSpeed 18
	)

	(method (init)
		(if (Random 0 1)
			(self setCel: (Random 0 2) setCycle: Fwd)
		else
			(self setCel: (Random 0 2) setCycle: Rev)
		)
		(super init:)
	)
)

(instance elliot of Actor
	(properties
		y 115
		view 590
		loop 5
		priority 8
		signal 2064
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1590 15) ; "Where does a creature of such size live in such a shallow swamp?"
				(Say 1590 16) ; "Anywhere it likes."
			)
			(3 ; Do
				(Say 1590 17) ; "That isn't a creature I wish to catch."
			)
			(5 ; Talk
				(Say 1590 18) ; "Pardon me, which way to Loch Ness? I seem to have taken a wrong turn somewhere."
			)
			(10 ; Longbow
				(Say 1590 19) ; "It seems harmless enough. I've no reason to shoot at it."
			)
			(4 ; Inventory
				(Say 1590 20) ; "A silly idea at best."
			)
		)
	)
)

(instance lilTree of Feature
	(properties
		lookStr 5 ; "Only stunted bushes and thick reeds grow near these fens."
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 0 91 28 80 54 87 56 109 91 118 117 141 107 146 0 148
			yourself:
		)
		(super init:)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance monastery of Feature
	(properties
		lookStr 7 ; "The Normans built well. It would take a mighty army and a long siege to overcome such a place."
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 114 30 121 25 140 28 202 20 222 25 258 27 278 23 278 75 112 75
			yourself:
		)
		(super init:)
	)

	(method (doVerb theVerb invItem)
		(if (== theVerb 3) ; Do
			(Say 1590 8 1) ; "I must find a way to go there if I wish to do anything there."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance waters of Feature
	(properties
		lookStr 9 ; "Faith, that is dark and unwholesome water, just deep enough to drown a man."
	)

	(method (doVerb theVerb)
		(if (== theVerb 3) ; Do
			(Say 1590 10 1) ; "I care not to touch this water."
		else
			(super doVerb: theVerb &rest)
		)
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 76 116 319 116 319 122 309 122 280 118 258 122 240 132 223 130 211 135 222 140 261 142 280 147 282 142 319 145 319 161 265 163 247 155 223 154 203 170 168 170 151 175 137 164 120 157 136 156 154 152 156 145 109 138 93 123
			yourself:
		)
		(super init:)
	)
)

(instance roundGround of Feature
	(properties
		nsTop 119
		nsBottom 189
		nsRight 319
		lookStr 14 ; "The ground here is boggy and unpleasant."
	)
)

(instance fog of Feature
	(properties
		nsTop 70
		nsBottom 125
		nsRight 319
		lookStr 11 ; "The fog grows ever thicker. It would be easy to become lost within."
	)

	(method (doVerb theVerb)
		(if (== theVerb 3) ; Do
			(Say 1590 12 1) ; "How can one grasp insubstantial tendrils of mist?"
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance sky of Feature
	(properties
		nsBottom 69
		nsRight 319
		lookStr 21 ; "A perpetual gloom hangs over these fens."
	)
)

(instance gate of Feature
	(properties
		nsTop 57
		nsLeft 236
		nsBottom 73
		nsRight 251
		lookStr 13 ; "I can dimly make out the front gate, facing to the north."
	)
)

(instance walkUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo posn: 250 240 init: setMotion: PolyPath 245 184 self)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance walkOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (== (gEgo edgeHit:) 2)
					(gEgo setMotion: PolyPath 335 (gEgo y:) self)
				else
					(gEgo
						setMotion:
							PolyPath
							(gEgo x:)
							(+ (gEgo y:) 50)
							self
					)
				)
			)
			(1
				(HandsOn)
				(if (== (gEgo edgeHit:) 2)
					(gCurRoom newRoom: 600)
				else
					(gCurRoom newRoom: 580)
				)
			)
		)
	)
)

(instance nessie of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo stopUpd:)
				(elliot init: setMotion: MoveTo 40 100 self)
			)
			(1
				(= ticks 40)
			)
			(2
				(elliot setMotion: MoveTo 88 100 self)
			)
			(3
				(= ticks 120)
			)
			(4
				(elliot setMotion: MoveTo 85 138 self)
			)
			(5
				(HandsOn)
				(elliot dispose:)
				(self dispose:)
			)
		)
	)
)

(instance bumpBog of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Say 1590 6 self) ; "There's a thicket and marshy ground up ahead. I'll have to turn back."
			)
			(1
				(gEgo
					setMotion: MoveTo (+ (gEgo x:) 15) (gEgo y:) self
				)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance beKilled of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((= [local2 0] ((ScriptID 601 2) new:)) ; monk
					view: 16
					loop: 5
					cel: 5
					x: 267
					y: 178
					init:
					stopUpd:
				)
				((= [local2 1] ((ScriptID 601 2) new:)) ; monk
					view: 585
					loop: 0
					x: 211
					y: 183
					init:
					stopUpd:
				)
				(gEgo view: 0 loop: 3 cel: 1 x: 236 y: 188 init: stopUpd:)
				(= ticks 48)
			)
			(1
				(Converse 2 @local113 11 0 11 1 self) ; "An outlaw!"
			)
			(2
				([local2 1] setCycle: CT 3 1 self)
			)
			(3
				(dieSound play:)
				([local2 1] setCycle: End)
				(gEgo view: 792 loop: 0 cel: 0 setCycle: End self)
			)
			(4
				(Converse 2 @local118 11 0 11 1 self) ; "Bit of a fool coming back here after setting off the alarm, wasn't he?"
			)
			(5
				(gRgnMusic2 stop:)
				(dieSound dispose:)
				(EgoDead)
			)
		)
	)
)

(instance dieSound of Sound
	(properties
		flags 1
		number 588
	)
)

