;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 104)
(include sci.sh)
(use Main)
(use n098)
(use Interface)
(use Feature)
(use Wander)
(use Timer)
(use Jump)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	night 0
)

(local
	local0
	local1
	local2
	local3
)

(procedure (localproc_0 param1)
	(param1 signal: (& (| (param1 signal:) $0100) $fffd) stopUpd:)
	(= local3 0)
	(bedroom seconds: 20)
	(gGame setCursor: global75 1)
)

(procedure (localproc_1 param1 param2 &tmp temp0 temp1) ; UNUSED
	(= temp0 (proc255_5 param1 param2))
	(= temp1 local3)
	(= local3 (or temp0 local3))
	(if
		(= temp0
			(if temp0
				(not temp1)
			)
		)
		(param2 claimed: 1)
	)
	(return temp0)
)

(instance night of Rm
	(properties
		picture 52
		style 0
	)

	(method (init &tmp temp0)
		(= global340 0)
		(= global104 0)
		(= global107 1)
		(gGame setCursor: 8 1)
		(child view: (+ 850 global114))
		(childEyes view: (child view:))
		(proc0_12 0)
		(if (== (mod global114 2) 0)
			(= local1 1)
			(= picture 50)
			(self drawPic: picture)
			(child posn: 73 128 init:)
			(childEyes posn: 83 103 init: setScript: blink)
			(drawerF init:)
			(drawer view: 870 loop: 6 cel: 0 posn: 5 188 init: hide:)
			(deskTop
				view: 871
				loop: 2
				posn: 20 137
				setStep: 1 1
				cycleSpeed: 3
				init:
			)
			(painting view: 871 loop: 5 posn: 40 76 init:)
			(photo view: 871 loop: 4 posn: 252 80 init:)
			(book posn: 277 114 init:)
			(train view: 870 loop: 3 cel: 13 posn: 220 166 init:)
			(ball init:)
			(mitt init:)
		else
			(self drawPic: picture)
			(child posn: 77 127 init:)
			(childEyes posn: 84 102 init: setScript: blink)
			(drawerF init:)
			(drawer posn: 1 189 init: hide:)
			(deskTop init:)
			(painting init:)
			(photo init:)
			(book view: 891 loop: 2 posn: 276 116 init:)
			(doll init:)
			(shoes init:)
		)
		(super init:)
		(gKeyDownHandler add: self)
		(self setScript: bedroom)
		(Animate (gCast elements:) 1)
		(for ((= temp0 0)) (<= temp0 100) ((+= temp0 8))
			(Palette palSET_INTENSITY 0 255 temp0)
			(Wait 1)
		)
		(proc0_3)
	)

	(method (handleEvent event)
		(if (== (event type:) evMOUSEBUTTON)
			(bedroom seconds: 20)
		)
		(if (and (== (event type:) evKEYBOARD) (== (event message:) KEY_ESCAPE))
			(gCast eachElementDo: #dispose)
			(for ((= global108 100)) (>= global108 0) ((-= global108 8))
				(Palette palSET_INTENSITY 0 255 global108)
				(Wait 2)
			)
			(gSfx stop:)
			(DoAudio audSTOP)
			(Animate (gCast elements:) 0)
			(script dispose:)
			(gLongSong play:)
			(proc98_1)
			(DisposeScript 98)
			(event claimed: 1)
		)
	)

	(method (dispose)
		(if (gTimers size:)
			(gTimers eachElementDo: #dispose)
			(gTimers eachElementDo: #delete)
		)
		(= global104 0)
		(= global107 0)
		(DoAudio audRATE 11000)
		(DisposeScript 991)
		(gKeyDownHandler delete: self)
		(super dispose:)
	)
)

(instance bedroom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(gGame setCursor: global75 1)
				(= cycles 2)
			)
			(2
				(if (HaveMouse)
					(= seconds 10)
				else
					(= seconds 20)
				)
			)
			(3
				(if local3
					(= state 1)
					(= seconds 10)
				else
					(Load rsPIC (if local1 51 else 53))
					(Load rsVIEW (if local1 872 else 892))
					(= global343 2)
					(Printf 900 478) ; "It's time to go to sleep now!"
					(= global343 0)
					(= cycles 1)
				)
			)
			(4
				(closeDoor register: 1)
				(gCurRoom setScript: closeDoor)
			)
		)
	)
)

