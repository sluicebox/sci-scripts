;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 290)
(include sci.sh)
(use Main)
(use SQRoom)
(use ExitFeature)
(use SQNarrator)
(use n666)
(use PolyPath)
(use Polygon)
(use Feature)
(use StopWalk)
(use Timer)
(use Grooper)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm290 0
	Endodroid 1
)

(local
	local0
	local1
)

(procedure (localproc_0)
	(return (if (< (gEgo x:) (endroid y:)) 1 else 0))
)

(instance rm290 of SQRoom
	(properties
		noun 1
		picture 290
		horizon -15
	)

	(method (init)
		(super init: &rest)
		(gGSound1 setVol: 90)
		((self plane:) setRect: -160 0 321 138)
		(UpdatePlane plane)
		(= local1
			(if (and (IsFlag 15) (IsFlag 14) (IsFlag 20) (not (IsFlag 16)))
				(not (IsFlag 21))
			)
		)
		(self
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 35 128 87 128 87 138 418 138 418 128 390 120 379 112 224 112 224 114 61 114
					yourself:
				)
		)
		(if local1
			(self
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 129 132 117 127 123 117 219 117 219 130 168 134
						yourself:
					)
			)
		else
			(self
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 128 117 219 117 219 130 128 130
						yourself:
					)
			)
		)
		(gEgo
			init:
			normalize:
			x: 429
			y: 58
			code: scrollCode
			setScale: 0
			setScript: sEnterRoom
		)
		(cond
			((or (IsFlag 21) (and (not (IsFlag 35)) (not local1)))
				(toolsCrate init:)
			)
			((and (not (IsFlag 35)) local1)
				(nitroStream init: setScript: blowNitroWad)
				(toolsCrate init:)
			)
			((IsFlag 16)
				(endroid view: 2942 loop: 0)
				(endroid
					cel: (endroid lastCel:)
					posn: 154 130
					init:
					ignoreActors: 1
					approachVerbs: 4 154 ; Do, Pipe
					approachX: 191
					approachY: 132
				)
				(tools init:)
			)
			(local1
				(endroid
					view: 2920
					setLoop: 0 1
					cel: 0
					posn: 154 130
					init:
					ignoreActors: 1
					approachVerbs: 4 154 ; Do, Pipe
					approachX: 191
					approachY: 132
				)
				(tools init:)
				(nitroStream init: setScript: blowNitroWad)
			)
			(else
				(Load 140 297) ; WAVE
				(endroid init: ignoreActors: 1 setScript: endroidFixes)
				(tools init:)
				(killRange init:)
			)
		)
		(Load 140 298) ; WAVE
		(spider1 init: setScript: crawlin)
		(spider3 init: setScript: (crawlin new:))
		(if (> (gGame detailLevel:) 2)
			(rat init: setScript: crawlinRat)
			(spider2 init: setScript: (crawlin new:))
		)
		(breath init: ignoreActors: 1 setCycle: Fwd)
		(if
			(and
				(not (gEgo has: 80)) ; Pipe
				(not (IsFlag 16))
				(not (IsFlag 21))
				(IsFlag 35)
			)
			(pipe init: approachVerbs: 4) ; Do
		)
		(floor init:)
		(ceiling init:)
		(baseWindow init:)
		(stairs init:)
		(bottle1 init:)
		(bottle2 init:)
		(bottle3 init:)
		(crate1 init:)
		(crate2 init:)
		(crate3 init:)
		(crate4 init:)
		(crate5 init:)
		(light init:)
		(kegs init:)
		(openConduit init:)
		(seat init:)
		(exit300 init: gTheExitCursor approachVerbs: 5) ; Exit
		(cond
			((or (IsFlag 21) (not (IsFlag 35))) 0)
			((IsFlag 16)
				(mergeTimer setReal: mergeTimer 30)
			)
			(local1
				(meltTimer setReal: meltTimer 30)
			)
			(else
				(killTimer setReal: killTimer 30)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(RemapColors 0) ; Off
		(FrameOut)
		(super newRoom: newRoomNumber &rest)
	)

	(method (doit &tmp temp0)
		(cond
			(local0)
			(
				(and
					gFeatures
					(gFeatures contains: killRange)
					(killRange onMe: gEgo)
				)
				(endroid setScript: endroidAnnoyed 0 (localproc_0))
			)
		)
		(if (<= (= temp0 (GetDistance (gEgo x:) (gEgo y:) 193 114)) 50)
			(PalVary 0 291 0 (- 100 (* temp0 2)) 64 79) ; PalVaryStart
		)
		(super doit: &rest)
	)

	(method (notify)
		(gEgo normalize: 5)
		(endroid view: 2942 loop: 0)
		(endroid
			cel: (endroid lastCel:)
			posn: 154 130
			init:
			ignoreActors: 1
			approachVerbs: 4 154 ; Do, Pipe
			approachX: 191
			approachY: 132
		)
		(mergeTimer setReal: mergeTimer 30)
		(gGame handsOn:)
	)

	(method (dispose)
		(killTimer client: 0 delete: dispose:)
		(meltTimer client: 0 delete: dispose:)
		(mergeTimer client: 0 delete: dispose:)
		(ClearFlag 20)
		(ClearFlag 16)
		((self plane:) setRect: 0 0 319 138)
		(PalVary 3) ; PalVaryKill
		(squeak stop:)
		(ratchet stop:)
		(super dispose: &rest)
	)
)

