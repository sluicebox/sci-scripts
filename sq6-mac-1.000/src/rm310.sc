;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 310)
(include sci.sh)
(use Main)
(use SQRoom)
(use ExitFeature)
(use Scaler)
(use ROsc)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use StopWalk)
(use Grooper)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm310 0
)

(local
	[local0 16] = [151 83 57 91 127 105 127 105 220 92 210 91 355 136 355 136]
	local16
	local17
	local18
	local19
	local20
	local21
	local22
	local23
	local24
	local25
	local26
	local27
	local28
	local29
)

(procedure (localproc_0 param1 &tmp temp0)
	(if (or (not argc) (not param1))
		(return 0)
	)
	(if
		(>
			(= temp0
				(Abs
					(-
						(GetAngle
							(waitron x:)
							(waitron y:)
							(param1 x:)
							(param1 y:)
						)
						(param1 heading:)
					)
				)
			)
			180
		)
		(= temp0 (- 360 temp0))
	)
	(if (<= temp0 (waitron sightAngle:))
		(return 1)
	)
)

(instance rm310 of SQRoom
	(properties
		noun 1
		picture 310
	)

	(method (init)
		(SetFlag 26)
		(SetFlag 55)
		(self
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 311 116 294 111 294 104 277 104 264 106 129 91 40 98 74 114 123 108 165 110 170 118 225 135 311 135
					yourself:
				)
		)
		(super init: &rest)
		(gEgo
			posn: 284 104
			init:
			normalize: 2
			setScaler: Scaler 100 75 121 93
		)
		(= local22 (not (gEgo has: 92))) ; Roger_ID
		(waitron
			init:
			setScaler: Scaler 100 81 104 90
			setLooper: Grooper
			setCycle: StopWalk -1
			ignoreActors: 0
			baseSetter: doBase
			setController: waitronController
		)
		(if (not (IsFlag 13))
			(drug1 init: approachVerbs: 68 setScript: (tokin new:) 0 4) ; Roger_ID
			(drug2 init: approachVerbs: 68 setScript: (tokin new:) 0 3) ; Roger_ID
			(drug3 init: approachVerbs: 68 setScript: (tokin new:) 0 3) ; Roger_ID
		)
		(if local22
			(pilot init: setScript: chugInLug ignoreActors: 1)
		)
		(if
			(and
				(<= gHowFast 8)
				(= local25 (RandomNumber 0 2))
				(> (gGame detailLevel:) 2)
			)
			(Load 140 314) ; WAVE
			(stevie init: ignoreActors: 1 setCycle: Fwd)
			(billy init: setScript: makinFun ignoreActors: 1 setCycle: Fwd)
		)
		(if (= local24 (RandomNumber 0 1))
			(mikey init: setScript: drinkin)
		)
		(if (IsFlag 14)
			(nitroKeg
				posn: 123 88
				approachX: 134
				approachY: 93
				init:
				approachVerbs: 4 ; Do
				ignoreActors: 1
				setCycle: Fwd
				setPri: 50
			)
		else
			(nitroKeg init: approachVerbs: 4 ignoreActors: 1 setCycle: Fwd) ; Do
		)
		(glassOBeerB init: hide: setPri: (+ (mikey priority:) 1))
		(glassOBeerF init: hide:)
		(if (and (IsFlag 13) (not (IsFlag 23)))
			(hookahHoses init: approachVerbs: 4) ; Do
		)
		(elevator init: approachVerbs: 4) ; Do
		(conduit init:)
		(ltbooth init:)
		(rtbooth init:)
		(chairs init:)
		(tubeLights init:)
		(fancyLight init:)
		(floor init:)
		(rail init:)
		(walls init:)
		(exitElevator init: gTheExitSCursor approachVerbs: 4 10) ; Do, ExitDown
		(Load 140 314) ; WAVE
		(Load rsVIEW 314 315 316 317 3170 3150 3160 3140)
		(gGame handsOn:)
	)

	(method (setInset)
		(if (and (laughter handle:) (laughter client:))
			((laughter client:) cue:)
			(laughter stop:)
		)
		(super setInset: &rest)
	)

	(method (newRoom newRoomNumber)
		(gGSound2 stop:)
		(laughter client: 0 stop:)
		(super newRoom: newRoomNumber &rest)
	)

	(method (dispose)
		(gEgo setScale: 0)
		(super dispose: &rest)
	)
)

(class SplitScript of Script
	(properties
		whichSwitch 0
	)

	(method (altChangeState param1)
		(= state param1)
	)

	(method (pickSwitch))

	(method (cue)
		(if client
			(= lastTicks gGameTime)
			(if (== (+ state 1) 0)
				(self pickSwitch:)
			)
			(if whichSwitch
				(self altChangeState: (+ state 1) &rest)
			else
				(self changeState: (+ state 1) &rest)
			)
		)
	)
)

