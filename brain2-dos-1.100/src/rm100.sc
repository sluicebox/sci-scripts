;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 100)
(include sci.sh)
(use Main)
(use dummyClient)
(use PuzzleIcon)
(use BrainWindow)
(use IconBar)
(use Feature)
(use LoadMany)
(use GameControls)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm100 0
)

(local
	local0
	local1 = 1
	local2
	[local3 20]
	[local23 20]
	[local43 20]
	[local63 20]
	[local83 20]
	[local103 4] = [0 -2 -3 -999]
	[local107 7] = [0 4 5 26 6 7 999]
	[local114 7] = [0 38 39 40 41 42 999]
	[local121 4] = [0 -2 -3 999]
	[local125 8]
)

(procedure (localproc_0)
	(theEyes setScript: blink)
	(theMouth setCycle: End theMouth)
	(rko init: setCycle: Fwd)
	(flamingo1 setScript: (flamingoS new:))
	(flamingo2 setScript: flamingoS)
	(fish1 init: setScript: (onOccation new:) 0 20)
	(fish2 init: setScript: (onOccation new:) 0 40)
	(fish3 init: setScript: onOccation 0 50)
	(bonzai setScript: rise)
	(pad setScript: launch)
	(ear setCycle: Fwd)
	(dish setCycle: Fwd)
)

(procedure (localproc_1 param1)
	(= local2 0)
	(Message msgGET 100 2 0 27 1 @local3) ; "Continue Introduction"
	(Message msgGET 100 2 0 32 1 @local23) ; "Skip Introduction"
	(Message msgGET 100 2 0 31 1 @local43) ; "Restore a Game"
	(Message msgGET 100 2 0 29 1 @local63) ; "Information"
	(Message msgGET 100 2 0 30 1 @local83) ; "Quit"
	(param1 init: show: dispose:)
	(if (== local2 3)
		(localproc_2)
	else
		(return local2)
	)
)

(procedure (localproc_2)
	(if (== (InfoTeller doVerb:) -999)
		(localproc_1 quest)
	else
		(localproc_2)
	)
)

(procedure (localproc_3 param1 param2 param3)
	(Memory memPOKE (+ param1 (* 2 param2)) param3)
)

