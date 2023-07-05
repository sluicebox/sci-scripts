;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 201)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm201 0
)

(local
	local0
	local1
	local2
	[local3 20]
	local23
	local24
)

(instance rm201 of Rm
	(properties
		picture 46
		style 0
	)

	(method (init &tmp [temp0 50])
		(= global103 1)
		(Load rsPIC 47)
		(Load rsPIC 0)
		(Load rsVIEW 246)
		(Load rsVIEW 35)
		(Load rsVIEW 135)
		(Load rsVIEW 96)
		(Load rsVIEW 16)
		(Load rsVIEW global117)
		(Load rsVIEW 40)
		(Load rsVIEW 142)
		(Load rsVIEW 17)
		(Load rsSOUND 5)
		(Load rsSOUND 26)
		(Load rsSOUND 4)
		(Load rsSOUND 1)
		(= global107 0)
		(if
			(or
				(== global114 0)
				(== global114 2)
				(== global114 4)
				(== global114 6)
			)
			(= local0 1)
		else
			(= local0 0)
		)
		(super init:)
		(theWindow init: stopUpd:)
		(book init:)
		(momPoster init:)
		(= local1 (Random 0 4))
		(toy1 loop: (if local0 3 else 2) cel: local1 init:)
		(for ((= local2 local1)) (== local1 local2) ((= local2 (Random 0 4)))
		)
		(toy2
			loop: (if local0 3 else 2)
			cel: local2
			x: (if local0 230 else 236)
			y: (if local0 152 else 149)
			init:
		)
		(thePic cel: (Random 0 4) init:)
		(kid
			setLoop: 0
			setCel: global114
			posn: 71 136
			setPri: 14
			init:
			stopUpd:
		)
		(if (== gScore gPossibleScore)
			(box init: setPri: 13 addToPic:)
			(largeMedallion init: setPri: 14 addToPic:)
			(egoMedallion init: setPri: 15 stopUpd:)
			(spark1 setCycle: Fwd setPri: 15 init:)
			(spark2 setCycle: Fwd setPri: 15 init:)
			(self setScript: endScript)
		else
			(self setScript: rmScript)
		)
	)

	(method (doit)
		(super doit:)
		(if (and (== local24 1) (== local23 1))
			(gCurRoom newRoom: 32)
		)
		(if (== (cloudSound prevSignal:) -1)
			(cloudSound prevSignal: 0)
			(= local24 1)
		)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(cond
			((== (event message:) KEY_F2)
				(event claimed: 0)
			)
			((!= gPrevRoomNum 32)
				(gGlobalMGSound stop:)
				(cloudSound stop:)
				(gCurRoom drawPic: 99 8)
				(self newRoom: 32)
			)
			(else
				(= global103 0)
				(= global132 0)
				(HandsOn)
			)
		)
	)
)

(instance rmScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= global206 gSpeed)
				(switch global131
					(0
						(gGame setSpeed: 4)
					)
					(1
						(gGame setSpeed: 5)
					)
					(2
						(gGame setSpeed: 6)
					)
				)
				(= seconds 4)
			)
			(1
				(gGlobalMGSound number: 26 priority: 5 loop: 1 play:)
				(= seconds 9)
			)
			(2
				(balloon
					view: 135
					setLoop: 3
					setCel: 0
					ignoreHorizon:
					ignoreActors: 1
					illegalBits: 0
					posn: 223 84
					init:
					stopUpd:
				)
				(= cycles 2)
			)
			(3
				(= global107
					(Display
						(Format @global270 {Good night,\n%s.} @global210)
						dsWIDTH
						115
						dsFONT
						1
						dsCOORD
						156
						47
						dsALIGN
						alCENTER
						dsCOLOR
						0
						dsSAVEPIXELS
					)
				)
				(= seconds global120)
			)
			(4
				(Display 201 0 dsRESTOREPIXELS global107)
				(balloon dispose:)
				(gCurRoom drawPic: 0 5)
				(door init:)
				(kid setLoop: 2 cel: 0 posn: 84 105 cycleSpeed: 5)
				(= seconds 3)
			)
			(5
				(door setCycle: End self)
			)
			(6
				(door dispose:)
				(kid setCycle: End self)
			)
			(7
				(kid setCycle: End self)
			)
			(8
				(kid setCycle: End self)
			)
			(9
				(kid setLoop: 5)
				(= seconds 4)
			)
			(10
				(kid dispose:)
				(balloon
					view: 96
					setLoop: 0
					cel: 255
					posn: 89 102
					cycleSpeed: (if global131 3 else 0)
					setStep:
						(if global131
							4
							3
						else
							6
							5
						)
					setMotion: MoveTo 142 88 self
					ignoreHorizon:
					ignoreActors: 1
					illegalBits: 0
					setCycle: End
					init:
				)
				(gGlobalMGSound stop:)
				(cloudSound play:)
			)
			(11
				(if (!= (balloon cel:) 5)
					(-- state)
					(= cycles 2)
				else
					(= cycles 1)
				)
			)
			(12
				(balloon dispose:)
				(theWindow dispose:)
				(DrawPic 47 7 1 (if global131 3 else 1))
				(= cycles 1)
			)
			(13
				(if global131
					(DrawPic 47 7 1 2)
					(= cycles 1)
				else
					(gCurRoom setScript: cloudScript)
				)
			)
			(14
				(DrawPic 47 7 1 1)
				(= cycles 1)
			)
			(15
				(DrawPic 47 7 1 0)
				(= cycles 2)
			)
			(16
				(gCurRoom setScript: cloudScript)
			)
		)
	)
)

