;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7)
(include sci.sh)
(use Main)
(use Interface)
(use Osc)
(use Polygon)
(use Feature)
(use MoveFwd)
(use LoadMany)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm7 0
)

(instance rm7 of Rm
	(properties
		lookStr {This is the Star Generator Development Laboratory. Due to your incredibly low security clearance, you have never had access to this room. What a mess! Wreckage clutters the middle of the floor. A pair of lab workers have been blasted from the roster of the living. You're glad somebody else has to clean this up!}
		picture 7
		east 6
		south 6
	)

	(method (init)
		(LoadMany rsVIEW 53 4 400)
		(self setRegions: 700) ; arcadaRegion
		(deadMan1 init:)
		(deadMan2 init:)
		(= global166 2)
		(if (not (gEgo has: 15)) ; Widget
			(Load rsVIEW 57)
			(widget init:)
		)
		(super init:)
		(if (!= (gLongSong number:) 355)
			(gLongSong number: 319 loop: 1 play: 40 fade: 127 25 10 0 hold: 1)
		)
		(gFeatures
			add:
				miscEquip
				baseSupport
				upperSupport
				floor
				starChart
				glassGlobe
				rightConsole
			eachElementDo: #init
		)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 189 0 0 319 0 319 155 298 146 287 152 270 157 243 145 241 140 244 135 241 132 226 129 224 126 204 123 177 121 134 121 100 121 72 124 80 129 81 133 70 136 70 148 42 158 26 160 43 167 72 177 114 186 301 186 303 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 128 131 179 131 196 155 194 162 181 167 161 167 140 164 127 161 122 155 115 155 103 156 96 153 97 149 104 146 102 140 103 132
					yourself:
				)
		)
		(gEgo init:)
		(self setScript: enterScript)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			(
				(= temp0
					(switch ((User alterEgo:) edgeHit:)
						(2 east)
						(3 south)
					)
				)
				(self setScript: ExitRoom)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(if (!= (gLongSong number:) 355)
			(gLongSong hold: 0 fade:)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance ExitRoom of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (== state 0) (> (gEgo nsLeft:) 320))
			(= cycles 1)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setHeading: 135 setMotion: MoveFwd 100)
			)
			(1
				(gEgo setHeading: 180 self)
			)
			(2
				(gCurRoom newRoom: 6)
			)
		)
	)
)

(instance enterScript of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(HandsOff)
				(if (IsFlag 17)
					(= state 3)
				)
				(gEgo
					posn: 330 239
					setLoop: 7
					setPri: -1
					setMotion: MoveTo 280 185 self
				)
			)
			(1
				(gSoundEffects number: 816 loop: 1 play:)
				(gEgo view: 53 cycleSpeed: 5 setLoop: 0 setCycle: End self)
			)
			(2
				(gEgo setLoop: 1 setCycle: End self)
			)
			(3
				(gEgo cycleSpeed: 2)
				(= seconds 1)
			)
			(4
				(HandsOn)
				(SetFlag 17)
				(NormalEgo 1 0 60)
				(self dispose:)
			)
		)
	)
)

(instance searchBody of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setHeading: 0 self)
			)
			(1
				(if register
					(Print 7 0) ; "Your search of the body reveals nothing."
					(= state 2)
				)
				(gEgo
					view: 4
					loop: (if (< (gEgo x:) ((CueObj client:) x:)) 5 else 4)
					cycleSpeed: 5
					cel: register
					setCycle: (if register Beg else End) self
				)
			)
			(2
				(gEgo
					loop: (+ (gEgo loop:) 2)
					cel: 0
					cycleSpeed: 2
					setCycle: Osc 2 self
				)
				(= state 0)
				(= register 3)
			)
			(3
				(HandsOn)
				(= state -1)
				(= register 0)
				(NormalEgo 3 0 60)
				(self dispose:)
			)
		)
	)
)

(instance getWidget of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo view: 57 loop: 0 cel: 0 setCycle: CT 2 1 self)
			)
			(1
				(widget dispose:)
				(SetScore 1 133)
				(gEgo get: 15) ; Widget
				(gEgo setCycle: End self)
			)
			(2
				(HandsOn)
				(NormalEgo 6 0 60)
				(self dispose:)
			)
		)
	)
)