(instance drinkin of SplitScript
	(properties)

	(method (pickSwitch)
		(if (RandomNumber 0 2)
			(= whichSwitch 0)
		else
			(= whichSwitch 1)
		)
	)

	(method (altChangeState param1)
		(switch (= state param1)
			(0
				(= ticks (RandomNumber 210 600))
			)
			(1
				(client loop: 1 cel: 0 setCycle: End self)
			)
			(2
				(= ticks (RandomNumber 10 60))
			)
			(3
				(client setCycle: Beg self)
			)
			(4
				(= state -1)
				(= ticks 1)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks (RandomNumber 180 360))
			)
			(1
				(client loop: 0 cel: 0 setCycle: End self)
			)
			(2
				(= state -1)
				(= ticks 1)
			)
		)
	)
)

(instance tokin of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks (RandomNumber 15 75))
			)
			(1
				(client setCycle: End self)
			)
			(2
				(client setCel: 0 setCycle: CT register 1 self)
			)
			(3
				(= state -1)
				(= ticks 1)
			)
		)
	)
)

(instance chugInLug of SplitScript
	(properties)

	(method (pickSwitch)
		(if (and local18 (glassOBeerF isNotHidden:))
			(= whichSwitch 1)
		else
			(= whichSwitch 0)
		)
	)

	(method (altChangeState param1)
		(switch (= state param1)
			(0
				(= ticks (RandomNumber 15 45))
			)
			(1
				(client loop: 5 cel: 0 setCycle: CT 2 1 self)
			)
			(2
				(if
					(and
						(waitron script:)
						(or
							(== (waitron script:) wipeFrontTable)
							(== (waitron script:) giveFrontTableDrink)
						)
					)
					(-- state)
					(= ticks 30)
				else
					(= ticks 1)
				)
			)
			(3
				(glassOBeerF hide:)
				(client setCycle: End self)
			)
			(4
				(= state -1)
				(= ticks 1)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks (RandomNumber 300 480))
			)
			(1
				(if (or (not local18) (glassOBeerF isNotHidden:))
					(= state -1)
				)
				(= ticks 1)
			)
			(2
				(client loop: 0 cel: 0 setCycle: End self)
			)
			(3
				(client loop: 1 cel: 0 setCycle: End self)
			)
			(4
				(client loop: 2 cel: 0 setCycle: Fwd)
				(= ticks (RandomNumber 45 75))
			)
			(5
				(if (and (RandomNumber 0 1) (<= local27 3))
					(++ local27)
					(client loop: 3 cel: 0 setCycle: End self)
				else
					(= local27 0)
					(client loop: 4 cel: 0 setCycle: End self)
					(= local18 0)
				)
			)
			(6
				(if local18
					(client loop: 0 cel: (client lastCel:) setCycle: Beg self)
				else
					(client loop: 5 cel: 0)
					(= cycles 2)
				)
			)
			(7
				(= state -1)
				(= ticks 1)
			)
		)
	)
)

(instance makinFun of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks (RandomNumber 660 900))
			)
			(1
				(client loop: 1 cel: 0 setCycle: Fwd)
				(= ticks 120)
			)
			(2
				(if (not (gTalkers isEmpty:))
					(client setCycle: Beg)
					(= state -1)
				)
				(= ticks 1)
			)
			(3
				(laughter play: self setVol: 127)
				(= ticks 30)
			)
			(4
				(stevie hide:)
				(client loop: 2 setCel: 0 setCycle: End self)
			)
			(5
				(client loop: 3 setCel: 0 setCycle: RandCycle)
			)
			(6
				(client setCycle: End self)
			)
			(7
				(client loop: 5 cel: 0 setCycle: End self)
			)
			(8
				(stevie show: setCycle: Fwd)
				(client loop: 4 cel: 0 setCycle: Fwd)
				(= state -1)
				(= ticks 1)
			)
		)
	)
)

(instance druggiesSplit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(drug2 setScript: 0 setCycle: 0)
				(drug3 setScript: 0 setCycle: 0)
				(client
					view: 312
					loop: 0
					cel: 0
					posn: 55 87
					cycleSpeed: 6
					setCycle: CT 2 1 self
				)
			)
			(1
				(gMessager say: 13 68 0 0 self) ; "You hear them say "Geez, our skimmer's double-hovered. We gotta run.""
			)
			(2
				(client setCycle: End self)
				(gGSound2 number: 311 setLoop: 0 play: setVol: 127)
			)
			(3
				(hookahHoses init: approachVerbs: 4) ; Do
				(drug2 hide: dispose:)
				(drug3 hide: dispose:)
				(client loop: 1 cel: 0 setCycle: End self)
			)
			(4
				(SetFlag 13)
				(client hide: dispose:)
			)
		)
	)
)

