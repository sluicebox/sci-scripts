;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm001 0
)

(local
	local0
	local1
	local2
)

(instance rm001 of Rm
	(properties
		picture 1
	)

	(method (init &tmp [temp0 50])
		(HandsOff)
		(Load rsSOUND 72)
		(Load rsSOUND 73)
		(Load rsSOUND 87)
		(Load rsPIC 1)
		(Load rsPIC 150)
		(Load rsPIC 151)
		(Load rsPIC 152)
		(Load rsPIC 153)
		(Load rsPIC 154)
		(Load rsPIC 926)
		(Load rsVIEW 1)
		(Load rsVIEW 2)
		(Load rsVIEW 3)
		(Load rsVIEW 4)
		(Load rsVIEW 5)
		(Load rsVIEW 601)
		(Load rsVIEW 926)
		(Load rsTEXT 1)
		(super init:)
		(self setScript: openingScript)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return)
		)
		(if (event type:)
			(Display 1 0 dsRESTOREPIXELS local0)
			(Display 1 0 dsRESTOREPIXELS local1)
			(gLongSong stop:)
			(if gModelessDialog
				(gModelessDialog dispose:)
			)
			(gCurRoom newRoom: 2)
		)
	)

	(method (doit)
		(super doit:)
	)
)

(instance openingScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 5)
			)
			(1
				(gCurRoom overlay: 926 3)
				(= cycles 2)
			)
			(2
				(drip1 init:)
				(drip2 init:)
				(drip3 init:)
				(drip4 init:)
				(= seconds 3)
			)
			(3
				(= local0
					(proc0_18
						{\04 1989 Sierra On-Line, Inc.}
						106
						250
						100
						35
						180
						101
						1
						105
						68
						102
						14
						103
						0
					)
				)
				(= seconds 7)
			)
			(4
				(drip1 dispose:)
				(drip2 dispose:)
				(drip3 dispose:)
				(drip4 dispose:)
				(Display 1 0 dsRESTOREPIXELS local0)
				(gCurRoom drawPic: 150 5)
				(= cycles 2)
			)
			(5
				(Mark init: setCycle: End setMotion: MoveTo 52 37 self)
			)
			(6
				(Mark stopUpd:)
				(Scott init: setCycle: End setMotion: MoveTo 268 37 self)
			)
			(7
				(= cycles 2)
			)
			(8
				(Scott stopUpd:)
				(= local0
					(Print
						{Created and Written by\nMark Crowe and Scott Murphy}
						#mode
						1
						#font
						68
						#dispose
					)
				)
				(= seconds 7)
			)
			(9
				(Scott dispose:)
				(Mark dispose:)
				(RedrawCast)
				(= local0
					(Print
						{Programmed by\nScott Murphy, Doug Oldfield,\nKen Koch, Chris Smith\nGraphics by\nMark Crowe\nGame Development System by\nJeff Stephenson, Bob Heitman,\nPablo Ghenis, Stuart Goldstein\nMusic by\nBob Siebenberg\nSound Effects & Music Editing by Mark Seibert}
						#mode
						0
						#font
						68
						#dispose
					)
				)
				(= seconds 7)
			)
			(10
				(RedrawCast)
				(= local0
					(Print
						{Macintosh Version by\nJohn Hartin, John Rettig,\nJohn Crane\nMacintosh Art by\nNate Larsen, Steven Coallier,\nJeff Crowe}
						#mode
						0
						#font
						68
						#dispose
					)
				)
				(= seconds 7)
			)
			(11
				(RedrawCast)
				(= local0
					(Print
						{It has been an indeterminate amount\nof time since Roger Wilco rocketed\naway from Vohaul's burning space\nfortress. Time stands still for our\nhero in suspended animation.}
						#mode
						1
						#font
						68
						#dispose
					)
				)
				(= seconds 12)
			)
			(12
				(= cycles 2)
			)
			(13
				(= local0
					(Print
						{Its engines long spent, the small\nescape pod drifts aimlessly through\nunfamiliar star fields, its course\naltered many times by small asteroids\nand space debris. Inside, Roger lies\nundisturbed in his sleep chamber....\n...but not for long.}
						#mode
						1
						#font
						68
						#dispose
					)
				)
				(= seconds 13)
			)
			(14
				(= local2 1)
			)
			(15
				(RedrawCast)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(gLongSong number: 72 play:)
				(pod init: setMotion: MoveTo 129 97 self)
			)
			(16
				(gLongSong number: 73 loop: -1 play:)
				(gCurRoom overlay: 151 6)
				(podOutline init: setCycle: Fwd)
				(pod setMotion: MoveTo -54 97 self)
			)
			(17
				(podOutline dispose:)
				(pod dispose:)
				(= gShowStyle 8)
				(gCurRoom drawPic: 150)
				(= cycles 3)
			)
			(18
				(gCurRoom overlay: 152)
				(= cycles 7)
			)
			(19
				(podImage init: setCycle: End self)
			)
			(20
				(= cycles 2)
			)
			(21
				(podImage stopUpd:)
				(scanner init: setCycle: Fwd)
				(= seconds 3)
			)
			(22
				(lifeForm init: setCycle: Fwd)
				(= seconds 5)
			)
			(23
				(scanner dispose:)
				(alienWord init:)
				(= seconds 3)
			)
			(24
				(alienText init: setMotion: MoveTo 221 127 self)
			)
			(25
				(alienText posn: 221 127 stopUpd:)
				(alienWord setCel: 1 stopUpd:)
				(= cycles 15)
			)
			(26
				(gCast eachElementDo: #dispose)
				(= gShowStyle 0)
				(gCurRoom drawPic: 153)
				(pod3 init: setMotion: MoveTo 87 156 self)
				(light init:)
				(hand init:)
			)
			(27
				(gCast eachElementDo: #dispose)
				(gCurRoom drawPic: 154 3)
				(pod2 init: setMotion: MoveTo 184 169 self)
				(hatch init:)
			)
			(28
				(beamSound play:)
				(pod2 setStep: 1 1 setMotion: MoveTo 137 169 self)
				(= cycles 2)
			)
			(29
				(beam init: stopUpd:)
				(gLongSong stop:)
			)
			(30
				(= cycles 20)
			)
			(31
				(pod2 setMotion: MoveTo 137 80 self)
			)
			(32
				(= cycles 2)
			)
			(33
				(beam dispose:)
				(self setScript: closeHatchScript self)
			)
			(34
				(pod2 dispose:)
				(= seconds 2)
			)
			(35
				(Print
					{The pod, considered to be nothing more\nthan another piece of scrap, is taken\naboard a robot commanded garbage\nfreighter. Unfortunately these robots\nhave no regard for organics.}
					#mode
					1
					#font
					68
					#dispose
				)
				(= seconds 12)
			)
			(36
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(= local2 2)
			)
		)
	)

	(method (doit)
		(if (and (== (gLongSong prevSignal:) -1) (== local2 1))
			(= local2 0)
			(openingScript cue:)
		)
		(if (and (== local2 2) (== (beamSound prevSignal:) -1))
			(= local2 0)
			(gCurRoom newRoom: 155)
		)
		(super doit:)
	)
)