(procedure (localproc_4)
	(gGame setCursor: 999)
	(gSounds eachElementDo: #pause 1)
	(if (localproc_1 quest)
		(gSounds eachElementDo: #pause 0)
		(switch local2
			(1
				(gSounds eachElementDo: #pause 0)
				(gCurRoom newRoom: 130)
			)
			(2
				(= global174 1)
				(gSounds eachElementDo: #pause 0)
				(gCurRoom newRoom: 130)
			)
			(3
				(localproc_2)
			)
			(4
				(= gQuit 1)
			)
		)
	else
		(gGame setCursor: 996)
		(gSounds eachElementDo: #pause 0)
	)
)

(instance rm100 of Rm
	(properties
		picture 50
	)

	(method (init)
		(= [local125 0] @local103)
		(= [local125 1] @local107)
		(= [local125 2] @local114)
		(InfoTeller init: info @local103 @local125 @local121)
		(info init:)
		(HandsOff)
		(gMouseDownHandler add: self)
		(gKeyDownHandler add: self)
		(super init:)
		(self setScript: logoScript)
	)

	(method (doit)
		(super doit:)
		(if (!= (gCurRoom script:) logoScript)
			(Palette palANIMATE 231 236 -9)
		)
	)

	(method (handleEvent event &tmp [temp0 20])
		(if (IsObject gFastCast)
			(super handleEvent: event &rest)
		else
			(Format @temp0 100 0 800) ; "%d.scr"
			(cond
				(
					(and
						(== (event type:) evKEYBOARD)
						(== (event message:) KEY_ALT_t)
						(FileIO fiEXISTS @temp0)
					)
					(event claimed: 0)
					(HandsOn)
					(Palette palSET_INTENSITY 0 255 100)
					((ScriptID 800) handleEvent: event) ; MISSING SCRIPT
				)
				((not local1)
					(event claimed: 1)
				)
				((event claimed:) 0)
				((OneOf (event type:) evKEYBOARD evMOUSEBUTTON evJOYDOWN)
					(event claimed: 1)
					(localproc_4)
				)
				((== (event type:) evMOUSERELEASE)
					(event claimed: 1)
				)
			)
			(super handleEvent: event &rest)
		)
	)

	(method (dispose)
		(PalVary pvUNINIT)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(super dispose: &rest)
	)

	(method (cue)
		(switch (gCMusic prevSignal:)
			(5
				(sierraT show:)
			)
			(10
				(discoveryT show:)
			)
			(15
				(seriesT show:)
			)
			(else
				(if (and (sierraT isNotHidden:) (>= (bigGear y:) 141))
					(localproc_4)
					(logoLeft dispose:)
					(smallGear dispose:)
					(mediumGear dispose:)
					(bigGear dispose:)
					(sierraT dispose:)
					(discoveryT dispose:)
					(seriesT dispose:)
					(if (and (!= local2 1) (!= local2 2))
						(self setScript: tuneSync)
					)
				)
			)
		)
	)
)

(instance logoScript of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(if (> state 1)
			(Palette palANIMATE 112 127 -7 128 143 -5 144 159 -7 192 107 -5 96 111 -7)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(LoadMany rsVIEW 51 996)
				(gCMusic number: 1 setLoop: 1 play: gCurRoom)
				(smallGear init: hide:)
				(mediumGear init: hide:)
				(bigGear init: hide:)
				(sierraT init: hide:)
				(discoveryT init: hide:)
				(seriesT init: hide:)
				(logoLeft init:)
				(logoRight init:)
				(= ticks 1)
			)
			(1
				(gGame setCursor: 996)
				(= ticks 19)
			)
			(2
				(logoLeft setMotion: MoveTo 140 69 self)
				(logoRight setMotion: MoveTo 140 69 self)
			)
			(3 0)
			(4
				(logoLeft setCel: 2 stopUpd:)
				(logoRight dispose:)
				(smallGear show: setCycle: Fwd setMotion: MoveTo 118 65)
				(mediumGear show: setCycle: Fwd setMotion: MoveTo 199 58)
				(= ticks 20)
			)
			(5
				(bigGear show: setCycle: Fwd setMotion: MoveTo 186 141 gCurRoom)
			)
		)
	)
)

(instance dawn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Palette palSET_INTENSITY 0 255 0)
				(smoke init: setCycle: Fwd)
				(= seconds 2)
			)
			(1
				(Palette palSET_FROM_RESOURCE 100 2)
				(Palette palSET_INTENSITY 0 255 0)
				(= cycles 1)
				(= register 0)
			)
			(2
				(Palette palSET_INTENSITY 0 255 (+= register 2))
				(if (< register 100)
					(-- state)
					(= ticks 3)
				else
					(self dispose:)
				)
			)
		)
	)
)

(instance erupt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(PalVary pvINIT 101 2 64 2)
				(smoke cycleSpeed: 8 setLoop: 1 cel: 0 setCycle: End self)
				(= seconds 6)
			)
			(1
				(DoAudio audPLAY 233)
				(smoke setLoop: 3 setCycle: Fwd)
				(glow init: setCycle: Fwd)
			)
			(2
				(smoke setLoop: 2 cel: 0 cycleSpeed: 14 setCycle: End self)
				(glow dispose:)
				(PalVary pvUNINIT)
				(PalVary pvINIT 102 4 64 2)
				(= ticks 120)
			)
			(3
				(smoke setLoop: 5 setCycle: Fwd)
			)
			(4
				(PalVary pvUNINIT)
				(PalVary pvINIT 103 4 64 2)
				(= seconds 5)
			)
			(5
				(PalVary pvUNINIT)
				(self dispose:)
			)
		)
	)
)

(instance tuneSync of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= local1 0)
				(gCurRoom drawPic: 100)
				(flamingo1 init:)
				(flamingo2 init:)
				(theEyes init:)
				(theMouth init:)
				(ear init:)
				(dish init:)
				(bonzai init:)
				(gCMusic number: 2 loop: 1 play: self)
				(self setScript: dawn)
			)
			(1
				(smoke setScript: erupt)
			)
			(2
				(= local1 1)
				(localproc_0)
			)
			(3
				(PalVary pvUNINIT)
				(gCurRoom overlay: 110 3)
				(gCSoundFX number: 260 loop: 1 play:)
			)
			(4
				(= global131 0)
				(gCurRoom newRoom: 120)
			)
		)
	)
)

