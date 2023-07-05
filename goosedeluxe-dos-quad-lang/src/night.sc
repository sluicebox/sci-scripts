;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 104)
(include sci.sh)
(use Main)
(use Plane)
(use Blk)
(use Feature)
(use Wander)
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

(procedure (localproc_0)
	(= local1 0)
	(bedroom seconds: 20)
	(gGame setCursor: 10 1)
)

(instance night of Room
	(properties
		picture 52
	)

	(method (init &tmp temp0)
		(= global300 0)
		(= global104 0)
		(= global107 1)
		(gGame setCursor: 8 1)
		(child view: (+ 850 global114))
		(childEyes view: (child view:))
		(gLongSong fade:)
		(switch (= temp0 global114)
			(0
				(child posn: 82 123)
				(= local2 82)
				(= local3 123)
				(childEyes posn: 84 106)
			)
			(1
				(child posn: 77 133)
				(= local2 77)
				(= local3 133)
				(childEyes posn: 82 105)
			)
			(2
				(child posn: 77 134)
				(= local2 77)
				(= local3 133)
				(childEyes posn: 81 106)
			)
			(3
				(child posn: 75 133)
				(= local2 78)
				(= local3 138)
				(childEyes posn: 80 105)
			)
			(4
				(child posn: 90 119)
				(= local2 91)
				(= local3 116)
				(childEyes posn: 81 106)
			)
			(5
				(child posn: 73 127)
				(= local2 72)
				(= local3 135)
				(childEyes posn: 83 103)
			)
			(6
				(child posn: 82 129)
				(= local2 78)
				(= local3 133)
				(childEyes posn: 81 102)
			)
			(7
				(child posn: 78 129)
				(= local2 74)
				(= local3 136)
				(childEyes posn: 82 100)
			)
			(8
				(child posn: 81 133)
				(= local2 81)
				(= local3 135)
				(childEyes posn: 83 104)
			)
			(9
				(child posn: 81 128)
				(= local2 75)
				(= local3 136)
				(childEyes posn: 82 100)
			)
			(10
				(child posn: 81 133)
				(= local2 81)
				(= local3 135)
				(childEyes posn: 82 105)
			)
			(11
				(child posn: 90 134)
				(= local2 78)
				(= local3 138)
				(childEyes posn: 83 104)
			)
		)
		(child init:)
		(childEyes init: setPri: 140 1 setScript: blink)
		(drawerF init:)
		(= global511 bedroomItemCast)
		(global511 init: add: drawerF)
		(if (== (mod global114 2) 0)
			(= local0 1)
			(= picture 50)
			(drawer view: 870 loop: 6 cel: 0 posn: 6 175 init: hide:)
			(deskTop
				view: 871
				loop: 2
				posn: 19 142
				setStep: 1 1
				cycleSpeed: 3
				init:
			)
			(topCage init:)
			(painting view: 871 loop: 5 posn: 40 81 init:)
			(photo view: 871 loop: 4 posn: 251 85 init:)
			(book view: 870 loop: 5 posn: 276 120 init:)
			(train view: 870 loop: 3 cel: (train lastCel:) posn: 220 173 init:)
			(ball init:)
			(mitt init:)
			(bedroomItemCast
				add: drawer deskTop painting photo book train ball mitt
			)
		else
			(= local0 0)
			(= picture 52)
			(drawer posn: 4 179 init: hide:)
			(deskTop init:)
			(painting init:)
			(photo init:)
			(book view: 891 loop: 2 posn: 276 120 init:)
			(doll init:)
			(shoes init:)
			(bedroomItemCast add: drawer deskTop painting photo book doll shoes)
		)
		(= number gCurRoomNum)
		(= gPerspective picAngle)
		(if (not plane)
			(= plane gThePlane)
		)
		(plane setRect: 0 0 319 199)
		(self drawPic: picture)
		(gKeyDownHandler add: self)
		(self setScript: bedroom)
		(FrameOut)
		(for ((= temp0 0)) (<= temp0 100) ((+= temp0 8))
			(Palette 2 0 235 temp0) ; PalIntensity
		)
		(gGame handsOn:)
		(gGame setCursor: 6)
	)

	(method (drawPic param1 param2 param3)
		(if (and (> argc 2) param3)
			(if (!= param1 -1)
				(= picture (= curPic param1))
			)
			(if (!= param2 -1)
				(= style param2)
			)
		)
		(gThePlane picture: picture)
		(UpdatePlane gThePlane)
	)

	(method (handleEvent event &tmp [temp0 2])
		(if (== (event type:) evMOUSEBUTTON)
			(bedroom seconds: 20)
		)
		(if (and (== (event type:) evKEYBOARD) (== (event message:) KEY_ESCAPE) (== local1 0))
			(gGame handsOff:)
			(event claimed: 1)
			(gSfx stop:)
			(DoAudio audSTOP)
			((global511 plane:) dispose:)
			(global511 dispose:)
			(gCast eachElementDo: #dispose)
			(gLongSong stop:)
			(gLongSong number: 600 setLoop: -1 play:)
			(Palette 2 0 255 0) ; PalIntensity
			(= gOverlays -1)
			(proc0_6)
			(= global300 1)
			(= global104 0)
			(proc0_19 0 320 3)
			(= global176 0)
			(= global511 MgButtonBar)
			(global511 init:)
			(= gCurRoomNum 0)
			(gCurRoom newRoom: 32)
		)
	)

	(method (dispose)
		(= global104 0)
		(= global107 0)
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
				(gGame setCursor: gTheCursor 1)
				(= cycles 2)
			)
			(2
				(if (HaveMouse)
					(= seconds 20)
				else
					(= seconds 30)
				)
			)
			(3
				(if local1
					(= state 1)
					(= seconds 5)
				else
					(Load rsPIC (if local0 51 else 53))
					(Load rsVIEW (if local0 872 else 892))
					(= global303 2)
					(= global303 0)
					(= cycles 1)
				)
			)
			(4
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
				(gGame handsOff:)
				(= local1 1)
				(= global104 1)
				(gGame setCursor: 8 1)
				(self cue:)
			)
			(1
				(gSfx number: 815 play: self)
				(= temp0 (+ 880 (* gLanguage 1000)))
				(book view: temp0 loop: 0 setCycle: End)
				(gLongSong number: 602 setLoop: -1 play:)
			)
			(2
				(gMessager say: 1 1 24 0 self 0) ; "It's time to go to sleep now!"
			)
			(3
				(if local0
					(deskTop view: 872 cel: (deskTop loop:) loop: 4)
					(photo view: 872)
					(train view: 872 posn: 198 148 loop: 3 setPri: 180 1)
					(if (mitt cel:)
						(mitt loop: 6)
					else
						(ball view: 872 loop: 7)
						(mitt loop: 5)
					)
					(mitt view: 872)
					(door view: 872 posn: 319 165)
				else
					(deskTop view: 892 loop: 4 cel: 0)
					(photo view: 892 posn: 235 56)
					(doll view: 892 setLoop: 2)
					(shoes view: 892 setLoop: 3)
				)
				(book dispose:)
				(painting dispose:)
				(drawer dispose:)
				(night
					picture: (if local0 51 else 53)
					drawPic: (if local0 51 else 53)
				)
				(photo loop: 1 cel: 0)
				(childEyes dispose:)
				(child posn: local2 local3 setLoop: 1)
				(door init:)
				(= seconds 4)
			)
			(4
				(gMessager say: 1 1 25 0 self 0) ; "Yawn."
			)
			(5
				(= seconds 3)
			)
			(6
				(door setCycle: End)
				(= ticks 15)
			)
			(7
				(gSfx number: 37 play:)
				(= cycles 1)
			)
			(8
				(Load rsVIEW 21)
				(if local0
					(Load rsVIEW 865)
				else
					(Load rsVIEW 866)
				)
				(Load rsSOUND 600)
				(= seconds 2)
			)
			(9
				(gSfx number: 805 play:)
				(if (not local0)
					(dream view: 866)
				)
				(dream init: setCycle: CT 6 1 self)
			)
			(10
				(Load rsPIC 65)
				((= register (View new:))
					view: (if local0 865 else 866)
					loop: 0
					cel: 6
					posn: 97 63
					init:
					setPri: 1 1
				)
				(dream setPri: 150 1 cel: 7)
				(gooseRider
					view: (+ 21 global114)
					posn: 106 112
					init:
					setCycle: Fwd
					setMotion: MoveTo 124 106 self
				)
			)
			(11
				(gCast eachElementDo: #dispose)
				((gCurRoom plane:) drawPic: 65)
				(gooseRider
					view: (+ 21 global114)
					posn: 124 106
					init:
					setCycle: Fwd
					setMotion: MoveTo 250 100 self
				)
			)
			(12
				(= global176 0)
				((global511 plane:) dispose:)
				(global511 dispose:)
				(= global511 MgButtonBar)
				(global511 init:)
				(gCurRoom newRoom: 32)
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
				(childEyes setCycle: Beg self)
			)
			(2
				(= state -1)
				(= ticks (Random 180 300))
			)
		)
	)
)