(instance wipeFrontTable of Script
	(properties)

	(method (init)
		(super init: &rest)
		(= register 0)
	)

	(method (doit)
		(super doit: &rest)
		(if register
			(= register 0)
			(self cue:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client
					approachVerbs: 4 ; Do
					setApproachPt: 74 114
					setHeading: 180 self
					setPri: 125
				)
			)
			(1
				(client view: 317 setLoop: 0 1 cel: 0 setPri: 127)
				(= ticks 120)
			)
			(2
				(if (not local17)
					(= ticks 1)
				)
			)
			(3
				(client setCycle: End self)
			)
			(4
				(= local16 1)
				(client loop: 1 cel: 0 setCycle: Fwd)
				(= ticks 240)
			)
			(5
				(if (not local17)
					(= ticks 1)
				)
			)
			(6
				(client setCycle: End self)
			)
			(7
				(= local16 0)
				(= local26 1)
				(client loop: 0 cel: (client lastCel:) setCycle: Beg self)
			)
			(8
				(client
					view: 314
					setLoop: 2 0
					setPri: -1
					setLooper: Grooper
					setCycle: StopWalk -1
					approachVerbs:
					setApproachPt:
				)
				(= local26 0)
				(self dispose:)
			)
		)
	)
)

(instance wipeBackTable of Script
	(properties)

	(method (init)
		(super init: &rest)
		(= register 0)
	)

	(method (doit)
		(super doit: &rest)
		(if register
			(= register 0)
			(self cue:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client
					approachVerbs: 4 ; Do
					setApproachPt: 264 106
					setHeading: 45 self
				)
			)
			(1
				(client view: 3170 setLoop: 0 1 cel: 0)
				(= ticks 120)
			)
			(2
				(if (not local17)
					(= ticks 1)
				)
			)
			(3
				(client setCycle: End self)
			)
			(4
				(= local16 1)
				(client loop: 1 cel: 0 setCycle: Fwd)
				(= ticks 240)
			)
			(5
				(if (not local17)
					(= ticks 1)
				)
			)
			(6
				(client setCycle: End self)
			)
			(7
				(= local16 0)
				(= local26 1)
				(client loop: 0 cel: (client lastCel:) setCycle: Beg self)
			)
			(8
				(client
					view: 314
					setLoop: 3 0
					setLooper: Grooper
					setCycle: StopWalk -1
					approachVerbs:
					setApproachPt:
				)
				(= local26 0)
				(self dispose:)
			)
		)
	)
)

(instance giveFrontTableDrink of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client
					approachVerbs: 4 ; Do
					setApproachPt: 74 114
					setHeading: 180 self
					setPri: 125
				)
			)
			(1
				(client
					view: 315
					setLoop: 0 1
					cel: 0
					setPri: 127
					setCycle: End self
				)
			)
			(2
				(glassOBeerF setPri: (- (pilot priority:) 1) show:)
				(= local18 1)
				(= local20 0)
				(client view: 316 loop: 0 cel: 0 setCycle: End self)
			)
			(3
				(if (not local17)
					(= ticks 1)
				)
			)
			(4
				(client
					view: 314
					setLoop: 2 0
					setPri: -1
					setLooper: Grooper
					setCycle: StopWalk -1
					approachVerbs:
					setApproachPt:
				)
				(self dispose:)
			)
		)
	)
)

(instance giveBackTableDrink of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client
					approachVerbs: 4 ; Do
					setApproachPt: 264 106
					setHeading: 45 self
				)
			)
			(1
				(client view: 3150 setLoop: 0 1 cel: 0 setCycle: End self)
			)
			(2
				(glassOBeerB show:)
				(= local19 1)
				(= local20 0)
				(client view: 3160 loop: 0 cel: 0 setCycle: End self)
			)
			(3
				(if (not local17)
					(= ticks 1)
				)
			)
			(4
				(client
					view: 314
					setLoop: 3 0
					setLooper: Grooper
					setCycle: StopWalk -1
					approachVerbs:
					setApproachPt:
				)
				(self dispose:)
			)
		)
	)
)

(instance waitronGetsDrink of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local20 1)
				(client view: 3140 setHeading: 180 self)
			)
			(1
				(if register
					(= ticks register)
				else
					(= ticks 270)
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance waitronRests of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local20 0)
				(client view: 314 setHeading: 180 self)
			)
			(1
				(if register
					(= ticks register)
				else
					(= ticks 270)
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance waitronScoldsNW of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client view: 318 loop: 0 cel: 0 setPri: 125 setCycle: End self)
			)
			(1
				(gMessager say: 16 4 7 0 self) ; "HEY, BUDDY! Get your paws outta my tips or I'll liberate your favorite organ. I'll even let you choose. Or, you can leave my tips alone and you won't have to worry about that decision. It's up to you."
				(client
					setCycle: ROsc 101 (- (client lastCel:) 1) (client lastCel:)
				)
			)
			(2
				(client
					view: 314
					setPri: -1
					setLoop: 2 0
					setLooper: Grooper
					setCycle: StopWalk -1
				)
				(if register
					(register register: 1)
				)
				(self dispose:)
			)
		)
	)
)