(instance cloudScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cloud1
					init:
					setStep:
						(if global131
							2
						else
							6
							5
						)
					setMotion: MoveTo 50 135
				)
				(cloud2
					init:
					setStep:
						(if global131
							2
						else
							6
							5
						)
					setMotion: MoveTo 50 121
				)
				(cloud3
					init:
					setStep:
						(if global131
							2
						else
							6
							5
						)
					setMotion: MoveTo 50 105
				)
				(if global131
					(cloud4 init: setStep: 2 3 setMotion: MoveTo 50 89)
				)
				(theRider
					init:
					setStep:
						(if global131
							2
						else
							6
							5
						)
					setMotion: MoveTo 177 126 self
				)
				(theWing init:)
				(if (< global131 1)
					(DrawPic 47 7 1 0)
				)
			)
			(1
				(theRider setMotion: MoveTo 233 182 self)
				(cloud1 setMotion: MoveTo (- (cloud1 x:) 82) (- (cloud1 y:) 82))
				(cloud2 setMotion: MoveTo (- (cloud2 x:) 82) (- (cloud2 y:) 82))
				(cloud3 setMotion: MoveTo (- (cloud3 x:) 82) (- (cloud3 y:) 82))
				(if global131
					(cloud4
						setMotion: MoveTo (- (cloud4 x:) 82) (- (cloud4 y:) 82)
					)
				)
			)
			(2
				(cloudSound fade:)
				(= local23 1)
				(theRider setMotion: MoveTo 253 200)
			)
		)
	)
)

(instance endScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(self setScript: lastSoundScript)
				(gGlobalMGSound number: 4 priority: 5 loop: 1 play: lastSoundScript)
				(bird init:)
				(balloon
					view: 135
					setLoop: 3
					setCel: 0
					illegalBits: 0
					ignoreActors: 1
					posn: 223 84
					init:
					stopUpd:
				)
				(RedrawCast)
				(Display
					(Format @global270 {Time to get\nup, %s.} @global210)
					dsWIDTH
					115
					dsFONT
					1
					dsCOORD
					156
					42
					dsALIGN
					alCENTER
					dsCOLOR
					0
					dsSAVEPIXELS
				)
				(= seconds global120)
			)
			(1
				(balloon dispose:)
				(= global132 0)
				(sun init: setMotion: MoveTo 152 86 self)
			)
			(2
				(= seconds 2)
			)
			(3)
			(4
				(goose
					illegalBits: 0
					setLoop: 3
					setCycle: Walk
					cycleSpeed: 1
					moveSpeed: 1
					setMotion: MoveTo 146 188 self
					setPri: 14
					init:
				)
			)
			(5
				(goose setCel: 0)
				(= cycles 10)
			)
			(6
				(= cycles 20)
			)
			(7
				(goose setLoop: 4 moveSpeed: 2 setCycle: End self)
			)
			(8
				(= seconds 6)
			)
			(9
				(Print 201 1 105 1 67 -1 130 70 280) ; "Mother Goose and her design team hope you enjoyed Mixed-Up Mother Goose. Congratulations on a job well done!"
				(= global103 0)
			)
		)
	)
)

(instance lastSoundScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0)
			(1
				(= cycles 25)
			)
			(2
				(gGlobalMGSound number: 1 loop: 1)
				(if (== global208 0)
					(gGlobalMGSound play:)
				)
				(endScript cue:)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance balloon of Act
	(properties)

	(method (init)
		(super init:)
		(self setPri: 14)
	)
)

(instance door of Prop
	(properties)

	(method (init)
		(super init:)
		(self view: 135 setLoop: 1 setCel: 0 posn: 264 160)
	)
)

