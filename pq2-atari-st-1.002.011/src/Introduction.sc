;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 200)
(include sci.sh)
(use Main)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Introduction 0
)

(local
	[local0 10]
	[local10 10]
	local20
	local21
	local22
	local23
	local24
	local25
	local26
	local27
	local28
)

(procedure (localproc_0 &tmp temp0 temp1)
	(= temp1 (Display &rest dsALIGN alCENTER dsCOORD 10 10 dsWIDTH 300 dsCOLOR 15 dsSAVEPIXELS))
	(repeat
		(= temp0 (Event new: 5))
		(breakif (& (temp0 type:) $0005))
		(temp0 dispose:)
	)
	(temp0 dispose:)
	(Display 200 10 dsRESTOREPIXELS temp1)
)

(instance introMusic of Sound
	(properties
		number 1
	)
)

(instance Introduction of Rm
	(properties
		style 0
	)

	(method (dispose)
		(gSounds eachElementDo: #dispose)
		(super dispose:)
	)

	(method (init)
		(HandsOff)
		(super init:)
		(Load rsVIEW 900)
		(Load rsVIEW 901)
		(Load rsVIEW 902)
		(Load rsPIC 46)
		(Load rsSOUND 1)
		(Load rsVIEW 310)
		(Load rsVIEW 924)
		(Load rsVIEW 925)
		(Load rsPIC 47)
		(Load rsPIC 885)
		(Load rsPIC 48)
		(Load rsVIEW 311)
		(Load rsVIEW 903)
		(Load rsVIEW 904)
		(Load rsVIEW 209)
		(Load rsVIEW 292)
		(Load rsSOUND 1)
		(gCurRoom drawPic: 0 0)
		(gCurRoom setScript: IntroScript)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (== (event type:) evKEYBOARD)
			(event claimed: 1)
			(if (== (event message:) KEY_F2)
				(if (GetMenu 1282 113)
					(DoSound sndSET_SOUND 0)
					(SetMenu 1282 113 0 110 {Turn on})
				else
					(DoSound sndSET_SOUND 1)
					(SetMenu 1282 113 1 110 {Turn off})
				)
			)
			(if
				(or
					(== (event message:) KEY_RETURN)
					(and (>= (event message:) KEY_SPACE) (<= (event message:) $0060)) ; `
				)
				(event claimed: 1)
				(gCurRoom newRoom: 701)
			)
		)
	)
)

(instance IntroScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(introMusic play:)
				(if (< global110 30)
					((= [local10 9] (View new:))
						view: 901
						loop: 0
						posn: 160 112
						setPri: 10
						init:
						ignoreActors:
						stopUpd:
						addToPic:
					)
					((= [local0 9] (View new:))
						view: 900
						loop: 0
						posn: 160 63
						setPri: 0
						init:
						ignoreActors:
						setPri: 10
						addToPic:
					)
					(self changeState: 24)
				else
					((= [local0 9] (View new:))
						view: 900
						loop: 0
						posn: 160 63
						setPri: 0
						init:
						ignoreActors:
						stopUpd:
					)
					(self cue:)
				)
			)
			(1
				((= [local0 0] (Prop new:))
					view: 900
					loop: 9
					cel: 2
					posn: 160 30
					setPri: 1
					init:
					ignoreActors:
					setCycle: Beg self
				)
			)
			(2
				((= [local0 1] (View new:))
					view: 900
					loop: 8
					posn: 160 34
					setPri: 2
					init:
					ignoreActors:
				)
				(= cycles 1)
			)
			(3
				((= [local0 2] (View new:))
					view: 900
					loop: 7
					posn: 160 40
					setPri: 3
					init:
					ignoreActors:
				)
				(= cycles 1)
			)
			(4
				((= [local0 3] (View new:))
					view: 900
					loop: 6
					posn: 160 50
					setPri: 4
					init:
					ignoreActors:
				)
				(= cycles 1)
			)
			(5
				([local0 0] dispose:)
				((= [local0 4] (View new:))
					view: 900
					loop: 5
					posn: 160 64
					setPri: 5
					init:
					ignoreActors:
				)
				(= cycles 1)
			)
			(6
				([local0 1] dispose:)
				((= [local0 5] (View new:))
					view: 900
					loop: 4
					posn: 160 74
					setPri: 6
					init:
					ignoreActors:
				)
				(= cycles 1)
			)
			(7
				([local0 2] dispose:)
				((= [local0 6] (View new:))
					view: 900
					loop: 3
					posn: 160 80
					setPri: 7
					init:
					ignoreActors:
				)
				(= cycles 1)
			)
			(8
				([local0 3] dispose:)
				((= [local0 7] (View new:))
					view: 900
					loop: 2
					posn: 160 78
					setPri: 8
					init:
					ignoreActors:
				)
				(= cycles 1)
			)
			(9
				([local0 4] dispose:)
				((= [local0 8] (View new:))
					view: 900
					loop: 1
					posn: 160 70
					setPri: 9
					init:
					ignoreActors:
				)
				(= cycles 1)
			)
			(10
				([local0 5] dispose:)
				([local0 9] setPri: 10 addToPic:)
				(= cycles 1)
			)
			(11
				([local0 6] dispose:)
				((= [local10 0] (Prop new:))
					view: 901
					loop: 9
					cel: 2
					posn: 160 180
					setPri: 1
					init:
					ignoreActors:
					setCycle: Beg self
				)
			)
			(12
				([local0 7] dispose:)
				((= [local10 1] (View new:))
					view: 901
					loop: 8
					posn: 160 174
					setPri: 2
					init:
					ignoreActors:
				)
				(= cycles 1)
			)
			(13
				([local0 8] dispose:)
				((= [local10 2] (View new:))
					view: 901
					loop: 7
					posn: 160 165
					setPri: 3
					init:
					ignoreActors:
				)
				(= cycles 1)
			)
			(14
				((= [local10 3] (View new:))
					view: 901
					loop: 6
					posn: 160 158
					setPri: 4
					init:
					ignoreActors:
				)
				(= cycles 1)
			)
			(15
				([local10 0] dispose:)
				((= [local10 4] (View new:))
					view: 901
					loop: 5
					posn: 160 152
					setPri: 5
					init:
					ignoreActors:
				)
				(= cycles 1)
			)
			(16
				([local10 1] dispose:)
				((= [local10 5] (View new:))
					view: 901
					loop: 4
					posn: 160 144
					setPri: 6
					init:
					ignoreActors:
				)
				(= cycles 1)
			)
			(17
				([local10 2] dispose:)
				((= [local10 6] (View new:))
					view: 901
					loop: 3
					posn: 160 134
					setPri: 7
					init:
					ignoreActors:
				)
				(= cycles 1)
			)
			(18
				([local10 3] dispose:)
				((= [local10 7] (View new:))
					view: 901
					loop: 2
					posn: 160 126
					setPri: 8
					init:
					ignoreActors:
				)
				(= cycles 1)
			)
			(19
				([local10 4] dispose:)
				((= [local10 8] (View new:))
					view: 901
					loop: 1
					posn: 160 120
					setPri: 9
					init:
					ignoreActors:
				)
				(= cycles 1)
			)
			(20
				([local10 5] dispose:)
				((= [local10 9] (View new:))
					view: 901
					loop: 0
					posn: 160 112
					setPri: 10
					init:
					ignoreActors:
					stopUpd:
					addToPic:
				)
				(= cycles 1)
			)
			(21
				([local10 6] dispose:)
				(= cycles 1)
			)
			(22
				([local10 7] dispose:)
				(= cycles 1)
			)
			(23
				([local10 8] dispose:)
				(= cycles 1)
			)
			(24
				((= local20 (Act new:))
					view: 902
					loop: 1
					cel: 0
					posn: (if (< global110 30) 120 else 0) 178
					setPri: 15
					init:
					setStep: 8
					ignoreActors:
					setCycle: 0
					setMotion: MoveTo 144 178
				)
				((= local21 (Act new:))
					view: 902
					loop: 0
					cel: 0
					posn: (if (< global110 30) 200 else 320) 178
					setPri: 15
					init:
					setStep: 8
					ignoreActors:
					setCycle: 0
					setMotion: MoveTo 176 178 self
				)
			)
			(25
				(local20 setStep: 2 setMotion: MoveTo 140 178)
				(local21 setStep: 2 setMotion: MoveTo 180 178 self)
			)
			(26
				(local20 setMotion: MoveTo 143 178 setStep: 1)
				(local21 setMotion: MoveTo 177 178 setStep: 1)
				(= seconds 3)
			)
			(27
				(local20 dispose:)
				(local21 dispose:)
				(gCurRoom setScript: jimScript)
			)
		)
	)
)

(instance streetLight of Prop
	(properties)
)

(instance redLight1 of Prop
	(properties)
)

(instance redLight2 of Prop
	(properties)
)

(instance blueLight1 of Prop ; UNUSED
	(properties)
)

(instance blueLight2 of Prop ; UNUSED
	(properties)
)

(instance building of Act
	(properties)
)

(instance farBuildings of Act
	(properties)
)

(instance jim1 of View
	(properties)
)

(instance jim2 of View
	(properties)
)

(instance jim3 of View
	(properties)
)

(instance jimb1 of View
	(properties)
)

(instance jimb2 of View
	(properties)
)

(instance jimScript of Script
	(properties)

	(method (init)
		(runNext init: 16)
		(gCurRoom drawPic: 46)
		(= local23 0)
		(= local24 0)
		(= local26 337)
		(= local27 76)
		(streetLight view: 310 loop: 2 posn: 298 122 setPri: 15 init:)
		(redLight1 view: 310 loop: 1 posn: 276 149 setPri: 12 init:)
		(redLight2 view: 310 loop: 1 posn: 293 149 setPri: 12 init:)
		(building
			view: 310
			setLoop: 3
			setCel: 0
			posn: 340 80
			setPri: 1
			init:
			illegalBits: 0
			ignoreActors:
			setMotion: MoveTo 250 105
		)
		(farBuildings
			view: 310
			setLoop: 4
			setCel: 0
			posn: local26 local27
			setPri: 0
			init:
		)
		(jim1
			view: 924
			loop: 0
			cel: 0
			posn: 26 108
			setPri: 14
			init:
			ignoreActors:
		)
		(jim2
			view: 924
			loop: 0
			cel: 1
			posn: 56 108
			setPri: 14
			init:
			ignoreActors:
		)
		(jim3
			view: 924
			loop: 0
			cel: 2
			posn: 80 108
			setPri: 14
			init:
			ignoreActors:
			addToPic:
		)
		(jimb1
			view: 925
			loop: 0
			cel: 0
			posn: 125 108
			setPri: 14
			init:
			ignoreActors:
			addToPic:
		)
		(jimb2
			view: 925
			loop: 0
			cel: 1
			posn: 176 108
			setPri: 14
			init:
			ignoreActors:
			addToPic:
		)
		(RedrawCast)
		(super init:)
	)

	(method (doit)
		(if (== local23 0)
			(self changeState: 0)
		)
		(runNext doit:)
		(if (runNext state:)
			(runNext state: 0)
			(gCast eachElementDo: #dispose)
			(gCurRoom setScript: everyoneElseScript)
		)
		(cond
			((and (== local24 3) (= local25 0))
				(-= local26 1)
				(farBuildings posn: local26 local27)
				(= local24 0)
				(+= local25 1)
			)
			((and (== local24 3) (= local25 10))
				(-= local26 1)
				(+= local27 1)
				(farBuildings posn: local26 local27)
				(= local24 0)
				(= local25 0)
			)
			(else
				(+= local24 1)
			)
		)
		(if (and (== (building x:) 250) (== (building y:) 105))
			(self changeState: 1)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(streetLight setCycle: Fwd)
				(redLight1 setCycle: Fwd)
				(redLight2 setCycle: Fwd)
				(Display 200 0 dsCOORD 10 115) ; "Name: Jim Walls"
				(Display 200 1 dsCOORD 10 125) ; "Weight: 200 lbs"
				(Display 200 2 dsCOORD 10 135) ; "Height: 5'10""
				(Display 200 3 dsCOORD 10 145) ; "Hair: Light Brown"
				(Display 200 4 dsCOORD 10 155) ; "Eyes: Green"
				(Display 200 5 dsCOORD 10 165) ; "Wanted: For excessive verbosity"
				(Display 200 6 dsCOORD 150 115) ; "Alias: B.B.Walls"
				(Display 200 7 dsCOORD 150 125) ; "MO: Author and"
				(Display 200 8 dsCOORD 175 135) ; "designer of"
				(Display 200 9 dsCOORD 175 145) ; "Police Quest II"
				(= local23 1)
			)
			(1
				(building posn: 340 80 setMotion: MoveTo 250 105)
			)
		)
	)
)

(instance bainsRunning of Act
	(properties)
)

(instance bainsShadow of Act
	(properties)
)

(instance sonnyRunning of Act
	(properties)
)

(instance sonnyShadow of Act
	(properties)
)

(instance legs of Prop
	(properties)
)

(instance weeds of Act
	(properties)
)

(instance weeds2 of Act
	(properties)
)

(instance bubbles of Act
	(properties)
)

(instance executive of View
	(properties)
)

(instance producer of View
	(properties)
)

(instance ken of View
	(properties)
)

(instance programming of View
	(properties)
)

(instance art of View
	(properties)
)

(instance animation of View
	(properties)
)

(instance project of View
	(properties)
)

(instance coordinator of View
	(properties)
)

(instance system of View
	(properties)
)

(instance development of View
	(properties)
)

(instance music of View
	(properties)
)

(instance heitman of View
	(properties)
)

(instance jeff of View
	(properties)
)

(instance pablo of View
	(properties)
)

(instance stuart of View
	(properties)
)

(instance crowe of View
	(properties)
)

(instance jerry of View
	(properties)
)

(instance fischbach of View
	(properties)
)

(instance mickie of View
	(properties)
)

(instance dave of View
	(properties)
)

(instance vu of View
	(properties)
)

(instance cheri of View
	(properties)
)

(instance chris of View
	(properties)
)

(instance everyoneElseScript of Script
	(properties)

	(method (init)
		(gCurRoom drawPic: 47)
		(bainsRunning
			view: 209
			setLoop: 1
			posn: -30 140
			setCycle: Walk
			setStep: 11 1
			init:
		)
		(bainsShadow
			view: 209
			setLoop: 2
			posn: -40 135
			setCycle: Walk
			setStep: 11 1
			init:
			ignoreActors: 1
			setPri: 1
		)
		(sonnyRunning
			view: 292
			setLoop: 1
			posn: -30 140
			setCycle: Walk
			setStep: 8 1
			init:
		)
		(sonnyShadow
			view: 292
			setLoop: 2
			posn: -40 135
			setCycle: Walk
			setStep: 8 1
			ignoreActors: 1
			setPri: 1
			init:
		)
		(legs
			view: 311
			loop: 0
			posn: 253 125
			setPri: 0
			init:
			cycleSpeed: 1
			setCycle: Fwd
		)
		(weeds
			view: 311
			setLoop: 1
			posn: 10 130
			setPri: 2
			init:
			setCycle: Fwd
			cycleSpeed: 1
			setStep: 4 1
			setMotion: MoveTo 300 130 weed1Script
		)
		(weeds2
			view: 311
			setLoop: 1
			posn: 150 140
			setPri: 2
			init:
			setCycle: Fwd
			setStep: 4 1
			setMotion: MoveTo 300 140 weed2Script
		)
		(bubbles
			view: 311
			setLoop: 2
			posn: 60 130
			setPri: 1
			setStep: 4 5
			init:
			setCycle: Fwd
			setMotion: MoveTo 160 0 bubbleScript
		)
		(super init:)
		(self changeState: 0)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(executive
					view: 903
					setLoop: 5
					setCel: 0
					ignoreActors:
					posn: 158 64
					init:
					stopUpd:
				)
				(producer
					view: 903
					setLoop: 5
					setCel: 1
					ignoreActors:
					posn: 158 82
					init:
					stopUpd:
				)
				(ken
					view: 904
					setLoop: 6
					setCel: 0
					ignoreActors:
					posn: 157 100
					init:
					stopUpd:
				)
				(= seconds 5)
			)
			(1
				(executive dispose:)
				(producer dispose:)
				(ken dispose:)
				(development
					view: 903
					setLoop: 3
					setCel: 1
					ignoreActors: 1
					setPri: 15
					init:
					posn: 158 64
					stopUpd:
				)
				(system
					view: 903
					setLoop: 3
					setCel: 0
					ignoreActors: 1
					setPri: 15
					posn: 153 82
					init:
					stopUpd:
				)
				(jeff
					view: 904
					setLoop: 0
					setCel: 0
					ignoreActors: 1
					setPri: 15
					init:
					posn: 157 97
					stopUpd:
				)
				(heitman
					view: 904
					setLoop: 0
					setCel: 1
					ignoreActors: 1
					setPri: 15
					init:
					posn: 158 115
					stopUpd:
				)
				(pablo
					view: 904
					setLoop: 0
					setCel: 2
					ignoreActors: 1
					setPri: 15
					init:
					posn: 158 131
					stopUpd:
				)
				(stuart
					view: 904
					setLoop: 0
					setCel: 3
					ignoreActors: 1
					setPri: 15
					init:
					posn: 159 148
					stopUpd:
				)
				(= seconds 8)
			)
			(2
				(system dispose:)
				(development dispose:)
				(heitman dispose:)
				(jeff dispose:)
				(pablo dispose:)
				(stuart dispose:)
				(project
					view: 903
					setLoop: 4
					setCel: 0
					ignoreActors: 1
					setPri: 15
					init:
					posn: 156 86
					stopUpd:
				)
				(coordinator
					view: 903
					setLoop: 4
					setCel: 1
					ignoreActors: 1
					setPri: 15
					init:
					posn: 157 104
					stopUpd:
				)
				(crowe
					view: 904
					setLoop: 1
					setCel: 0
					ignoreActors: 1
					setPri: 15
					init:
					posn: 155 121
					stopUpd:
				)
				(= seconds 4)
			)
			(3
				(project dispose:)
				(coordinator dispose:)
				(crowe dispose:)
				(legs dispose:)
				(weeds dispose:)
				(weeds2 dispose:)
				(bubbles dispose:)
				(gCurRoom drawPic: 885)
				(programming
					view: 903
					setLoop: 0
					setCel: 0
					setPri: 15
					init:
					posn: 97 20
					ignoreActors: 1
					stopUpd:
				)
				(dave
					view: 904
					setLoop: 2
					setCel: 2
					ignoreActors: 1
					setPri: 3
					init:
					posn: 97 38
					stopUpd:
				)
				(fischbach
					view: 904
					setLoop: 1
					setCel: 2
					ignoreActors: 1
					setPri: 3
					init:
					posn: 97 54
					stopUpd:
				)
				(jerry
					view: 904
					setLoop: 1
					setCel: 1
					ignoreActors: 1
					setPri: 3
					init:
					posn: 97 71
					stopUpd:
				)
				(mickie
					view: 904
					setLoop: 2
					setCel: 1
					ignoreActors: 1
					setPri: 3
					init:
					posn: 97 88
					stopUpd:
				)
				(heitman
					view: 904
					setLoop: 2
					setCel: 0
					ignoreActors: 1
					setPri: 3
					init:
					posn: 97 105
					stopUpd:
				)
				(vu
					view: 904
					setLoop: 5
					setCel: 0
					ignoreActors: 1
					setPri: 3
					init:
					posn: 97 121
					stopUpd:
				)
				(= seconds 2)
			)
			(4
				(bainsScript changeState: 0)
				(= seconds 10)
			)
			(5
				(programming dispose:)
				(jerry dispose:)
				(fischbach dispose:)
				(heitman dispose:)
				(mickie dispose:)
				(dave dispose:)
				(art
					view: 903
					setLoop: 1
					setCel: 0
					ignoreActors: 1
					setPri: 15
					init:
					posn: 38 50
					stopUpd:
				)
				(animation
					view: 903
					setLoop: 1
					setCel: 1
					ignoreActors: 1
					setPri: 15
					init:
					posn: 121 50
					stopUpd:
				)
				(cheri
					view: 904
					setLoop: 3
					setCel: 1
					ignoreActors: 1
					setPri: 3
					init:
					posn: 96 70
					stopUpd:
				)
				(vu setLoop: 3 setCel: 0 posn: 96 90)
				(= seconds 5)
			)
			(6
				(art dispose:)
				(animation dispose:)
				(vu dispose:)
				(cheri dispose:)
				(music
					view: 903
					setLoop: 2
					setCel: 0
					ignoreActors: 1
					setPri: 15
					init:
					posn: 97 50
					stopUpd:
				)
				(chris
					view: 904
					setLoop: 4
					setCel: 0
					ignoreActors: 1
					setPri: 15
					init:
					posn: 97 70
					stopUpd:
				)
				(= seconds 6)
			)
			(7
				(music dispose:)
				(chris dispose:)
				(gCurRoom drawPic: 48)
				(= cycles 10)
			)
			(8
				(localproc_0 200 11) ; "One Year has passed since Detective Sonny Bonds successfully brought Jessie Bains (The Death Angel) to justice. Bains' world of rampant drugs and open violence, the world he controlled so well, has been silenced. As the memory of this animal slowly fades, the city of Lytton once again lives in the peace and serenity of its past."
				(localproc_0 200 12) ; "Officer Sonny Bonds has been promoted to the position of Homicide Detective. The day begins with Detective Bonds arriving for another routine work day, or so it seems..."
				(gCurRoom newRoom: 701)
			)
		)
	)
)

(instance bainsScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(bainsRunning init: setMotion: MoveTo 172 140 self)
				(bainsShadow init: setMotion: MoveTo 162 135)
			)
			(1
				(bainsShadow cel: (bainsShadow cel:) setMotion: MoveTo 235 135)
				(bainsRunning setLoop: 0 cel: (bainsRunning cel:))
				(bainsRunning setMotion: MoveTo 245 140 self)
				(sonnyScript changeState: 0)
			)
			(2
				(bainsShadow cel: (bainsShadow cel:) setMotion: MoveTo 330 135)
				(bainsRunning setLoop: 1 cel: (bainsRunning cel:))
				(bainsRunning setMotion: MoveTo 340 140 self)
			)
			(3
				(bainsRunning dispose:)
				(bainsShadow dispose:)
			)
		)
	)
)

(instance sonnyScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(sonnyRunning setMotion: MoveTo 172 140 self)
				(sonnyShadow setMotion: MoveTo 162 135)
			)
			(1
				(sonnyShadow cel: (sonnyShadow cel:) setMotion: MoveTo 230 135)
				(sonnyRunning setMotion: MoveTo 240 140 self)
				(sonnyRunning setLoop: 0 cel: (sonnyRunning cel:))
			)
			(2
				(sonnyShadow cel: (sonnyShadow cel:) setMotion: MoveTo 330 135)
				(sonnyRunning setMotion: MoveTo 340 140 self)
				(sonnyRunning setLoop: 1 cel: (sonnyRunning cel:))
			)
			(3
				(sonnyRunning dispose:)
				(sonnyShadow dispose:)
			)
		)
	)
)

(instance bubbleScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(bubbles posn: 60 130 setMotion: MoveTo 160 0 self)
			)
			(1
				(self changeState: 0)
			)
		)
	)
)

(instance weed1Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(weeds posn: 10 130 setMotion: MoveTo 300 130 self)
			)
			(2
				(self changeState: 1)
			)
		)
	)
)

(instance weed2Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(3
				(weeds posn: 10 140 setMotion: MoveTo 300 140 self)
			)
			(4
				(self changeState: 1)
			)
		)
	)
)

(instance runNext of Script
	(properties)

	(method (init param1)
		(= state 0)
		(= seconds param1)
	)
)