(instance deadMan1 of View
	(properties
		x 42
		y 157
		description {Randy}
		sightAngle 45
		approachX 67
		approachY 156
		lookStr {The lifeless body of Randy, one of the lab technicians, lies sprawled at your feet. Those laser blasts are nasty. Why, you can't distinguish one exposed organ from another.}
		view 400
		cel 7
		priority 4
		signal 16400
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 2 5 3) ; Look, Talk, Do
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(gCurRoom setScript: searchBody)
			)
			(5 ; Talk
				(Print 7 1) ; "Gosh, Randy's even quieter in this state."
			)
			(12 ; Smell
				(Print 7 2) ; "Randy's recently re-exposed and re-heated lunch smells pretty good. You start to regret having slept through lunch."
			)
			(11 ; Taste
				(Print 7 3) ; "Although it's darn tempting, all this tension has your stomach churning. The last thing it needs is more stomach acid, especially from someone else's stomach."
			)
			(4 ; Inventory
				(switch invItem
					(10 ; buckazoid
						(Print 7 4) ; "Randy, usually a sucker for a Buckazoid, is showing a remarkable lack of interest."
					)
					(0 ; Cartridge
						(Print 7 5) ; "Randy ignores your efforts to ask him about the cartridge, maybe because he's dead."
					)
					(1 ; keyCard
						(Print 7 6) ; "Randy doesn't seem to want the keycard. His present condition may have something to do with this."
					)
					(15 ; Widget
						(Print 7 7) ; "Whatever this thing does, reanimating the dead does not appear to be one of them."
					)
					(2 ; Gadget
						(Print 7 8) ; "Even you don't need a translator to get the message that Randy is D-E-A-D."
					)
					(else
						(super doVerb: theVerb invItem)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance deadMan2 of View
	(properties
		x 264
		y 152
		description {Hugh}
		sightAngle 45
		approachX 241
		approachY 154
		lookStr {Yet another crewman's motionless body reduces the shine of the floor wax. Hugh doesn't look too neat and clean with his lungs hanging out like that.}
		view 400
		cel 2
		priority 9
		signal 16400
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 2 5 3) ; Look, Talk, Do
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(gCurRoom setScript: searchBody)
			)
			(5 ; Talk
				(Print 7 9) ; "Normally a pleasant guy to talk with, Hugh is pretty darn boring now."
			)
			(11 ; Taste
				(Print 7 10) ; "Either you have a taste for sweat or you didn't smell him before you tried to taste him."
			)
			(12 ; Smell
				(Print 7 11) ; "Hmmm. I think Hugh might have missed a shower or two. Or perhaps his body got sweaty from the heat of that laser blast."
			)
			(4 ; Inventory
				(switch invItem
					(10 ; buckazoid
						(Print 7 12) ; "Your money doesn't hold much interest for Hugh at this point."
					)
					(0 ; Cartridge
						(Print 7 13) ; "Hugh offers you no help with the cartridge."
					)
					(1 ; keyCard
						(Print 7 14) ; "If Hugh could speak, he'd tell you he doesn't want the keycard. He might also have something to say about your intelligence."
					)
					(15 ; Widget
						(Print 7 15) ; "It's possible Hugh's only pretending disinterest in the widget. It's also possible he's still dead."
					)
					(2 ; Gadget
						(Print 7 16) ; "Blatant, messy death requires no translation."
					)
					(else
						(super doVerb: theVerb invItem)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance widget of Prop
	(properties
		x 132
		y 141
		description {widget}
		approachX 121
		approachY 162
		lookStr {You find a small but heavy device affixed to the base of the Star Generator platform. It appears to be magnetic. That must be how the aliens upset the force field protecting the unit!}
		view 57
		loop 1
		priority 12
		signal 16400
		cycleSpeed 2
	)

	(method (init)
		(super init: &rest)
		(self setCycle: Fwd approachVerbs: 2 3) ; Look, Do
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(gCurRoom setScript: getWidget)
			)
			(5 ; Talk
				(Print 7 17) ; "Widgets don't talk."
			)
			(12 ; Smell
				(Print 7 18) ; "It smells magnetic."
			)
			(11 ; Taste
				(Print 7 19) ; "It tastes quite metallic."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance upperSupport of Feature
	(properties
		description {upper support}
		sightAngle 45
		onMeCheck 2
		lookStr {This is the upper support for the Star Generator when it is affixed to the pedestal.}
	)

	(method (doVerb theVerb invItem)
		(self x: ((User curEvent:) x:) y: ((User curEvent:) y:))
		(super doVerb: theVerb invItem &rest)
	)
)

(instance baseSupport of Feature
	(properties
		description {baseSupport}
		sightAngle 45
		onMeCheck 4
		lookStr {The base of the Star Generator research pedestal has apparently been trashed by the vandals who stole the Generator.}
	)

	(method (doVerb theVerb invItem)
		(self x: ((User curEvent:) x:) y: ((User curEvent:) y:))
		(super doVerb: theVerb invItem &rest)
	)
)

(instance miscEquip of Feature
	(properties
		description {miscEquip}
		sightAngle 45
		onMeCheck 16
		lookStr {Now you know why you didn't have clearance for this place. You don't understand what most of this crap does. This thing looks like a giant speaker for the cosmos.}
	)

	(method (doVerb theVerb invItem)
		(self x: ((User curEvent:) x:) y: ((User curEvent:) y:))
		(super doVerb: theVerb invItem &rest)
	)
)

(instance rightConsole of Feature
	(properties
		description {rightConsole}
		sightAngle 45
		onMeCheck 16384
		lookStr {This thing looks like it came off the front end of an old Studebaker (or maybe the Batmobile). Anyway, it appears non-functional at this time. It was probably damaged in the heist.}
	)

	(method (doVerb theVerb invItem)
		(self x: ((User curEvent:) x:) y: ((User curEvent:) y:))
		(super doVerb: theVerb invItem &rest)
	)
)

(instance glassGlobe of Feature
	(properties
		description {glassGlobe}
		sightAngle 45
		onMeCheck 32
		lookStr {The glass globe atop the console is inactive at this time. The mess of wiring inside reminds you of how your hair looks after a nap.}
	)

	(method (doVerb theVerb invItem)
		(self x: ((User curEvent:) x:) y: ((User curEvent:) y:))
		(super doVerb: theVerb invItem &rest)
	)
)

(instance floor of Feature
	(properties
		description {floor}
		onMeCheck 64
		lookStr {You are standing on the research platform where the Star Generator is... was mounted for testing.}
	)
)

(instance starChart of Feature
	(properties
		description {starChart}
		sightAngle 45
		onMeCheck 8
		lookStr {This is a star chart. It was used for locating candidates to test the Star Generator on once the bulk of the development process was completed.}
	)

	(method (doVerb theVerb invItem)
		(self x: ((User curEvent:) x:) y: ((User curEvent:) y:))
		(super doVerb: theVerb invItem &rest)
	)
)