(instance crawlin of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks (RandomNumber 270 480))
			)
			(1
				(client
					setLoop: (client fwdLoop:) 1
					setMotion: MoveTo (client stopX:) (client stopY:) self
					setCycle: Fwd
				)
			)
			(2
				(client setCycle: 0)
				(= ticks (RandomNumber 270 480))
			)
			(3
				(client
					loop: (client bkLoop:)
					setMotion: MoveTo (client startX:) (client startY:) self
					setCycle: Fwd
				)
			)
			(4
				(client setCycle: 0)
				(= state -1)
				(= ticks 1)
			)
		)
	)
)

(instance crawlinRat of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks (RandomNumber 270 480))
			)
			(1
				(client
					setLoop: (client fwdLoop:) 1
					setMotion: MoveTo (client stopX:) (client stopY:) self
					setCycle: Fwd
				)
				(self setScript: squeakin)
			)
			(2
				(client setCycle: 0)
				(squeak stop:)
				(self setScript: 0)
				(= ticks (RandomNumber 270 480))
			)
			(3
				(client
					loop: (client bkLoop:)
					setMotion: MoveTo (client startX:) (client startY:) self
					setCycle: Fwd
				)
				(self setScript: squeakin)
			)
			(4
				(client setCycle: 0)
				(squeak stop:)
				(self setScript: 0)
				(= state -1)
				(= ticks 1)
			)
		)
	)
)

(instance squeakin of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks (RandomNumber 120 270))
			)
			(1
				(if (and (gTalkers isEmpty:) (not (gGSound2 handle:)))
					(squeak play:)
					(= ticks 80)
				else
					(= ticks 1)
				)
			)
			(2
				(= state -1)
				(= ticks 1)
			)
		)
	)
)

(instance fallinSpidey of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGSound2 number: 296 loop: 0 play: setVol: 127)
				(client
					setPri: 143
					setSpeed: 1
					setStep: -1 6
					setCycle: Fwd
					setMotion: MoveTo (client x:) 150 self
				)
			)
			(1
				(gGSound2 stop:)
				(client hide: dispose:)
				(self dispose:)
			)
		)
	)
)

(instance blowNitroWad of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(gGSound2 number: 524 loop: -1 play: setVol: 127)
				(client setCycle: Fwd)
				(= ticks 600)
			)
			(2
				(client loop: 1 cel: 0 setCycle: End self)
			)
			(3
				(gGSound2 stop:)
				(client hide: dispose:)
				(self dispose:)
			)
		)
	)
)