(instance closeDoor of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(if global157
					(DoAudio audWPLAY 47)
				)
				(= local3 1)
				(painting dispose:)
				(drawer dispose:)
				(deskTop addToPic:)
				(photo addToPic:)
				(if local1
					(train addToPic:)
				else
					(doll addToPic:)
					(shoes addToPic:)
				)
				(= global104 1)
				(gGame setCursor: 7 1)
				(= cycles 1)
				(if register
					(+= state 2)
				else
					(book
						signal: (& (book signal:) $feff)
						view: 880
						loop: 2
						setCycle: End self
					)
				)
			)
			(1
				(if global157
					(DoAudio audRATE 22000)
					(Timer set60ths: self (/ (DoAudio audPLAY 47) 2))
				else
					(gSfx number: 47 play: self)
				)
			)
			(2)
			(3
				(if global157
					(DoAudio audRATE 11000)
					(Timer set60ths: self (DoAudio audPLAY 478))
				else
					(= cycles 1)
				)
				(book stopUpd:)
			)
			(4
				(night drawPic: (if local1 51 else 53))
				(Graph grFILL_BOX 189 0 200 320 1 0 0 0)
				(Graph grFILL_BOX 0 319 200 320 1 0 0 0)
				(book dispose:)
				(if local1
					(deskTop view: 872)
					(photo view: 872)
					(train view: 872 loop: 3 addToPic:)
					(if (mitt cel:)
						(mitt loop: 6)
					else
						(ball view: 872 loop: 7 addToPic:)
						(mitt loop: 5)
					)
					(mitt view: 872 addToPic:)
					(door view: 872 posn: 318 156)
				else
					(deskTop view: 892)
					(photo view: 892)
					(doll view: 892 setLoop: 2 addToPic:)
					(shoes view: 892 setLoop: 3 addToPic:)
				)
				(deskTop loop: 4 addToPic:)
				(photo loop: 1 addToPic:)
				(childEyes dispose:)
				(child posn: 76 129 setCel: 1 addToPic:)
				(door init:)
				(= local0 0)
				(= seconds 3)
			)
			(5
				(door setCycle: End self)
			)
			(6
				(door addToPic:)
				(= cycles 1)
			)
			(7
				(Load rsVIEW (+ global114 21))
				(Load rsVIEW 865)
				(Load rsPIC 800)
				(Load rsSOUND 600)
				(= seconds 2)
			)
			(8
				(gSfx number: 588 play:)
				(dream init: setCycle: End self)
			)
			(9
				(Graph grFILL_BOX 52 76 100 80 2 0 1 0)
				(dream setPri: 1 addToPic:)
				(gooseRider
					view: (+ global114 21)
					init:
					setCycle: Fwd
					setMotion: MoveTo 220 95 self
				)
				(= ticks 65)
			)
			(10
				(train dispose:)
				(gAddToPics eachElementDo: #dispose release:)
				(SetPort 0 0 200 320 0 0)
				(night picture: 800 drawPic: 800 9)
				(= cycles 1)
			)
			(11 0)
			(12
				(SetPort 0 0 156 258 3 4)
				(= global176 0)
				(gCurRoom newRoom: 32)
			)
		)
	)
)

(instance book of Prop
	(properties
		view 870
		loop 5
		priority 14
		signal 26897
	)

	(method (doVerb)
		(if (and (not local3) (not cel))
			(gCurRoom setScript: closeDoor)
		)
	)
)

(instance painting of Prop
	(properties
		x 42
		y 64
		view 891
		loop 1
		signal 26625
		cycleSpeed 12
	)

	(method (doVerb)
		(if (not local3)
			(gGame setCursor: 7 1)
			(&= signal $feff)
			(= local3 1)
			(self setCycle: Fwd)
			(if global157
				(if local1
					(Timer set60ths: self (DoAudio audPLAY 579))
				else
					(Timer set60ths: self (DoAudio audPLAY 592))
				)
			else
				(gSfx number: (if local1 579 else 592) play: self)
			)
		)
	)

	(method (cue)
		(if cel
			(self setCycle: CT 0 1 self)
		else
			(if global157
				(DoAudio audSTOP)
			else
				(gSfx stop:)
			)
			(localproc_0 self)
		)
	)
)

(instance drawerF of Feature
	(properties
		x 10
		y 189
		onMeCheck 1024
	)

	(method (doVerb)
		(if (not local3)
			(drawer setScript: moveDrawer)
		)
	)
)

(instance drawer of Prop
	(properties
		view 891
		priority 11
		signal 26640
		cycleSpeed 8
	)
)

(instance deskTop of Actor
	(properties
		x 21
		y 145
		view 890
		loop 4
		signal 24833
		cycleSpeed 6
		illegalBits 2
		moveSpeed 8
	)

	(method (doVerb)
		(if (not local3)
			(gGame setCursor: 7 1)
			(&= signal $feff)
			(= local3 1)
			(self setScript: (if local1 topScript else sqeeze))
		)
	)
)