(instance openHatchScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(hatch stopUpd:)
				(= seconds 5)
			)
			(1
				(hatch setCycle: End self)
			)
			(2
				(hatch stopUpd:)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance closeHatchScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(hatch setPri: 8 setCycle: Beg self)
			)
			(1
				(hatch stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance handScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(hand
					setLoop: 1
					setCel: 0
					setCycle: 0
					setMotion: MoveTo 121 191 self
				)
			)
			(2
				(hand setCycle: End self)
			)
			(3
				(light setCycle: Fwd)
				(= seconds 2)
			)
			(4
				(hand setCel: 0 setMotion: MoveTo 169 191 self)
			)
			(5
				(= cycles 15)
			)
			(6
				(hand setCycle: End self)
			)
			(7
				(hand setCel: 0 setMotion: MoveTo 121 223)
			)
		)
	)
)

(instance podOutline of Prop
	(properties
		view 1
		cel 1
	)

	(method (init)
		(super init:)
		(self ignoreActors: 1 setLoop: 1 setCel: 1 setPri: 5 posn: 127 97)
	)
)

(instance lifeForm of Prop
	(properties
		view 2
	)

	(method (init)
		(super init:)
		(self ignoreActors: 1 setLoop: 2 setPri: 5 posn: 152 86)
	)
)