(instance sEnterRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(RemapColors 2 244 175) ; ByPercent
				(gEgo
					view: 293
					loop: 1
					cel: 0
					posn: 434 53
					setSpeed: 6
					setCycle: End self
				)
			)
			(2
				(gEgo
					loop: 0
					cel: 0
					posn: 436 97
					setPri: 130
					setCycle: End self
				)
			)
			(3
				(gEgo posn: 411 127 normalize: 5)
				(if (and local1 (IsFlag 35))
					(gEgo setMotion: MoveTo 228 111 self)
				else
					(= ticks 1)
				)
			)
			(4
				(if (and local1 (not (IsFlag 202)))
					((gCurRoom plane:) setRect: -120 0 361 138)
					(UpdatePlane (gCurRoom plane:))
				)
				(cond
					((not (IsFlag 35))
						(= ticks 1)
					)
					((IsFlag 21)
						(= ticks 1)
					)
					((IsFlag 16)
						(= ticks 1)
					)
					(local1
						(if (nitroStream script:)
							(-- state)
							(= ticks 1)
						else
							(gMessager say: 1 1 7 0 self) ; "Frosta la keister, baby!"
						)
					)
					(else
						(gMessager say: 0 0 9 0 self) ; "You go now and I don't rearrange your organs."
					)
				)
			)
			(5
				(gEgo setPri: -1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sLeaveRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(endroid setScript: 0)
				(cond
					((killTimer client:)
						(killTimer client: 0 delete: dispose:)
					)
					((meltTimer client:)
						(meltTimer client: 0 delete: dispose:)
					)
					((mergeTimer client:)
						(mergeTimer client: 0 delete: dispose:)
					)
				)
				(gEgo
					view: 293
					loop: 2
					cel: 0
					posn: 436 98
					setSpeed: 6
					setPri: 130
					setCycle: End self
				)
			)
			(1
				(gEgo
					loop: 3
					cel: 0
					posn: 445 57
					setPri: -1
					setCycle: End self
				)
			)
			(2
				(gCurRoom newRoom: 300)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance rogBreaksEndroid of Script
	(properties)

	(method (init)
		(= register 0)
		(super init: &rest)
	)

	(method (doit)
		(if register
			(= register 0)
			(self cue:)
		)
		(super doit: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(endroid setScript: 0)
				(meltTimer client: 0 delete: dispose:)
				(Load rsVIEW 2940 2942)
				(Load 140 292) ; WAVE
				(client
					view: 2940
					loop: 0
					cel: 0
					posn: 191 132
					setSpeed: 6
					setCycle: End self
				)
			)
			(1
				(= ticks (* (client cycleSpeed:) 2))
			)
			(2
				(client loop: 1 cel: 0 setCycle: End self)
				(gGSound2 number: 292 loop: 0 play: setVol: 127)
			)
			(3
				(endroid setScript: endroidCrumbles)
			)
			(4
				(Load 140 2903) ; WAVE
				(client loop: 2 cel: 0 setCycle: End self)
			)
			(5
				(= cycles (* (client cycleSpeed:) 2))
			)
			(6
				(gGSound2 number: 2903 loop: 0 play: setVol: 127)
				(= ticks 45)
			)
			(7
				(gGame points: 5 446)
				(gEgo normalize: 1 put: 80) ; Pipe
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance pickUpPipe of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(client setSpeed: 6 setHeading: 90 self)
			)
			(1
				(client
					view: 294
					loop: 0
					cel: 0
					posn: 378 132
					setCycle: End self
				)
				(pipe hide:)
			)
			(2
				(gGame points: 3 445)
				(gEgo get: 80 normalize: 0) ; Pipe
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance rogSweepsUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load 140 295) ; WAVE
				(endroid setScript: 0)
				(mergeTimer client: 0 delete: dispose:)
				(client setHeading: 270 self)
			)
			(1
				(client
					view: 2943
					loop: 0
					cel: 0
					posn: 191 132
					setSpeed: 6
					setCycle: CT 2 1 self
				)
			)
			(2
				(endroid hide:)
				(client setCycle: End self)
			)
			(3
				(client loop: 1 cel: 0 setSpeed: 8 setCycle: CT 1 1 self)
			)
			(4
				(gGSound2 number: 295 loop: 0 play: setVol: 127)
				(client setCycle: CT 7 1 self)
			)
			(5
				(gGSound2 play:)
				(client setCycle: End self)
			)
			(6
				(client loop: 2 cel: 0 setSpeed: 6 setCycle: End self)
			)
			(7
				(= ticks 30)
			)
			(8
				(gGame points: 5 447)
				(gEgo normalize: 1 put: 110 get: 111) ; Whisk_Broom, Whisk_Broom_Full
				((gInventory at: 111) select: 0 1) ; Whisk_Broom_Full
				(= global121 (gTheIconBar curIcon:))
				(gMessager say: 11 70 4 0 self) ; "You quite cleverly whisk the cubed culprit into your dustpan. It's going to be tough to carry him this way, though."
			)
			(9
				((ScriptID 0 9) setReal: (ScriptID 0 9) 120) ; reformTimer, reformTimer
				(ClearFlag 16)
				(SetFlag 21)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance rogerFreezes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(endroid setScript: 0)
				(meltTimer client: 0 delete: dispose:)
				(client
					view: 2941
					loop: 0
					cel: 0
					setSpeed: 6
					setCycle: CT 4 1 self
				)
			)
			(1
				(endroid hide:)
				(client setCycle: End self)
			)
			(2
				(endroid show:)
				(client loop: 1 cel: 0 setCycle: End self)
			)
			(3
				(gMessager say: 11 4 4 0 self) ; "Oh, not real smart."
			)
			(4
				(EgoDead 24 self) ; "Don't you just hate it when that happens?"
			)
			(5
				(meltTimer setReal: meltTimer 30)
				(endroid show:)
				(gEgo posn: 241 120 normalize: 5)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance rogAvoidsRight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setMotion: PolyPath 240 115 self)
			)
			(1
				(Face gEgo endroid self)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance rogAvoidsLeft of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setMotion: PolyPath 104 118 self)
			)
			(1
				(Face gEgo endroid self)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance endroidFixes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setLoop: 1 1 cel: 0 setCycle: CT 3 1 self)
			)
			(1
				(= ticks (RandomNumber 20 45))
			)
			(2
				(if (gTalkers isEmpty:)
					(ratchet play: setVol: 127)
				)
				(client setCycle: End self)
			)
			(3
				(client loop: 2 cel: 0 setCycle: Fwd)
				(= ticks (RandomNumber 60 180))
			)
			(4
				(ratchet stop:)
				(client loop: 3 cel: 0 setCycle: End self)
			)
			(5
				(= ticks (RandomNumber 120 210))
			)
			(6
				(= state -1)
				(= ticks 1)
			)
		)
	)

	(method (dispose)
		(gGSound2 stop:)
		(super dispose: &rest)
	)
)