(instance sqeeze of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: End self)
			)
			(1
				(if global157
					(DoAudio audPLAY 584)
				else
					(gSfx number: 584 play:)
				)
				(= ticks (client cycleSpeed:))
			)
			(2
				(client setCycle: Beg self)
			)
			(3
				(localproc_0 client)
				(self dispose:)
			)
		)
	)
)

(instance train of Prop
	(properties
		onMeCheck 16384
		signal 16641
		cycleSpeed 5
	)

	(method (doVerb)
		(if (not local3)
			(= local3 1)
			(gGame setCursor: 7 1)
			(&= signal $feff)
			(self setScript: trainScript)
		)
	)
)

(instance photo of Prop
	(properties
		x 252
		y 82
		view 891
		loop 3
		signal 26881
	)

	(method (doVerb)
		(if (not local3)
			(gGame setCursor: 7 1)
			(= local3 1)
			(&= signal $feff)
			(if local1
				(photoAni start: 3)
			)
			(self setScript: photoAni)
		)
	)
)

(instance photoAni of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if global157
					(DoAudio audPLAY 586)
				else
					(gSfx number: 586 play:)
				)
				(client setCycle: CT 6 1 self)
			)
			(1
				(if global157
					(DoAudio audPLAY 587)
				else
					(gSfx number: 587 play:)
				)
				(client setCycle: End self)
			)
			(2
				(localproc_0 client)
				(self dispose:)
			)
			(3
				(if global157
					(DoAudio audPLAY (Random 19 22))
				else
					(gSfx number: 19 play:)
				)
				(client setCycle: End self)
			)
			(4
				(if global157
					(DoAudio audPLAY (Random 19 22))
				else
					(gSfx number: 19 play:)
				)
				(client setCycle: Beg self)
				(= state 1)
			)
		)
	)
)

(instance door of Prop
	(properties
		x 295
		y 141
		view 892
		signal 26624
		cycleSpeed 4
	)
)

(instance child of View
	(properties
		signal 26881
	)

	(method (handleEvent event)
		(if (== (event type:) evMOUSEBUTTON)
			(bedroom seconds: 20)
		)
		(if (and (== (event type:) evKEYBOARD) (== (event message:) KEY_ESCAPE))
			(gCast eachElementDo: #dispose)
			(Animate (gCast elements:) 0)
			(SetPort 0 0 200 320 0 0)
			(DrawPic 800 9)
			(Animate (gCast elements:) 0)
			(gLongSong number: 600 loop: -1 vol: 127 play: priority: 0)
			(SetPort 0 0 156 258 3 4)
			(= global176 0)
			(gCurRoom newRoom: 32)
			(event claimed: 1)
		)
	)
)

(instance childEyes of Prop
	(properties
		loop 1
		priority 14
		signal 26640
	)
)

(instance trainScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if global157
					(DoAudio audPLAY 41)
				else
					(gSfx number: 41 play:)
				)
				(client setCycle: End self)
			)
			(1
				(if global157
					(DoAudio audSTOP)
				else
					(gSfx stop:)
				)
				(localproc_0 client)
				(self dispose:)
			)
		)
	)
)

(instance topScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(deskTop setCycle: Walk setMotion: Wander 5)
				(if global157
					(DoAudio audPLAY 589)
				else
					(gSfx number: 589 play:)
				)
				(= seconds 5)
			)
			(1
				(client loop: 2 setMotion: 0 setScript: 0)
				(if global157
					(DoAudio audSTOP)
				else
					(gSfx stop:)
				)
				(localproc_0 deskTop)
			)
		)
	)
)

(instance moveDrawer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(= local3 1)
				(gGame setCursor: 7 1)
				(if local1
					(if global157
						(DoAudio audPLAY 585)
					else
						(gSfx number: 585 play:)
					)
					(drawer show: setCycle: CT 4 1 self)
				else
					(DoAudio audPLAY 44)
					(drawer show: setCycle: End self)
				)
			)
			(1
				(if local1
					((= register (Prop new:))
						view: 870
						loop: 7
						posn: 33 163
						init:
					)
					(drawer setCycle: End)
					(register setCycle: End self)
				else
					(if global157
						(Timer set60ths: self (DoAudio audPLAY 593))
					else
						(gSfx number: 593 play: self)
					)
					(= seconds 5)
				)
			)
			(2
				(if local1
					(register setCycle: Beg self)
				else
					(if seconds
						(= seconds 0)
					)
					(= cycles 1)
				)
			)
			(3
				(if local1
					(= cycles 2)
				else
					(++ state)
				)
				(DoAudio audPLAY 45)
				(drawer setCycle: Beg self)
			)
			(4
				(register dispose:)
			)
			(5
				(drawer hide:)
				(proc0_3)
				(bedroom seconds: 20)
				(= local3 0)
				(gGame setCursor: global75 1)
				(client setScript: 0)
			)
		)
	)
)