(instance scanner of Prop
	(properties
		view 2
	)

	(method (init)
		(super init:)
		(self ignoreActors: 1 setLoop: 3 setPri: 5 posn: 105 111)
	)
)

(instance podImage of Prop
	(properties
		view 2
	)

	(method (init)
		(super init:)
		(self ignoreActors: 1 setLoop: 1 setPri: 5 posn: 111 97 cycleSpeed: 1)
	)
)

(instance hatch of Act
	(properties
		view 3
	)

	(method (init)
		(super init:)
		(self
			ignoreActors:
			setLoop: 0
			setCel: 0
			setPri: 5
			posn: 108 102
			setScript: openHatchScript
		)
	)
)

(instance hand of Act
	(properties
		view 5
	)

	(method (init)
		(super init:)
		(self
			ignoreActors:
			posn: 121 223
			setLoop: 1
			setCel: 0
			setPri: 6
			setStep: 8 8
			setCycle: 0
			setScript: handScript
		)
	)
)

(instance Scott of Act
	(properties
		view 601
	)

	(method (init)
		(super init:)
		(self setLoop: 0 ignoreActors: 1 posn: 160 100 setPri: 4 setStep: 12 12)
	)
)

(instance Mark of Act
	(properties
		view 601
	)

	(method (init)
		(super init:)
		(self setLoop: 1 ignoreActors: 1 posn: 160 100 setPri: 4 setStep: 12 12)
	)
)

(instance drip1 of Prop
	(properties
		view 926
	)

	(method (init)
		(super init:)
		(self setLoop: 0 setCel: 0 posn: 141 112 setPri: 15 setCycle: Fwd)
	)
)

(instance drip2 of Prop
	(properties
		view 926
	)

	(method (init)
		(super init:)
		(self setLoop: 0 setCel: 9 posn: 163 152 setPri: 15 setCycle: Fwd)
	)
)

(instance drip3 of Prop
	(properties
		view 926
	)

	(method (init)
		(super init:)
		(self setLoop: 0 setCel: 2 posn: 216 148 setPri: 15 setCycle: Fwd)
	)
)

(instance drip4 of Prop
	(properties
		view 926
	)

	(method (init)
		(super init:)
		(self setLoop: 0 setCel: 4 posn: 270 143 setPri: 15 setCycle: Fwd)
	)
)

(instance drip5 of Prop ; UNUSED
	(properties
		view 926
	)

	(method (init)
		(super init:)
		(self setLoop: 0 setCel: 6 posn: 34 145 setPri: 15 setCycle: Fwd)
	)
)

(instance pod3 of Act
	(properties
		view 5
	)

	(method (init)
		(super init:)
		(self ignoreActors: setLoop: 2 setPri: 4 posn: 191 52 setStep: 5 2)
	)
)

(instance light of Prop
	(properties
		view 5
		priority 6
	)

	(method (init)
		(super init:)
		(self ignoreActors: 1)
	)
)

(instance beam of View
	(properties
		view 4
	)

	(method (init)
		(super init:)
		(self posn: 110 189 setPri: 6)
	)
)

(instance pod2 of Act
	(properties
		view 3
	)

	(method (init)
		(super init:)
		(self
			setLoop: 1
			ignoreActors: 1
			illegalBits: 0
			posn: 320 169
			setPri: 7
			setStep: 2 1
		)
	)
)

(instance pod of Act
	(properties
		view 1
	)

	(method (init)
		(super init:)
		(self
			ignoreActors: 1
			setLoop: 0
			setCel: 0
			setPri: 4
			posn: 363 97
			setStep: 2
		)
	)
)

(instance alienWord of Prop
	(properties
		view 2
	)

	(method (init)
		(super init:)
		(self ignoreActors: 1 setLoop: 4 setPri: 6 posn: 226 144 setCycle: Fwd)
	)
)

(instance alienText of Act
	(properties
		view 2
	)

	(method (init)
		(super init:)
		(self ignoreActors: 1 setLoop: 0 setPri: 4 posn: 221 205 setStep: -1 6)
	)
)

(instance beamSound of Sound
	(properties
		number 87
		priority 5
	)
)