(instance endroidCrumbles of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client
					view: 2942
					loop: 0
					cel: 0
					posn: 154 130
					setSpeed: 8
					setCycle: CT 16 1 self
				)
			)
			(1
				(rogBreaksEndroid register: 1)
				(client setCycle: End self)
			)
			(2
				(client setSpeed: 6)
				(mergeTimer setReal: mergeTimer 30)
				(= local1 0)
				(SetFlag 16)
				(gMessager say: 11 154) ; "Cool. Laying a solid blow upside the head of this frigid felon has reduced him to cubes. He's not too hard to handle now."
				(self dispose:)
			)
		)
	)
)

(instance endroidAnnoyed of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 1)
				(gGame handsOff:)
				(gEgo setMotion: 0)
				(endroid
					view: 297
					setLoop: 4 1
					cel: 0
					posn: 156 132
					setCycle: End self
				)
			)
			(1
				(self setScript: endroidKills self (localproc_0))
			)
			(2
				(gMessager say: 0 0 10 0 self) ; "Yeah, that is great improvement. Look much better now."
			)
			(3
				(EgoDead 4 self) ; "I'm not going to say he told you so, but he did."
			)
			(4
				(killTimer setReal: killTimer 30)
				(client
					view: 297
					loop: 1
					cel: 0
					posn: 172 132
					setScript: endroidFixes
				)
				(gEgo show: posn: 241 120 normalize: 5)
				(= local0 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance endroidKills of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (== register 1)
					(= temp0 (+ (gEgo x:) 30))
					(= temp1 (+ (gEgo y:) 1))
				else
					(= temp0 (- (gEgo x:) 30))
					(= temp1 (+ (gEgo y:) 1))
				)
				(endroid
					view: 298
					loop: (if (== register 1) 1 else 0)
					cel: 0
					setCycle: StopWalk -1
					setLooper: Grooper
					setMotion: PolyPath temp0 temp1 self
				)
			)
			(1
				(gEgo setHeading: (if (== register 1) 90 else 270) self)
				(endroid loop: 4 cel: (if (== register 1) 1 else 0))
			)
			(2
				(if (and client (== client talkToEndroid))
					(gMessager say: 11 2 8 3 self) ; "My, you're a tall one. Uh, is there something I can do for you?"
				else
					(= ticks 30)
				)
			)
			(3
				(if (gTalkers isEmpty:)
					(Load 140 291) ; WAVE
					(= cycles 10)
				else
					(-- state)
					(= ticks 5)
				)
			)
			(4
				(gEgo hide:)
				(endroid
					view: 296
					loop: (if (== register 1) 1 else 0)
					cel: 0
					posn: (gEgo x:) (+ (gEgo y:) 1)
					setLooper:
					setCycle: CT 3 1 self
				)
			)
			(5
				(gGSound2 number: 291 loop: 0 play: setVol: 127)
				(endroid setCycle: End self)
			)
			(6
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance endroidMelts of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(cond
					((<= 104 (gEgo x:) 172)
						(gEgo setScript: rogAvoidsLeft)
					)
					((< 172 (gEgo x:) 240)
						(gEgo setScript: rogAvoidsRight)
					)
					(else
						(gEgo setMotion: 0)
					)
				)
				(client view: 2920 loop: 1 cel: 0 setCycle: End self)
			)
			(1
				(gMessager say: 11 0 6 1 self) ; "Bummer. It looks like your friend has reconstituted. This could be a painful development."
			)
			(2
				(Load rsVIEW 298)
				(gMessager say: 11 0 6 2) ; "Yes, it looks like he's going to beat the ..."
				(self setScript: endroidKills self (localproc_0))
			)
			(3
				(gMessager say: 11 0 6 3 self) ; "Yep, he sure did. Boy, that's gotta hurt."
			)
			(4
				(EgoDead 4 self) ; "I'm not going to say he told you so, but he did."
			)
			(5
				(meltTimer setReal: meltTimer 30)
				(client view: 2920 setLoop: 0 cel: 0 posn: 154 130)
				(gEgo show: posn: 241 120 normalize: 5)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance endroidMerges of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load 140 2901) ; WAVE
				(cond
					((<= 104 (gEgo x:) 172)
						(gEgo setScript: rogAvoidsLeft)
					)
					((< 172 (gEgo x:) 240)
						(gEgo setScript: rogAvoidsRight)
					)
					(else
						(gEgo setMotion: 0)
					)
				)
				(client view: 2942 loop: 1 cel: 0 setCycle: End self)
			)
			(1
				(gGSound2 number: 2901 loop: 0 play: setVol: 127)
				(client
					view: 295
					loop: 0
					cel: 0
					posn: 146 133
					setCycle: End self
				)
			)
			(2
				(gMessager say: 11 0 6 1 self) ; "Bummer. It looks like your friend has reconstituted. This could be a painful development."
			)
			(3
				(client loop: 1 cel: 0 setCycle: End self)
			)
			(4
				(Load rsVIEW 298)
				(gMessager say: 11 0 6 2) ; "Yes, it looks like he's going to beat the ..."
				(self setScript: endroidKills self (localproc_0))
			)
			(5
				(gMessager say: 11 0 6 3 self) ; "Yep, he sure did. Boy, that's gotta hurt."
			)
			(6
				(EgoDead 4 self) ; "I'm not going to say he told you so, but he did."
			)
			(7
				(mergeTimer setReal: mergeTimer 30)
				(client view: 2942 loop: 0 cel: (client lastCel:) posn: 154 130)
				(gEgo show: posn: 241 120 normalize: 5)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance talkToEndroid of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 1)
				(gGame handsOff:)
				(cond
					((<= 104 (gEgo x:) 172)
						(gEgo setScript: rogAvoidsLeft self)
					)
					((< 172 (gEgo x:) 240)
						(gEgo setScript: rogAvoidsRight self)
					)
					(else
						(gEgo setMotion: 0)
						(= cycles 2)
					)
				)
			)
			(1
				(Face gEgo endroid self)
			)
			(2
				(gMessager say: 11 2 8 1 self) ; "Hey, there. So, what's up? Pretty crappy weather we're having, don't you think?"
			)
			(3
				(endroid
					view: 297
					setLoop: 4 1
					cel: 0
					posn: 156 132
					setCycle: End self
				)
			)
			(4
				(gMessager say: 11 2 8 2 self) ; "Wow, so what's with the hole in your arm? That's ah, that's gotta sting."
			)
			(5
				(self setScript: endroidKills self (localproc_0))
			)
			(6
				(gMessager sayRange: 11 2 8 4 5 self) ; "He's apparently a social minimalist. His only reaction is the kind of look that makes you want to run to the safety of your closet and assume your all-too-familiar fetal position."
			)
			(7
				(EgoDead 4 self) ; "I'm not going to say he told you so, but he did."
			)
			(8
				(killTimer setReal: killTimer 30)
				(client
					view: 297
					loop: 1
					cel: 0
					posn: 172 132
					setScript: endroidFixes
				)
				(gEgo show: posn: 241 120 normalize: 5)
				(= local0 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance endroid of Actor
	(properties
		noun 11
		x 172
		y 132
		view 297
		loop 1
		xStep 5
	)

	(method (init)
		(|= signal $1000)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(cond
					(local1
						(gMessager say: noun 1 4) ; "The endodroid is frozen quite solid."
					)
					((IsFlag 16)
						(gMessager say: noun 1 5) ; "The endodroid is broken into nice little cube-sized pieces."
					)
					(else
						(gMessager say: noun 1 0) ; "It's the endodroid -- and he's repairing himself. Yuck!"
					)
				)
			)
			(4 ; Do
				(cond
					(local1
						(gEgo setScript: rogerFreezes)
					)
					((IsFlag 16)
						(super doVerb: theVerb &rest)
					)
					(else
						(self setScript: endroidAnnoyed)
					)
				)
			)
			(154 ; Pipe
				(cond
					(local1
						(gEgo setScript: rogBreaksEndroid)
					)
					((IsFlag 16)
						(super doVerb: theVerb &rest)
					)
					(else
						(self setScript: endroidAnnoyed)
					)
				)
			)
			(70 ; Whisk_Broom
				(cond
					(local1
						(super doVerb: theVerb &rest)
					)
					((IsFlag 16)
						(gEgo setScript: rogSweepsUp)
					)
					(else
						(self setScript: endroidAnnoyed)
					)
				)
			)
			(2 ; Talk
				(cond
					(local1
						(super doVerb: theVerb &rest)
					)
					((IsFlag 16)
						(super doVerb: theVerb &rest)
					)
					(else
						(self setScript: talkToEndroid)
					)
				)
			)
			(else
				(cond
					(local1
						(super doVerb: theVerb &rest)
					)
					((IsFlag 16)
						(super doVerb: theVerb &rest)
					)
					(else
						(self setScript: endroidAnnoyed)
					)
				)
			)
		)
		(if (and (CueObj client:) (== (CueObj client:) self))
			(CueObj client: 0)
		)
	)
)