(instance sqeeze of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSfx number: 584 play:)
				(client setCycle: End self)
			)
			(1
				(client setCycle: Beg self)
			)
			(2
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
				(deskTop
					cycleSpeed: 15
					moveSpeed: 15
					setCycle: Walk
					setMotion: Wander 10
					observeBlocks: topCage
				)
				(gSfx number: 589 play:)
				(= seconds 5)
			)
			(1
				(client cel: 0 setMotion: 0 setScript: 0)
				(gSfx stop:)
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
				(gGame handsOff:)
				(= local1 1)
				(gGame setCursor: 7 1)
				(gSfx number: 44 play:)
				(if local0
					(drawer show: setCycle: CT 5 1 self)
				else
					(drawer show: setCycle: End self)
					(gSfx number: 593 play:)
				)
			)
			(1
				(if local0
					((= register (Prop new:))
						view: 870
						loop: 7
						posn: 47 157
						init:
					)
					(drawer setCycle: End)
					(gSfx number: 585 play:)
					(register setPri: 180 1 setCycle: End self)
				else
					(= cycles 1)
				)
			)
			(2
				(if local0
					(register setCycle: CT 1 -1 self)
				else
					(= cycles 1)
				)
			)
			(3
				(if local0
					(register dispose:)
					(drawer setCel: 5)
				)
				(gSfx number: 44 play:)
				(drawer setCycle: Beg self)
			)
			(4
				(drawer hide:)
				(gGame handsOn:)
				(bedroom seconds: 20)
				(= local1 0)
				(gGame setCursor: 10 1)
				(client setScript: 0)
			)
		)
	)
)

