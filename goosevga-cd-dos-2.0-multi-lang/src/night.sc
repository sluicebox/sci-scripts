;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 104)
(include sci.sh)
(use Main)
(use n098)
(use Wander)
(use Jump)
(use Motion)
(use Game)
(use Menu)
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
	local4
)

(procedure (localproc_0 param1)
	(param1 signal: (& (| (param1 signal:) $0100) $fffd) stopUpd:)
	(= local3 0)
	(bedroom seconds: 20)
	(gGame setCursor: 901 1)
)

(procedure (localproc_1 param1 param2 &tmp temp0 temp1)
	(= temp0 (proc0_18 param1 param2))
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
		(super init:)
		(TheMenuBar state: 0)
		(= global104 0)
		(= global107 1)
		(child view: (+ 850 global114))
		(eyes view: (child view:))
		(proc0_12 0)
		(if (== (mod global114 2) 0)
			(= local1 1)
			(= picture 50)
			(self drawPic: picture)
			(child posn: 73 128 init:)
			(eyes posn: 83 103 init: setScript: blink)
			(drawer view: 870 loop: 6 cel: 0 posn: 5 188 init: hide:)
			(deskTop
				view: 871
				loop: 2
				posn: 20 137
				setStep: 1 1
				cycleSpeed: 1
				moveSpeed: 1
				init:
			)
			(painting view: 871 loop: 5 posn: 40 76 init:)
			(photo view: 871 loop: 4 posn: 252 80 init:)
			(book posn: 277 114 init:)
			(train view: 870 loop: 3 cel: 13 posn: 220 166 init:)
			(ball init:)
			(mitt init:)
		else
			(gCurRoom overlay: 52)
			(child posn: 77 127 init:)
			(eyes posn: 84 102 init: setScript: blink)
			(drawer posn: 1 189 init: hide:)
			(deskTop init:)
			(painting init:)
			(photo init:)
			(book view: 891 loop: 2 posn: 276 116 init:)
			(doll init:)
			(shoes init:)
		)
		(self setScript: bedroom)
		(Animate (gCast elements:) 1)
		(for ((= temp0 0)) (<= temp0 100) ((+= temp0 8))
			(Palette palSET_INTENSITY 0 255 temp0)
			(Wait 2)
		)
		(proc0_2)
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
				(gGame setCursor: 901 1)
				(= seconds 10)
			)
			(2
				(if local3
					(= state 1)
					(= seconds 10)
				else
					(closeDoor register: 1)
					(gCurRoom setScript: closeDoor)
				)
			)
		)
	)
)

(instance closeDoor of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(DoAudio audWPLAY 47)
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
				(gGame setCursor: 69 1)
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
				(DoAudio audRATE 22000)
				(Timer set60ths: self (/ (DoAudio audPLAY 47) 2))
			)
			(2)
			(3
				(DoAudio audRATE 11000)
				(Timer set60ths: self (DoAudio audPLAY 478))
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
				(eyes dispose:)
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
				(Timer set60ths: self (DoAudio audPLAY 479))
			)
			(7
				(Load rsVIEW (+ global114 21))
				(Load rsVIEW 865)
				(Load rsPIC 800)
				(Load rsSOUND 1)
				(DoAudio audWPLAY 588)
				(= seconds 2)
			)
			(8
				(DoAudio audPLAY 588)
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
				(= cycles 65)
			)
			(10
				(train dispose:)
				(gAddToPics eachElementDo: #dispose release:)
				(SetPort 0 0 200 320 0 0)
				(night picture: 800 drawPic: 800 18)
				(= cycles 1)
			)
			(11
				(gLongSong number: 1 loop: -1 vol: 127 play: priority: 0)
			)
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

	(method (handleEvent event)
		(if (and (localproc_1 self event) (not cel))
			(gCurRoom setScript: closeDoor)
		)
	)
)

(instance painting of Prop
	(properties
		y 64
		x 42
		view 891
		loop 1
		signal 26625
		cycleSpeed 2
	)

	(method (handleEvent event)
		(if (localproc_1 self event)
			(gGame setCursor: 69 1)
			(&= signal $feff)
			(= local3 1)
			(self setCycle: Fwd)
			(Timer
				set60ths:
					self
					(if local1
						(DoAudio audPLAY 579)
					else
						(DoAudio audPLAY 592)
					)
			)
		)
	)

	(method (cue)
		(if cel
			(self setCycle: CT 0 1 self)
		else
			(DoAudio audSTOP)
			(localproc_0 self)
		)
	)
)

(instance drawer of Prop
	(properties
		view 891
		priority 11
		signal 26640
		cycleSpeed 1
	)

	(method (handleEvent event)
		(if (localproc_1 self event)
			(self setScript: moveDrawer)
		)
	)
)

(instance deskTop of Act
	(properties
		y 145
		x 21
		view 890
		loop 4
		signal 24833
		cycleSpeed 2
		illegalBits 2
	)

	(method (handleEvent event)
		(if (localproc_1 self event)
			(gGame setCursor: 69 1)
			(&= signal $feff)
			(= local3 1)
			(if local1
				(self setScript: topScript)
			else
				(self setCycle: End self)
			)
		)
	)

	(method (cue)
		(if cel
			(DoAudio audPLAY 584)
			(self setCycle: Beg self)
		else
			(localproc_0 self)
		)
	)
)

(instance train of Prop
	(properties
		signal 26881
		cycleSpeed 3
	)

	(method (handleEvent event)
		(if (localproc_1 self event)
			(= local3 1)
			(gGame setCursor: 69 1)
			(&= signal $feff)
			(self setScript: trainScript)
		)
	)
)