(instance kid of Prop
	(properties
		view 35
	)

	(method (init)
		(super init:)
	)
)

(instance toy1 of View
	(properties
		y 183
		x 285
		view 246
		loop 2
	)

	(method (init)
		(super init:)
		(self addToPic:)
	)
)

(instance toy2 of View
	(properties
		y 136
		x 71
		view 246
		loop 2
	)

	(method (init)
		(super init:)
		(self addToPic:)
	)
)

(instance thePic of View
	(properties
		y 81
		x 39
		view 246
		loop 4
		signal 16384
	)

	(method (init)
		(super init:)
		(self addToPic:)
	)
)

(instance theWindow of Prop
	(properties
		y 92
		x 152
		view 135
	)

	(method (init)
		(super init:)
		(self cel: (if (== gScore gPossibleScore) 0 else 1))
	)
)

(instance bird of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			view: 135
			setLoop: 2
			cel: 0
			posn: (- (theWindow x:) 13) (- (theWindow y:) 24)
			cycleSpeed: 2
			setCycle: Fwd
		)
	)
)

(instance sun of Act
	(properties)

	(method (init)
		(super init:)
		(self
			view: 135
			setLoop: 0
			setCel: 2
			ignoreActors: 1
			illegalBits: 0
			posn: 152 106
			setPri: 4
			moveSpeed: 4
		)
	)
)

(instance thePicture of View ; UNUSED
	(properties
		y 140
		x 123
		view 246
		loop 4
	)

	(method (init)
		(super init:)
		(self setCel: (Random 0 1) addToPic:)
	)
)

(instance book of View
	(properties
		y 136
		x 108
		view 246
		signal 16384
	)

	(method (init)
		(super init:)
		(self setPri: 15 addToPic:)
	)
)

(instance momPoster of View
	(properties
		y 86
		x 220
		view 246
	)

	(method (init)
		(super init:)
		(self setLoop: 1 setCel: (Random 0 2) setPri: 14 addToPic:)
	)
)

(instance cloud1 of Act
	(properties)

	(method (init)
		(super init:)
		(self
			view: 96
			setLoop: 1
			setCel: 3
			ignoreActors: 1
			posn: 299 120
			setPri: 14
		)
	)

	(method (doit)
		(if (and (== (cloud1 y:) 135) (< (cloud1 x:) 62))
			(self posn: 257 135 setMotion: MoveTo 50 135)
		)
		(super doit:)
	)
)

(instance cloud2 of Act
	(properties)

	(method (init)
		(super init:)
		(self
			view: 96
			setLoop: 1
			setCel: 2
			ignoreActors: 1
			posn: 297 106
			setPri: 11
		)
	)
)

(instance cloud3 of Act
	(properties)

	(method (init)
		(super init:)
		(self
			view: 96
			setLoop: 1
			setCel: 1
			ignoreActors: 1
			posn: 250 90
			setPri: 10
		)
	)
)

(instance cloud4 of Act
	(properties)

	(method (init)
		(super init:)
		(self
			view: 96
			setLoop: 1
			setCel: 0
			ignoreActors: 1
			posn: 257 75
			setPri: 9
		)
	)
)

(instance theRider of Act
	(properties)

	(method (init)
		(super init:)
		(self
			view: global117
			setLoop: 0
			setCel: 0
			setCycle: Fwd
			posn: -6 126
			ignoreHorizon: 1
			ignoreActors: 1
			illegalBits: 0
			setPri: 12
			cycleSpeed: (if global131 1 else 0)
		)
	)
)

(instance theWing of Act
	(properties)

	(method (init)
		(super init:)
		(self
			view: 16
			setLoop: (+ (theRider loop:) 5)
			ignoreHorizon: 1
			ignoreActors: 1
			illegalBits: 0
			setPri: 13
		)
	)

	(method (doit)
		(self posn: (theRider x:) (theRider y:) setCel: (theRider cel:))
		(super doit:)
	)
)

(instance box of View
	(properties
		y 37
		x 288
		view 40
	)
)

(instance egoMedallion of View
	(properties
		y 122
		x 70
		view 142
		loop 1
		cel 1
	)
)

(instance largeMedallion of View
	(properties
		y 33
		x 288
		view 142
	)
)

(instance spark1 of Prop
	(properties
		y 10
		x 296
		view 142
		loop 2
	)
)

(instance spark2 of Prop
	(properties
		y 17
		x 271
		view 142
		loop 2
		cel 5
	)
)

(instance goose of Act
	(properties
		y 188
		x 23
		view 17
	)
)

(instance cloudSound of Sound
	(properties
		number 5
	)
)