(instance onOccation of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks register)
			)
			(1
				(client cel: 0 setCycle: End self)
			)
			(2
				(= ticks (Random 60 300))
				(= state 0)
			)
		)
	)
)

(instance flamingoS of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks (Random 60 300))
			)
			(1
				(client setCycle: End self)
			)
			(2
				(client setCycle: Beg self)
				(= state -1)
			)
		)
	)
)

(instance launch of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(pad init:)
				(= ticks 14)
			)
			(1
				(pad loop: 11 cel: 0 setCycle: End self)
			)
			(2
				(= ticks 45)
			)
			(3
				(DoAudio audPLAY 238)
				(pad loop: 12 cel: 0 setCycle: CT 8 1 self)
			)
			(4
				(pad cel: 9)
				(rocket
					init:
					posn: 242 47
					setCycle: Fwd
					setMotion: MoveTo 242 -8 self
				)
			)
			(5
				(rocket dispose:)
				(pad loop: 14 cel: 0 setCycle: End self)
				(= state 0)
			)
		)
	)
)

(instance rise of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(bonzai setCycle: End self)
			)
			(1
				(= ticks 6)
			)
			(2
				(bonzai loop: 1 cel: 0 cycleSpeed: 4 setCycle: Fwd)
				(self dispose:)
			)
		)
	)
)

(instance blink of Script
	(properties
		register 182
	)

	(method (cue &tmp temp0)
		(if (not start)
			(if (== (client cel:) 1)
				(= start 180)
				(client cel: state)
			else
				(= state (client cel:))
				(= start 7)
				(client cel: 1)
			)
		else
			(= register (Random 40 300))
			(= temp0 (* 2 (Random 0 1)))
			(if (== (client cel:) 1)
				(= state temp0)
			else
				(client cel: temp0)
			)
		)
		(if (== start register)
			(++ register)
		)
		(= ticks (if (< start register) start else register))
		(-= start ticks)
		(-= register ticks)
	)
)

(instance flamingo1 of Prop
	(properties
		x 160
		y 148
		view 100
		loop 3
		cel 2
		cycleSpeed 4
	)
)

(instance flamingo2 of Prop
	(properties
		x 146
		y 144
		view 100
		loop 4
		cel 2
		cycleSpeed 12
	)
)

(instance theMouth of Prop
	(properties
		x 181
		y 94
		view 100
		loop 7
		cycleSpeed 22
	)

	(method (cue)
		(self addToPic:)
	)
)

(instance theEyes of Prop
	(properties
		x 181
		y 94
		view 100
		loop 6
		cel 1
		signal 16384
		cycleSpeed 7
	)
)

(instance fish1 of Prop
	(properties
		x 197
		y 187
		view 100
		loop 9
	)
)

(instance fish2 of Prop
	(properties
		x 264
		y 172
		view 100
		loop 10
		cel 9
	)
)

(instance fish3 of Prop
	(properties
		x 28
		y 98
		view 100
		loop 15
	)
)

(instance rko of Prop
	(properties
		x 99
		y 70
		view 100
		loop 8
		cel 3
		priority 5
		signal 16
	)
)

(instance smoke of Prop
	(properties
		x 195
		y 13
		view 101
	)
)

(instance glow of Actor
	(properties
		x 197
		y 28
		view 101
		loop 4
		cycleSpeed 8
	)
)

(instance bonzai of Prop
	(properties
		x 82
		y 84
		view 100
		cycleSpeed 8
	)
)

(instance pad of Prop
	(properties
		x 231
		y 82
		view 100
		loop 11
		signal 16384
		cycleSpeed 8
	)
)

(instance rocket of Actor
	(properties
		x 242
		y 40
		yStep 3
		view 100
		loop 13
		signal 26624
		cycleSpeed 3
		illegalBits 0
		moveSpeed 3
	)
)

(instance ear of Prop
	(properties
		x 201
		y 130
		view 100
		loop 5
		cel 4
		cycleSpeed 5
	)
)

(instance dish of Prop
	(properties
		x 272
		y 27
		view 100
		loop 2
		cel 10
	)
)

(instance logoLeft of Actor
	(properties
		x -100
		y 69
		view 51
		priority 6
		signal 18448
		origStep 771
		moveSpeed 1
	)
)

(instance logoRight of Actor
	(properties
		x 380
		y 69
		view 51
		cel 1
		priority 6
		signal 18448
		origStep 771
		moveSpeed 1
	)
)