(instance photo of Prop
	(properties
		y 82
		x 252
		view 891
		loop 3
		signal 26897
	)

	(method (handleEvent event)
		(if (localproc_1 self event)
			(gGame setCursor: 69 1)
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
				(DoAudio audPLAY 586)
				(client setCycle: CT 6 1 self)
			)
			(1
				(DoAudio audPLAY 587)
				(client setCycle: End self)
			)
			(2
				(localproc_0 client)
				(self dispose:)
			)
			(3
				(DoAudio audPLAY (Random 19 22))
				(client setCycle: End self)
			)
			(4
				(DoAudio audPLAY (Random 19 22))
				(client setCycle: Beg self)
				(= state 1)
			)
		)
	)
)

(instance door of Prop
	(properties
		y 141
		x 295
		view 892
		signal 26624
		cycleSpeed 1
	)
)

(instance child of View
	(properties
		signal 26881
	)
)

(instance eyes of Prop
	(properties
		loop 1
		priority 14
		signal 26640
	)
)

(instance mouth of Prop ; UNUSED
	(properties
		priority 14
		signal 16
	)
)

(instance trainScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(DoAudio audPLAY 41)
				(client setCycle: End self)
			)
			(1
				(DoAudio audSTOP)
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
				(DoAudio audPLAY 589)
				(= seconds 5)
			)
			(1
				(client loop: 2 setMotion: 0 setScript: 0)
				(DoAudio audSTOP)
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
				(= local3 1)
				(gGame setCursor: 69 1)
				(if local1
					(DoAudio audPLAY 585)
					(drawer show: setCycle: End)
					(= cycles 10)
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
						setCycle: End self
					)
				else
					(Timer set60ths: self (DoAudio audPLAY 593))
					(++ state)
				)
			)
			(2
				(register setCycle: Beg self)
			)
			(3
				(if local1
					(= cycles 2)
				else
					(++ state)
				)
				(drawer setCycle: Beg self)
			)
			(4
				(register dispose:)
			)
			(5
				(drawer hide:)
				(bedroom seconds: 20)
				(= local3 0)
				(gGame setCursor: 901 1)
				(client setScript: 0)
			)
		)
	)
)

(instance ball of Act
	(properties
		y 91
		x 238
		view 870
		priority 14
		signal 26897
	)

	(method (handleEvent event)
		(if (localproc_1 self event)
			(&= signal $feff)
			(gGame setCursor: 69 1)
			(mitt setScript: catchBall)
		)
	)
)

(instance mitt of Act
	(properties
		y 137
		x 245
		view 870
		loop 1
		priority 4
		signal 26897
		cycleSpeed 2
		illegalBits 0
	)

	(method (handleEvent event)
		(if (localproc_1 self event)
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
				(gGame setCursor: 69 1)
				(client
					signal: (& (client signal:) $feff)
					startUpd:
					setCycle: End self
				)
			)
			(1
				(if register
					(DoAudio audPLAY (Random 19 22))
					(-- register)
				)
				(client setCycle: Beg self)
			)
			(2
				(self dispose:)
				(localproc_0 client)
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
				(gGame setCursor: 69 1)
				(client
					signal: (& (client signal:) $feff)
					startUpd:
					setCycle: CT 1 -1 self
				)
			)
			(1
				(client setCycle: End self)
			)
			(2
				(self dispose:)
				(localproc_0 client)
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
				(DoAudio audWPLAY 42)
				(= cycles 6)
			)
			(1
				(mitt setLoop: 2 cel: 0 setCycle: End self)
			)
			(2
				(DoAudio audPLAY 42)
				(ball dispose:)
			)
			(3
				(mitt setMotion: MoveTo 245 137 self)
			)
			(4
				(client setScript: 0)
				(localproc_0 client)
			)
		)
	)
)

(instance blink of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(eyes cel: 0 setCycle: End self)
			)
			(1
				(eyes setCycle: Beg)
				(= state -1)
				(= seconds (Random 3 5))
			)
		)
	)
)

(instance doll of Act
	(properties
		y 142
		x 243
		view 890
		signal 26881
		cycleSpeed 2
	)

	(method (handleEvent event)
		(if (localproc_1 self event)
			(&= signal $feff)
			(gGame setCursor: 69 1)
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
				(= cycles 22)
			)
			(1
				(Timer set60ths: self (DoAudio audPLAY 582))
				(doll setLoop: 2 setCel: 0 setCycle: End self)
			)
			(2
				(doll setLoop: 1 setCel: 0 setCycle: Fwd)
			)
			(3
				(doll setLoop: 0 setCel: 255 setCycle: Beg self)
			)
			(4
				(localproc_0 doll)
				(DoAudio audSTOP)
				(self dispose:)
			)
		)
	)
)

(instance shoes of Prop
	(properties
		y 182
		x 110
		view 890
		loop 3
		signal 26625
		cycleSpeed 2
	)

	(method (handleEvent event)
		(if (localproc_1 self event)
			(&= signal $feff)
			(gGame setCursor: 69 1)
			(self setScript: chacha)
		)
	)
)

(instance chacha of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local3 1)
				(Timer set60ths: self (- (DoAudio audPLAY 578) 40))
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
		y 120
		x 125
		view 865
		signal 26672
		cycleSpeed 4
	)
)

(instance gooseRider of Act
	(properties
		y 98
		x 53
		signal 26640
		cycleSpeed 3
		illegalBits 0
		xStep 1
	)
)