(instance ball of Actor
	(properties
		x 238
		y 91
		view 870
		priority 14
		signal 26897
	)

	(method (doVerb)
		(if (not local3)
			(&= signal $feff)
			(gGame setCursor: 7 1)
			(mitt setScript: catchBall)
		)
	)
)

(instance mitt of Actor
	(properties
		x 245
		y 137
		view 870
		loop 1
		priority 4
		signal 26897
		cycleSpeed 11
		illegalBits 0
	)

	(method (doVerb)
		(if (not local3)
			(self setScript: (if (== cel 0) backForth else forthBack))
		)
	)
)

(instance backForth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local3 1)
				(gGame setCursor: 7 1)
				(client
					signal: (& (client signal:) $feff)
					startUpd:
					setCycle: End self
				)
			)
			(1
				(= ticks (client cycleSpeed:))
			)
			(2
				(if global157
					(DoAudio audPLAY (Random 594 594))
				else
					(gSfx number: 594 play:)
				)
				(client setCycle: Beg self)
			)
			(3
				(localproc_0 client)
				(self dispose:)
			)
		)
	)
)

(instance forthBack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local3 1)
				(gGame setCursor: 7 1)
				(client
					signal: (& (client signal:) $feff)
					startUpd:
					setCycle: CT 1 -1 self
				)
				(if global157
					(DoAudio audPLAY (Random 594 594))
				else
					(gSfx number: 594 play:)
				)
			)
			(1
				(= ticks (client cycleSpeed:))
			)
			(2
				(client setCycle: End self)
			)
			(3
				(localproc_0 client)
				(self dispose:)
			)
		)
	)
)

(instance catchBall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local3 1)
				(Load rsVIEW 870)
				(ball
					startUpd:
					setCycle: Walk
					setLoop: 0
					setMotion: JumpTo 253 144 self
				)
				(mitt
					signal: (& (client signal:) $feff)
					startUpd:
					setLoop: 1
					setCycle: End
					ignoreActors: 1
					setMotion: MoveTo 254 152
				)
				(if global157
					(DoAudio audWPLAY 42)
				)
			)
			(1
				(mitt setLoop: 2 cel: 0 setCycle: End self)
				(= ticks (mitt cycleSpeed:))
			)
			(2
				(if global157
					(DoAudio audPLAY 42)
				else
					(gSfx number: 42 play:)
				)
				(ball dispose:)
			)
			(3
				(mitt setMotion: MoveTo 245 137 self)
			)
			(4
				(localproc_0 client)
				(self dispose:)
			)
		)
	)
)

(instance blink of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(childEyes cel: 0 setCycle: End self)
			)
			(1
				(childEyes setCycle: Beg)
				(= state -1)
				(= ticks (Random 180 300))
			)
		)
	)
)

(instance doll of Actor
	(properties
		x 243
		y 142
		view 890
		signal 26881
		cycleSpeed 6
	)

	(method (doVerb)
		(if (not local3)
			(&= signal $feff)
			(gGame setCursor: 7 1)
			(self setScript: dance)
		)
	)
)

(instance dance of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local3 1)
				(doll setCycle: End)
				(= ticks 63)
			)
			(1
				(gSfx number: 582 play: self)
				(doll setLoop: 2 setCel: 0 setCycle: End self)
			)
			(2
				(doll setLoop: 1 setCel: 0 setCycle: Fwd)
				(= seconds 8)
			)
			(3
				(if (!= seconds 0)
					(= seconds 0)
				)
				(doll setLoop: 0 setCel: 255 setCycle: Beg self)
			)
			(4
				(localproc_0 doll)
				(gSfx stop:)
				(self dispose:)
			)
		)
	)
)

(instance shoes of Prop
	(properties
		x 110
		y 182
		view 890
		loop 3
		signal 26625
		cycleSpeed 6
	)

	(method (doVerb)
		(&= signal $feff)
		(gGame setCursor: 7 1)
		(self setScript: chacha)
	)
)

(instance chacha of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local3 1)
				(if global157
					(Timer set60ths: self (- (DoAudio audPLAY 578) 40))
				else
					(gSfx number: 578 play: self)
				)
				(shoes setCycle: Fwd)
			)
			(1
				(shoes setCycle: CT 0 1 self)
			)
			(2
				(localproc_0 shoes)
				(self dispose:)
			)
		)
	)
)

(instance dream of Prop
	(properties
		x 125
		y 120
		view 865
		signal 26672
		cycleSpeed 4
	)
)

(instance gooseRider of Actor
	(properties
		x 53
		y 98
		signal 26640
		cycleSpeed 6
		illegalBits 0
		xStep 1
		moveSpeed 1
	)
)