(instance smallGear of Actor
	(properties
		x 138
		y 85
		view 51
		loop 1
		cel 3
		priority 4
		signal 18448
		cycleSpeed 3
		origStep 257
		moveSpeed 2
	)
)

(instance mediumGear of Actor
	(properties
		x 167
		y 90
		view 51
		loop 2
		cel 3
		priority 4
		signal 18448
		cycleSpeed 3
		origStep 257
		moveSpeed 2
	)
)

(instance bigGear of Actor
	(properties
		x 135
		y 90
		view 51
		loop 3
		cel 2
		priority 4
		signal 18448
		cycleSpeed 3
		origStep 257
		moveSpeed 2
	)
)

(instance sierraT of View
	(properties
		x 211
		y 98
		view 51
		loop 4
		signal 16384
	)
)

(instance discoveryT of View
	(properties
		x 211
		y 98
		view 51
		loop 4
		cel 1
		signal 16384
	)
)

(instance seriesT of View
	(properties
		x 211
		y 98
		view 51
		loop 4
		cel 2
		signal 16384
	)
)

(instance quest of GameControls
	(properties)

	(method (init)
		(gGame setCursor: 999)
		((= window (BrainWindow new:))
			top: 30
			left: 77
			bottom: 130
			right: 243
			priority: 15
			yourself:
		)
		(self
			add: titleIc continueIc skipIc restoreIc infoIc quitIc
			curIcon: continueIc
		)
		(super init: &rest)
	)
)

(instance titleIc of IconI
	(properties
		view 935
		loop 2
		cel 0
		nsTop 0
		signal 4
		maskView 361
		maskLoop 3
	)

	(method (show &tmp [temp0 30])
		(Message msgGET 100 2 0 33 1 @temp0) ; "You may choose..."
		(Display @temp0 dsWIDTH 135 dsCOORD 15 8 dsCOLOR 17)
	)
)