(instance waitronScoldsSE of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client view: 3180 loop: 0 cel: 0 setCycle: End self)
			)
			(1
				(gMessager say: 16 4 7 0 self) ; "HEY, BUDDY! Get your paws outta my tips or I'll liberate your favorite organ. I'll even let you choose. Or, you can leave my tips alone and you won't have to worry about that decision. It's up to you."
				(client
					setCycle: ROsc 101 (- (client lastCel:) 1) (client lastCel:)
				)
			)
			(2
				(client
					view: 314
					setPri: -1
					setLoop: 2 0
					setLooper: Grooper
					setCycle: StopWalk -1
				)
				(if register
					(register register: 1)
				)
				(self dispose:)
			)
		)
	)
)

(instance waitronTalksToRog of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if
					(>=
						(GetDistance
							(gEgo x:)
							(gEgo y:)
							(waitron x:)
							(waitron y:)
						)
						30
					)
					(= temp0
						(*
							(= temp0
								(-
									(= temp0
										(GetAngle
											(waitron x:)
											(waitron y:)
											(gEgo x:)
											(gEgo y:)
										)
									)
									90
								)
							)
							-1
						)
					)
					(= temp1 (+ (waitron x:) (CosMult temp0 30)))
					(= temp2 (- (waitron y:) (SinMult temp0 30)))
					(gEgo setMotion: PolyPath temp1 temp2 self)
				else
					(= ticks 1)
				)
			)
			(1
				(if (not (localproc_0 gEgo))
					(Face client gEgo self)
				else
					(= ticks 1)
				)
			)
			(2
				(gMessager say: 16 2 0 0 self) ; "Howdy, Dollface. What can I get ya'?"
			)
			(3
				(waitronController restart:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance visitDruggies of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setHeading: 0 self)
			)
			(1
				(if register
					(= ticks register)
				else
					(= ticks 270)
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance downWeGo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 180 self)
			)
			(1
				(gCurRoom newRoom: 300)
			)
		)
	)
)

(instance egoFlashesID of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(client view: 311 loop: 0 cel: 0 setSpeed: 6 setCycle: End self)
			)
			(1
				(client loop: 1 cel: 0 setCycle: Fwd)
				(= ticks 60)
			)
			(2
				(Load 140 311) ; WAVE
				(drug1 setCycle: 0 setScript: druggiesSplit self)
				(client setCycle: 0)
			)
			(3
				(client loop: 0 cel: (client lastCel:) setCycle: Beg self)
			)
			(4
				(client normalize: 7)
				(gGame points: 3 449 handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance egoGrabsBucksNW of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local17 1)
				(Load 140 313) ; WAVE
				(client setHeading: 315 self)
			)
			(1
				(client view: 3191 loop: 0 cel: 0 setCycle: End self)
			)
			(2
				(gGSound2 number: 313 setLoop: 0 play: setVol: 127)
				(gMessager say: 16 4 5) ; "You snag a buckazoid off the waitron. How cool you are."
				(client loop: 1 cel: 0 setCycle: End self)
			)
			(3
				(client
					loop: 0
					cel: (gEgo lastCel:)
					setCycle: Beg self
					get: 13 ; Buckazoids
				)
				(++ gBuckazoidCount)
			)
			(4
				(client normalize: 7)
				(= local17 0)
				(wipeBackTable register: 1)
				(gGame points: 3 448 handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance egoGrabsBucksSE of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local17 1)
				(Load 140 313) ; WAVE
				(client setHeading: 135 self)
			)
			(1
				(client view: 319 loop: 0 cel: 0 setCycle: End self)
			)
			(2
				(gMessager say: 16 4 5) ; "You snag a buckazoid off the waitron. How cool you are."
				(client loop: 1 cel: 0 setCycle: End self)
				(gGSound2 number: 313 setLoop: 0 play: setVol: 127)
			)
			(3
				(client
					loop: 0
					cel: (gEgo lastCel:)
					setCycle: Beg self
					get: 13 ; Buckazoids
				)
				(++ gBuckazoidCount)
			)
			(4
				(client normalize: 4)
				(= local17 0)
				(wipeFrontTable register: 1)
				(gGame points: 3 448 handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance egoGrovelsSE of Script
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
				(= local17 1)
				(gGame handsOff:)
				(client setHeading: 135 self)
			)
			(1
				(client view: 319 loop: 0 cel: 0 setCycle: End self)
			)
			(2
				(waitron setScript: waitronScoldsNW waitronController self)
				(client view: 3190 loop: 1 cel: 0 setCycle: End self)
			)
			(3)
			(4
				(= local17 0)
				(client normalize: 4)
				(gGame handsOn:)
				(if (>= gBuckazoidCount 19)
					(gMessager say: 16 4 6) ; "Hey, don't be greedy. It's bad enough that you stole already."
				)
				(self dispose:)
			)
		)
	)
)

(instance egoGrovelsNW of Script
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
				(= local17 1)
				(gGame handsOff:)
				(client setHeading: 315 self)
			)
			(1
				(client view: 3191 loop: 0 cel: 0 setCycle: End self)
			)
			(2
				(waitron setScript: waitronScoldsSE waitronController self)
				(client view: 3192 loop: 1 cel: 0 setCycle: End self)
			)
			(3)
			(4
				(= local17 0)
				(client normalize: 7)
				(gGame handsOn:)
				(if (>= gBuckazoidCount 19)
					(gMessager say: 16 4 6) ; "Hey, don't be greedy. It's bad enough that you stole already."
				)
				(self dispose:)
			)
		)
	)
)