(instance nitroStream of Prop
	(properties
		x 160
		y 49
		view 292
	)
)

(instance breath of Prop
	(properties
		x 429
		y 58
		fixPriority 1
		view 291
		cycleSpeed 8
	)
)

(instance pipe of View
	(properties
		noun 10
		approachX 378
		approachY 132
		x 409
		y 133
		view 2900
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (and (not (gEgo has: 80)) (not (IsFlag 16))) ; Pipe
					(gEgo setScript: pickUpPipe)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance tools of View
	(properties
		noun 13
		x 182
		y 120
		priority 122
		fixPriority 1
		view 2920
		cel 2
	)

	(method (init)
		(if local1
			(= cel 2)
		else
			(= cel 3)
		)
		(super init: &rest)
	)
)

(instance killRange of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 136 114 125 125 139 136 181 136 181 114
					yourself:
				)
		)
	)
)

(instance floor of Feature
	(properties
		noun 5
		sightAngle 40
		x 192
		y 20
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 65 104 67 125 82 130 82 137 226 138 225 115 368 115 368 137 418 137 419 129 429 126 398 118 413 107 378 107 377 101 216 108 181 108 180 104 116 103 112 108
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance ceiling of Feature
	(properties
		noun 6
		sightAngle 40
		x 171
		y 5
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 21 0 319 0 319 7 22 7 yourself:)
				((Polygon new:) type: PTotalAccess init: 367 0 367 7 450 7 450 0 yourself:)
		)
		(super init: &rest)
	)
)