(instance continueIc of IconI
	(properties
		nsTop 25
		signal 257
	)

	(method (select)
		(= local2 0)
		(quest state: (& (quest state:) $ffdf))
	)

	(method (show)
		(= nsRight 80)
		(= nsBottom (+ nsTop 15))
		(Display @local3 dsCOORD 20 (+ nsTop 3) dsCOLOR 46)
		(if (and gPMouse (gPMouse respondsTo: #stop))
			(gPMouse stop:)
		)
	)

	(method (highlight param1 &tmp temp0)
		(if param1
			(= temp0 46)
		else
			(= temp0 17)
		)
		(Display @local3 dsCOORD 20 (+ nsTop 3) dsCOLOR temp0)
	)
)

(instance skipIc of IconI
	(properties
		nsTop 40
		signal 257
	)

	(method (select)
		(= local2 1)
		(quest state: (& (quest state:) $ffdf))
	)

	(method (show)
		(= nsRight 80)
		(= nsBottom (+ nsTop 15))
		(Display @local23 dsCOORD 20 (+ nsTop 3) dsCOLOR 17)
		(if (& signal $0004)
			(self mask:)
		)
		(if (and gPMouse (gPMouse respondsTo: #stop))
			(gPMouse stop:)
		)
	)

	(method (highlight param1 &tmp temp0)
		(if param1
			(= temp0 46)
		else
			(= temp0 17)
		)
		(Display @local23 dsCOORD 20 (+ nsTop 3) dsCOLOR temp0)
	)
)

(instance restoreIc of IconI
	(properties
		nsTop 55
		signal 257
	)

	(method (select)
		(= local2 2)
		(quest state: (& (quest state:) $ffdf))
	)

	(method (show)
		(= nsRight 80)
		(= nsBottom (+ nsTop 15))
		(Display @local43 dsCOORD 20 (+ nsTop 3) dsCOLOR 17)
		(if (& signal $0004)
			(self mask:)
		)
		(if (and gPMouse (gPMouse respondsTo: #stop))
			(gPMouse stop:)
		)
	)

	(method (highlight param1 &tmp temp0)
		(if param1
			(= temp0 46)
		else
			(= temp0 17)
		)
		(Display @local43 dsCOORD 20 (+ nsTop 3) dsCOLOR temp0)
	)
)

(instance infoIc of IconI
	(properties
		nsTop 70
		signal 257
	)

	(method (select)
		(= local2 3)
		(quest state: (& (quest state:) $ffdf))
	)

	(method (show)
		(= nsRight 80)
		(= nsBottom (+ nsTop 15))
		(Display @local63 dsCOORD 20 (+ nsTop 3) dsCOLOR 17)
		(if (& signal $0004)
			(self mask:)
		)
		(if (and gPMouse (gPMouse respondsTo: #stop))
			(gPMouse stop:)
		)
	)

	(method (highlight param1 &tmp temp0)
		(if param1
			(= temp0 46)
		else
			(= temp0 17)
		)
		(Display @local63 dsCOORD 20 (+ nsTop 3) dsCOLOR temp0)
	)
)

(instance quitIc of IconI
	(properties
		nsTop 85
		signal 257
	)

	(method (select)
		(= local2 4)
		(quest state: (& (quest state:) $ffdf))
	)

	(method (show)
		(= nsRight 80)
		(= nsBottom (+ nsTop 15))
		(Display @local83 dsCOORD 20 (+ nsTop 3) dsCOLOR 17)
		(if (& signal $0004)
			(self mask:)
		)
		(if (and gPMouse (gPMouse respondsTo: #stop))
			(gPMouse stop:)
		)
	)

	(method (highlight param1 &tmp temp0)
		(if param1
			(= temp0 46)
		else
			(= temp0 17)
		)
		(Display @local83 dsCOORD 20 (+ nsTop 3) dsCOLOR temp0)
	)
)

(class TellerIcon of IconI
	(properties
		view 935
		loop 2
		cel 0
		nsTop 15
		signal 257
		maskView 361
		maskLoop 3
		myHandle 0
		value 0
		myTeller 0
	)

	(method (select)
		(myTeller iconValue: value)
		((myTeller theControls:)
			state: (& ((myTeller theControls:) state:) $ffdf)
		)
	)

	(method (show &tmp [temp0 15])
		(Message msgGET 100 0 0 36 1 @temp0) ; "Learn About:"
		(Display @temp0 dsCOORD 15 5 dsCOLOR 17)
		(= nsRight 80)
		(= nsBottom (+ nsTop 15))
		(Display myHandle dsCOORD 20 (+ nsTop 3) dsCOLOR 17)
		(if (& signal $0004)
			(self mask:)
		)
		(if (and gPMouse (gPMouse respondsTo: #stop))
			(gPMouse stop:)
		)
	)

	(method (highlight param1 &tmp temp0)
		(if param1
			(= temp0 46)
		else
			(= temp0 17)
		)
		(Display myHandle dsCOORD 20 (+ nsTop 3) dsCOLOR temp0)
	)
)

(class InfoTeller of Obj
	(properties
		query 0
		curArray 0
		arrays 0
		keys 0
		client 0
		iconValue 0
		theControls 0
	)

	(method (init param1 param2 param3 param4)
		(= client param1)
		(= curArray param2)
		(= arrays param3)
		(if (> argc 3)
			(= keys param4)
		)
		(client actions: self)
		(super init:)
	)

	(method (doVerb)
		(= iconValue 0)
		(while 1
			(if (self respond:)
				(break)
			)
		)
		(return query)
	)

	(method (showDialog)
		(self doDialog: (if (== (WordAt arrays 0) curArray) 1 else 0) &rest)
	)

	(method (getSeqNum)
		(return 1)
	)

	(method (oldChild param1 &tmp temp0)
		(= temp0 0)
		(while (++ temp0)
			(if (== (WordAt keys temp0) param1)
				(self stuffArray: (WordAt arrays temp0) 1)
				(return 1)
			)
			(< (WordAt keys temp0) 999)
		)
		(return 1)
	)

	(method (respond)
		(= query (self showDialog:))
		(if (and (!= query -999) iconValue)
			(= query iconValue)
		)
		(cond
			((or (not query) (== query -999))
				(= query -999)
				(return 1)
			)
			((== query 999)
				(self doParent:)
				(return 0)
			)
			((and (< query 0) (not (self doChild: query)))
				(return 1)
			)
		)
		(= query (Abs query))
		(Say 0 (client noun:) 5 query 0)
		(return 1)
	)

	(method (doDialog param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13 temp14 [temp15 30])
		(= temp0 [param1 (= temp3 0)])
		(= temp5 5)
		(= temp8 0)
		(= temp4 0)
		(= temp9 (List new:))
		((= theControls (GameControls new:))
			window:
				((BrainWindow new:)
					top: 40
					left: 70
					bottom: 140
					right: 250
					priority: 15
					yourself:
				)
		)
		(if (OneOf curArray @local103 @local114 @local107)
			(+= temp5 15)
		)
		(for ((= temp2 1)) (!= (WordAt curArray temp2) 999) ((++ temp2))
			(= temp6 1)
			(for ((= temp3 1)) (and temp6 (< temp3 argc)) ((+= temp3 2))
				(if
					(and
						(== (WordAt curArray temp2) [param1 temp3])
						(not [param1 (+ temp3 1)])
					)
					(= temp6 0)
				)
			)
			(if temp6
				(= temp7 (WordAt curArray temp2))
				(= temp14 (self getSeqNum: (Abs temp7)))
				(if
					(not
						(= temp13
							(Message
								msgSIZE
								gCurRoomNum
								(client noun:)
								2
								(Abs temp7)
								temp14
							)
						)
					)
					(break)
				)
				(= temp1 (Memory memALLOC_NONCRIT temp13))
				(temp9 add: temp1)
				(Message msgGET 100 1 2 (Abs temp7) temp14 temp1)
				((= temp4 (infoIcon new:))
					myHandle: temp1
					value: temp7
					nsTop: temp5
					myTeller: self
				)
				(theControls add: temp4)
				(if (== (++ temp8) 1)
					(theControls curIcon: temp4)
				)
				(+= temp5 15)
			)
		)
		(if (not (IsObject temp4))
			((theControls window:) dispose:)
			(theControls dispose:)
			(temp9 dispose:)
			(return -999)
		)
		(= temp4 (infoIcon new:))
		(if (not temp0)
			(Message msgGET 100 0 0 34 1 @temp15) ; "Something Else"
			(temp4 myHandle: @temp15 value: 999 nsTop: temp5 myTeller: self)
		else
			(Message msgGET 100 0 0 35 1 @temp15) ; "Enough Already"
			(temp4 myHandle: @temp15 value: -999 nsTop: temp5 myTeller: self)
		)
		(theControls add: temp4)
		((theControls window:)
			top: (- 60 (* 7 temp8))
			bottom: (- (+ temp5 80) (* 7 temp8))
		)
		(theControls init: show: dispose:)
		(for
			((= temp10 (FirstNode (temp9 elements:))))
			temp10
			((= temp10 temp11))
			
			(= temp11 (NextNode temp10))
			(if (not (= temp12 (NodeValue temp10)))
				(break)
			else
				(Memory memFREE temp12)
			)
		)
		(return (temp9 dispose:))
	)

	(method (doChild param1)
		(switch param1
			(-2
				(self oldChild: param1)
				(self doVerb:)
				(return 0)
			)
			(-3
				(self oldChild: param1)
				(self doVerb:)
				(return 0)
			)
			(else
				(return 1)
			)
		)
	)

	(method (doParent)
		(self stuffArray: (WordAt curArray 0) 0)
	)

	(method (stuffArray param1 param2)
		(if param2
			(localproc_3 param1 0 curArray)
		)
		(= curArray param1)
		(return param2)
	)
)

(instance info of Feature
	(properties
		x 160
		y 100
		noun 1
		nsBottom 199
		nsRight 319
	)
)

(instance infoIcon of TellerIcon
	(properties)

	(method (show &tmp [temp0 30])
		(cond
			((== (InfoTeller curArray:) @local103)
				(Message msgGET 100 1 2 1 1 @temp0) ; "Do You Want..."
				(Display @temp0 dsCOORD 15 5 dsCOLOR 17)
			)
			((== (InfoTeller curArray:) @local114)
				(Message msgGET 100 1 2 22 1 @temp0) ; "Help..."
				(Display @temp0 dsCOORD 15 5 dsCOLOR 17)
			)
			((== (InfoTeller curArray:) @local107)
				(Message msgGET 100 1 2 37 1 @temp0) ; "Tech info..."
				(Display @temp0 dsCOORD 15 5 dsCOLOR 17)
			)
		)
		(= nsRight 80)
		(= nsBottom (+ nsTop 15))
		(Display myHandle dsCOORD 20 (+ nsTop 3) dsCOLOR 17)
		(if (& signal $0004)
			(self mask:)
		)
		(if (and gPMouse (gPMouse respondsTo: #stop))
			(gPMouse stop:)
		)
	)
)