(instance photoAni of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSfx number: 586 play:)
				(client setCycle: CT 6 1 self)
			)
			(1
				(gSfx number: 587 play:)
				(client setCycle: End self)
			)
			(2
				(client cel: 0)
				(localproc_0 client)
				(self dispose:)
			)
			(3
				(gSfx number: (Random 19 22) play:)
				(client setCycle: End self)
			)
			(4
				(gSfx number: (Random 19 22) play:)
				(client setCycle: Beg self)
				(= state 1)
			)
		)
	)
)

(instance backForth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local1 1)
				(gGame setCursor: 7 1)
				(client setCycle: End self)
				(gSfx number: 594 play:)
			)
			(1
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

(instance forthBack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local1 1)
				(gGame setCursor: 7 1)
				(client setCycle: CT 1 -1 self)
				(gSfx number: 594 play:)
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
				(= local1 1)
				(Load rsVIEW 870)
				(gSfx number: 42 play:)
				(ball
					setCycle: Walk
					setLoop: 0
					ignoreActors: 1
					setPri: 195 1
					setMotion: JumpTo 256 140 self
				)
				(mitt
					setLoop: 1
					setCycle: End
					ignoreActors: 1
					setMotion: MoveTo 259 150
				)
			)
			(1
				(mitt setLoop: 2 cel: 1 setCycle: End self)
				(ball dispose:)
			)
			(2
				(mitt setMotion: MoveTo 254 145 self)
			)
			(3
				(localproc_0 client)
				(self dispose:)
			)
		)
	)
)

(instance trainScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSfx number: 41 play:)
				(client cel: 0 setCycle: End self)
			)
			(1
				(gSfx stop:)
				(localproc_0 client)
				(self dispose:)
			)
		)
	)
)

(instance dance of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local1 1)
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

(instance chacha of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local1 1)
				(gSfx number: 578 play: self)
				(shoes setCycle: Fwd)
			)
			(1
				(shoes setCycle: Beg self)
			)
			(2
				(localproc_0 shoes)
				(self dispose:)
			)
		)
	)
)

(instance paintAnim of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(painting setCycle: Fwd)
				(gSfx number: (if local0 579 else 592) play: self)
			)
			(1
				(painting setCycle: End self)
			)
			(2
				(painting cel: 0)
				(localproc_0 painting)
				(self dispose:)
			)
		)
	)
)