(instance baseWindow of Feature
	(properties
		noun 14
		sightAngle 40
		x 288
		y 34
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 269 25 289 25 293 30 299 32 308 32 308 42 269 43
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance stairs of Feature
	(properties
		noun 4
		sightAngle 40
		x 438
		y 50
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 447 82 479 82 479 91 479 126 429 126 399 117 398 110 409 110 410 105 418 104 418 98 427 97 427 90 441 90 441 83
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance bottle1 of Feature
	(properties
		noun 12
		sightAngle 40
		x 410
		y 130
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 445 91 478 90 478 118 454 119 436 113 435 101 442 101
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance bottle2 of Feature
	(properties
		noun 12
		sightAngle 40
		x 280
		y 135
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 244 98 319 98 319 138 226 138 224 133 225 114 242 114
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance bottle3 of Feature
	(properties
		noun 12
		sightAngle 40
		x 70
		y 135
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 20 93 55 93 64 103 64 114 48 121 21 120
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance crate1 of Feature
	(properties
		noun 3
		sightAngle 40
		x 400
		y 80
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 396 51 424 51 424 107 379 106 379 69 393 69
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance crate2 of Feature
	(properties
		noun 3
		sightAngle 40
		x 305
		y 80
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 299 57 319 57 320 96 290 96 289 75 298 75
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance crate3 of Feature
	(properties
		noun 3
		sightAngle 40
		x 200
		y 80
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 187 58 214 58 214 105 180 105 180 76 187 74
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance crate4 of Feature
	(properties
		noun 8
		sightAngle 40
		x 400
		y 130
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 434 114 434 123 419 128 419 137 479 137 479 119 452 119
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance crate5 of Feature
	(properties
		noun 8
		sightAngle 40
		x 90
		y 130
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 68 115 67 125 82 130 82 137 21 137 21 122 51 122
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance light of Feature
	(properties
		noun 7
		sightAngle 40
		x 191
		y 90
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 190 45 178 54 204 54 yourself:)
		)
		(super init: &rest)
	)
)

(instance kegs of Feature
	(properties
		noun 18
		sightAngle 40
		x 253
		y 50
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 219 90 289 90 288 106 217 107
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance openConduit of Feature
	(properties
		noun 9
		sightAngle 40
		x 178
		y 33
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 172 17 172 47 169 50 188 50 186 47 186 17
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 205 17 205 50 202 54 220 54 217 50 217 17
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance seat of Feature
	(properties
		noun 3
		sightAngle 40
		x 158
		y 119
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 141 119 155 112 175 112 175 120 159 127 141 127
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance toolsCrate of Feature
	(properties
		noun 3
		sightAngle 40
		x 195
		y 116
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 180 128 209 128 211 113 206 105 182 105 180 113
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance exit300 of ExitFeature
	(properties
		sightAngle 40
		approachX 417
		approachY 125
		x 430
		y 40
		nextRoom 300
		message 5
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 452 0 479 0 479 80 452 80
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Exit
				(gEgo setScript: sLeaveRoom)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(class Vermin of Actor
	(properties
		fwdLoop -1
		bkLoop -1
		startX 0
		startY 0
		stopX 0
		stopY 0
	)

	(method (init)
		(self posn: startX startY ignoreActors: 1)
		(super init: &rest)
	)
)

(class rm290Code of Code
	(properties
		theInc 0
		l 0
		t 0
		r 0
		b 0
		bLoop -2
	)
)

(instance scrollCode of rm290Code
	(properties)

	(method (doit)
		(= l ((gCurRoom plane:) left:))
		(= t ((gCurRoom plane:) top:))
		(= r ((gCurRoom plane:) right:))
		(= b ((gCurRoom plane:) bottom:))
		(= theInc (gEgo xStep:))
		(if
			(and
				(> (+ (gEgo x:) l) 220)
				(> r 325)
				(gEgo mover:)
				(> (gEgo x:) ((gEgo mover:) xLast:))
			)
			((gCurRoom plane:) setRect: (- l theInc) t (- r theInc) b)
			(UpdatePlane (gCurRoom plane:))
		)
		(if
			(and
				(< (+ (gEgo x:) l) 100)
				(< l -5)
				(gEgo mover:)
				(< (gEgo x:) ((gEgo mover:) xLast:))
			)
			((gCurRoom plane:) setRect: (+ l theInc) t (+ r theInc) b)
			(UpdatePlane (gCurRoom plane:))
		)
		(self updateBreath:)
	)

	(method (updateBreath)
		(= bLoop
			(cond
				((not (gEgo isNotHidden:)) -1)
				(
					(and
						(gEgo cycler:)
						(not
							(or
								((gEgo cycler:) isMemberOf: Walk)
								((gEgo cycler:) isMemberOf: StopWalk)
							)
						)
					)
					-1
				)
				((and (gEgo script:) (== (gEgo script:) rogerFreezes)) -1)
				(else
					(switch (gEgo loop:)
						(0 0)
						(6 0)
						(4 0)
						(1 1)
						(7 1)
						(5 1)
						(3 -1)
						(2 -1)
					)
				)
			)
		)
		(cond
			((== bLoop -1)
				(if (breath isNotHidden:)
					(breath hide:)
				)
			)
			((not (breath isNotHidden:))
				(breath loop: bLoop)
				(breath show:)
			)
		)
		(if (== bLoop 0)
			(breath
				x: (+ (gEgo x:) 8)
				y: (+ (gEgo y:) -50)
				priority: (gEgo priority:)
			)
		)
		(if (== bLoop 1)
			(breath
				x: (- (gEgo x:) 8)
				y: (+ (gEgo y:) -50)
				priority: (gEgo priority:)
			)
		)
	)
)

(instance spider1 of Vermin
	(properties
		noun 16
		priority 143
		fixPriority 1
		view 290
		loop 2
		fwdLoop 3
		bkLoop 2
		startX 330
		startY 124
		stopX 238
		stopY 124
	)
)

(instance spider2 of Vermin
	(properties
		noun 16
		priority 143
		fixPriority 1
		view 290
		loop 2
		fwdLoop 4
		bkLoop 5
		startX 23
		startY 145
		stopX 23
		stopY -15
	)
)

(instance spider3 of Vermin
	(properties
		noun 16
		priority 39
		fixPriority 1
		view 290
		loop 6
		fwdLoop 6
		bkLoop 7
		startX 25
		startY 39
		stopX 47
		stopY 39
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(self setScript: fallinSpidey)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance rat of Vermin
	(properties
		noun 17
		priority 113
		fixPriority 1
		view 290
		fwdLoop 0
		bkLoop 1
		startY 113
		stopX 274
		stopY 113
	)
)

(instance CrawlTo of MoveTo ; UNUSED
	(properties)

	(method (doit)
		(if (client isBlocked:)
			(self moveDone:)
		)
		(super doit: &rest)
	)
)

(instance killTimer of Timer
	(properties)

	(method (cue)
		(cond
			(
				(or
					(gEgo script:)
					(not (gTalkers isEmpty:))
					(and (CueObj client:) (== (CueObj client:) endroid))
				)
				(self setTicks: self 20)
			)
			(
				(or
					(not (endroid script:))
					(and
						(endroid script:)
						(!= (endroid script:) endroidAnnoyed)
						(!= (endroid script:) talkToEndroid)
					)
				)
				(endroid setScript: endroidAnnoyed 0 (localproc_0))
			)
		)
	)
)

(instance meltTimer of Timer
	(properties)

	(method (cue)
		(if
			(or
				(gEgo script:)
				(not (gTalkers isEmpty:))
				(and (CueObj client:) (== (CueObj client:) endroid))
			)
			(self setTicks: self 20)
		else
			(endroid setScript: endroidMelts 0 (localproc_0))
		)
	)
)

(instance mergeTimer of Timer
	(properties)

	(method (cue)
		(if
			(or
				(gEgo script:)
				(not (gTalkers isEmpty:))
				(and (CueObj client:) (== (CueObj client:) endroid))
			)
			(self setTicks: self 20)
		else
			(endroid setScript: endroidMerges 0 (localproc_0))
		)
	)
)

(instance squeak of Sound
	(properties
		number 298
		loop 0
	)
)

(instance ratchet of Sound
	(properties
		number 297
		loop -1
	)
)

(instance Endodroid of SmallTalker
	(properties
		showTalk 0
	)

	(method (init)
		(= client endroid)
		(super init: &rest)
	)
)