(instance egoPicksUpKeg of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(nitroKeg hide:)
				(client
					view: 313
					setLoop: 0 1
					cel: 0
					setScale: 0
					setSpeed: 6
					setCycle: End self
				)
			)
			(1
				(= local23 (gDoCursor view:))
				(gDoCursor setView: 9530)
				(gGame points: 1 451 handsOn:)
				(gTheIconBar disable: 0 1 3 4 7)
				(self dispose:)
			)
		)
	)
)

(instance egoPutsDownKeg of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(client view: 313 loop: 0)
				(client cel: (client lastCel:) setSpeed: 6 setCycle: Beg self)
			)
			(1
				(nitroKeg show:)
				(client normalize: 7 setScaler: Scaler 100 75 121 93)
				(if local23
					(gDoCursor setView: local23)
					(= local23 0)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance egoDragsKeg of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(client view: 313 loop: 1 cel: 0 setSpeed: 6 setCycle: End self)
			)
			(1
				(gGSound2 number: 312 setLoop: 0 play: setVol: 127)
				(nitroKeg
					posn: 123 88
					approachX: 134
					approachY: 93
					show:
					setPri: 50
				)
				(client loop: 2 cel: 0 posn: 134 93 setCycle: End self)
			)
			(2
				(gMessager say: 10 155 0 0 self) ; "The canister snaps neatly into the conduit opening."
			)
			(3
				(SetFlag 14)
				(client normalize: 7 setScaler: Scaler 100 75 121 93)
				(if local23
					(gDoCursor setView: local23)
					(= local23 0)
				)
				(gGame points: 5 452 handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance egoTurnKegOnOff of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load 140 303) ; WAVE
				(client
					view: 313
					loop: 4
					cel: 0
					setScale: 0
					setSpeed: 6
					setCycle: CT 2 1 self
				)
			)
			(1
				(gGSound2 number: 303 setLoop: -1 play: setVol: 127)
				(client setCycle: ROsc 3 2 3 self)
			)
			(2
				(gGSound2 stop:)
				(client setCycle: End self)
			)
			(3
				(if (IsFlag 20)
					(ClearFlag 20)
					(gMessager say: 10 4 10 0) ; "The nitro stops flowing."
				else
					(gMessager say: 10 4 11 0) ; "Nitro begins to flow through the tubing and into the conduit."
					(SetFlag 20)
				)
				(client normalize: 7 setScaler: Scaler 100 75 121 93)
				(gGame points: 3 453 handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance egoGetsHooked of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(client
					view: 3100
					loop: 4
					cel: 0
					setSpeed: 6
					setScale: 0
					setCycle: CT 2 1 self
				)
			)
			(1
				(hookahHoses hide: dispose:)
				(client setCycle: End self)
			)
			(2
				(SetFlag 23)
				(gEgo get: 58 normalize: 7 setScaler: Scaler 100 75 121 93) ; Hookah_Hose
				(gGame points: 1 450)
				(= cycles 2)
			)
			(3
				(gMessager say: 15 4 4 0 self) ; "You snag the four hoses. Never know when you're going to meet that special lady."
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(class Druggie of Prop
	(properties
		approachX 50
		approachY 102
	)

	(method (doVerb theVerb)
		(switch theVerb
			(68 ; Roger_ID
				(if (not (IsFlag 13))
					(gEgo setScript: egoFlashesID)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance drug1 of Druggie
	(properties
		noun 13
		x 55
		y 87
		view 310
		cycleSpeed 10
	)

	(method (init)
		(|= signal $1000)
		(super init: &rest)
	)
)

(instance drug2 of Druggie
	(properties
		noun 14
		x 30
		y 67
		view 310
		loop 1
		cycleSpeed 10
	)

	(method (init)
		(|= signal $1000)
		(super init: &rest)
	)
)

(instance drug3 of Druggie
	(properties
		noun 12
		x 10
		y 87
		z 4
		view 310
		loop 2
		cycleSpeed 12
	)

	(method (init)
		(|= signal $1000)
		(super init: &rest)
	)
)

(instance nitroKeg of Prop
	(properties
		noun 10
		approachX 50
		approachY 102
		x 38
		y 97
		view 3100
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((and (IsFlag 13) (not (IsFlag 14)))
						(if local21
							(= local21 0)
							(if (gMouseDownHandler contains: self)
								(gMouseDownHandler delete: self)
							)
							(gEgo setScript: egoPutsDownKeg)
						else
							(= local21 1)
							(gMouseDownHandler addToFront: self)
							(gEgo setScript: egoPicksUpKeg)
						)
					)
					((IsFlag 14)
						(gEgo setScript: egoTurnKegOnOff)
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(1 ; Look
				(cond
					((and (not (IsFlag 14)) (not (IsFlag 13)))
						(gMessager say: noun theVerb 17 0) ; "As with some other tables, a large tank marked Liquid Nitrogen sits beneath the center. It feeds the hookah manifold above. A set of hoses are within reach for each being which might be perched there."
					)
					((and (not (IsFlag 14)) (IsFlag 13))
						(gMessager say: noun theVerb 15 0) ; "The druggies are gone, leaving a partially-used nitro tank."
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (handleEvent event)
		(if
			(and
				(& (event type:) evMOUSEBUTTON)
				(or (waitron onMe: event) (not (conduit onMe: event)))
				local21
			)
			(= local21 0)
			(if (gMouseDownHandler contains: self)
				(gMouseDownHandler delete: self)
			)
			(gEgo setScript: egoPutsDownKeg)
			(event claimed: 1)
			(return 1)
		else
			(super handleEvent: event &rest)
		)
	)

	(method (dispose)
		(if (gMouseDownHandler contains: self)
			(gMouseDownHandler delete: self)
		)
		(super dispose: &rest)
	)
)

(instance pilot of Prop
	(properties
		noun 21
		x 90
		y 109
		priority 128
		fixPriority 1
		view 3101
		loop 5
	)

	(method (init)
		(|= signal $1000)
		(super init: &rest)
	)
)

(instance stevie of Prop
	(properties
		noun 20
		x 174
		y 152
		priority 138
		fixPriority 1
		view 3103
	)

	(method (init)
		(|= signal $1000)
		(super init: &rest)
	)
)

(instance billy of Prop
	(properties
		noun 20
		x 174
		y 152
		priority 139
		fixPriority 1
		view 3103
		loop 4
	)

	(method (init)
		(|= signal $1000)
		(super init: &rest)
	)
)

(instance mikey of Prop
	(properties
		noun 22
		x 242
		y 82
		view 3102
		loop 1
	)

	(method (init)
		(|= signal $1000)
		(super init: &rest)
	)
)

(instance glassOBeerB of View
	(properties
		x 231
		y 82
		view 3100
		loop 2
	)

	(method (init)
		(|= signal $1000)
		(super init: &rest)
	)
)

(instance glassOBeerF of View
	(properties
		x 112
		y 98
		priority 130
		fixPriority 1
		view 3100
		loop 2
	)

	(method (init)
		(|= signal $1000)
		(super init: &rest)
	)
)

(instance hookahHoses of View
	(properties
		noun 15
		approachX 50
		approachY 102
		x 29
		y 88
		z 10
		view 3100
		loop 3
	)

	(method (init)
		(|= signal $1000)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (and (IsFlag 13) (not (IsFlag 23)))
					(gEgo setScript: egoGetsHooked)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance elevator of View
	(properties
		x 284
		y 102
		view 3130
	)

	(method (init)
		(|= signal $1000)
		(= actions exitElevator)
		(= approachX (actions approachX:))
		(= approachY (actions approachY:))
		(super init: &rest)
	)

	(method (dispose)
		(= actions 0)
		(super dispose: &rest)
	)
)

(instance conduit of Feature
	(properties
		noun 19
		x 139
		y 80
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 114 75 127 75 127 87 114 87
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (and (not (IsFlag 14)) local21)
					(= local21 0)
					(gEgo setScript: egoDragsKeg)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance rtbooth of Feature
	(properties
		noun 5
		sightAngle 40
		x 220
		y 64
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 181 72 221 69 259 70 257 99 182 91
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (and (not local24) (or (== theVerb 4) (== theVerb 1) (== theVerb 2))) ; Do, Look, Talk
			(gMessager say: noun theVerb 4 0)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance ltbooth of Feature
	(properties
		noun 5
		sightAngle 40
		x 25
		y 64
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 9 53 72 53 72 90 21 93 9 87
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (and (IsFlag 13) (or (== theVerb 4) (== theVerb 1) (== theVerb 2))) ; Do, Look, Talk
			(gMessager say: noun theVerb 4 0)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance chairs of Feature
	(properties
		noun 4
		sightAngle 40
		x 119
		y 105
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 158 81 166 89 166 116 135 116 136 105 155 102 154 92
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 79 81 72 90 72 116 102 116 102 106 83 102 83 89
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (and (not local22) (or (== theVerb 4) (== theVerb 1))) ; Do, Look
			(gMessager say: noun theVerb 4)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance tubeLights of Feature
	(properties
		noun 8
		sightAngle 40
		x 230
		y 21
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 222 5 230 3 239 12 238 39 223 38
					yourself:
				)
				((Polygon new:) type: PTotalAccess init: 24 0 38 0 38 42 24 42 yourself:)
		)
		(super init: &rest)
	)
)

(instance fancyLight of Feature
	(properties
		noun 17
		sightAngle 40
		x 127
		y 50
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 86 0 169 0 171 19 162 28 143 37 115 38 92 28 84 17
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance floor of Feature
	(properties
		noun 6
		x 173
		y 100
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 27 98 134 86 319 117 319 136 84 137 30 107
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance rail of Feature
	(properties
		noun 7
		sightAngle 40
		x 87
		y 110
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 7 80 168 138 159 138 7 83
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance walls of Feature
	(properties
		noun 11
		x 126
		y 45
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 180 0 180 90 146 85 73 89 73 0
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 234 0 282 0 298 36 249 36
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance exitElevator of ExitFeature
	(properties
		noun 9
		sightAngle 40
		approachX 284
		approachY 104
		x 284
		y 105
		nextRoom 300
		message 10
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 259 38 266 72 266 105 280 107 288 107 298 105 298 70 289 38
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if
			(and
				(& (event type:) evVERB)
				(self onMe: event)
				(not (event claimed:))
				(self isNotHidden:)
				(== (event message:) message)
			)
			(= sightAngle 26505)
		else
			(= sightAngle 40)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gEgo setScript: downWeGo)
			)
			(10 ; ExitDown
				(gEgo setScript: downWeGo)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(class Controller of Obj
	(properties
		client 0
		state -1
		start 0
		pair -1
		x -1
		y -1
		qScript 0
		holdPair -1
	)

	(method (setTarget))

	(method (onTarget))

	(method (moveDone))

	(method (queueScript))

	(method (restart)
		(self init: client)
	)

	(method (init param1)
		(if (>= argc 1)
			((= client param1) controller: self)
		)
		(= state (- start 1))
		(self cue:)
	)

	(method (dispose)
		(= client 0)
		(super dispose:)
	)

	(method (changeState newState)
		(= state newState)
	)

	(method (cue)
		(if client
			(self changeState: (+ state 1) &rest)
		)
	)
)

(class ControlledActor of Actor
	(properties
		controller 0
	)

	(method (setController param1)
		(if controller
			(controller dispose:)
		)
		(if param1
			(param1 init: self &rest)
		)
	)

	(method (setApproachPt param1 param2)
		(if (>= argc 1)
			(= approachX param1)
			(if (>= argc 2)
				(= approachY param2)
			)
		else
			(= approachY (= approachX 0))
		)
	)

	(method (setScript)
		(if (and controller script (== (script caller:) controller))
			(script caller: 0)
		)
		(super setScript: &rest)
	)

	(method (doit)
		(if controller
			(controller doit:)
		)
		(super doit: &rest)
	)

	(method (dispose)
		(self setController: 0)
		(super dispose: &rest)
	)
)

(instance waitronController of Controller
	(properties)

	(method (setTarget &tmp temp0 temp1)
		(= temp1 0)
		(= temp0 pair)
		(while (== pair temp0)
			(if (> (++ temp1) 100)
				(break)
			)
			(if (!= holdPair -1)
				(= pair holdPair)
				(= holdPair -1)
				(break)
			)
			(cond
				((client isBlocked:)
					(= holdPair pair)
					(= pair 8)
					(if (> (gEgo x:) (waitron x:))
						(= x (- (waitron x:) 1))
					else
						(= x (+ (waitron x:) 1))
					)
					(cond
						((and (< 120 (waitron x:) 190) (< 100 (waitron y:) 120))
							(= y (- (waitron y:) 8))
						)
						((RandomNumber 0 2)
							(= y (- (waitron y:) 6))
						)
						(else
							(= y (+ (waitron y:) 6))
						)
					)
					(client signal: (& (client signal:) $fbff))
					(break)
				)
				(local20
					(if (and local24 (not local19))
						(= pair 5)
						(continue)
					)
					(if (and local22 (not local18))
						(= pair 3)
						(continue)
					)
					(= pair 7)
				)
				(else
					(if (and local18 local19)
						(switch (RandomNumber 0 2)
							(0
								(= pair 7)
							)
							(1
								(= pair 4)
							)
							(2
								(= pair 2)
							)
						)
						(continue)
					)
					(switch (RandomNumber 0 3)
						(0
							(= pair 6)
						)
						(1
							(= pair 7)
						)
						(2
							(= pair 4)
						)
						(3
							(= pair 2)
						)
					)
				)
			)
		)
		(if (!= pair 8)
			(= x [local0 (* pair 2)])
			(= y [local0 (+ (* pair 2) 1)])
		)
	)

	(method (onTarget)
		(return
			(and
				(<= (Abs (- (client x:) x)) (client xStep:))
				(<= (Abs (- (client y:) y)) (client yStep:))
			)
		)
	)

	(method (moveDone)
		(if (self onTarget:)
			(switch pair
				(2
					(client setScript: wipeFrontTable self)
				)
				(3
					(client setScript: giveFrontTableDrink self)
				)
				(4
					(client setScript: wipeBackTable self)
				)
				(5
					(client setScript: giveBackTableDrink self)
				)
				(1
					(client setScript: visitDruggies self 120)
				)
				(0
					(client setScript: waitronRests self 20)
				)
				(6
					(client setScript: waitronGetsDrink self 600)
				)
				(7
					(client setScript: waitronRests self 720)
				)
				(8
					(self cue:)
				)
			)
		else
			(self cue:)
		)
	)

	(method (queueScript param1)
		(if (and argc param1)
			(= qScript param1)
			(return 1)
		else
			(return 0)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= qScript 0)
				(self setTarget:)
				(client setMotion: WaiterTo x y self)
			)
			(1
				(self moveDone:)
			)
			(2
				(if qScript
					(waitron setScript: qScript self)
				else
					(self changeState: -1 cue:)
				)
			)
		)
	)

	(method (restart)
		(switch state
			(0
				(client setMotion: WaiterTo x y self)
			)
			(else 0)
		)
	)
)

(instance waitron of ControlledActor
	(properties
		noun 16
		sightAngle 40
		x 175
		y 100
		view 314
	)

	(method (setHeading param1)
		(switch param1
			(0
				(if (== loop 3)
					(return)
				else
					(super setHeading: param1 &rest)
				)
			)
			(45
				(if (== loop 6)
					(return)
				else
					(super setHeading: param1 &rest)
				)
			)
			(90
				(if (== loop 0)
					(return)
				else
					(super setHeading: param1 &rest)
				)
			)
			(135
				(if (== loop 4)
					(return)
				else
					(super setHeading: param1 &rest)
				)
			)
			(180
				(if (== loop 2)
					(return)
				else
					(super setHeading: param1 &rest)
				)
			)
			(225
				(if (== loop 5)
					(return)
				else
					(super setHeading: param1 &rest)
				)
			)
			(270
				(if (== loop 1)
					(return)
				else
					(super setHeading: param1 &rest)
				)
			)
			(315
				(if (== loop 7)
					(return)
				else
					(super setHeading: param1 &rest)
				)
			)
			(else
				(super setHeading: param1 &rest)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					(local21)
					((not script)
						(super doVerb: theVerb &rest)
					)
					(local26)
					((and (== script wipeFrontTable) local16 (< gBuckazoidCount 19))
						(gEgo setScript: egoGrabsBucksSE)
					)
					((and (== script wipeFrontTable) local16 (>= gBuckazoidCount 19))
						(gEgo setScript: egoGrovelsSE)
					)
					((and (== script wipeFrontTable) (not local16))
						(gEgo setScript: egoGrovelsSE)
					)
					((and (== script wipeBackTable) local16 (< gBuckazoidCount 19))
						(gEgo setScript: egoGrabsBucksNW)
					)
					((and (== script wipeBackTable) local16 (>= gBuckazoidCount 19))
						(gEgo setScript: egoGrovelsNW)
					)
					((and (== script wipeBackTable) (not local16))
						(gEgo setScript: egoGrovelsNW)
					)
					((== script giveFrontTableDrink)
						(gEgo setScript: egoGrovelsSE)
					)
					((== script giveBackTableDrink)
						(gEgo setScript: egoGrovelsNW)
					)
				)
			)
			(2 ; Talk
				(cond
					((or (not gTalkers) (not (gTalkers isEmpty:))))
					((gEgo script:))
					((and (not script) mover)
						(waitron setMotion: 0)
						(waitron setScript: waitronTalksToRog)
					)
					(else
						(gMessager say: 16 2 16 0) ; "Gee, she looks pretty busy right now. Maybe I should wait until she's done with that table."
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance WaiterTo of MoveTo
	(properties)

	(method (init param1 param2 param3 param4 &tmp temp0 temp1)
		(if (>= argc 1)
			(= client param1)
			(if (>= argc 2)
				(= x param2)
				(if (>= argc 3)
					(= y param3)
					(if (>= argc 4)
						(= caller param4)
					)
				)
			)
		)
		(= completed 0)
		(= xLast (client x:))
		(= yLast (client y:))
		(= b-moveCnt (+ 1 (client moveSpeed:) gGameTime))
		(if (= temp1 (client cycler:))
			(temp1 cycleCnt: b-moveCnt)
		)
		(if
			(and
				(not (client isBlocked:))
				(client cycler:)
				(GetDistance (= temp0 (client x:)) (= temp1 (client y:)) x y)
			)
			(client
				setHeading: (GetAngle (* temp0 4) (* temp1 5) (* x 4) (* y 5))
			)
		)
		(InitBresen self)
	)

	(method (doit)
		(if (client isBlocked:)
			(self moveDone:)
		)
		(super doit: &rest)
	)
)

(instance laughter of Sound
	(properties
		flags 1
		number 314
		loop 0
	)
)

(instance doBase of Code
	(properties)

	(method (doit param1)
		(if (and argc param1)
			(= local28 (/ (- (param1 nsRight:) (param1 nsLeft:)) 2))
			(= local29 (if (param1 script:) 1 else 3))
			(param1
				brLeft: (- (param1 x:) local28)
				brTop: (- (param1 y:) local29)
				brBottom: (+ (param1 y:) local29)
				brRight: (+ (param1 x:) local28)
			)
		)
	)
)