(instance childEyes of Prop
	(properties
		loop 2
	)
)

(instance book of Prop
	(properties
		view 870
		loop 5
	)

	(method (doVerb)
		(if (and (not local1) (not cel))
			(gCurRoom setScript: closeDoor)
		)
	)
)

(instance painting of Prop
	(properties
		x 40
		y 66
		view 891
		loop 1
		cycleSpeed 12
	)

	(method (doVerb)
		(if (not local1)
			(= local1 1)
			(gGame setCursor: 7 1)
			(self setScript: paintAnim)
		)
	)
)

(instance drawer of Prop
	(properties
		view 891
		cycleSpeed 8
	)
)

(instance deskTop of Actor
	(properties
		x 28
		y 155
		view 890
		loop 4
		illegalBits 2
		moveSpeed 8
	)

	(method (doVerb)
		(if (not local1)
			(gGame setCursor: 7 1)
			(= local1 1)
			(self setScript: (if local0 topScript else sqeeze))
		)
	)
)

(instance photo of Prop
	(properties
		x 235
		y 56
		view 891
		loop 3
	)

	(method (doVerb)
		(if (not local1)
			(gGame setCursor: 7 1)
			(= local1 1)
			(if local0
				(photoAni start: 3)
			)
			(self setScript: photoAni)
		)
	)
)

(instance ball of Actor
	(properties
		x 235
		y 95
		view 870
		signal 26897
		moveSpeed 5
	)

	(method (doVerb)
		(if (not local1)
			(gGame setCursor: 7 1)
			(mitt setScript: catchBall)
		)
	)
)

(instance mitt of Actor
	(properties
		x 254
		y 145
		view 870
		loop 1
		signal 26897
		cycleSpeed 9
		illegalBits 0
	)

	(method (doVerb)
		(if (not local1)
			(self setScript: (if (== cel 0) backForth else forthBack))
		)
	)
)

(instance train of Prop
	(properties
		view 870
		loop 3
		cycleSpeed 5
	)

	(method (doVerb)
		(if (not local1)
			(= local1 1)
			(gGame setCursor: 7 1)
			(self setScript: trainScript)
		)
	)
)

(instance doll of Actor
	(properties
		x 245
		y 147
		view 890
		signal 26881
	)

	(method (doVerb)
		(if (not local1)
			(gGame setCursor: 7 1)
			(self setScript: dance)
		)
	)
)

(instance shoes of Prop
	(properties
		x 112
		y 189
		view 890
		loop 3
		signal 26625
	)

	(method (doVerb)
		(if (not local1)
			(gGame setCursor: 7 1)
			(self setScript: chacha)
		)
	)
)

(instance door of Prop
	(properties
		x 319
		y 165
		view 892
		cycleSpeed 4
	)
)

(instance dream of Prop
	(properties
		x 97
		y 63
		view 865
		signal 26673
		cycleSpeed 15
	)
)

(instance gooseRider of Actor
	(properties
		x 53
		y 98
		signal 26641
		cycleSpeed 8
		illegalBits 0
		moveSpeed 8
	)
)

(instance child of View
	(properties)
)

(instance drawerF of Feature
	(properties
		nsTop 131
		nsRight 50
		nsBottom 199
		x 10
		y 189
	)

	(method (doVerb)
		(if (not local1)
			(drawer setScript: moveDrawer)
		)
	)
)

(instance topCage of Cage
	(properties
		left -2
		top 138
		right 40
		bottom 150
	)
)

(instance bedroomItemCast of MgButtonBar
	(properties)

	(method (checkCursor param1 &tmp temp0)
		(if (!= (param1 plane:) plane)
			(param1 localize: plane)
		)
		(if (not (gUser canControl:))
			(if (!= gTheCursor 8)
				(gGame setCursor: 8)
			)
			(return)
		)
		(cond
			((= temp0 (self firstTrue: #onMe param1))
				(if (!= gTheCursor 10)
					(gGame setCursor: 10)
				)
			)
			((!= gTheCursor 6)
				(gGame setCursor: 6)
				(= saveCursor 0)
			)
		)
	)

	(method (init)
		(if (not plane)
			(= plane (Plane new:))
		)
		(plane back: 1 priority: 1 init: 0 0 639 399 addCast: self)
	)
)

